# Social-Login
Single Library Provide Facebook, Google and Twitter Login Functionality

# README #

**This repository for?**

Social Login Library
Version 1.0

**How do I get set up?**

**Gradle Set Up**


```
#!android

dependencies {
    compile 'com.pkb.sociallogin:sociallogin:1.0'
}

```


**Add Permission** 


```
#!andrid

 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 <uses-permission android:name="android.permission.INTERNET"/>

```

**Add Project ID in String File**


```
#!android

 <string name="facebook_app_id">175817389108883063</string>
    <string name="twitter_consumer_key">bceG8id6GQcE7TJmjdCy3pcM5hdfd</string>
    <string name="twitter_consumer_secret">ZeyGajYsK9dFKPdHZjdsfdY7mUZIcHWXuhkHWxdsdfa8WUyehLD3o5JDbPZ</string>

```




**Add Activity In Menifest** 


```
#!andrid

**For FaceBook Login**

 <meta-data android:name="com.facebook.sdk.ApplicationId" android:value="@string/facebook_app_id"/>


  <activity android:name="com.facebook.FacebookActivity"
            android:configChanges="keyboard|keyboardHidden|screenLayout|screenSize|orientation"
            android:theme="@android:style/Theme.Translucent.NoTitleBar"
            android:label="@string/app_name" />

 <activity
            android:name="com.pkb.sociallogin.SocialLoginActivity"
            android:theme="@android:style/Theme.Translucent.NoTitleBar">
        </activity>


**For Google Login**

 <meta-data
            android:name="com.google.android.gms.version"
            android:value="@integer/google_play_services_version"/>

 <activity
            android:name="com.pkb.sociallogin.SocialLoginActivity"
            android:theme="@android:style/Theme.Translucent.NoTitleBar">
        </activity>


**For Twitter Login**

<activity
            android:name="com.pkb.sociallogin.SocialLoginActivity"
            android:theme="@android:style/Theme.Translucent.NoTitleBar">
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <data
                    android:host="loginexample"
                    android:scheme="twitterloginexample" />
            </intent-filter>
        </activity>

```


**Declare Constant Variable to Code** 


```
#!andrid

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


```


**Call To Login Functionality where you want**


```
#!andrid

For Facebook

  Intent in=new Intent(getApplicationContext(), SocialLoginActivity.class);
  in.putExtra(TYPE_KEY,TYPE_FACENOOK);
  startActivityForResult(in,FACEBOOK_REQUEST_CODE);


For Google 

   Intent in=new Intent(getApplicationContext(), SocialLoginActivity.class);
   in.putExtra(TYPE_KEY,TYPE_GOOGLE);
   startActivityForResult(in,GOOGLE_REQUEST_CODE);


For Twitter

    Intent in=new Intent(getApplicationContext(), SocialLoginActivity.class);
    in.putExtra(TYPE_KEY,TYPE_TWITTER);             
             in.putExtra(TWITTER_CONSUMER,getResources().getString(R.string.twitter_consumer_key));    
        in.putExtra(TWITTER_SECRETE,getResources().getString(R.string.twitter_consumer_secret));
                startActivityForResult(in,TWITTER_REQUEST_CODE);

```


**Get Social Login Response **

 
```
#!andrid

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

```
