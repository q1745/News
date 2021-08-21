package com.shuke.homepage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.shuke.homepage.adapter.MainVpAdapter;
import com.shuke.homepage.news.view.NewsFragment;

import java.util.ArrayList;
import java.util.List;


public class IndexFragment extends Fragment {

    TabLayout tab;
    ViewPager vp;
    List<Fragment> fragments = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_index, container, false);

        tab = inflate.findViewById(R.id.index_tab);
        vp = inflate.findViewById(R.id.index_vp);

//        fragments.add(new NewsFragment());

        for (int i = 0; i < CustomActivity.list.size(); i++) {
            tab.addTab(tab.newTab().setText(CustomActivity.list.get(i)));
        }

        vp.setAdapter(new MainVpAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments));

        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                vp.setCurrentItem(0);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return inflate;
    }
}