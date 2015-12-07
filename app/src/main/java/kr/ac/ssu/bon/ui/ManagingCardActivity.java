package kr.ac.ssu.bon.ui;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import kr.ac.ssu.bon.R;

/**
 * Created by Soeun on 2015-12-05.
 */
public class ManagingCardActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_managecard);


        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        int p1 = pref.getInt("p1", 27);
        int p2 = pref.getInt("p2", 5);
        int p3 = pref.getInt("p3", 3);
        int p4 = pref.getInt("p4", 19);

        RoundCornerProgressBar progress1 = (RoundCornerProgressBar) findViewById(R.id.progress_1);
        progress1.setProgressColor(Color.parseColor("#ed3b27"));
       // progress1.setBackgroundColor(Color.parseColor("#808080"));
        progress1.setMax(50);
        progress1.setProgress(27);
        ((TextView)findViewById(R.id.tv_managecard_1)).setText(27+" / 50");

        RoundCornerProgressBar progress2 = (RoundCornerProgressBar) findViewById(R.id.progress_2);
        progress2.setProgressColor(Color.parseColor("#ed3b27"));
        // progress1.setBackgroundColor(Color.parseColor("#808080"));
        progress2.setMax(50);
        progress2.setProgress(p2);
        ((TextView)findViewById(R.id.tv_managecard_2)).setText(p2 + " / 50");

        RoundCornerProgressBar progress3 = (RoundCornerProgressBar) findViewById(R.id.progress_3);
        progress3.setProgressColor(Color.parseColor("#ed3b27"));
        // progress1.setBackgroundColor(Color.parseColor("#808080"));
        progress3.setMax(50);
        progress3.setProgress(p3);
        ((TextView)findViewById(R.id.tv_managecard_3)).setText(p3 + " / 50");

        RoundCornerProgressBar progress4 = (RoundCornerProgressBar) findViewById(R.id.progress_4);
        progress4.setProgressColor(Color.parseColor("#ed3b27"));
        // progress1.setBackgroundColor(Color.parseColor("#808080"));
        progress4.setMax(50);
        progress4.setProgress(p4);
        ((TextView)findViewById(R.id.tv_managecard_4)).setText(p4 + " / 50");





    }
}
