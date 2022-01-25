package com.example.firebase;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class transport_details extends AppCompatActivity {

    private ImageView profilePicture;
    private TextView name,details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_details);

        profilePicture = findViewById(R.id.profilePicId);
       name = findViewById(R.id.nameId);
        details = findViewById(R.id.detailsId);

        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            String myValue = bundle.getString("name");

            showResult(myValue);
        }
    }

    private void showResult(String myValue) {
        if (myValue.equals("shurjomukhi")){

            profilePicture.setImageResource(R.drawable.diu);
            name.setText(R.string.shurjomukhi_name);
            details.setText(R.string.details);
        }
        if (myValue.equals("Rojonigondha")){

            profilePicture.setImageResource(R.drawable.diu);
            name.setText("Rojonigondha");
            details.setText(R.string.details);
        }


    }
}
