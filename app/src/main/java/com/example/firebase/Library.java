package com.example.firebase;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Library extends AppCompatActivity {

    RecyclerView NewsRecyclerview;
    NewsAdapter newsAdapter;
    List<NewsItem> mData;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;
    ConstraintLayout rootLayout;
    EditText searchInput ;
    CharSequence search="";



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // let's make this activity on full screen

        requestWindowFeature( Window.FEATURE_NO_TITLE);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_library);

        // hide the action bar
       // getSupportActionBar().hide();



        // ini view

        fabSwitcher = findViewById(R.id.fab_switcher);
        rootLayout = findViewById(R.id.root_layout);
        searchInput = findViewById(R.id.search_input);
        NewsRecyclerview = findViewById(R.id.news_rv);
        mData = new ArrayList<>();

        // load theme state

        isDark = getThemeStatePref();
        if(isDark) {
            // dark theme is on

            searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));

        }
        else
        {
            // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));

        }



        // fill list news with data
        // just for testing purpose i will fill the news list with random data
        // you may get your data from an api / firebase or sqlite database ...
        mData.add(new NewsItem("Programming in C","by stephen g. kochan","Available",R.drawable.a));
        mData.add(new NewsItem("Plumbing: Design and Practice","by S. G. Deolalokar","Available",R.drawable.b));
        mData.add(new NewsItem("Java SE 8 for the Really Impatient","by Cay S. Horstmann","Available",R.drawable.c));
        mData.add(new NewsItem("Building and Construction Materials: \n Testing and Quality Control (Lab Manual Series)","by M.L. Gambhir , Neha Jamwal","Available",R.drawable.d));
        mData.add(new NewsItem("A textbook of Optics ","Brij Lal , N. Subrahmanyam","Available",R.drawable.e));
        mData.add(new NewsItem("Object Oriented Programming With \n C Plus Plus","by E. Balaguruswamy","Available",R.drawable.f));
        mData.add(new NewsItem("Telecommunications, Switching, \n Traffic And Networks","by J.E. Flood","Available",R.drawable.g));
        mData.add(new NewsItem("Java: A Beginner's Guide 6th Edition","by Herbert Schildt","Available",R.drawable.h));
        mData.add(new NewsItem("Mechanical Measurements","by tThomas G. Beckwith , Roy D. Marangoni , John H. Lienhard","Available",R.drawable.i));
        mData.add(new NewsItem("Modern Power System Analysis","by D. P. Kothari , I. J. Nagrath","Available",R.drawable.j));
        mData.add(new NewsItem("Data Mining Methods and Models","by Daniel T Larose","Available",R.drawable.k));
        mData.add(new NewsItem("Engineering a Compiler","by Keith D Cooper , Lind Torczon","Available",R.drawable.l));
        mData.add(new NewsItem("Computer Graphics : A Programming \n Approach","by Steven Harrington","Available",R.drawable.m));
        mData.add(new NewsItem("Machine Learning ","by Tom M. Mitchell","Available",R.drawable.n   ));




        // adapter ini and setup

        newsAdapter = new NewsAdapter(this,mData,isDark);
        NewsRecyclerview.setAdapter(newsAdapter);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));


        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark ;
                if (isDark) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);

                }
                else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                newsAdapter = new NewsAdapter(getApplicationContext(),mData,isDark);
                if (!search.toString().isEmpty()){

                    newsAdapter.getFilter().filter(search);

                }
                NewsRecyclerview.setAdapter(newsAdapter);
                saveThemeStatePref(isDark);




            }
        });



        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                newsAdapter.getFilter().filter(s);
                search = s;


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    private void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false) ;
        return isDark;

    }



}
