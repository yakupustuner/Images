package com.learn.images.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.learn.images.adapter.ImagesAdapter
import com.learn.images.databinding.FragmentFirstBinding
import com.learn.images.viewmodel.ImagesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : Fragment(),SearchView.OnQueryTextListener {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var imagesAdapter = ImagesAdapter(arrayListOf())
    private val  viewModel by viewModel<ImagesViewModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.search.setOnQueryTextListener(this)
        recyclerView()
        obServer()


    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            searchImage(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private fun searchImage(c:String){
        viewModel.getData(c)

    }

    private fun recyclerView() {
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
        binding.recyclerView.adapter = imagesAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun obServer(){
        viewModel.images.observe(viewLifecycleOwner, Observer {
            it?.let {
                val url = it.data?.hits?.map {
                    it.previewURL
                }
                imagesAdapter.imagesList = url ?: listOf()
                imagesAdapter.notifyDataSetChanged()
            }
        })
    }
}
