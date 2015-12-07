package kr.ac.ssu.bon.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;
import java.util.List;

import kr.ac.ssu.bon.R;
import kr.ac.ssu.bon.model.Board;

/**
 * Created by lk on 15. 11. 29..
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private int position;

    private static final int ITEM_COUNT = 100;

    private List<Board> mContentItems = new ArrayList<>();

    public static RecyclerViewFragment newInstance(int position) {
        return new RecyclerViewFragment(position);
    }
//
//    public static RecyclerViewFragment getInstance(int position){
//
//    }


    public RecyclerViewFragment(int position) {
        this.position = position;
        Log.i("sadfa", position + "");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview_carpaccio, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        if (position == 0) {
            mAdapter = new RecyclerViewMaterialAdapter(new StoryRecyclerViewAdapter(mContentItems, getActivity()));
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter = new RecyclerViewMaterialAdapter(new TestRecyclerViewAdapter(mContentItems, getActivity()));
            mRecyclerView.setAdapter(mAdapter);
        }

        {
            if (position == 0) {
                mContentItems.add(new Board("헌혈증이 필요합니다..", "안녕하세요 저는 아산 칠석고등학교 3학년 8반 이정혜입니다.\n" +
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
                        "헌혈증을 가지고 계신 분들은 기부버튼을 눌러 기부해주시면 상당한 도움이 될 것입니다. 부탁드립니다!", "http://lemonlab.co.kr/bon/jung.png"));
            } else if (position == 1) {

            } else if (position == 2) {
                mContentItems.add(new Board("헌혈에 집에서..", "안녕하세요? 저는 부천에 살고 있는 건강한 20대 청년입니다. \n" +
                        "\n" +
                        "고등학교 때 한 헌혈을 시작으로 매년 꾸준히 하여 올해로 100회를 넘겼습니다. 헌혈을 습관처럼 해오면서 간호사 분들의 말씀을 가볍게 넘기게 되는 경우가 많이 생기는데요, 오늘은 그로 인해 생긴 불상사를 알려드리고자 사연을 쓰게 되었습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "때는 2013년 11월. 저는 평소와 같이 가벼운 마음으로 헌혈을 하러 부천 '헌혈의집'에 방문했습니다. 문진을 다 작성하고 오렌지 주스를 마시면서 느긋한 마음으로 차례를 기다리고 있었죠.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "\"강혁 님!\" 하며 호명하는 소리에 들어가 보니 간호사 분께서\n" +
                        "\n" +
                        "\"꾸준히 혈장 헌혈을 많이 하셨네요. 이번에 혈소판 혈장이라는 새로운 헌헐을 하면 기념품 1+1을 드리는 행사를 하고 있는데요, \n" +
                        "\n" +
                        "한 번 해보시겠어요?\"라고 묻더군요.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "평소에 혈장 헌혈을 주로 했지만 기왕 헌혈하는 거 '두 배로 나눔을 실천하면 더 아름답지 않을까'란 생각에 흔쾌히 하겠다고 했습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "헌혈 준비 전, \"시간이 좀 걸리니까 미리 화장실 다녀오고 충분히 수분을 섭취하세요.\"라며 간호사 분이 말씀하셨습니다.\n" +
                        "\n" +
                        "저는 건성으로 \"네\"라고 대답하고 오렌즈 주스 3잔을 비운 뒤, 화장실에는 다녀오지 않았죠.\n" +
                        "\n" +
                        "몇 분 후 날카로운 주사바늘은 제 팔뚝을 뚫고 들어왔고, 전 갑자기 소변이 마렵기 시작했습니다.\n" +
                        "\n" +
                        "\"팔에 압력 있을 때만 힘주시고요. 압력 없을 때는 피 들어가는 거니까 힘 빼세요. 하시다 불편한 점 있으시면 말씀하시고요.\"\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "친절한 간호사 선생님의 배려에 잠시동안 '화장실 가고 싶습니다'라고 말하고 싶었지만, 이미 주사바늘은 깊숙이 들어간 후였죠. \n" +
                        "\n" +
                        "헌혈은 시작되어 피가 호스관을 타고 쉼 없이 흘러갔습니다. 한 20분 정도 지났을까요? 제가 자세를 자꾸 바꾸며 발을 꼬자 간호사 선생님이 오셔서 \"불편한 곳 있으신가요?\"라고 묻더군요.\n" +
                        "\n" +
                        "전 차마 말할 수 없어 \"아니오....\"라고 한 채 소변을 꾹 참았습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "다리를 여러 번 풀기를 반복하며 열심히 참았죠. 한 40분 정도 지났을까요?\n" +
                        "\n" +
                        "이제 끝날 때가 됐겠지 싶었는데 기계는 멈추지 않았습니다. 도저히 참기가 힘들어 지나가는 간호사 한 분을 붙잡고 물어봤죠.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "\"저기 선생님, 끝나려면 아직 멀었나요?\"\n" +
                        "\n" +
                        "\"이제 반 이상 지나서 한 30~40분 정도면 끝날 것 같아요. 어디 불편하신가요?\"\n" +
                        "\n" +
                        "\"네? 그렇게 오래 걸리는 건가요?\"\n" +
                        "\n" +
                        "\"네.^^평소에 혈장만 하시다가 혈소판 혈장은 처음 해보시는 거죠? 혈소판 혈장은 대략 1시간 조금 넘게 걸려요.\"\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "아...갑자기 그때부터 평소에는 나타나지도 않던 헌혈 후유증이 오는 것처럼 잠시 머리가 어지러운 기분이 들었습니다. 설명을 제대로 듣지고 않고 혈소판 혈장 헌혈을 하겠다고 했으니, 이제 와서 '화장실이 급해 죽겠으니 바늘을 뽑아주십쇼!'하기에도 너무 늦은 것 같더군요. 그렇게 또 어떻게 몸을 비비 꼬며 1시간가량을 버텼습니다. 제가 식은땀을 흘리며 얼굴 색깔이 빨개지자 또 간호사 한 분이 오셨습니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "\"어디 많이 불편하신가요?\"\n" +
                        "\n" +
                        "\"아니오...괜찮습니다...........'\n" +
                        "\n" +
                        "\"식은 땀 나시는 것 같은데, 전에도 헌혈하던 도중에 갑자기 춥거나 열이 나거나 이런 적이 있으셨나요?\"\n" +
                        "\n" +
                        "\"아니요. 그냥 잠깐 더워서 그래요. 괜찮아요.\"\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "제가 계속 괜찮다고 간곡한 표정으로 이야기하자 그 간호사 분도 고개만 갸우뚱하시곤 다른 쪽으로 가시더라고요. 저는 그때 이미 극도로 예민해져서 표정관리 따위는 할 수 없었습니다. 머릿속에선 군대에서 불렀던 군가가 떠올랐죠. '전우여!전우여!'를 100번 넘게 외쳤을까요? 기계 돌아가는 소리가 멈추더니 드디어 헌혈이 끝났음을 알리는 알람 소리가 들려왔습니다. 아... 그때의 안도감이란! \n" +
                        "\n" +
                        "간호사 한 분이 오셔서 바늘을 빼고 지혈대를 묶어 주자 저는 마지막 남은 힘을 다 짜서 하체에 힘을 주고 몸을 일으켰습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "그때 간호사님 왈 \"위에 있는 시계가 울리면 그때 일어나셔야 돼요. 누워계세요.\"\n" +
                        "\n" +
                        "\"아, 그게 제가 이만 가봐야 돼서요..\"\n" +
                        "\n" +
                        "\"안돼요. 알람 울리면 그때 일어나셔야 돼요.\"\n" +
                        "\n" +
                        "\"아.. 제가 정말 급하게 가봐야 하는 곳이 있습니다.\"\n" +
                        "\n" +
                        "\"식은 땀도 흘리시는 것 같은데 충분히 수분 섭취하시고 가셔야 해요!\"\n" +
                        "\n" +
                        "\"정말 급한 일이라 가봐야 해요!\"\n" +
                        "\n" +
                        "\"어디 가셔야 하는 건데요?\"\n" +
                        "\n" +
                        "\".... 개인적인 일이라 여기서 말씀드리리가 좀..\"\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "그때야 간호사 선생님께서는 저의 개인적인 볼일을 알아차리셨는지 저를 부축해 일으키시곤 화장실로 안내해 주셨습니다. \n" +
                        "\n" +
                        "정말 그때 그 자리에서 5분만 더 있었어도 저는 자주 가는 '헌혈의집'을 바꿔야 했을지도 모르죠. 어쨌든 다행히도 아무런 일 없이 헌혈과  볼일 모두 무사히 마칠 수 있었습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "제가 볼일을 보고 오자 간호사 분께서 웃는 얼굴로 \"혈소판 혈장 같은 경우는 시간이 오래 걸려서 미리 화장실을 다녀오셔야 돼요.^^\"라고 말씀해 주시더군요.\n" +
                        "\n" +
                        "부끄러워서 아무 말도 못하고 고개를 숙인 채 도망치듯 헌혈의집을 빠져나왔습니다. 그 이후론 헌혈을 하기 전, 무조건 화장실에 가는 것을 습관으로 삼고 있습니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "헌혈로 사랑을 나누시는 헌혈자 여러분! 헌혈 전 주의사항을 무심코 흘려듣지 마세요!\n" +
                        "\n" +
                        "그랬다간 정말 저처럼 큰 대가를 치를 수도 있습니다. 아무쪼록 다들 헌혈의 나눔으로 넉넉한 2014년 되시고요. 긴 글 끝까지 읽어 주셔서 감사합니다. ", "http://lemonlab.co.kr/bon/kang.png"));
                mContentItems.add(new Board("안녕하세요?", "안녕하세요? 저는 이제 막 중년의 문턱에 들어선 한 학교의 교사입니다. 선생님으로 많은 사건들을 만나며 점점 젊은이들이 살기 각박해지고 있는 세상이 되고 있는 것 같아 마음이 아파올 때가 많습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "물론 저도 학생이었던 적이 있었답니다. 그땐 저도 마음대로 되지 않는 세상에 불만이 많았죠. 오늘은 제가 학창시절 겪었던 따뜻한 이야기를 하나 해드릴까 합니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "공부가 제일 하기 싫었던 고3 시절, 지금의 학생들과 똑같이 저도 고3 막바지를 앞두고 곤두박질치는 성적에 고민이 많았습니다. 그래도 선생님이 되고 싶다는 꿈 하나로 힘들었던 시절을 버텼죠. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "제가 학력고사 세대인데요, 그때는 지금과는 달리 서점에서 직접 원서를 사 와서 가고 싶은 대학에 지원해야 했습니다. 지금 세대들은 잘 상상이 안 가시죠? 원서 접수 날에는 항상 서점에 사람들이 북적북적 하곤 했답니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "대학 원서 접수 마감을 하루 앞둔 어느 날, 저도 여느 학생들과 마찬가지로 대학에 지원하기 위해 서점으로 향했습니다. 북적북적한 인파를 뚫고 원서를 찾고 있었는데, 서점의 한 직원이 와서는 원서가 모두 떨어졌으니 다른 서점에서 찾아보라고 하더군요. 순간 간담이 서늘해졌지만, 더 큰 서점에 가면 있을 거라는 직원 말에 안양에 살던 저는 서둘러 1시간 정도 걸리는 수원으로 가는 버스를 탔습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "다행히 거기에는 새하얀 원서 뭉치가 여러 개 놓여있더라고요. 안도의 한숨을 내쉬며 계산대 앞에 섰는데, 뒷주머니에 지갑이 잡히질 않는 겁니다. 탈탈 뒤져 보았지만 지갑은 어디에도 없었죠. 수중에는 동전 100원뿐이었습니다. 급하게 공중전화로 집에 전화를 했지만 아무도 받지 않고, 친구 집에도 전화를 했는데 집에 없다더군요. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "공중전화는 금방 끊겼고 순간 전 이렇게도 대학에 떨어질 수 있구나 하는 생각이 들었습니다. 어린 마음에 눈물까지 핑 돌더라고요.\n" +
                        "\n" +
                        "어찌 할 바를 몰라 서점문을 박차고 나오니, 문 앞엔 하얀색 헌혈차 한 대가 있었습니다. 순간 배가 고파 일단 헌혈을 하고 초코파이라도 얻어먹자는 생각에 헌혈차 안으로 들어갔죠. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "그런데 신분증이 없으면 헌혈을 할 수 없다고 하시더군요. 오늘 되는 일이 하나도 없구나 속으로 한탄하며 무턱대고 헌혈차 안에 있던 사람들에게 말했습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "\"제가 원서를 사야 하는데 원서 살 돈이 없어요. 지갑을 잃어버렸어요... 헌혈을 할 테니 도와주시면 안될까요?\"\n" +
                        "\n" +
                        "순간 조용해진 헌혈자 안. 막막해진 제 눈에는 눈물이 고였습니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "그 후 몇 초가 지났을까요? 직원 아저씨 한 분이 제 손을 끌고 헌혈자 밖으로 나갔습니다.\n" +
                        "\n" +
                        "아저씨는 밥은 먹고 왔냐고 물으셨죠. 그리곤 식당으로 데려가 비빔밥 한 그릇을 사주셨습니다. 헤어지던 길, 제 손에 원서비에 차비까지 보태서 쥐어주시던 아저씨. 대학 꼭 합격하라며 돌아서는 그분의 등 뒤로 꼭 꿈을 이뤄 선생님이 되겠다는 다짐을 다시 새겼습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "같이 밥을 먹으며 알게 된 사실이지만, 그분은 헌혈된 피를 수거하시던 적십자 직원이었습니다. 전 그렇게 이름도, 사는 곳도 모르는 한 분께 커다란 도움을 받아 무사히 대학에 지원했죠. 그 후로 열심히 공부해 선생님이라는 꿈을 이뤘습니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "인생의 출발점에서 큰 도움을 주셨던 그 아저씨 덕분에 헌혈의 인연이 시작되어 이제는 다른 사람들을 도울 수 있다는 사실에 감사하고 있습니다. 제가 갑작스러운 도움으로 기회를 얻고 따뜻한 추억을 갖게 되었듯이, 우리 주위에 소중한 인연이 더 많아질수록 세상은 더 따뜻해질 거라 생각합니다. \n" +
                        "\n" +
                        "선뜻 도움의 손길을 건네주었던 그분처럼 저도 아이들에게 좋은 선생님이 될 수 있도록 열심히 살겠습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "P.S 1996년 수원 장안문 헌혈버스에서 한 고등학생에게 밥을 사주고, 원서비와 차비까지 주신 남성분을 찾아주실 수 있을까요? 그때 주신 도움으로 이제 열혈 현혈팬이 되었고, 헌혈 전도사로 살아가고 있습니다. 그리고 제 꿈도 이루었습니다. 제가 식사 대접 한 번 하고 싶습니다. 다시 한번 제 인생의 출발선에서 도움 주셔서 감사합니다.", "http://www.osinews.co.kr/ArticleUpload/4/20120824163041.jpg"));
                mContentItems.add(new Board("하나뿐인 셔츠", "1999년의 일입니다. \n" +
                        "\n" +
                        "다니던 대학을 그만두고 다시 입시 준비를 하고 있었는데, 당시 저에게는 시대를 앞서가는 디자인의 셔츠가 하나 있었습니다. 흰색 슬림한 드레스 셔츠였는데, 셔츠의 왼쪽은 잉크를 볼펜으로 마구 흩뿌린 것처럼 검정 무늬가 있었고 오른쪽은 무늬 없이 새하얀 셔츠였습니다. 처음 만나는 사람들은 여지없이 옷에 잉크가 묻었다고 생각하여 무슨 일이 있었는지 질문부터 던지는 그런 옷이었는데, 다소 번거로웠지만(?) 멋진 옷이었습니다.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "어늘 날인가 제가 그 셔츠를 입고 헌혈을 하러 갔습니다. 얼룩무늬의 왼팔이 아닌, 새하얀 바탕이 오른쪽 소매를 걷고 헌혈 준비를 했습니다. 그런데 그날 웬일로 오른팔의 혈관에 바늘을 찌르자마자 순간적으로 피가 '촤악'하고 튀었습니다. (16년째 헌혈을 하고 있는데 , 그 이후로도 그런 적은 없었습니다.) 신기한 경험이었지만 그리 대수롭게 생각하지는 않았고, 흘러내리거나 맨살에 묻은 피는 간호사님과 함께 닦아냈지만 옷에 묻은 피는 어쩔 수가 없었습니다. 일단 묻은 건 나중에 해결하리고 하고 헌혈을 계속했죠.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "헌혈을 마치고 집에 가야 하는데 내심 걱정이 되었습니다. 옷에 피질을 하고 있으니 사람들이 이상하게 보거나, 불량학생으로 보면 어떡하지? 하는 생각이 들었기 때문입니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "그런데 집에 가는 버스를 타고, 약국과 슈퍼에도 들렸는데 의외로 옷이나 피에 대해 말을 걸기는커녕 제 못을 보고도 뭔가 놀라는 눈치나 낌새조차 느낄 수 없었습니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "집에 와서 거울을 본 저는 그제야 이유를 알 수 있었습니다. 셔츠가 마치 처음부터 좌우대칭으로 만들어진 것처럼, 왼쪽은 검은색 무늬, 오른쪽은 빨간색 무늬가 불규칙적이면서 규칙적인 듯 잘 어울리는 것이 아니겠습니까?\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "이대로 평생 입고 다니고 싶은 생각이 들 정도로 더욱 멋진 셔츠가 된 것이었습니다. 물론 시간이 지나면 선홍색 핏자국이 탁한 갈색으로 변할 것이기 때문에 이후에 과산화수소를 빌려서 핏기를 제거한 후 세탁을 했습니다. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "나중에야 안 일이지만, 드물게 바늘을 꽂았을 때 혈류압에 의해 피가 튀는 경우도 있는 것 같더라고요. 혹시나 그런 일을 겪게 되더라도 '당황하지 않고 계속 헌혈~끝!", "https://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/s320x320/e15/915708_761025243939317_220752133_n.jpg"));
            }

            mAdapter.notifyDataSetChanged();

        }

        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);

//        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void addItem(Board board) {
        mContentItems.add(0, board);
        mAdapter.notifyDataSetChanged();
    }
}