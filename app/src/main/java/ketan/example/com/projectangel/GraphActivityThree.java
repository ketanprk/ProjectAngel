package ketan.example.com.projectangel;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GraphActivityThree extends AppCompatActivity {
    private ActivityTabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar mToolbar;
    Context mContext;
    private int[] tabIcons = {
            R.drawable.chart,
            R.drawable.wallet,
            R.drawable.home, R.drawable.map_marker,
            R.drawable.ic_layers
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_three);
        mContext = this;
        tabLayout = findViewById(R.id.tabLayout_bottom);
        viewPager = findViewById(R.id.viewpager);
        mToolbar = findViewById(R.id.mToolbar);


        adapter = new ActivityTabAdapter(getSupportFragmentManager(), this);
        adapter.addFragment(new

                FragmentActivityThree(), tabIcons[0]);
        adapter.addFragment(new

                FragmentActivityThree(), tabIcons[1]);
        adapter.addFragment(new

                FragmentActivityThree(), tabIcons[2]);
        adapter.addFragment(new

                FragmentActivityThree(), tabIcons[3]);
        adapter.addFragment(new

                FragmentActivityThree(), tabIcons[4]);


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        highLightCurrentTab(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()

        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ActivityGraphFour.class));
                finish();
            }
        });

    }

    private void highLightCurrentTab(int position) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(adapter.getTabView(i));
        }
        TabLayout.Tab tab = tabLayout.getTabAt(position);
        assert tab != null;
        tab.setCustomView(null);
        tab.setCustomView(adapter.getSelectedTabView(position));
    }

}
