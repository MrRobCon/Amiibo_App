package com.example.breakingbad

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.breakingbad.data.FavouriteEntity
import com.example.breakingbad.databinding.EditorFragmentBinding

class EditorFragment : Fragment() {

    private val args: EditorFragmentArgs by navArgs()
    private lateinit var binding: EditorFragmentBinding
    private lateinit var viewModel: EditorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.let {
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_check)
        }
        setHasOptionsMenu(true)

        
        binding = EditorFragmentBinding.inflate(inflater, container, false)
        binding.name.setText(args.character.name)
        binding.nickname.setText(args.character.nickname)
        binding.birthday.setText(args.character.birthday)
        binding.status.setText(args.character.status)
        binding.portrayed.setText(args.character.portrayed)

        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
        viewModel.currentFavourite.observe(viewLifecycleOwner, Observer {
            binding.myNotes.setText(it.myNotes)
        })


        viewModel.getFavourite(args.character.char_id)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed(){
                   
                    saveAndReturn()
                } 
            }
        )
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> saveAndReturn()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveAndReturn() : Boolean{

        viewModel.saveFavourite(FavouriteEntity(args.character.char_id, binding.myNotes.text.toString()))
        findNavController().navigateUp()
        return true
    }

}