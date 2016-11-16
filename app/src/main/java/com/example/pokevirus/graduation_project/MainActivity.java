package com.example.pokevirus.graduation_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Firebase Ref;
    private RecyclerView category_list;
    private DatabaseReference mdatabase;
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Firebase.setAndroidContext(this);
        Ref = new Firebase("https://yourdocto.firebaseio.com/").child("Categories");
        Firebase.setAndroidContext(this);
        category_list = (RecyclerView) findViewById(R.id.category_list);
        category_list.setHasFixedSize(true);
        //   category_list.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        category_list.setLayoutManager(new GridLayoutManager(this,2));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart()
    {

        super.onStart();
        FirebaseRecyclerAdapter<categories,cateViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<categories, cateViewHolder>(
                categories.class,
                R.layout.category_card,
                cateViewHolder.class,
                Ref
        ){


            @Override
            protected void populateViewHolder(cateViewHolder cateViewHolder, categories categories, int i) {
                cateViewHolder.setName(categories.getName());
                cateViewHolder.setImage(getApplicationContext(),categories.getImage());

            }
        };

        category_list.setAdapter(firebaseRecyclerAdapter);
    }

    public static class cateViewHolder extends RecyclerView.ViewHolder {
        View mview;

        public cateViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
        }

        public void setName(String Name) {
            TextView name = (TextView) mview.findViewById(R.id.name);
            name.setText(Name);
        }

        public void setImage(android.content.Context ctx, String Image) {
            ImageView image = (ImageView) mview.findViewById(R.id.image);
            Picasso.with(ctx).load(Image).into(image);

        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(getApplicationContext(),Login.class));
        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
