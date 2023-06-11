package com.example.a10120246uts;


import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Daily extends AppCompatActivity {
    //(8 juni 2023, 10120246, Muhammad Naufal Malikulmulki, IF-06)
    DrawerLayout drawerLayout;
    Context context, contextFriend;
    RecyclerView recyclerView, recyclerViewFriend;
    RecyclerView.Adapter recyclerViewAdapter, recyclerViewAdapterFriend;
    RecyclerView.LayoutManager recylerViewLayoutManager, recylerViewLayoutManageFriend;
    String[] subjects = {
            "Wake Up", "Take a Bath", "Have a Breakfast", "Studying", "homework", "Playing Games",
            "Have a Dinner", "Playing Handphone", "Sleep"
    };
    int[] subjectImage = {
            R.drawable.ic_bangun, R.drawable.ic_mandi,
            R.drawable.ic_makanan, R.drawable.ic_sekul,
            R.drawable.ic_fact, R.drawable.ic_game,
            R.drawable.ic_makan, R.drawable.ic_hp,
            R.drawable.ic_tidur
    };
    String[] subjectsName = {
            "Fahmi", "Abyan", "Adit", "Rahmat"
    };
    int[] subjectImageFriend = {
            R.drawable.fahmi, R.drawable.byan,
            R.drawable.dit, R.drawable.mamat
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        context = getApplicationContext();
        recyclerView = findViewById(R.id.recyclerView);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new AdapterRecyclerView(subjects, subjectImage, context);
        recyclerView.setAdapter(recyclerViewAdapter);

        contextFriend = getApplicationContext();
        recyclerViewFriend = findViewById(R.id.recyclerViewFriend);
        recylerViewLayoutManageFriend = new LinearLayoutManager(contextFriend, LinearLayoutManager.HORIZONTAL, false);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewFriend.setLayoutManager(recylerViewLayoutManageFriend);
        recyclerViewAdapterFriend = new com.example.a10120246uts.AdapterRecyclerViewFriend(subjectsName, subjectImageFriend, contextFriend);
        recyclerViewFriend.setAdapter(recyclerViewAdapterFriend);


        drawerLayout = findViewById(R.id.DrawerLayout);
    }

    public void ClickMenu(View view) {
        //Open drawer
        mainscreen.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view) {
        mainscreen.closeDrawer(drawerLayout);
    }

    public void Clickmainscreen (View view) {
        //redirect to home
        mainscreen.redirectActivity(this, com.example.a10120246uts.mainscreen.class);
    }

    public void ClickDaily(View view) {
        //recreate
        recreate();
    }

    public void ClickGallery(View view) {
        //redirect to gallery
        mainscreen.redirectActivity(this, com.example.a10120246uts.Gallery.class);
    }

    public void ClickMusic(View view) {
        //redirect to music
        mainscreen.redirectActivity(this, com.example.a10120246uts.Music.class);
    }

    public void ClickProfile(View view) {
        //redirect to profile
        mainscreen.redirectActivity(this, com.example.a10120246uts.Profile.class);
    }

    public void ClickLogout(View view) {
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