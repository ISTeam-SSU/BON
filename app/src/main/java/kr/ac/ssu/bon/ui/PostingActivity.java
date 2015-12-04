package kr.ac.ssu.bon.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import kr.ac.ssu.bon.R;

/**
 * Created by lk on 15. 12. 4..
 */
public class PostingActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_posting);

        EditText etTitle = (EditText) findViewById(R.id.et_posting_title);

    }
}
