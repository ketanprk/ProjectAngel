package ketan.example.com.projectangel;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityTabAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<Integer> mFragmentIconList = new ArrayList<>();
    private Context mContext;

    ActivityTabAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public void addFragment(Fragment fragment, int tabIcon) {
        mFragmentList.add(fragment);
        mFragmentIconList.add(tabIcon);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_tab_activity, null);
        TextView tabTextView = view.findViewById(R.id.tabTextView);
        ImageView tabImageView = view.findViewById(R.id.tabImageView);
        tabImageView.setImageResource(mFragmentIconList.get(position));
        return view;
    }

    public View getSelectedTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.selected_tab_activity, null);
        ImageView tabImageView = view.findViewById(R.id.tabImageView);
        tabImageView.setImageResource(mFragmentIconList.get(position));
        tabImageView.setColorFilter(ContextCompat.getColor(mContext, R.color.blue), PorterDuff.Mode.SRC_ATOP);
        return view;
    }

}
