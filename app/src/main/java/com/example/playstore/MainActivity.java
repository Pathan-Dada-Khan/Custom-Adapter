package com.example.playstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Store> store =new ArrayList<Store>();

        store.add(new Store("Amazon","Amazon Mobile LLC",R.drawable.amazon,"in.amazon.mShop.android.shopping"));
        store.add(new Store("Truecaller","Truecaller LLC",R.drawable.call,"com.truecaller"));
        store.add(new Store("Facebook","Facebook LLC",R.drawable.fb,"com.facebook.katana"));
        store.add(new Store("Files","Google LLC",R.drawable.files,"com.google.android.apps.nbu.files"));
        store.add(new Store("Gallery","Gallery App",R.drawable.gallery,"oss.gallerynew.android"));
        store.add(new Store("Hotstar","Disney + Hotstar",R.drawable.hotstar,"in.startv.hotstar"));
        store.add(new Store("Instagram","Facebook LLC",R.drawable.insta,"com.instagram.android"));
        store.add(new Store("MX Player","MX Media",R.drawable.mx,"com.mxtech.videoplayer.ad"));
        store.add(new Store("Google Pay","Google LLC",R.drawable.pay,"com.google.android.apps.nbu.paisa.user"));
        store.add(new Store("Pics Art","PicsArt",R.drawable.pics,"com.picsart.studio"));
        store.add(new Store("BGMI","Battle Grounds Mobile India",R.drawable.pubg,"com.pubg.imobile"));
        store.add(new Store("Snapchat","Snap Inc",R.drawable.snap,"com.snapchat.android"));
        store.add(new Store("Twitter","Twitter, Inc.",R.drawable.tiwt,"com.twitter.android"));
        store.add(new Store("VLC","Videolabs",R.drawable.vlc,"org.videolan.vlc"));
        store.add(new Store("WhatsApp","Facebook LLC",R.drawable.whats,"com.whatsapp"));
        store.add(new Store("Wynk Music","Airtel",R.drawable.wynk,"com.bsbportal.music"));

        MyListAdapter adapter =new MyListAdapter(this,store);
        ListView lv=(ListView) findViewById(R.id.listview);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Store s=store.get(position);
                Intent i=new Intent(MainActivity.this,Installer.class);
                Bundle bundle=new Bundle();
                bundle.putInt("image",s.getImg());
                i.putExtras(bundle);
                i.putExtra("title",s.getTitle());
                i.putExtra("des",s.getDes());
                i.putExtra("app",s.getApp());
                startActivity(i);
            }
        });
    }
}