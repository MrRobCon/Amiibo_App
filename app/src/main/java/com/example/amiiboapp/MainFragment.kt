package com.example.amiiboapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amiiboapp.data.AmiiboEntity

import com.example.amiiboapp.databinding.FragmentMainBinding

class MainFragment : Fragment(),
    AmiiboListAdapter.ListItemListener{

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: AmiiboListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity)
            .supportActionBar?.setDisplayHomeAsUpEnabled(false)


        binding = FragmentMainBinding.inflate(inflater,container,false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        with(binding.recyclerView){
            setHasFixedSize(true)
            val divider = DividerItemDecoration(
                context, LinearLayoutManager(context).orientation
            )
            addItemDecoration(divider)
        }

        viewModel.amiiboList.observe(viewLifecycleOwner, Observer {
            Log.i("amiiboLogging", it.toString())
            adapter = AmiiboListAdapter(it, this@MainFragment)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })
        return binding.root

    }

    override fun onItemClick(amiibo: AmiiboEntity) {

        Log.i(TAG, "onItemClick : Received Amiibo name ${amiibo.name}")
        val action = MainFragmentDirections.actionMainFragmentToEditorFragment(amiibo)
        findNavController().navigate(action)

    }
}