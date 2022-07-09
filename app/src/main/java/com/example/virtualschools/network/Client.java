package com.example.virtualschools.network;

import static com.example.virtualschools.Constants.VIRTUAL_SCHOOLS_BASE_URL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Retrofit retrofit = null;

    public static Api getClient() {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request newRequest  = chain.request().newBuilder()
                                .build();
                        return chain.proceed(newRequest);
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(VIRTUAL_SCHOOLS_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(Api.class);
    }
}
