package com.example.testuxproject.homepage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testuxproject.fragment_console;
import com.example.testuxproject.fragment_mobile;
import com.example.testuxproject.fragment_pc;
import com.example.testuxproject.fragment_recommend;

public class Home_tab_adapter extends FragmentStateAdapter {

    public Home_tab_adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return  new fragment_recommend();
            case 1: return new fragment_mobile();
            case 2: return new fragment_pc();
            case 3: return new fragment_console();

        }
        return new fragment_recommend();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
