package rungene.com.forsale;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import rungene.com.forsale.account.LoginActivity;
import rungene.com.forsale.util.SectionsPagerAdapter;


public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";

    //widgets
   private TabLayout tabLayout;
   public ViewPager viewPager;

   //vars
    public SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        setUpViewPager();
    }

    private  void setUpViewPager(){
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

      viewPager.setAdapter(sectionsPagerAdapter);
      tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        int id = item.getItemId();

        if (id==R.id.menu_logout){
           signOut();
            return true;
        }else {
            Toast.makeText(this, "Not logged out", Toast.LENGTH_SHORT).show();
        }



 /*       switch (item.getItemId()) {
            case R.id.menu_logout:
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
                signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/

        return super.onOptionsItemSelected(item);

    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(SearchActivity.this, LoginActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
    }

    }

