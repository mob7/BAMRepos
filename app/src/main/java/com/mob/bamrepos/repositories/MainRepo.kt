package com.mob.bamrepos.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    private val _dataResponseLD = MutableLiveData<List<Repo>>()

    val dataResponseLD: LiveData<List<Repo>>
        get() = _dataResponseLD

    fun getRepos() {
        val call = apiService.getRepos()
        call.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                _dataResponseLD.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.e(TAG, "onFailure: " + t.message)
            }
        })
    }

}