package com.pkb.testing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.pkb.sociallogin.SocialLoginActivity;


/**
 * Created by comp3 on 9/11/2015.
 */
public class LoginActivity extends FragmentActivity {

    Button loginButton,sign_in_button,twitter;
    public static String TYPE_FACENOOK="facebook";
    public static String TYPE_GOOGLE="google";
    public static String TYPE_TWITTER="twitter";
    public static int FACEBOOK_REQUEST_CODE=5001;
    public static int GOOGLE_REQUEST_CODE=5002;
    public static int TWITTER_REQUEST_CODE=5003;

    public static int RESPONCE_CODE=5000;
    public static String RESPONCE_KEY="responce";
    public static String TYPE_KEY="type";
    public static String TWITTER_CONSUMER="twitterConsumerKey";
    public static String TWITTER_SECRETE="twitterConsumerSecret";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton= (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(getApplicationContext(), SocialLoginActivity.class);
                in.putExtra(TYPE_KEY,TYPE_FACENOOK);
                startActivityForResult(in,FACEBOOK_REQUEST_CODE);
            }
        });

        sign_in_button= (Button) findViewById(R.id.sign_in_button);
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(getApplicationContext(), SocialLoginActivity.class);
                in.putExtra(TYPE_KEY,TYPE_GOOGLE);
                startActivityForResult(in,GOOGLE_REQUEST_CODE);
            }
        });


        twitter= (Button) findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(getApplicationContext(), SocialLoginActivity.class);
                in.putExtra(TYPE_KEY,TYPE_TWITTER);
                in.putExtra(TWITTER_CONSUMER,getResources().getString(R.string.twitter_consumer_key));
                in.putExtra(TWITTER_SECRETE,getResources().getString(R.string.twitter_consumer_secret));
                startActivityForResult(in,TWITTER_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==FACEBOOK_REQUEST_CODE){
            if(resultCode==RESPONCE_CODE){
                Log.d("Facebook RESPONCE",""+data.getExtras().getString(RESPONCE_KEY));
            }
        }
        if(requestCode==GOOGLE_REQUEST_CODE){
            if(resultCode==RESPONCE_CODE){
                Log.d("GOOGLE RESPONCE",""+data.getExtras().getString(RESPONCE_KEY));
            }
        }
        if(requestCode==TWITTER_REQUEST_CODE){
            if(resultCode==RESPONCE_CODE){
                Log.d("TWITTER RESPONCE",""+data.getExtras().getString(RESPONCE_KEY));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
