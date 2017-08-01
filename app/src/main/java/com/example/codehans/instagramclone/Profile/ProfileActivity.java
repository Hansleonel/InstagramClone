package com.example.codehans.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.codehans.instagramclone.R;
import com.example.codehans.instagramclone.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by ogtie05 on 24/07/2017.
 */
//Crearemos todas las activities independientes de los layouts propios, por ahora.
public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    //esta variable se usara para ubicar la animacion del BottomNavigationView
    private static final int ACTIVITY_NUM = 4;

    private Context mContext = ProfileActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: Empenzando");

        setupBottomNavigationView();
        setupToolbar();
    }

    //metodo usado para usar el toolbar del activity_profile
    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG, "onMenuItemClick: clicked menu item : " + item);

                switch (item.getItemId()) {
                    case R.id.profileMenu:
                        Log.d(TAG, "onMenuItemClick: ir a las opciones del perfil");
                }
                return false;
            }
        });

    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: personalizando el BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigationView(mContext, bottomNavigationViewEx);
        //selecciona en el navigationBottom 
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    //metodo para la visualizacion correcta de las opciones de menu
    //metodo obligatorio para la aparicion del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }
}
