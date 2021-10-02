package com.example.paynav_assignment.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.paynav_assignment.Fragments.receiveFragment;
import com.example.paynav_assignment.Fragments.returnFragment;

public class ReturnReceiveAdapter extends FragmentStateAdapter {
    public ReturnReceiveAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 1){
            return new receiveFragment();
        }

        return new returnFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
