package com.example.a10120246uts;


import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Gallery extends AppCompatActivity {
    //(8 juni 2023, 10120246, Muhammad Naufal Malikulmulki, IF-06)
    Context contextGallery;
    RecyclerView recyclerViewGallery;
    RecyclerView.Adapter recyclerViewAdapterGallery;
    RecyclerView.LayoutManager recylerViewLayoutManagerGallery;
    String[] subjectsGallery = {
            "Foto1", "Foto2", "Foto3"
    };
    int[] subjectImageGallery={

            R.drawable.image_dr,
            R.drawable.nopal2,
            R.drawable.nopal3

    };
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);
        contextGallery = getApplicationContext();
        recyclerViewGallery = findViewById(R.id.recyclerViewGallery);
        recylerViewLayoutManagerGallery = new GridLayoutManager( contextGallery, 2);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewGallery.setLayoutManager(recylerViewLayoutManagerGallery);
        recyclerViewAdapterGallery = new AdapterRecyclerViewGallery(subjectsGallery, subjectImageGallery,contextGallery );
        recyclerViewGallery.setAdapter(recyclerViewAdapterGallery);
        //ass
        drawerLayout = findViewById(R.id.DrawerLayout);
    }
    public void ClickMenu(View view){
        //Open drawer
        mainscreen.openDrawer(drawerLayout);

    }
    public void Clickmainscreen(View view){mainscreen.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        //redirect to home
        mainscreen.redirectActivity(this,mainscreen.class);
    }
    public void ClickGallery(View view){
        //recreate
        recreate();
    }

    public void ClickDaily(View view){
        //redirect to gallery
        mainscreen.redirectActivity(this,Daily.class);
    }
    public void ClickMusic(View view){
        //redirect to music
        mainscreen.redirectActivity(this,Music.class);
    }
    public void ClickProfile(View view){
        //redirect to profile
        mainscreen.redirectActivity(this,Profile.class);
    }
    public void ClickLogout(View view){
        //close
        mainscreen.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        mainscreen.closeDrawer(drawerLayout);
    }
}