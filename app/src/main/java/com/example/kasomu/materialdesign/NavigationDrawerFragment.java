package com.example.kasomu.materialdesign;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    private RecyclerView recyclerView;
    public static ActionBarDrawerToggle mDrawerToggle;
    private drawerAdapter adapter;
    private DrawerLayout mDrawerLayout;
    // private boolean mUserLearnedDrawer;
    //private boolean mFromSavedInstanceState;
    private View containerView;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* mUserLearnedDrawer = Boolean.getBoolean(readFromPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
        if(savedInstanceState!=null)
        {
            mFromSavedInstanceState = true;
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(
                R.layout.fragment_navigation_drawer, container, false);
        rootView.setFitsSystemWindows(true);
        //Assigning the recyclerView  -- Reference : https://www.youtube.com/watch?v=Wq2o4EbM74k&index=13&list=PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD
        recyclerView = (RecyclerView) rootView.findViewById(R.id.drawerList);
        adapter = new drawerAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }


    public static List<drawer_recycleViewInfo> getData()
    {
        List<drawer_recycleViewInfo> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_action_home,R.drawable.ic_action_search,R.drawable.ic_action_user,R.drawable.ic_action_settings};
        String[] titles = {"My Home","Job Search","My Profile","Settings"};
        for(int i=0;i<titles.length&&i<icons.length;i++)
        {
            drawer_recycleViewInfo current = new drawer_recycleViewInfo();
            current.text = titles[i];
            current.iconid = icons[i];
            data.add(current);
        }
        return data;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        mDrawerLayout = drawerLayout;
        containerView = getActivity().findViewById(fragmentId);
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
               /* if(!mUserLearnedDrawer)
                {
                    mUserLearnedDrawer = true;
                    saveToPreference(getActivity(),PREF_FILE_NAME,mUserLearnedDrawer+"");
                }*/
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };
        mDrawerToggle.syncState();
        /*if(!mUserLearnedDrawer && !mFromSavedInstanceState)
        {
            mDrawerLayout.openDrawer(containerView);

        }*/
        mDrawerLayout.setDrawerListener(mDrawerToggle);
       /* mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });*/
    }

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    public static void saveToPreference(Context context, String preferenceName, String preferenceValue) {
        //Should pass filename and Mode
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }

}
