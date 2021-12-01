package com.example.breakingbad

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
import com.example.breakingbad.data.CharacterEntity

import com.example.breakingbad.databinding.FragmentMainBinding

class MainFragment : Fragment(),
    CharacterListAdapter.ListItemListener{

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: CharacterListAdapter

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

        viewModel.character.observe(viewLifecycleOwner, Observer {
            Log.i("characterLogging", it.toString())
            adapter = CharacterListAdapter(it, this@MainFragment)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })
        return binding.root

    }

    override fun onItemClick(character: CharacterEntity) {

        Log.i(TAG, "onItemClick : Received Character name ${character.name}")
        val action = MainFragmentDirections.actionMainFragmentToEditorFragment(character)
        findNavController().navigate(action)

    }
}