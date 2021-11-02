package com.example.waterwand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference to bottom navigation viewer
        //BottomNavigationView bottomNav = findViewById(R.id.my_nav);
        //bottomNav.setOnItemSelectedListener(navListener);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new FirstFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.my_nav);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment fragment = null;
                switch (item.getItemId())
                {
                    case R.id.firstFragment:
                        fragment = new FirstFragment();
                        break;
                    case R.id.secondFragment:
                        fragment = new SecondFragment();
                        break;
                    case R.id.thirdFragment:
                        fragment = new ThirdFragment();
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
                return true;
            }
        });

        //React to clicks on an item
      /*private BottomNavigationView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean OnItemSelectedListener(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.firstFragment:
                            selectedFragment = new FirstFragment();
                            break;
                        case R.id.secondFragment:
                            selectedFragment = new SecondFragment();
                            break;
                        case R.id.thirdFragment:
                            selectedFragment = new ThirdFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, selectedFragment).commit();
                    return true;
                }

            };
*/
    }
}