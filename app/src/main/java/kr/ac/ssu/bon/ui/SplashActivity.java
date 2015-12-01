package kr.ac.ssu.bon.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kr.ac.ssu.bon.DeviewSchedApplication;
import kr.ac.ssu.bon.R;
import kr.ac.ssu.bon.helper.UserProfileProvider;
import kr.ac.ssu.bon.model.User;
import kr.ac.ssu.bon.util.JsonFromFile;

import static kr.ac.ssu.bon.util.LogUtils.makeLogTag;

/**
 * Created by lk on 15. 11. 29..
 */
public class SplashActivity extends AppCompatActivity implements Runnable {

    private static final String TAG = makeLogTag("SplashActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashlogin);


        Handler handler = new Handler();
        handler.postDelayed(this, 1500);

    }

//    private void getAllScheData() {
//
//        volleyer(DeviewSchedApplication.deviewRequestQueue)
//                .get(DeviewSchedApplication.HOST_URL + "2015/list")
//                .withTargetClass(AllScheItems.class)
//                .withListener(new Response.Listener<AllScheItems>() {
//                    @Override
//                    public void onResponse(AllScheItems items) {
//                        AllScheItems.result = items;
//                    }
//                })
//                .withErrorListener(new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d(TAG, error.toString());
//                    }
//                })
//                .execute();
//    }

    private void getAllScheDataFromFile() {
        Gson gson = new Gson();
//        String jsonString = JsonFromFile.readJsonFromAssets("allsche.json", getBaseContext());
        //DeviewSchedApplication.allscheItems = gson.fromJson(jsonString, AllScheItems.class);
    }

    @Override
    public void run() {
        getAllScheDataFromFile();

        User user = new User();
        if (DeviewSchedApplication.LOGIN_STATE) {
            user = UserProfileProvider.getUserProfile(getBaseContext(), 60);
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("UserInfo", user);
        startActivity(intent);
        finish();
    }
}

