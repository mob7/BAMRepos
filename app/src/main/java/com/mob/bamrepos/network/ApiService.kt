package com.mob.bamrepos.network

import com.mob.bamrepos.models.response.Repo
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("repos?page=1")
    fun getRepos(): Call<List<Repo>>

}