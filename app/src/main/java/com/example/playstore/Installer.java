package com.example.playstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class Installer extends AppCompatActivity {

    ImageView image;
    TextView title,des;
    Button open,install,uninstall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installer);

        image=(ImageView)findViewById(R.id.installer_img);
        title=(TextView)findViewById(R.id.installer_title);
        des=(TextView)findViewById(R.id.installer_des);
        open=(Button)findViewById(R.id.open);
        install=(Button)findViewById(R.id.install);
        uninstall=(Button)findViewById(R.id.uninstall);

        open.setVisibility(View.GONE);
        uninstall.setVisibility(View.GONE);

        Intent intent =getIntent();

        Bundle bundle =this.getIntent().getExtras();
        int img =bundle.getInt("image");
        String aTitle = intent.getStringExtra("title");
        String aDes = intent.getStringExtra("des");
        String aApp = intent.getStringExtra("app");
        image.setImageResource(img);
        title.setText(aTitle);
        des.setText(aDes);

        install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                install.setVisibility(View.GONE);
                open.setVisibility(View.VISIBLE);
                uninstall.setVisibility(View.VISIBLE);
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpen = new Intent();
                intentOpen.setPackage(aApp);
                try{
                    startActivity(intentOpen);
                }catch (ActivityNotFoundException e){
                    Intent intentMarket = new Intent(Intent.ACTION_VIEW);
                    intentMarket.setData(Uri.parse("market://details?id=" +aApp));
                    startActivity(intentMarket);
                }
            }
        });

        uninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open.setVisibility(View.GONE);
                uninstall.setVisibility(View.GONE);
                install.setVisibility(View.VISIBLE);
            }
        });

    }
}