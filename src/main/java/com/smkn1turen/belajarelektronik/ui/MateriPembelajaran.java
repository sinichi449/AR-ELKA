package com.smkn1turen.belajarelektronik.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.smkn1turen.belajarelektronik.MainActivity;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.UnityPlayerActivity;
import com.smkn1turen.belajarelektronik.constant.UniversalSetter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MateriPembelajaran extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_pembelajaran);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UniversalSetter.setOrangeStatusBar(getWindow(), getResources());

        FloatingActionButton fab = findViewById(R.id.fab);
        // TODO: Replace code
        fab.setOnClickListener(v -> {
            Toast.makeText(MateriPembelajaran.this, "Membuka AR", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MateriPembelajaran.this, UnityPlayerActivity.class));
        });
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_resistor, R.id.nav_kapasitor,
                R.id.nav_dioda, R.id.nav_transistor, R.id.nav_induktor,
                R.id.nav_integrated_circuit)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.materi_pembelajaran, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_home) {
            Intent intent = new Intent(MateriPembelajaran.this, MainActivity.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(MateriPembelajaran.this, android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            startActivity(intent, options.toBundle());
            finish();
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}
