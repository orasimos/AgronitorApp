package gr.aueb.cf.agronitor.apiclient;

import gr.aueb.cf.agronitor.apiclient.greenhouses.GreenhouseResponse;
import gr.aueb.cf.agronitor.apiclient.login.LoginRequest;
import gr.aueb.cf.agronitor.apiclient.login.LoginResponse;
import gr.aueb.cf.agronitor.apiclient.register.RegisterRequest;
import gr.aueb.cf.agronitor.apiclient.register.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IApiService {

    @POST("users/register/")
    Call<RegisterResponse> registerUser (@Body RegisterRequest registerRequest);

    @POST("users/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @GET("greenhouses/user/{userId}")
    Call<GreenhouseResponse> getGreenhouses(@Path("userId") String userId);
}
