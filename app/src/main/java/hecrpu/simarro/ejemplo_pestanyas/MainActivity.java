package hecrpu.simarro.ejemplo_pestanyas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = (BottomNavigationView) findViewById(R.id.menuNavigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment f = null;
        switch (item.getItemId()){
            case R.id.navigationHome:
                f = new HomeFragment();
                break;
            case R.id.navigationDashboard:
                f = new DashboardFragment();
                break;
        }
        if (f != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedor, f)
                    .commit();
        }

        return true;
    }
}