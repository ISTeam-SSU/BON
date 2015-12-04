package kr.ac.ssu.bon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kr.ac.ssu.bon.R;
import kr.ac.ssu.bon.model.Board;

/**
 * Created by lk on 15. 12. 4..
 */
public class PostingActivity extends AppCompatActivity {

    public static final int POSTING_REQUEST = 110;

    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_posting);

        final EditText etTitle = (EditText) findViewById(R.id.et_posting_title);
        final EditText etContext = (EditText) findViewById(R.id.et_posting_context);

        Button btSend = (Button) findViewById(R.id.bt_posting_send);
        Button btPhoto = (Button) findViewById(R.id.bt_posting_photo);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),etContext.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                intent.putExtra("title", etTitle.getText().toString());
                intent.putExtra("context", etContext.getText().toString());
                setResult(POSTING_REQUEST, intent);
                finish();
            }
        });



    }
}
