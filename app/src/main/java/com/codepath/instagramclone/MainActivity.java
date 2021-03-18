package com.codepath.instagramclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.codepath.instagramclone.fragments.ComposeFragment;
import com.codepath.instagramclone.fragments.PostsFragment;
import com.codepath.instagramclone.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;

    private Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLogOut = findViewById(R.id.btnLogOut);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null

                Log.i(TAG,"Successfully logged out");
                goToLoginActivity();

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        //TODO: update fragment
                        Toast.makeText(MainActivity.this,"Home",Toast.LENGTH_SHORT).show();
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        Toast.makeText(MainActivity.this,"Compose",Toast.LENGTH_SHORT).show();
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:

                    default:
                        
                        Toast.makeText(MainActivity.this,"Profile",Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }

    private void goToLoginActivity() {
        Intent i = new Intent (this, LoginActivity.class);
        startActivity(i);
        Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Reached Login Page");

    }


}