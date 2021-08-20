package com.shuke.homepage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class IndexFragment extends Fragment {

    TabLayout tab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_index, container, false);

        tab = inflate.findViewById(R.id.index_tab);

        for (int i = 0; i < CustomActivity.list.size(); i++) {
            tab.addTab(tab.newTab().setText(CustomActivity.list.get(i)));
        }

        return inflate;
    }
}