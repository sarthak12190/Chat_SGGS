package com.example.chat_sggs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.chat_sggs.Addaptor.FragmentsAdaptor;
import com.example.chat_sggs.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.quickstart.auth.Sign_In_activity;

public class MainActivity extends AppCompatActivity {
//hello shreyaNerkar

    ActivityMainBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new FragmentsAdaptor(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        auth = FirebaseAuth.getInstance();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.settings:
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                auth.signOut();
                Intent intent = new Intent(MainActivity.this , Sign_In_activity.class);
                startActivity(intent);
                break;

            case R.id.groupChat:
                Intent intentt = new Intent(MainActivity.this , Group_Chat.class);
                startActivity(intentt);
                break;
        }
        return true;
    }
}