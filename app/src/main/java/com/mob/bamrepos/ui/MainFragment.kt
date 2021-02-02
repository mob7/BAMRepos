package com.mob.bamrepos.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mob.bamrepos.R
import com.mob.bamrepos.viewmodels.MainViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mViewModel: MainViewModel by viewModels { viewModelFactory }
    private lateinit var mMainAdapter: MainAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)

        loadingProgressBar.visibility = View.VISIBLE
        mViewModel.getRepos()


        mMainAdapter = MainAdapter()
        reposRecyclerView.apply {
            adapter = mMainAdapter
            hasFixedSize()
        }

        mViewModel.dataResponseLD.observe(viewLifecycleOwner,
            Observer {
                mMainAdapter.updateData(it)
                loadingProgressBar.visibility = View.INVISIBLE
            })

    }

}