package com.example.jiocin;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class HideOrShow {
    LinearLayout searchBar;
    ScrollView hideOrShow;
    float downX;
    float upX;

    HideOrShow(LinearLayout searchBar,ScrollView hideOrShow){
        this.searchBar=searchBar;
        this.hideOrShow=hideOrShow;
    }
    void hideOrShow(){
        hideOrShow.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        downX = event.getX();}
                    case MotionEvent.ACTION_UP:{
                        upX = event.getX();

                        float deltaX = downX - upX;

                        if(Math.abs(deltaX)>0){
                            if(deltaX>=0){
                                swipeToUp();
                                return true;
                            }else{
                                swipeToDown();
                                return  true;
                            }
                        }
                    }
                }

                return false;
            }
        });

    }

    private void swipeToDown() {
        searchBar.setVisibility(View.VISIBLE);
    }

    private void swipeToUp() {
        searchBar.setVisibility(View.GONE);
    }
}
