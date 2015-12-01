package kr.ac.ssu.bon.helper;

import android.net.Uri;

/**
 * Created by lk on 15. 11. 29..
 */
public interface ProfileChangedListener {
    void updateUserProfile(Uri imageUri, String name);
}
