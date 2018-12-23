package today.tailor.tt;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainTab extends AppCompatActivity {
    private static final String TAG = "Tab1Fragment";

    private SectionPageAdapter sectionPageAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main_tab);
        Log.d(TAG, "OnCreate Starting");

        sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        init();
    }


    public void init()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.textlogo);
    }

    public void setupViewPager(ViewPager viewPager)
    {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "New Product");
        adapter.addFragment(new Tab2Fragment(), "Featured");
        adapter.addFragment(new Tab3Fragment(), "Favourite");

        viewPager.setAdapter(adapter);
    }
}
