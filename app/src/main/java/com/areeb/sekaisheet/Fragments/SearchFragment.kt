package com.areeb.sekaisheet.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.areeb.sekaisheet.Adapters.UnsplashPhotoAdapter
import com.areeb.sekaisheet.R
import com.areeb.sekaisheet.UnsplashModels.UnsplashPhoto
import com.areeb.sekaisheet.ViewModels.HomeViewModel
import com.areeb.sekaisheet.ViewModels.SearchViewModel
import com.areeb.sekaisheet.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search),UnsplashPhotoAdapter.OnItemClickListener {
private val search_viewModel by viewModels<SearchViewModel>()
    private var _searchBinding :FragmentSearchBinding?=null

    private val searchBinding get() = _searchBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _searchBinding=FragmentSearchBinding.bind(view)

        getSearchPhoto()

    }

    override fun onItemClick(photo: UnsplashPhoto) {
        TODO("Not yet implemented")
        Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()
    }

    fun getSearchPhoto(){
        val adapter = UnsplashPhotoAdapter(this)

        searchBinding.apply {
            searchRec.setHasFixedSize(true)
            searchRec.layoutManager=GridLayoutManager(context,2)

            searchRec.adapter=adapter

        }

        search_viewModel.searchPhoto.observe(viewLifecycleOwner){
            adapter.submitData(viewLifecycleOwner.lifecycle,it)

        }


    }

    fun searchFun(){
        val searchQuery =searchBinding.searchTxt.toString()
        val searchView = searchQuery as SearchView

        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query !=null){
                    searchBinding.searchRec.scrollToPosition(0)
                    search_viewModel.searchPhoto(query)
                    searchView.clearFocus()

                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }
    override fun onDestroy() {
        super.onDestroy()

        _searchBinding=null
    }


}