package com.example.firebase;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class faculty extends AppCompatActivity {

    RecyclerView NewsRecyclerview;
    NewsAdapterFaculty newsAdapter;
    List<NewsItemFac> mData;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;
    ConstraintLayout rootLayout;
    EditText searchInput ;
    CharSequence search="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // let's make this activity on full screen

        requestWindowFeature( Window.FEATURE_NO_TITLE);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_faculty);

        // hide the action bar

        getSupportActionBar().hide();



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

            searchInput.setBackgroundResource(R.drawable.search_input_dark_style2 );
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));

        }
        else
        {
            // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style2 );
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));

        }



        // fill list news with data
        // just for testing purpose ii will fill the news list with random data
        // you may get your data from an api / firebase or sqlite database ...
        mData.add(new NewsItemFac("Prof. Dr. S.M. Mahbub Ul Haque Majumder","Dean\nmahbub@daffodilvarsity.edu.bd\n01712-245179,01713-493007","CSE",R.drawable.ff ));
        mData.add(new NewsItemFac("Professor Dr. Md. Fokhray Hossain","Associate Dean & Professor\ndrfokhray@daffodilvarsity.edu.bd\n01713-493250","CSE",R.drawable.gg ));
        mData.add(new NewsItemFac("Prof. Dr. Syed Akhter Hossain","Head\naktarhossain@daffodilvarsity.edu.bd\n+8801817-382645","CSE",R.drawable.a2 ));
        mData.add(new NewsItemFac("Dr. Sheak Rashed Haider Noori","Associate Professor and Associate Head \ndrnoori@daffodilvarsity.edu.bd\n01847140176","CSE",R.drawable.jj ));
        mData.add(new NewsItemFac("Ms. Nazmun Nessa Moon","Assistant Professor\nmoon@daffodilvarsity.edu.bd\n01713191187","CSE",R.drawable.kk ));
        mData.add(new NewsItemFac("Mr. Md. Tarek Habib","Assistant Professor\ntarek.cse@diu.edu.bd\n01709076951,01559024179","CSE",R.drawable.cc ));
        mData.add(new NewsItemFac("Md Zahid Hasan","Assistant Professor & Associate Head (In-Charge)\nzahid.cse@diu.edu.bd\n01672580748","CSE",R.drawable.hh ));
        mData.add(new NewsItemFac("Mr. Narayan Ranjan Chakraborty","Assistant Professor\nnarayan@daffodilvarsity.edu.bd\n01717379897","CSE",R.drawable.dd ));
        mData.add(new NewsItemFac("Mr. Shah Md Tanvir Siddiquee","Assistant Professor \ntanvir.cse@diu.edu.bd\n01712560297","CSE",R.drawable.ee ));
        mData.add(new NewsItemFac("Mr. Shaon Bhatta Shuvo","Senior Lecturer \nshaon.cse@diu.edu.bd\n01717950030 ","CSE",R.drawable.shaon ));
        mData.add(new NewsItemFac("Mr. Saiful Islam","Senior Lecturer \nsaiful.cse@diu.edu.bd\n01989089279 ","CSE",R.drawable.saiful ));
        mData.add(new NewsItemFac("Mr. Ahmed Al Marouf","Lecturer\nmarouf.cse@diu.edu.bd\n8801911784448","CSE",R.drawable.ii ));
        mData.add(new NewsItemFac("Mr. Md. Jueal Mia","Lecturer\njueal.cse@diu.edu.bd\n8801911142859","CSE",R.drawable.b2 ));


        mData.add(new NewsItemFac("Mr. Fahad Faisal","Assistant Professor   \nfahad.cse@diu.edu.bd\n+8801712937997","CSE",R.drawable.fahad ));
        mData.add(new NewsItemFac("Mr. Abdus Sattar","Assistant Professor   \nabdus.cse@diu.edu.bd\n01818392800","CSE",R.drawable.sattar ));
        mData.add(new NewsItemFac("Ms. Most. Hasna Hena","Senior Lecturer   \nhena.cse@diu.edu.bd\n01719472885","CSE",R.drawable.hasna ));
        mData.add(new NewsItemFac("Mr. Aniruddha Rakshit","Senior Lecturer\naniruddha.cse@diu.edu.bd\n01830055234","CSE",R.drawable.oni ));
        mData.add(new NewsItemFac("Mr. Sheikh Abujar","Senior Lecturer\nsheikh.cse@diu.edu.bd\n+8801673566566","CSE",R.drawable.abu ));
        mData.add(new NewsItemFac("Mr. Md. Azizul Hakim","Lecturer\nazizul.cse@diu.edu.bd\n01945735307","CSE",R.drawable.hakim ));
        mData.add(new NewsItemFac("Ms. Farah Sharmin","Senior Lecturer\nfarah@daffodilvarsity.edu.bd\n01715232346","CSE",R.drawable.farah ));
        mData.add(new NewsItemFac("Mr. Md. Riazur Rahman","Senior Lecturer\nriazur_rahman@daffodilvarsity.edu.bd\n01982076848","CSE",R.drawable.riaz ));
        mData.add(new NewsItemFac("Mr. Masud Rabbani","Lecturer\nmasud.cse@diu.edu.bd\n01923-887080","CSE",R.drawable.rabbani ));












        // adapter ini and setup

        newsAdapter = new NewsAdapterFaculty(this,mData,isDark);
        NewsRecyclerview.setAdapter(newsAdapter);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));


        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark ;
                if (isDark) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style2 );

                }
                else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style2 );
                }

                newsAdapter = new NewsAdapterFaculty(getApplicationContext(),mData,isDark);
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
