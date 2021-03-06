package com.deliCoin2.demo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.deliCoin2.bean.User;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.firebase.client.Firebase;

public class Login extends ActionBarActivity {

    private TextView info;
    //private LoginButton loginButton;
    private Button btnWithoutLogin;
    private CallbackManager callbackManager;
    public User user = User.getInstance();

    public static final String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        Firebase.setAndroidContext(this);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);

        Log.i("FACEBOOK_DELI_COIN", "Facebook is available HERE !!!");
        info = (TextView)findViewById(R.id.info);

        btnWithoutLogin = (Button) findViewById(R.id.btnWithoutLogin);
        btnWithoutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        /*
        if(isLoggedIn())
        {
            btnWithoutLogin.setVisibility(View.VISIBLE);
        }else
        {
            btnWithoutLogin.setVisibility(View.GONE);
        }

        loginButton.setVisibility(View.GONE);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                // App code
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code
                                Log.v("LoginActivity++", response.toString());

                                try{

                                    user.init((String) object.get("id"),
                                            (String) object.get("birthday"),
                                            (String) object.get("gender"),
                                            (String) object.get("email"),
                                            (String) object.get("name"));

                                    Firebase ref = new Firebase("https://delicoin.firebaseio.com/androidApp/users");
                                    //ref.child(user.getId()).addValueEventListener(new ValueEventListener() {
                                    ref.child(user.getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            Firebase ref = new Firebase("https://delicoin.firebaseio.com/androidApp/users/" + user.getId());
                                            if (dataSnapshot.exists()) {
                                                Long countLogin = dataSnapshot.child("countLogin") != null ?
                                                        Long.parseLong(dataSnapshot.child("countLogin").getValue().toString()) : 0l;
                                                Map<String, Object> countLoginMap = new HashMap<String, Object>();
                                                Long count = countLogin + 1L;
                                                countLoginMap.put("countLogin", count + "");
                                                ref.updateChildren(countLoginMap);
                                            } else {
                                                ref.setValue(user);
                                            }

                                        }

                                        @Override
                                        public void onCancelled(FirebaseError firebaseError) {

                                        }
                                    });

                                }catch(Exception e)
                                {
                                    Log.e(TAG, "Error saving user"+ e.getMessage());
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();


                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
                Log.i(TAG, "Logged in");
//                info.setText(
//                        "User ID: "
//                                + loginResult.getAccessToken().getUserId()
//                                + "\n" +
//                                "Auth Token: "
//                                + loginResult.getAccessToken().getToken()
//                );
            }

            @Override
            public void onCancel() {
                info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {

                info.setText("Login attempt failed.");

            }
        });*/
        Log.i(TAG, "called facebook");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    /*
    * Method to detect the availability of Facebook
    * */
    public boolean isFacebookAvailable() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Test; please ignore");
        intent.setType("text/plain");

        final PackageManager pm = this.getApplicationContext().getPackageManager();
        for(ResolveInfo resolveInfo: pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)){
            ActivityInfo activity = resolveInfo.activityInfo;
            // Log.i("actividad ->", activity.name);
            if (activity.name.contains("com.facebook.katana")) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onRestart() {
        super.onRestart();

//        if(isLoggedIn())
//        {
//            btnWithoutLogin.setVisibility(View.VISIBLE);
//        }else
//        {
//            btnWithoutLogin.setVisibility(View.GONE);
//        }
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

//        if(isLoggedIn())
//        {
//            btnWithoutLogin.setVisibility(View.VISIBLE);
//        }else
//        {
//            btnWithoutLogin.setVisibility(View.GONE);
//        }
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();


        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }


    /*Check if the session of facebook is active
    * it helps us to show continue button*/
    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }
}
