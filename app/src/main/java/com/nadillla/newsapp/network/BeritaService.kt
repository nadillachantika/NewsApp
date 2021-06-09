package com.nadillla.newsapp.network

import com.nadillla.newsapp.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface BeritaService {

    @GET("everything?q=kesehatan&from=2021-06-07&to=2021-06-07&sortBy=popularity&apiKey=be14be3a5ea949858c0c15edca7cd40d")
    fun getBeritaKesehatan(): Call<ResponseServer>

    @GET("everything?q=olahraga&from=2021-06-07&to=2021-06-07&sortBy=popularity&apiKey=be14be3a5ea949858c0c15edca7cd40d")
    fun getBeritaOlahraga():Call<ResponseServer>

    @GET("everything?q=teknologi&from=2021-06-07&to=2021-06-07&sortBy=popularity&apiKey=be14be3a5ea949858c0c15edca7cd40d")
    fun getBeritaTeknologi():Call<ResponseServer>

    @GET("everything?q=makanan&from=2021-06-07&to=2021-06-07&sortBy=popularity&apiKey=be14be3a5ea949858c0c15edca7cd40d")
    fun getBeritaMasakan():Call<ResponseServer>

    @GET("everything?q=all&from=2021-06-07&to=2021-06-07&sortBy=popularity&apiKey=be14be3a5ea949858c0c15edca7cd40d")
    fun getBeritaAll():Call<ResponseServer>




}