package kr.ac.ssu.bon.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import kr.ac.ssu.bon.R;
import kr.ac.ssu.bon.model.Board;
import kr.ac.ssu.bon.util.AppController;

/**
 * Created by lk on 15. 12. 7..
 */
public class HistoryActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_history);

        NetworkImageView nv = (NetworkImageView) findViewById(R.id.iv_history_img);
        TextView tvTitle = (TextView) findViewById(R.id.tv_history_title);
        TextView tvContext = (TextView) findViewById(R.id.tv_history_context);

        Board board = new Board("헌혈증이 필요합니다..", "안녕하세요 저는 아산 칠석고등학교 3학년 8반 이정혜입니다.\n" +
                "\n" +
                "최근 같은 반 친구가 교통사고를 크게 당했습니다.\n" +
                "\n" +
                "사고현장에 있던 목격자들의 진술에 따르면 친구는 저녁에 하교하던 중 학교 앞 지하철역 주변 사거리에서 승용차에 치여 몇 십미터를 끌려갔다고 합니다.\n" +
                "\n" +
                "다행히 주위에 계시던 분들께서 달려와 도와주신 덕에 사고가 나고 얼마 안되어 구조가 되었지만 친구는 큰 부상을 입어 혼수상태에 빠져있습니다.\n" +
                "\n" +
                "심각한 부상으로 지속적인 수혈이 필요해서 헌혈증이 많이 필요한 것 같습니다.\n" +
                "\n" +
                "기간은 언제까지일지 예상할 수 없다고 합니다. \n" +
                "\n" +
                "헌혈증을 가지고 계신 분들은 기부버튼을 눌러 기부해주시면 상당한 도움이 될 것입니다. 부탁드립니다!", "http://lemonlab.co.kr/bon/jung.png");

        nv.setImageUrl(board.imageUrl, AppController.getInstance().getImageLoader());
        tvTitle.setText(board.title);
        tvContext.setText(board.context);


    }
}
