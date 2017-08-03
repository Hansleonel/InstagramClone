package com.example.codehans.instagramclone.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.codehans.instagramclone.R;
import com.example.codehans.instagramclone.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Organizador de Logs";
    private Context mContext = MainActivity.this;
    private static final int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: Starting");

        //invocando al personalizador del navigationViewEx
        setupBottomNavigationView();
        setupViewPager();
    }

    //agregamos los fragments a los tabs en este caso cameraframent mainfragment y messageframent al
    //TabLayout
    private void setupViewPager() {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        //agregando los fragments a los tabs
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new MainFragment());
        adapter.addFragment(new MessagesFragment());

        //el viewPager actua como contenedor de los fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPagerContainer);
        //agrega el adaptador con los fragments dentro de los tabs al viewpager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        //para asignarle un icono a cada tab del TabLayout
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
    }

    //BottomNavigationView setup o personalizacion y seleccion el navigationBottom
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        //personalizando el navigationViewEx
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigationView(mContext, bottomNavigationViewEx);
        //selecciona en el navigationBottom
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }


}
