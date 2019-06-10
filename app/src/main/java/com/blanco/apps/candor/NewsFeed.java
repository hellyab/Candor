package com.blanco.apps.candor;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeed extends Fragment implements View.OnClickListener {
    private LinearLayout newsOne;


    public NewsFeed() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_feed, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        newsOne = getView().findViewById(R.id.news1);
        newsOne.setOnClickListener(this);


    }
    public void goToDetailed(View v){

    }
    @Override
    public void onClick(View v) {
        Log.d("sfda","adssfds");
        switch (v.getId()){
            case(R.id.news1):
                Intent intent = new Intent(getContext(), DetailActivity.class);
                Log.d("sfda","1111111");
                startActivity(intent);


                break;


        }

    }

}
