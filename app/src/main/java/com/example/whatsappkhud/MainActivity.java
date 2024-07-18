package com.example.whatsappkhud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.whatsappkhud.Adapter.FragmentAdapter;
import com.example.whatsappkhud.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.io.FileReader;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings) {
            //Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.logout) {
            auth.signOut();
            Intent intent = new Intent(MainActivity.this,SignInActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.GroupChat) {
            //Toast.makeText(this,"Group Chat", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,GroupChatActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}