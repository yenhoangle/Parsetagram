package com.example.yhle.parsetagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.yhle.parsetagram.fragments.ComposeFragment;
import com.example.yhle.parsetagram.fragments.PostsFragment;
import com.example.yhle.parsetagram.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private Button btnSignOut;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        final Fragment postsFragment = new PostsFragment();
        final Fragment composeFragment = new ComposeFragment();
        final Fragment profileFragment = new ProfileFragment();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        //listen for click on bottom navigation bar and navigate to appropriate fragment
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        fragment = composeFragment;
                        break;
                    case R.id.action_compose:
                        fragment = composeFragment;
                        break;
                    case R.id.action_profile:
                        fragment = composeFragment;
                        break;
                    default:
                        fragment = composeFragment;
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        //set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
}