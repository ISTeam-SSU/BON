package kr.ac.ssu.bon.helper;

import android.content.Context;

import com.facebook.Profile;

import kr.ac.ssu.bon.model.User;
import kr.ac.ssu.bon.util.DptopxChanger;

/**
 * Created by lk on 15. 11. 29..
 */
public class UserProfileProvider {
    public static User getUserProfile(Context context, int dp) {
        int size = DptopxChanger.dpToPXChange(context, dp);
        User user = new User();
        Profile profile = Profile.getCurrentProfile();
        user.name = profile.getName();
        user.picture = profile.getProfilePictureUri(size, size).toString();

        return user;
    }
}
