package gr.aueb.cf.agronitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

import gr.aueb.cf.agronitor.apiclient.ApiClient;
import gr.aueb.cf.agronitor.apiclient.IApiService;
import gr.aueb.cf.agronitor.apiclient.measurements.MeasurementsResponse;
import gr.aueb.cf.agronitor.fragments.AlarmsFragment;
import gr.aueb.cf.agronitor.fragments.SettingsFragment;
import gr.aueb.cf.agronitor.fragments.StatsFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagementActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private NavigationBarView bottomNavView;
    private String currentTemp;
    private String currentHum;
    private String currentHydr;
    private String currentUV;
    private String minTemp;
    private String maxTemp;
    private String minHum;
    private String maxHum;
    private String minHydr;
    private String maxHydr;
    private String minUV;
    private String maxUV;

    StatsFragment statsFragment = new StatsFragment();
    AlarmsFragment alarmsFragment = new AlarmsFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        String greenhouseId = getIntent().getStringExtra("greenhouseId");
        getMeasurements(greenhouseId);

        Bundle bundle = new Bundle();
        bundle.putString("currentTemp", currentTemp);
        bundle.putString("currentHum", currentHum);
        bundle.putString("currentHydr", currentHydr);
        bundle.putString("currentUV", currentUV);
        bundle.putString("minTemp", minTemp);
        bundle.putString("maxTemp", maxTemp);
        bundle.putString("minHum", minHum);
        bundle.putString("maxHum", maxHum);
        bundle.putString("minHydr", minHydr);
        bundle.putString("maxHydr", maxHydr);
        bundle.putString("minUV", minUV);
        bundle.putString("maxUV", maxUV);
        statsFragment.setArguments(bundle);

        bottomNavView = findViewById(R.id.bottomNavView);
        bottomNavView.setOnItemSelectedListener(this);
//        bottomNavView.setSelectedItemId(R.id.stats);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.stats) {
//            Bundle bundle = new Bundle();
//            bundle.putString("currentTemp", currentTemp);
//            bundle.putString("currentHum", currentHum);
//            bundle.putString("currentHydr", currentHydr);
//            bundle.putString("currentUV", currentUV);
//            bundle.putString("minTemp", minTemp);
//            bundle.putString("maxTemp", maxTemp);
//            bundle.putString("minHum", minHum);
//            bundle.putString("maxHum", maxHum);
//            bundle.putString("minHydr", minHydr);
//            bundle.putString("maxHydr", maxHydr);
//            bundle.putString("minUV", minUV);
//            bundle.putString("maxUV", maxUV);
//            statsFragment.setArguments(bundle);
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
        IApiService apiService = ApiClient.getApiClient().create(IApiService.class);
        Call<MeasurementsResponse> call = apiService.getMeasurements(greenhouseId);
        call.enqueue(new Callback<MeasurementsResponse>() {
            @Override
            public void onResponse(Call<MeasurementsResponse> call, Response<MeasurementsResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        currentTemp = response.body().getCurrentTemp();
                        System.out.println(currentTemp);
                        currentHum = response.body().getCurrentHum();
                        currentHydr = response.body().getCurrentHydr();
                        currentUV = response.body().getCurrentUV();
                        minTemp = response.body().getMinTemp();
                        maxTemp = response.body().getMaxTemp();
                        minHum = response.body().getMinHum();
                        maxHum = response.body().getMaxHum();
                        minHydr = response.body().getMinHydr();
                        maxHydr = response.body().getMaxHydr();
                        minUV = response.body().getMinUV();
                        maxUV = response.body().getMaxUV();

                        Bundle bundle = new Bundle();
                        bundle.putString("currentTemp", currentTemp);
                        bundle.putString("currentHum", currentHum);
                        bundle.putString("currentHydr", currentHydr);
                        bundle.putString("currentUV", currentUV);
                        bundle.putString("minTemp", minTemp);
                        bundle.putString("maxTemp", maxTemp);
                        bundle.putString("minHum", minHum);
                        bundle.putString("maxHum", maxHum);
                        bundle.putString("minHydr", minHydr);
                        bundle.putString("maxHydr", maxHydr);
                        bundle.putString("minUV", minUV);
                        bundle.putString("maxUV", maxUV);
                        statsFragment.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentFL, statsFragment).commit();
                    } else {
                        Toast.makeText(ManagementActivity.this, "There are not measurements yet", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<MeasurementsResponse> call, Throwable t) {
                Toast.makeText(ManagementActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}