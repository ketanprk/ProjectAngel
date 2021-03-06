package ketan.example.com.projectangel;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentActivityThree extends android.support.v4.app.Fragment {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_activity_three, container, false);

        addChart(view);
        return view;
    }

    private void addChart(View view) {
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewpager);
        adapter = new TabAdapter(getChildFragmentManager(), getContext());
        adapter.addFragment(new

                TabFragment3(), "Day");
        adapter.addFragment(new

                TabFragment3(), "week");
        adapter.addFragment(new

                TabFragment3(), "month");
        adapter.addFragment(new

                TabFragment3(), "year");
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