package com.smkn1turen.belajarelektronik.ui;

import android.app.ActivityOptions;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.smkn1turen.belajarelektronik.MainActivity;
import com.smkn1turen.belajarelektronik.R;
import com.smkn1turen.belajarelektronik.UnityPlayerActivity;
import com.smkn1turen.belajarelektronik.constant.UniversalSetter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
                R.id.nav_home, R.id.nav_multimeter, R.id.nav_resistor,
                R.id.nav_kapasitor, R.id.nav_dioda, R.id.nav_transistor, R.id.nav_induktor,
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
        } else if (item.getItemId() == R.id.action_download) {
            copyAssets();
            Toast.makeText(MateriPembelajaran.this, "File terunduh pada folder AR-ELKA",Toast.LENGTH_SHORT).show();
//            createNotification();
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

    private void copyAssets() {
        AssetManager assetManager = getAssets();
        String filname = "materi_lengkap.pdf";
//        if (files != null) for (String filname : files) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filname);
            File dir = new File(Environment.getExternalStorageDirectory() + "/AR-ELKA/");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File outFile = new File(Environment.getExternalStorageDirectory() + "/AR-ELKA/" + filname);
            out = new FileOutputStream(outFile);
            copyFile(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // NOOP
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // NOOP
                }
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    private void createNotification() {
        Context context = MateriPembelajaran.this;
        File file = new File(Environment.getExternalStorageDirectory() + "/AR-ELKA/" + "materi_lengkap.pdf");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 10, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "file_channel");
        builder.setSmallIcon(R.drawable.ic_file_download_black_24dp)
                .setContentTitle("Materi diunduh")
                .setContentTitle("Klik disini untuk membuka materi")
                .setContentIntent(pendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("file_channel", "file", NotificationManager.IMPORTANCE_DEFAULT));
        }
        notificationManager.notify(20, builder.build());
    }
}
