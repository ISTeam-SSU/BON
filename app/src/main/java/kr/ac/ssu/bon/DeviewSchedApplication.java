package kr.ac.ssu.bon;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.navercorp.volleyextensions.volleyer.factory.DefaultRequestQueueFactory;

import kr.ac.ssu.bon.helper.LoginPreferenceHelper;
import kr.ac.ssu.bon.ui.MainActivity;

import static kr.ac.ssu.bon.util.LogUtils.makeLogTag;

/**
 * Created by lk on 15. 11. 29..
 */
public class DeviewSchedApplication extends Application {

    private static final String TAG = makeLogTag("DeviewSchedApplication");

    private Context GLOBAL_CONTEXT = null;
    public static Boolean LOGIN_STATE = false;
    public static boolean FAVOR_SESSION_STATE = false;

    private CallbackManager mCallbackManager;
    public static RequestQueue deviewRequestQueue;
    private ProfileTracker profileTracker;

    private MainActivity mActivity = new MainActivity();

    //public static AllScheItems allscheItems = new AllScheItems();

    @Override
    public void onCreate() {
        super.onCreate();

        GLOBAL_CONTEXT = getApplicationContext();

        FacebookSdk.sdkInitialize(GLOBAL_CONTEXT);
        mCallbackManager = CallbackManager.Factory.create();
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
//                mActivity.updateUserProfile(currentProfile.getProfilePictureUri(100, 100), currentProfile.getName());
            }
        };

        setLoginState();
        setFavorSessionState();
        initRequestQueue();

    }

    public void setLoginState() {
        LoginPreferenceHelper prefHelper = new LoginPreferenceHelper(getBaseContext());
        DeviewSchedApplication.LOGIN_STATE = prefHelper.getPrefLoginValue(LoginPreferenceHelper.PREF_LOGIN_STATE, false);
    }

    public void setFavorSessionState() {
        /**
         * 로그인할때 false로 돌려야함
         */
//        FavoritePreferenceHelper prefHelper = new FavoritePreferenceHelper(getBaseContext());
//        DeviewSchedApplication.FAVOR_SESSION_STATE = prefHelper.getFavorSessionState(FavoritePreferenceHelper.PREF_FAVOR_STATE);
    }

    public void initRequestQueue() {
        deviewRequestQueue = DefaultRequestQueueFactory.create(GLOBAL_CONTEXT);
        deviewRequestQueue.start();
    }
}
