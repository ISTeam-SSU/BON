package kr.ac.ssu.bon.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by lk on 15. 11. 29..
 */
public class DptopxChanger {
    public static int dpToPXChange(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
