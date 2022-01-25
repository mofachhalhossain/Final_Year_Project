package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class transport extends AppCompatActivity implements View.OnClickListener{

    private Button shurjomukhi,Rojoniggonda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        shurjomukhi = findViewById(R.id.shurjomukhiId);
        Rojoniggonda = findViewById(R.id.RojoniggondaId);

        shurjomukhi.setOnClickListener(transport.this);
        Rojoniggonda.setOnClickListener(transport.this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.shurjomukhiId){
            Intent intent = new Intent(transport.this,transport_details.class);
            intent.putExtra("name","shurjomukhi");
            startActivity(intent);


        }
        if(view.getId() == R.id.RojoniggondaId){
            Intent intent = new Intent(transport.this,transport_details.class);
            intent.putExtra("name","Rojoniggonda");
            startActivity(intent);


        }



    }
}
