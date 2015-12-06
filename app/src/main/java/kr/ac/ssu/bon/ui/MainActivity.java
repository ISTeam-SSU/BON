package kr.ac.ssu.bon.ui;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.bumptech.glide.Glide;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import kr.ac.ssu.bon.DeviewSchedApplication;
import kr.ac.ssu.bon.R;
import kr.ac.ssu.bon.helper.LoginPreferenceHelper;
import kr.ac.ssu.bon.helper.ProfileChangedListener;
import kr.ac.ssu.bon.helper.UserProfileProvider;
import kr.ac.ssu.bon.model.Board;
import kr.ac.ssu.bon.model.User;
import kr.ac.ssu.bon.util.GlideCircleTransform;

import static kr.ac.ssu.bon.util.LogUtils.makeLogTag;

public class MainActivity extends AppCompatActivity implements DeviewFragment.OnFragmentInteractionListener, ProfileChangedListener {

    private static final String TAG = makeLogTag("MainActivity");

    private MaterialViewPager mViewPager;
    private Toolbar mToolbar;
    private ImageView mAvatarImage;
    private TextView mNameText;

    private FragmentManager fragmentManager;

    private User mUser = new User();

    private RecyclerViewFragment[] recyclerViewFragments;
    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null) {
            mUser = (User) getIntent().getSerializableExtra("UserInfo");
        }

        fragmentManager = getSupportFragmentManager();


        initMaterialViewPager();
        initToolbar();
        initNavigationView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setBackgroundColor(Color.RED);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, PostingActivity.class), PostingActivity.POSTING_REQUEST);
            }
        });
    }

    private void initToolbar() {
        setTitle("");
        mToolbar = mViewPager.getToolbar();
        setSupportActionBar(mToolbar);
    }

    private void initMaterialViewPager() {
        recyclerViewFragments = new RecyclerViewFragment[3];
        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                recyclerViewFragments[position] = RecyclerViewFragment.newInstance(position);
                pos = position;
                Log.i("pos", pos+"");
                return recyclerViewFragments[position];
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 3) {
                    case 0:
                        return getText(R.string.main_pager_one);
                    case 1:
                        return getText(R.string.main_pager_two);
                    case 2:
                        return getText(R.string.main_pager_three);
                }
                return null;
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                Log.i("tage",page+"");
                pos = page;
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.colorPrimary,
                                ContextCompat.getDrawable(getBaseContext(), R.drawable.story));
                    case 1:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.colorPrimary,
                                ContextCompat.getDrawable(getBaseContext(), R.drawable.thanks));
                    case 2:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.colorPrimary,
                                ContextCompat.getDrawable(getBaseContext(), R.drawable.love));
                }
                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
    }

    private void initNavigationView() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        setupDrawerContent(navigationView);

        View headerView = navigationView.inflateHeaderView(R.layout.nav_header);
        mAvatarImage = (ImageView) headerView.findViewById(R.id.profile_image);
        mNameText = (TextView) headerView.findViewById(R.id.profile_name_text);

        setUserInfo();
    }

    private void setUserInfo() {
        if (DeviewSchedApplication.LOGIN_STATE) {
            Glide.with(this)
                    .load(mUser.picture)
                    .transform(new GlideCircleTransform(this))
                    .into(mAvatarImage);

            mNameText.setText(mUser.name);
            ((FrameLayout)findViewById(R.id.fl_nav_header_progressbar)).setVisibility(View.VISIBLE);
            ((RoundCornerProgressBar)findViewById(R.id.progress_5)).setProgressColor(Color.parseColor("#ed3b27"));
            ((RoundCornerProgressBar)findViewById(R.id.progress_5)).setMax(50);
            ((RoundCornerProgressBar)findViewById(R.id.progress_5)).setProgress(27);
        }
    }

    private void resetUserInfo() {
        mAvatarImage.setImageResource(R.drawable.person_image_empty);
        mNameText.setText(getText(R.string.please_login));

        LoginPreferenceHelper prefHelper = new LoginPreferenceHelper(getBaseContext());
        prefHelper.setPrefLoginValue(LoginPreferenceHelper.PREF_LOGIN_STATE, false);
        DeviewSchedApplication.LOGIN_STATE = false;
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_blooldonate:
                        Toast.makeText(getApplicationContext(),"헌혈증 관리",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, ManagingCardActivity.class));
                        break;

                    case R.id.nav_survey:
                        Toast.makeText(getApplicationContext(), "전자문진", Toast.LENGTH_SHORT).show();
                        String url = "https://bloodinfo.net/emi_bldqualify.do?action=emiPopup";
                        Intent it = new Intent(MainActivity.this, DiagnosisActivity.class);
                        it.putExtra("Url", url);
                        startActivity(it);
                        //showSche(getResources().getText(R.string.all_schedule));
                        break;

                    case R.id.nav_schedule:
                        Toast.makeText(getApplicationContext(), "스케쥴", Toast.LENGTH_SHORT).show();
                        //showFindFriends();
                        break;

                    case R.id.nav_history:
                        Toast.makeText(getApplicationContext(), "히스토리", Toast.LENGTH_SHORT).show();
                        //showLocation();
                        break;

                    case R.id.nav_account:
                        if (DeviewSchedApplication.LOGIN_STATE) {
                            LoginManager.getInstance().logOut();
                            resetUserInfo();
                            Toast.makeText(getBaseContext(), getText(R.string.logout_msg), Toast.LENGTH_LONG).show();

                            return true;
                        }
                        showAccount();
                        break;

                    case R.id.nav_setting:
                        //showSetting();
                        break;
                }
                menuItem.setChecked(true);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawers();
                return true;
            }
        });
    }

    public void showHome() {
        /**
         * Todo 아래의 메소드가 호출되면 MainActivity위로 있는 모든 Fragment가 소멸됨
         */
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

//    private void showSche(CharSequence title) {
//        Intent intent = new Intent(getBaseContext(), ScheActivity.class);
//        intent.putExtra("title", title);
//        startActivity(intent);
//    }
//
//    private void showFindFriends() {
//
//    }
//
//    private void showLocation() {
//        startActivity(new Intent(getBaseContext(), LocationActivity.class));
//    }

    private void showAccount() {
        startActivityForResult(new Intent(getBaseContext(), AccoutActivity.class), AccoutActivity.ACCOUNT_REQUEST);
    }

//    private void showSetting() {
//        startActivity(new Intent(getBaseContext(), SettingActivity.class));
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        AppEventsLogger.activateApp(this);
//    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        AppEventsLogger.deactivateApp(this);
//    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            showHome();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("Result", requestCode + " / " + resultCode);
        if (requestCode == AccoutActivity.ACCOUNT_REQUEST) {
            if (DeviewSchedApplication.LOGIN_STATE) {
                mUser = UserProfileProvider.getUserProfile(getBaseContext(), 60);
                setUserInfo();
                //이미지를 정상적으로 못불러오는 경우가 생김
            }
        }
        if (resultCode == PostingActivity.POSTING_REQUEST) {
            String title = data.getStringExtra("title");
            String context = data.getStringExtra("context");
            Board board = new Board(title, context, "http://file.thisisgame.com/upload/tboard/user/2011/05/08/20110508230252_2377.jpg");
            recyclerViewFragments[pos].addItem(board);
            Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
            Log.i("fsd","sdf");
        }
    }

    @Override
    public void updateUserProfile(Uri imageUri, String name) {
        this.mUser.picture = imageUri.toString();
        this.mUser.name = name;

        setUserInfo();
    }
}
