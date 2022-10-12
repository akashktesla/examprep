package com.example.examprep2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examprep2.databinding.ActivityMainBinding
import com.example.examprep2.databinding.FragmentBlank2Binding

class MainActivity : AppCompatActivity() ,Communicator{
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
       binding.savebtn.setOnClickListener {
           saveData()
       }

        //dynamically adding a fragment
        supportFragmentManager.beginTransaction().replace(R.id.frame1,BlankFragment()).commit()
    }
    private fun saveData(){
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val edittext = binding.ett1.text
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        binding.tv1.setText("asdlfkj")
        Log.d("_log","drooooo")
       editor.apply {
          putString("STRING_KEY",edittext.toString())

       }.apply()
        Toast.makeText(this,"sucess vro",Toast.LENGTH_SHORT).show()
    }

   private fun loadData(){
       val binding = ActivityMainBinding.inflate(layoutInflater)
       val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
       val sharedstring = sharedPreferences.getString("STRING_KEY","key")
       Log.d("_log",sharedstring.toString())
       binding.tv1.setText(sharedstring.toString()
       )
   }


    override fun reload() {
        val bundle = Bundle()
        supportFragmentManager.beginTransaction().replace(R.id.frame2,BlankFragment2()).commit()
    }


}