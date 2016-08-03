package com.example.zyh.animator;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);




    }

    public  void onClick(View v){
                if(v==button)
                    performAnimate();
    }
    private  void performAnimate(){
        ViewWrapper wrapper=new ViewWrapper(button);
        ObjectAnimator.ofInt(wrapper,"width",500).setDuration(5000).start();

    }
    private  static  class  ViewWrapper{
        private View mTarget;
        public  ViewWrapper(View v){

            mTarget=v;
        }
        public  int getWidth(){

            return  mTarget.getLayoutParams().width;
        }
        public  void setWidth(int width){

            mTarget.getLayoutParams().width=width;
            mTarget.requestLayout();
        }
    }
}
