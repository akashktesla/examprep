package com.example.examprep2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.examprep2.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

    var displayMsg: String? = ""
    private val sharedViewModel:SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Log.d("_log","vrommmmmmmmmmmmmmmmmmmmmmmmmmmmm")
        // Inflate the layout for this fragment
        var binding = FragmentBlank2Binding.inflate(inflater, container, false)

        //communication karumam
        sharedViewModel.data.observe(viewLifecycleOwner,{
            binding.recieve.setText(it)
        })
        return binding.root
    }

}