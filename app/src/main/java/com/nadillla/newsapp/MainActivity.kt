package com.nadillla.newsapp

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.nadillla.newsapp.adapter.BeritaAdapter
import com.nadillla.newsapp.model.Berita
import com.nadillla.newsapp.model.ResponseServer
import com.nadillla.newsapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btnKesehatan = findViewById(R.id.btnKesehatan) as Button
        val btnOlahraga = findViewById(R.id.btnOlahraga) as Button
        val btnMasakan = findViewById(R.id.btnMasakan) as Button
        val btnTeknologi = findViewById(R.id.btnTeknologi) as Button


        if (isConnect()) {

            showBeritaAll()

            btnAll.setOnClickListener{
                progressbar.visibility = View.VISIBLE

                showBeritaAll()
            }

            btnKesehatan.setOnClickListener {
                showBeritaKesehatan()
            }
            btnMasakan.setOnClickListener {
                showBeritaMasakan()
            }
            btnOlahraga.setOnClickListener {
                showBeritaOlahraga()
            }
            btnTeknologi.setOnClickListener {
                showBeritaTeknologi()
            }

        } else{
            progressbar.visibility = View.GONE
            Toast.makeText(this, "Device is not connected", Toast.LENGTH_SHORT).show()
        }
    }


    fun isConnect(): Boolean {
        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected


    }

    private fun showData(article: ArrayList<Berita>?) {
        listBerita.adapter = BeritaAdapter(article)
    }

    private fun showBeritaKesehatan(){

        progressbar.visibility = View.VISIBLE
        ConfigNetwork.getRetrofit().getBeritaKesehatan().enqueue(object: Callback<ResponseServer> {
            override fun onFailure(call : Call<ResponseServer>, t: Throwable){

                progressbar.visibility = View.GONE
                Log.d("Server Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {

                Log.d("Response Server", response.message())
                if(response.isSuccessful){
                    progressbar.visibility = View.GONE

                    val status = response.body()?.status
                    if(status == "ok"){
                        val article = response.body()?.articles

                        showData(article)
                    }
                }
            }
        })

    }
    private fun showBeritaOlahraga(){
        progressbar.visibility = View.VISIBLE

        ConfigNetwork.getRetrofit().getBeritaOlahraga().enqueue(object: Callback<ResponseServer> {
            override fun onFailure(call : Call<ResponseServer>, t: Throwable){

                progressbar.visibility = View.GONE
                Log.d("Server Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {

                Log.d("Response Server", response.message())
                if(response.isSuccessful){
                    progressbar.visibility = View.GONE

                    val status = response.body()?.status
                    if(status == "ok"){
                        val article = response.body()?.articles

                        showData(article)
                    }
                }
            }
        })

    }
    private fun showBeritaMasakan(){
        progressbar.visibility = View.VISIBLE

        ConfigNetwork.getRetrofit().getBeritaMasakan().enqueue(object: Callback<ResponseServer> {
            override fun onFailure(call : Call<ResponseServer>, t: Throwable){

                progressbar.visibility = View.GONE
                Log.d("Server Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {

                Log.d("Response Server", response.message())
                if(response.isSuccessful){
                    progressbar.visibility = View.GONE

                    val status = response.body()?.status
                    if(status == "ok"){
                        val article = response.body()?.articles

                        showData(article)
                    }
                }
            }
        })

    }
    private fun showBeritaTeknologi(){
        progressbar.visibility = View.VISIBLE

        ConfigNetwork.getRetrofit().getBeritaTeknologi().enqueue(object: Callback<ResponseServer> {
            override fun onFailure(call : Call<ResponseServer>, t: Throwable){

                progressbar.visibility = View.GONE
                Log.d("Server Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {

                Log.d("Response Server", response.message())
                if(response.isSuccessful){
                    progressbar.visibility = View.GONE

                    val status = response.body()?.status
                    if(status == "ok"){
                        val article = response.body()?.articles

                        showData(article)
                    }
                }
            }
        })

    }

    private fun showBeritaAll(){
        ConfigNetwork.getRetrofit().getBeritaAll().enqueue(object: Callback<ResponseServer> {
            override fun onFailure(call : Call<ResponseServer>, t: Throwable){

                progressbar.visibility = View.GONE
                Log.d("Server Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {

                Log.d("Response Server", response.message())
                if(response.isSuccessful){
                    progressbar.visibility = View.GONE

                    val status = response.body()?.status
                    if(status == "ok"){
                        val article = response.body()?.articles

                        showData(article)
                    }
                }
            }
        })

    }


    override fun onBackPressed() {
        if(doubleBackToExitPressedOnce){
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false },2000)
    }
}
