package com.example.designmodal.edevnews.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.designmodal.edevnews.DataManager.ApiClient;
import com.example.designmodal.edevnews.DataManager.ApiInterface;
import com.example.designmodal.edevnews.Fragment.NewsFragment;
import com.example.designmodal.edevnews.Model.MenuModel;
import com.example.designmodal.edevnews.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Navigation_Drawer_Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation__drawer__main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        DisplayMenu();
    }

    public void DisplayMenu()
    {

        ApiInterface service = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<MenuModel>> call = service.getNewsCategory();

        call.enqueue(new Callback<List<MenuModel>>() {
            @Override
            public void onResponse(Call<List<MenuModel>> call, Response<List<MenuModel>> response) {
                List<MenuModel> NewsCategroyList = response.body();
                for(int i =0; i<NewsCategroyList.size();i++)
                {
                    final String category = NewsCategroyList.get(i).getCategory_title();
                    final String category_id = NewsCategroyList.get(i).getCategory_id();
                    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                    final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                    Menu menu =navigationView.getMenu();
                    menu.add(category).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem)
                        {
                            Bundle bundle = new Bundle();
                            bundle.putString("category_id_Param", category_id );
                            NewsFragment fragInfo = new NewsFragment();
                            fragInfo.setArguments(bundle);
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragInfo).commit();
                            return false;
                        }
                    });
                    drawerLayout.closeDrawers();

                }
            }
            @Override
            public void onFailure(Call<List<MenuModel>> call, Throwable t) {
                Toast.makeText(Navigation_Drawer_Main.this, "Error", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation__drawer__main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        return true;
    }
}
