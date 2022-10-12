package com.example.examprep2
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import com.example.examprep2.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    //communicator stuff
    private lateinit var communicator: Communicator

    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentBlankBinding.inflate(inflater,container,false);
        /* setting array adapter for dropdown
        val dropdownarray = resources.getStringArray(R.array.dropdownarray)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,dropdownarray)
        binding.dropdown.setAdapter(arrayAdapter)
         */

       //===============================communicaton===============================================
       communicator = activity as Communicator//used to reload
        sharedViewModel.data.observe(viewLifecycleOwner,{
            binding.send.setText(it)
        })
        binding.sendbtn.setOnClickListener {
            sharedViewModel.savedata(binding.send.text.toString())
            communicator.reload()
        }
        return binding.root
    }
}