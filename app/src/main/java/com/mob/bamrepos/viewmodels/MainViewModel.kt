package com.mob.bamrepos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mob.bamrepos.models.response.Repo
import com.mob.bamrepos.repositories.MainRepo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    var mRepo: MainRepo
) : ViewModel() {

    fun getRepos() {
        mRepo.getRepos()
    }

    val dataResponseLD: LiveData<List<Repo>>
        get() = mRepo.dataResponseLD

}