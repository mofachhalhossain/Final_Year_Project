package com.example.firebase;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class transaction extends AppCompatActivity {

    private EditText put_name,put_id,put_bankAccount,put_privacyCode;
    private ImageButton send_button;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        databaseReference= FirebaseDatabase.getInstance().getReference("students");


        put_name = (EditText)findViewById(R.id.put_name);
        put_id = (EditText)findViewById(R.id.put_id);
        put_bankAccount = (EditText)findViewById(R.id.put_bankAccount);
        put_privacyCode = (EditText)findViewById(R.id.put_privacyCode);
        send_button = (ImageButton)findViewById(R.id.send_button);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudents();
            }
        });

    }

    public void addStudents(){

        String studentName = put_name.getText().toString();
        String studentId = put_id.getText().toString();
        String studentBankAccount = put_bankAccount.getText().toString();
        String studentPrivacyCode = put_privacyCode.getText().toString();

        if(!TextUtils.isEmpty(studentName) && !TextUtils.isEmpty(studentId) && !TextUtils.isEmpty(studentBankAccount) && !TextUtils.isEmpty(studentPrivacyCode)){

            String id = databaseReference.push().getKey();

            students students = new students(studentName,studentId,studentBankAccount,studentPrivacyCode);

            databaseReference.child(id).setValue(students);

            put_name.setText("");
            put_id.setText("");
            put_bankAccount.setText("");
            put_privacyCode.setText("");

        }
        else{
            Toast.makeText(transaction.this,"Fill up correctly",Toast.LENGTH_LONG).show();
        }


    }

}
