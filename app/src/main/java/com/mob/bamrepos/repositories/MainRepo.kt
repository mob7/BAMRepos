package com.mob.bamrepos.repositories

import android.util.Log
import com.mob.bamrepos.models.response.Repo
import com.mob.bamrepos.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainRepo @Inject constructor(
    private var apiService: ApiService
) {

    private val TAG = "BAMRepos"

    fun getRepos() {
        val call = apiService.getRepos()
        call.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                Log.e(TAG, "onResponse: " + response.body())
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.e(TAG, "onFailure: " + t.message)
            }
        })
    }

}