package com.mob.bamrepos

import com.mob.bamrepos.repositories.MainRepo
import com.mob.bamrepos.viewmodels.MainViewModel
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

class ViewModelUnitTest {

    private var mainViewModel: MainViewModel? = null

    @Test
    @Inject
    fun testGetAuthData() {
        val mainRepo: MainRepo = Mockito.mock(MainRepo::class.java)
        mainViewModel = MainViewModel(mainRepo)
        mainViewModel!!.getRepos()
        Mockito.verify(mainRepo).getRepos()
    }
}