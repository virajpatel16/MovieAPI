package com.example.movieapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapi.Adepter.Movieadepter
import com.example.movieapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var apiinterface=ApiClint.getclint().create(Apiinterface::class.java)
            apiinterface.getData("504c15eb9fd2acefc91b639894d7c295")
                .enqueue(object  :  Callback<MovieModel> {
                    override fun onResponse(
                        call: Call<MovieModel>,
                        response: Response<MovieModel>
                    ) {
                        var data=response.body()

binding.rcvMovie.layoutManager=GridLayoutManager(this@MainActivity,2)

              binding.rcvMovie.adapter=Movieadepter(data?.results)

                    }

                    override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })
    }
}