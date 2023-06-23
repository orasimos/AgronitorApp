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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import gr.aueb.cf.agronitor.adapters.GreenhouseAdapter;
import gr.aueb.cf.agronitor.models.Greenhouse;

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

        ArrayList<Greenhouse> greenhouseArrayList = new ArrayList<Greenhouse>();
        greenhouseArrayList.add(new Greenhouse("Tomatoes"));
        greenhouseArrayList.add(new Greenhouse("Potatoes"));
        greenhouseArrayList.add(new Greenhouse("Cucumbers"));
        greenhouseArrayList.add(new Greenhouse("Peppers"));


        GreenhouseAdapter greenhouseAdapter = new GreenhouseAdapter(
                this, greenhouseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);

        greenhousesRV.setLayoutManager(linearLayoutManager);
        greenhousesRV.setAdapter(greenhouseAdapter);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}