package com.smkn1turen.belajarelektronik.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.smkn1turen.belajarelektronik.MainActivity;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.constant.SetBasicAppearance;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MateriPembelajaran extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_pembelajaran);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SetBasicAppearance.setOrangeStatusBar(getWindow(), getResources());

        FloatingActionButton fab = findViewById(R.id.fab);
        // TODO: Replace code
        fab.setOnClickListener(view -> Snackbar.make(view, "Open AR Camera", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_resistor, R.id.nav_kapasitor,
                R.id.nav_dioda, R.id.nav_transistor, R.id.nav_induktor,
                R.id.nav_integrated_circuit, R.id.nav_daftar_pustaka)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
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
