package com.example.whatsappkhud.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.whatsappkhud.Fragment.CallFragment;
import com.example.whatsappkhud.Fragment.ChatsFragment;
import com.example.whatsappkhud.Fragment.LiveFragment;
import com.example.whatsappkhud.Fragment.QuickFragment;
import com.example.whatsappkhud.Fragment.StatusFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new ChatsFragment();
            case 1:return new StatusFragment();
            case 2:return new CallFragment();
            case 3:return new LiveFragment();
            case 4:return new QuickFragment();
            default:return new ChatsFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;
        if (position==0){
            title="CHATS";
        }
        if (position==1){
            title="STATUS";
        }
        if (position==2){
            title="CALLS";
        }
        if (position==3){
            title="LIVE";
        }
        if (position==4){
            title="QUICK";
        }
        return title;
    }
}
