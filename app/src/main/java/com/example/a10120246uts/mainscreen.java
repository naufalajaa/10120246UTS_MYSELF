package com.example.a10120246uts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class mainscreen extends AppCompatActivity {
    //(8 juni 2023, 10120246, Muhammad Naufal Malikulmulki, IF-06)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        //ass variable
        drawerLayout = findViewById(R.id.DrawerLayout);

    }

    public void ClickMenu(View view) {
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        // open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view) {
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer

        // check
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        }
    }

    public void Clickmainscreen(View view) {
        recreate();
    }

    public void ClickDaily(View view) {
        //redirect to Daily
        redirectActivity(this, com.example.a10120246uts.Daily.class);
    }

    public void ClickGallery(View view) {
        //redirect to Gallery
        redirectActivity(this, com.example.a10120246uts.Gallery.class);
    }

    public void ClickMusic(View view) {
        //redirect to Music
        redirectActivity(this, com.example.a10120246uts.Music.class);
    }

    public void ClickProfile(View view) {
        //redirect to Profile
        redirectActivity(this, com.example.a10120246uts.Profile.class);
    }

    public void ClickLogout(View view) {
        //redirect to Logout
        logout(this);
    }

    public static void logout(final Activity activity) {
        //alert
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Log out");
        //set message
        builder.setMessage("Are you sure you want to Log out?");

        //positive
        builder.setPositiveButton("Log out", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //FINISH
                activity.finishAffinity();
                //exit
                System.exit(0);
            }

        });
        //negative
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //dismiss dialog
                dialog.dismiss();

            }

        });
        //show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //intent
        Intent intent = new Intent(activity, aClass);

        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //close
        closeDrawer(drawerLayout);
    }
}