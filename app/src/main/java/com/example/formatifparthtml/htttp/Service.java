package com.example.formatifparthtml.htttp;

import com.example.formatifparthtml.nombre;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    @GET("exam/representations/{name}")
    Call<List<nombre>> listRepos(@Path("name") int user);
;
}
