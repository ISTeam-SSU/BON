package kr.ac.ssu.bon.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

        RoundCornerProgressBar progress1 = (RoundCornerProgressBar) findViewById(R.id.progress_1);
        progress1.setProgressColor(Color.parseColor("#ed3b27"));
       // progress1.setBackgroundColor(Color.parseColor("#808080"));
        progress1.setMax(70);
        progress1.setProgress(15);




    }
}
