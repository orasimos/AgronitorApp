package gr.aueb.cf.agronitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


import java.io.IOException;

import javax.net.ssl.SSLHandshakeException;

import gr.aueb.cf.agronitor.apiclient.ApiClient;
import gr.aueb.cf.agronitor.models.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText usernameET;
    private TextInputEditText passwordET;
    private AppCompatButton loginBtn;
    private AppCompatButton registerBtn;

    String uri = "mongodb+srv://orasimos:HA9UPE.wEUD4XP!@cluster0.fhrtj0i.mongodb.net/" +
            "?retryWrites=true&w=majority";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameET = findViewById(R.id.usernameTextInputEditText);
        passwordET = findViewById(R.id.passwordTextInputEditText);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

//        connectMongo(uri);

//        TODO: make api call to get user from mongodb
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        final String username = usernameET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

        if (username.isEmpty()) {
            usernameET.setError("Username is required");
            usernameET.requestFocus();
            return;
        } else if (password.isEmpty()){
            passwordET.setError("Password is required");
            passwordET.requestFocus();
            return;
        }

        Call<ResponseBody> call = ApiClient.getInstance().getApi().loginUser(new User(username, password));

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = "";
                s = response.headers().toString();

                if (s.equals("success")) {
                    Toast.makeText(LoginActivity.this, "Welcome back " + username + "!", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                if (usernameET.getText().toString().trim().equals("admin") && passwordET.getText().toString().trim().equals("admin")) {
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}