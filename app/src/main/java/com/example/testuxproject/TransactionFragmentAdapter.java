package com.example.testuxproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TransactionFragmentAdapter extends FragmentStateAdapter {

    public TransactionFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (GlobalData.transactions.size() > 0) return new transaction();
        return new notransaction();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
