package com.example.firebase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity implements View.OnClickListener {

private CardView infoCard,  aboutCard, transacCard, transpoCard,libraryCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home );
        //defining cards
        infoCard=(CardView) findViewById(R.id.information);
       // chatCard=(CardView) findViewById(R.id.chat);
        aboutCard=(CardView) findViewById(R.id.about);
        transacCard=(CardView) findViewById(R.id.transaction);
        transpoCard=(CardView) findViewById(R.id.transport);
        libraryCard=(CardView) findViewById(R.id.library);

        //Add click listener to the card
        infoCard.setOnClickListener( this );
       // chatCard.setOnClickListener( this );
        aboutCard.setOnClickListener( this );
        transacCard.setOnClickListener( this );
        transpoCard.setOnClickListener( this );
        libraryCard.setOnClickListener( this );

        //for signout
        Toolbar toolbar=findViewById( R.id.toolbar );
    }

    //for toolbar signout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate( R.menu.menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuLogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity( new Intent( this,MainActivity.class ) );
                break;
        }
        return true;
    }


    @Override
    public void onClick(View view) {

        Intent intent;

         switch (view.getId()){
             case R.id.transport : intent= new Intent( this,transport.class ); startActivity( intent ); break;
            case R.id.about : intent= new Intent( this,about.class ); startActivity( intent ); break;
            case R.id.library : intent= new Intent( this,Library.class ); startActivity( intent ); break;
             case R.id.information : intent= new Intent( this,faculty.class ); startActivity( intent ); break;
             case R.id.transaction : intent= new Intent( this,transaction.class ); startActivity( intent ); break;
             //case R.id.chat : intent= new Intent( this,Users.class ); startActivity( intent ); break;

             default:break;
         }

    }


    //exit dialog box


    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder( this );
        builder.setMessage( "Are you sure you want to exit?" )
                .setCancelable( false )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       home. super.onBackPressed();

                    }
                } )

                .setNegativeButton( "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                } );

        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }
}
