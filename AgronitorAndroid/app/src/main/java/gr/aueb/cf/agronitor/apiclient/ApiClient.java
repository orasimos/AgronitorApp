package gr.aueb.cf.agronitor.apiclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://10.0.2.2:8080/api/";
    private static Retrofit retrofit = null;

    static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                                    .connectTimeout(20, TimeUnit.SECONDS)
                                                    .writeTimeout(20, TimeUnit.SECONDS)
                                                    .readTimeout(30, TimeUnit.SECONDS)
                                                    .build();

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder().setLenient().create();

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                             .addConverterFactory(GsonConverterFactory
                                             .create(gson))
                                             .client(okHttpClient)
                                             .build();
        }
        return retrofit;
    }

//    private static Retrofit getRetrofit() {
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                                        .addConverterFactory(GsonConverterFactory.create(new Gson()))
//                                        .baseUrl(BASE_URL)
//                                        .client(okHttpClient)
//                                        .build();
//        return retrofit;
//    }
//
//    public static IApiService getApiService() {
//        IApiService iApiService = getRetrofit().create(IApiService.class);
//        return iApiService;
//    }

}
