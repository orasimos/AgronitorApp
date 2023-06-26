package gr.aueb.cf.agronitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import gr.aueb.cf.agronitor.fragments.AlarmsFragment;
import gr.aueb.cf.agronitor.fragments.SettingsFragment;
import gr.aueb.cf.agronitor.fragments.StatsFragment;

public class ManagementActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private NavigationBarView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        bottomNavView = findViewById(R.id.bottomNavView);
        bottomNavView.setOnItemSelectedListener(this);
        bottomNavView.setSelectedItemId(R.id.stats);

        String greenhouseId = getIntent().getStringExtra("greenhouseId");
        getMeasurements(greenhouseId);
    }

    StatsFragment statsFragment = new StatsFragment();
    AlarmsFragment alarmsFragment = new AlarmsFragment();
    SettingsFragment settingsFragment = new SettingsFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.stats) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentFL, statsFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.alarms) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentFL, alarmsFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentFL, settingsFragment).commit();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void getMeasurements(String greenhouseId) {

    }
}