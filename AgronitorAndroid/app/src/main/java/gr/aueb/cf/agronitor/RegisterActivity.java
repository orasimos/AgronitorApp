package gr.aueb.cf.agronitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import gr.aueb.cf.agronitor.apiclient.ApiClient;
import gr.aueb.cf.agronitor.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import okhttp3.ResponseBody;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText emailET;
    private TextInputEditText usernameET;
    private TextInputEditText passwordET;
    private TextInputEditText confirmPasswordET;
    private AppCompatButton registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailET = findViewById(R.id.emailTextInputEditText);
        usernameET = findViewById(R.id.usernameTextInputEditText);
        passwordET = findViewById(R.id.passwordTextInputEditText);
        confirmPasswordET = findViewById(R.id.confirmPasswordTextInputEditText);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String username = usernameET.getText().toString().trim();
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();
        String passwordConf = confirmPasswordET.getText().toString().trim();

        if (username.isEmpty()) {
            usernameET.setError("Username is required");
            usernameET.requestFocus();
            return;
        } else if (password.isEmpty()) {
            passwordET.setError("Password is required");
            passwordET.requestFocus();
            return;
        } else if (passwordConf.isEmpty()) {
            confirmPasswordET.setError("Confirm your password");
            confirmPasswordET.requestFocus();
            return;
        } else if (!password.equals(passwordConf)) {
            confirmPasswordET.setError("Confirm your password");
            confirmPasswordET.requestFocus();
            return;
        } else if (email.isEmpty()) {
            emailET.setError("Email is required");
            emailET.requestFocus();
        }

        Call<ResponseBody> call = ApiClient.getInstance().getApi().registerUser(new User(username, email, password));

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = "";
                try {
                    s = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (s.equals("SUCCESS")) {
                    Toast.makeText(RegisterActivity.this, "Your registration was successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "User already exists!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}