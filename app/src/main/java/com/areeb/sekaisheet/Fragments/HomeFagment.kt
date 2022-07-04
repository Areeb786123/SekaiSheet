package com.areeb.sekaisheet.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.areeb.sekaisheet.Activites.DetailsActivity
import com.areeb.sekaisheet.Activites.SearchActivity
import com.areeb.sekaisheet.Adapters.homeAdapter
import com.areeb.sekaisheet.Network.RetrofitHelper
import com.areeb.sekaisheet.Network.RetrofitInterface
import com.areeb.sekaisheet.Repository.HomeRepo
import com.areeb.sekaisheet.UnsplashModels.UnsplashModels
import com.areeb.sekaisheet.UnsplashModels.UnsplashModelsItem
import com.areeb.sekaisheet.ViewModelFactory.HomeViewModelFactory
import com.areeb.sekaisheet.ViewModels.homeViewModel
import com.areeb.sekaisheet.databinding.FragmentHomeFagmentBinding


class HomeFagment : Fragment() {
    lateinit var homeFagmentBinding: FragmentHomeFagmentBinding
    lateinit var listofMovies: List<UnsplashModelsItem>


    lateinit var homViewModel: homeViewModel
    lateinit var retrofitInterface: RetrofitInterface

    lateinit var home_adapter: homeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    var imageLink = "";

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeFagmentBinding = FragmentHomeFagmentBinding.inflate(layoutInflater, container, false)
        val view = homeFagmentBinding!!.root


        settingUpOfrecyclerView()
        getAllHomeWallpaper()


        homeFagmentBinding.searchBar.setOnClickListener {
            val searchIntent  = Intent(activity,SearchActivity::class.java)
            startActivity(searchIntent)
        }



        return view

    }


//    fun TestRecylerView() {
//        var recyclerView = homeFagmentBinding.homeRecyclerView
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = GridLayoutManager(context, 2)
//        home_adapter = context?.let { homeAdapter(it,listofMovies, this) }!!
//        homeFagmentBinding.shimmerLayout.stopShimmer()
//        homeFagmentBinding.shimmerLayout.visibility = View.GONE
//        recyclerView.adapter = home_adapter
//
//
//    }

    fun settingUpOfrecyclerView() {
        homeFagmentBinding.homeRecyclerView.setHasFixedSize(true)
        homeFagmentBinding.homeRecyclerView.layoutManager = GridLayoutManager(context, 2)


    }

    fun getAllHomeWallpaper() {

        retrofitInterface =
            RetrofitHelper.getImageFromClient().create(RetrofitInterface::class.java)
        val imageObj = HomeRepo(retrofitInterface)
        homViewModel =
            ViewModelProvider(this, HomeViewModelFactory(imageObj)).get(homeViewModel::class.java)
//        homViewModel.homerepo

        home_adapter = context?.let { homeAdapter(it) }!!
        homeFagmentBinding.homeRecyclerView.adapter = home_adapter



        homViewModel.PixaImageLiveData.observe(requireActivity(), Observer {


            if (it == null) {
                Toast.makeText(activity, "empty data ", Toast.LENGTH_SHORT).show()
            } else {


                home_adapter.ImagesListOfPixa = it
                homeFagmentBinding.shimmerLayout.stopShimmer()
                homeFagmentBinding.shimmerLayout.visibility = View.GONE
//                homeFagmentBinding.shimmerLayout.stopShimmer()
//                homeFagmentBinding.shimmerLayout.visibility=View.GONE
                Log.e("mew_x", it.toString())


//
//                Log.e("debug_x", (it.photos as ArrayList<Photo>).toString())
                home_adapter.notifyDataSetChanged()

            }
        })
    }



}