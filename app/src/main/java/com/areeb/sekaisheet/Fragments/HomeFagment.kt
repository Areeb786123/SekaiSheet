package com.areeb.sekaisheet.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.areeb.sekaisheet.Activites.DetailsActivity
import com.areeb.sekaisheet.Adapters.UnsplashPhotoAdapter
import com.areeb.sekaisheet.R
import com.areeb.sekaisheet.UnsplashModels.UnsplashPhoto
import com.areeb.sekaisheet.ViewModels.HomeViewModel
import com.areeb.sekaisheet.databinding.FragmentHomeFagmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFagment : Fragment(R.layout.fragment_home_fagment),
    UnsplashPhotoAdapter.OnItemClickListener {
    private var _homeFagmentBinding: FragmentHomeFagmentBinding? = null
    private val homeFagmentBinding get() = _homeFagmentBinding!!
    private val viewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _homeFagmentBinding = FragmentHomeFagmentBinding.bind(view)
        getHomeData()

//        homeFagmentBinding.searchBar.setOnClickListener {
//            val searchIntent = Intent(activity,SearchFragment::class.java)
//            startActivity(searchIntent)
//
//        }


    }


    fun getHomeData() {
        val adapter = UnsplashPhotoAdapter(this)
        homeFagmentBinding.apply {
            homeRecyclerView.setHasFixedSize(true)
            homeRecyclerView.layoutManager = GridLayoutManager(context, 2)
            homeRecyclerView.adapter = adapter
        }
        viewModel.photo.observe(viewLifecycleOwner) {


            homeFagmentBinding.shimmerLayout.stopShimmer()
            homeFagmentBinding.shimmerLayout.visibility = View.GONE
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
            Log.e("mew", adapter.itemCount.toString())


        }


    }

    override fun onDestroy() {
        super.onDestroy()

        _homeFagmentBinding = null
    }

    override fun onItemClick(photo: UnsplashPhoto) {

        val detailsIntent = Intent(activity, DetailsActivity::class.java)
        detailsIntent.putExtra("photo", photo.urls.regular)
        startActivity(detailsIntent)
    }


}