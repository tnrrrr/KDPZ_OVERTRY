package com.example.kdpz_overtry.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.kdpz_overtry.R
import com.example.kdpz_overtry.databinding.FragmentMainBinding
import com.example.kdpz_overtry.domain.models.MainWeatherClass
import com.example.kdpz_overtry.presentation.settings.SettingsFragment
import com.examplefun.kdpz_overtry.presentation.main.MainDataViewModel


class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    private var weather: MainWeatherClass? = null

    lateinit var viewmodel:MainDataViewModel



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        viewmodel = ViewModelProvider(this).get(MainDataViewModel::class.java)

        viewmodel.weatherLiveData.observe(viewLifecycleOwner) {
            binding.cityName.text = it!!.cityName
            binding.currentTemp.text = it.main.tempString
            binding.weatherDescr.text = it.weather.description
            Glide.with(binding.weatherImage.context)
                .load(it.weather.icon)
                .into(binding.weatherImage)
        }

        setFragmentResultListener(SettingsFragment.REQUEST_KEY) { key, bundle ->
            val weather = bundle.getParcelable<MainWeatherClass?>("weather")
            if(weather!=null){
                viewmodel.saveData(weather)
                Log.d("data", "weather received")

                this.weather = weather
                binding.cityName.text = weather!!.cityName
                binding.currentTemp.text = weather.main.tempString
                binding.weatherDescr.text = weather!!.weather.description
                Glide.with(binding.weatherImage.context)
                    .load(weather.weather.icon)
                    .into(binding.weatherImage)
            }

        }

        binding.setings.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToSettingsFragment()
            findNavController().navigate(action)
        }

    }
}