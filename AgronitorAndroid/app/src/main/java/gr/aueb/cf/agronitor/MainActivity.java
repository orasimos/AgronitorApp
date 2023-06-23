package gr.aueb.cf.agronitor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.agronitor.adapters.GreenhouseAdapter;
import gr.aueb.cf.agronitor.apiclient.ApiClient;
import gr.aueb.cf.agronitor.apiclient.IApiService;
import gr.aueb.cf.agronitor.apiclient.greenhouses.GreenhouseRequest;
import gr.aueb.cf.agronitor.apiclient.greenhouses.GreenhouseResponse;
import gr.aueb.cf.agronitor.models.Greenhouse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView greenhousesRV;
    private FloatingActionButton addGreenhouse;
    private String newGreenhouseName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greenhousesRV = findViewById(R.id.greenhousesRV);
        addGreenhouse = findViewById(R.id.addGreenhouse);
        String userId = getIntent().getStringExtra("userId");
        ArrayList<Greenhouse> greenhouses = getGreenhouses(userId);

//        List<Greenhouse> greenhouseArrayList = new ArrayList<Greenhouse>();
//        greenhouseArrayList.add(new Greenhouse("Tomatoes"));
//        greenhouseArrayList.add(new Greenhouse("Potatoes"));
//        greenhouseArrayList.add(new Greenhouse("Cucumbers"));
//        greenhouseArrayList.add(new Greenhouse("Peppers"));

        GreenhouseAdapter greenhouseAdapter = new GreenhouseAdapter(
                this, greenhouses);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);

        greenhousesRV.setLayoutManager(linearLayoutManager);
        greenhousesRV.setAdapter(greenhouseAdapter);

        addGreenhouse.setOnClickListener(new View.OnClickListener() {
//            TODO: Add new greenhouse
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final EditText input = new EditText(MainActivity.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);

                builder.setTitle("Name your new greenhouse")
                        .setView(input)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                newGreenhouseName = input.getText().toString();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });
    }

    private ArrayList<Greenhouse> getGreenhouses(String userId) {
        ArrayList<Greenhouse> greenhouses = new ArrayList<>();
        IApiService apiService;
        apiService = ApiClient.getApiClient().create(IApiService.class);
        Call<GreenhouseResponse> call = apiService.getGreenhouses(userId);
        call.enqueue(new Callback<GreenhouseResponse>() {
            @Override
            public void onResponse(Call<GreenhouseResponse> call, Response<GreenhouseResponse> response) {
                if (response.isSuccessful()) {
                    greenhouses.addAll(response.body().getGreenhouseList());
                }
            }

            @Override
            public void onFailure(Call<GreenhouseResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return greenhouses;
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}