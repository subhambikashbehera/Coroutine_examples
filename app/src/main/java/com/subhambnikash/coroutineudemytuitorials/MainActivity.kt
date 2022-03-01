package com.subhambnikash.coroutineudemytuitorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.subhambnikash.coroutineudemytuitorials.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var viewModelFactory: viewModelFactory
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=DataBindingUtil.setContentView(this,R.layout.activity_main)


        viewModelFactory= viewModelFactory(13)
        viewModel=ViewModelProvider(this,viewModelFactory)[MainActivityViewModel::class.java]

        binding.apply {
            button.setOnClickListener {
               // viewModel.getUserData()
            }
        }

        viewModel.users.observe(this) {
            it.forEach {modelClass ->
                Log.d(TAG, "onCreate: ${modelClass.id}")
            }
        }

        lifecycleScope.launchWhenCreated {  }
        lifecycleScope.launchWhenStarted {  }
        lifecycleScope.launch(Dispatchers.Main){
           // donload()
            binding.textView.text=StrucuiredConcurrency().getUserData().toString()
        }
        lifecycleScope.launchWhenResumed {
          //  donload()
        }










    }


    suspend fun donload(){
        for (i in 0..500000){
            delay(100)
            Log.d(TAG, "donload: $i")
        }

    }

    companion object{
        var TAG="testMainActivity"
    }
}