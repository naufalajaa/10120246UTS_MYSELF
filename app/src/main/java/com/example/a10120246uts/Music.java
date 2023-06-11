package com.example.a10120246uts;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Music extends AppCompatActivity {
    //(8 juni 2023, 10120220, Muhammad Naufal Malikulmulki, IF-06)
    Context contextVideo, context;
    RecyclerView recyclerViewVideo, recyclerViewMusic;
    RecyclerView.Adapter recyclerViewAdapterVideo, recyclerViewAdapterMusic;
    RecyclerView.LayoutManager recylerViewLayoutManagerVideo, recylerViewLayoutManagerMusic;
    VideoView videoView;
    String[] subjectValuesVideo = {
            "Yosobi", "Yoasobi Dance", "KaiKai Kitan"
    };
    String[] subjectUrlVideo;
    String[] subjectValuesMusic = {
            "Terlukis Indah-Rizky Febian feat Ziva Magnolya",
            "Tentang Dirimu-Raisa",
            "Bagaimana Kalau Aku Tidak Baik-Baik Saja-Judika",
            "Ingkar-Tulus",
            "Pesan Terakhir-Lyodra",
            "Hadapi Berdua-Tiara Andini",
            "Hari Bahagia-Atta Halilintar dan Aurel Hermansyah",
            "Sahabat Tak Akan Pergi-Betrand Peto feat Anneth Delliecia",
            "Bisa Tanpamu-Andmesh",
            "Tenang-Yura Yunita"
    };
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        subjectUrlVideo = new String[]{
                "android.resource://" + getPackageName() + "/" + R.raw.yoasobi,
                "android.resource://" + getPackageName() + "/" + R.raw.yoasobi2,
                "android.resource://" + getPackageName() + "/" + R.raw.kaikaikitan
        };
        contextVideo = getApplicationContext();
        recyclerViewVideo = findViewById(R.id.recyclerViewVideo);
        recylerViewLayoutManagerVideo = new LinearLayoutManager(this);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewVideo.setLayoutManager(recylerViewLayoutManagerVideo);
        recyclerViewAdapterVideo = new com.example.a10120246uts.AdapterRecycleViewVideo(subjectValuesVideo, subjectUrlVideo, this);
        recyclerViewVideo.setAdapter(recyclerViewAdapterVideo);

        context = getApplicationContext();
        recyclerViewMusic = findViewById(R.id.recyclerViewMusic);
        recylerViewLayoutManagerMusic = new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewMusic.setLayoutManager(recylerViewLayoutManagerMusic);
        recyclerViewAdapterMusic = new com.example.a10120246uts.AdapterRecycleViewMusic(subjectValuesMusic, context);
        recyclerViewMusic.setAdapter(recyclerViewAdapterMusic);

        //ass
        drawerLayout = findViewById(R.id.DrawerLayout);
    }

    public void ClickMenu(View view) {
        //Open drawer
        com.example.a10120246uts.mainscreen.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view) {
        com.example.a10120246uts.mainscreen.closeDrawer(drawerLayout);
    }

    public void Clickmainscreen(View view) {
        //redirect to home
        com.example.a10120246uts.mainscreen.redirectActivity(this, com.example.a10120246uts.mainscreen.class);
    }

    public void ClickGallery(View view) {
        //redirect to gallery
        com.example.a10120246uts.mainscreen.redirectActivity(this, com.example.a10120246uts.Gallery.class);
    }

    public void ClickDaily(View view) {
        //redirect to gallery
        com.example.a10120246uts.mainscreen.redirectActivity(this, com.example.a10120246uts.Daily.class);
    }

    public void ClickMusic(View view) {

        //recreate
        recreate();
    }

    public void ClickProfile(View view) {
        //redirect to profile
        com.example.a10120246uts.mainscreen.redirectActivity(this, com.example.a10120246uts.Profile.class);
    }

    public void ClickLogout(View view) {
        //close
        com.example.a10120246uts.mainscreen.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        com.example.a10120246uts.mainscreen.closeDrawer(drawerLayout);
    }
}