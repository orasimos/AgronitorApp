package gr.aueb.cf.agronitor.apiclient;

import gr.aueb.cf.agronitor.models.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IApiService {

    @POST("register")
    Call<ResponseBody> registerUser (@Body User user);

    @POST("login")
    Call<ResponseBody> loginUser (@Body User user);

//    @GET("/greenhouses/{userId}")
//    okhttp3.Call<ResponseBody>
}
