package kr.ac.ssu.bon.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import kr.ac.ssu.bon.DeviewSchedApplication;
import kr.ac.ssu.bon.R;
import kr.ac.ssu.bon.helper.LoginPreferenceHelper;

import static kr.ac.ssu.bon.util.LogUtils.LOGE;
import static kr.ac.ssu.bon.util.LogUtils.LOGI;
import static kr.ac.ssu.bon.util.LogUtils.makeLogTag;

/**
 * Created by lk on 15. 11. 29..
 */
public class AccoutActivity extends FragmentActivity {

    private static final String TAG = makeLogTag("AccoutActivity");

    public static final int ACCOUNT_REQUEST = 100;

    private CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());


        mCallbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends"));
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        LoginPreferenceHelper prefHelper = new LoginPreferenceHelper(getBaseContext());
                        prefHelper.setPrefLoginValue(LoginPreferenceHelper.PREF_LOGIN_STATE, true);
                        DeviewSchedApplication.LOGIN_STATE = true;
                        setResult(ACCOUNT_REQUEST);
                        finish();
                    }

                    @Override
                    public void onCancel() {
                        LOGI(TAG, "onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        LOGE(TAG, "onError", exception.getCause());
                    }
//
//                    private void showAlert() {
//                        new AlertDialog.Builder(SplashActivity.this)
//                                .setTitle(R.string.cancelled)
//                                .setMessage(R.string.permission_not_granted)
//                                .setPositiveButton(R.string.ok, null)
//                                .show();
//                    }
                });


        setContentView(R.layout.activity_accout);
        initView();

    }


    private void initView() {
        final LoginButton fbLoginButton = (LoginButton) findViewById(R.id.account_facebooklogin);
        fbLoginButton.setReadPermissions("user_friends");
        fbLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviewSchedApplication.LOGIN_STATE) {
                    fbLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            LoginPreferenceHelper prefHelper = new LoginPreferenceHelper(getBaseContext());
                            prefHelper.setPrefLoginValue(LoginPreferenceHelper.PREF_LOGIN_STATE, true);
                            DeviewSchedApplication.LOGIN_STATE = true;
                            setResult(ACCOUNT_REQUEST);
                        }

                        @Override
                        public void onCancel() {
                            LOGI(TAG, "onCancel");
                        }

                        @Override
                        public void onError(FacebookException exception) {
                            LOGE(TAG, "onError", exception.getCause());
                        }
//
//                    private void showAlert() {
//                        new AlertDialog.Builder(SplashActivity.this)
//                                .setTitle(R.string.cancelled)
//                                .setMessage(R.string.permission_not_granted)
//                                .setPositiveButton(R.string.ok, null)
//                                .show();
//                    }
                    });
                } else if (DeviewSchedApplication.LOGIN_STATE) {
                    LoginPreferenceHelper prefHelper = new LoginPreferenceHelper(getBaseContext());
                    prefHelper.setPrefLoginValue(LoginPreferenceHelper.PREF_LOGIN_STATE, false);
                    DeviewSchedApplication.LOGIN_STATE = false;
                    setResult(ACCOUNT_REQUEST);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
