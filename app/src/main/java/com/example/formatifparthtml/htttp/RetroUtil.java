package com.example.formatifparthtml.htttp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetroUtil {

    public static  Service get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://4n6.azurewebsites.net/")
                .build();

        Service service = retrofit.create(Service.class);
        return service;
    }
}
