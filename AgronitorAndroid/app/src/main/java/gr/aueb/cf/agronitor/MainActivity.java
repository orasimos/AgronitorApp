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
import gr.aueb.cf.agronitor.apiclient.greenhouses.GreenhouseResponseList;
import gr.aueb.cf.agronitor.models.Greenhouse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView greenhousesRV;
    private FloatingActionButton addGreenhouse;
//    private String newGreenhouseName = "";
    private ArrayList<Greenhouse> greenhouses;
    private GreenhouseAdapter greenhouseAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greenhousesRV = findViewById(R.id.greenhousesRV);
        addGreenhouse = findViewById(R.id.addGreenhouse);
        String userId = getIntent().getStringExtra("userId");
        greenhouses = new ArrayList<>();
        ArrayList<Greenhouse> greenhouseList = getGreenhouses(userId);


        greenhouseAdapter = new GreenhouseAdapter(this, greenhouseList);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

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
//                                newGreenhouseName = input.getText().toString();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });
    }

    private ArrayList<Greenhouse> getGreenhouses(String userId) {
        IApiService apiService;
        apiService = ApiClient.getApiClient().create(IApiService.class);
        Call<GreenhouseResponseList> call = apiService.getGreenhouses(userId);
        call.enqueue(new Callback<GreenhouseResponseList>() {

            @Override
            public void onResponse(Call<GreenhouseResponseList> call, Response<GreenhouseResponseList> response) {
               if (response.isSuccessful()) {
                   GreenhouseResponseList greenhouseResponseList = response.body();
                   if (greenhouseResponseList != null) {
                       greenhouses.addAll(greenhouseResponseList.getGreenhouseList());
//                       greenhouseAdapter.notifyDataSetChanged();
                   } else {
                       Toast.makeText(MainActivity.this, "No greenhouses found", Toast.LENGTH_SHORT).show();
                   }
               }
            }

            @Override
            public void onFailure(Call<GreenhouseResponseList> call, Throwable t) {
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