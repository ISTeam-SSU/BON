package kr.ac.ssu.bon.util;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lk on 15. 11. 29..
 */
public class JsonFromFile {
    public static String readJsonFromAssets(String filename, Context context){
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String text = new String(buffer);

            return text;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}