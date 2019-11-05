package com.fitn.findjavadeveloper.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fitn.findjavadeveloper.R;



public class DetailActivity extends AppCompatActivity{
    TextView Link, Username;
    Toolbar mActionBarToolbar;
    ImageView imageView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = (ImageView) findViewById(R.id.profile_image_header);
        Username = (TextView) findViewById(R.id.username);
        Link = (TextView) findViewById(R.id.giturl);

        String username = getIntent().getExtras().getString("login");
        String linkUrl = getIntent().getExtras().getString("html_url");
        String avatarUrl = getIntent().getExtras().getString("avatar_url");

        Link.setText(linkUrl);
        Link.setTextColor(getResources().getColor(R.color.linkColor));
        Linkify.addLinks(Link, Linkify.WEB_URLS);
        Username.setText(username);
        Glide.with(this)
                .load(avatarUrl)
                .placeholder(R.drawable.loadimage)
                .into(imageView);
        getSupportActionBar().setTitle("Developers Details");
    }

    private Intent createShareIntent(){
        String username = getIntent().getExtras().getString("login");
        String linkUrl = getIntent().getExtras().getString("html_url");
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this developer @" + username + ", " + linkUrl)
                .getIntent();
        return shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareIntent());
        return true;
    }
}
