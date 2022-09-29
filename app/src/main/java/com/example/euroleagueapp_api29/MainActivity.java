package com.example.euroleagueapp_api29;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity<toolbar> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            LoginFragment loginFragment = new LoginFragment().newInstance();
            // RegisterFragment registerFragment = new RegisterFragment().newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.viewPager, loginFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case (R.id.action_about): {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.viewPager, new AboutFragment())
                        .addToBackStack("")
                        .commit();
                return true;
            }
            case (R.id.action_exit):{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}