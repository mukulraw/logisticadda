package com.freerentbuy.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.bottomNavigationView);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:

                        FragmentManager fm = getSupportFragmentManager();

                        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                            fm.popBackStack();
                        }

                        FragmentTransaction ft = fm.beginTransaction();
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        Web frag1 = new Web();
                        ft.replace(R.id.replace, frag1);
                        //ft.addToBackStack(null);
                        ft.commit();
                        //drawer.closeDrawer(GravityCompat.START);

                        break;
                    case R.id.action_search:


                        FragmentManager fm1 = getSupportFragmentManager();

                        for (int i = 0; i < fm1.getBackStackEntryCount(); ++i) {
                            fm1.popBackStack();
                        }

                        FragmentTransaction ft1 = fm1.beginTransaction();
                        ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        About frag11 = new About();
                        ft1.replace(R.id.replace, frag11);
                        //ft.addToBackStack(null);
                        ft1.commit();

                        break;
                    case R.id.action_blog:
                        FragmentManager fm2 = getSupportFragmentManager();

                        for (int i = 0; i < fm2.getBackStackEntryCount(); ++i) {
                            fm2.popBackStack();
                        }

                        FragmentTransaction ft2 = fm2.beginTransaction();
                        ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        Contact frag12 = new Contact();
                        ft2.replace(R.id.replace, frag12);
                        //ft.addToBackStack(null);
                        ft2.commit();

                        break;
                    case R.id.action_cart:
                        FragmentManager fm3 = getSupportFragmentManager();

                        for (int i = 0; i < fm3.getBackStackEntryCount(); ++i) {
                            fm3.popBackStack();
                        }

                        FragmentTransaction ft3 = fm3.beginTransaction();
                        ft3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        Advertise frag13 = new Advertise();
                        ft3.replace(R.id.replace, frag13);
                        //ft.addToBackStack(null);
                        ft3.commit();

                        break;
                    case R.id.action_orders:
                        FragmentManager fm31 = getSupportFragmentManager();

                        for (int i = 0; i < fm31.getBackStackEntryCount(); ++i) {
                            fm31.popBackStack();
                        }

                        FragmentTransaction ft31 = fm31.beginTransaction();
                        ft31.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        Blog frag131 = new Blog();
                        ft31.replace(R.id.replace, frag131);
                        //ft.addToBackStack(null);
                        ft31.commit();

                        break;
                }
                return true;
            }
        });

        navigation.setSelectedItemId(R.id.action_home);


    }
}