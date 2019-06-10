package com.blanco.apps.candor;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private static TextView sizeTV,locationTV,dateTV,softTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        sizeTV = (TextView)findViewById(R.id.size);
        locationTV = (TextView)findViewById(R.id.location);
        softTV = (TextView)findViewById(R.id.software);
        dateTV = (TextView)findViewById(R.id.date);

        Bundle b = new Bundle();
        b = getIntent().getExtras();

        //TODO: get the rest of contact parameters
        String check = b.getString("check");
        Image image = (Image) b.getSerializable(    "image");
   //     if(check[2]=="1") {
//            sizeTV.setText("valid");
//        }
//         else if(check[2]=="1") {
//            sizeTV.setText("valid");
//        }
//        else if(check[2]=="1") {
//            sizeTV.setText("valid");
//        }
//        else if(check[2]=="1") {
//            sizeTV.setText("valid");
//        }


    }



}
