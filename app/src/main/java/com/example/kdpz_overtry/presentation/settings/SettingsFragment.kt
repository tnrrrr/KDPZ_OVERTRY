package com.example.kdpz_overtry.presentation.settings

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kdpz_overtry.R
import com.example.kdpz_overtry.data.local.city.ListOfCities
import com.example.kdpz_overtry.data.local.city.ListOfCities.listCity
import com.example.kdpz_overtry.databinding.FragmentSettingsBinding
import com.example.kdpz_overtry.domain.models.MainWeatherClass


class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var binding: FragmentSettingsBinding
    val adapter = CityAdapter() {
        settigsViewModel.getWeather(it)
    }

    private lateinit var settigsViewModel: SettingsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        binding.apply {
            rcView.layoutManager = LinearLayoutManager(context)
            rcView.adapter = adapter
        }
        adapter.addCities(ListOfCities.listCity)

        settigsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)

        var weather: MainWeatherClass?

        settigsViewModel.weatherLiveData.observe(viewLifecycleOwner) {
            weather = it
            if (weather == null) {
                Toast.makeText(requireContext(), "City not found", Toast.LENGTH_SHORT).show()

                Log.d("data", "weather equal null")

                return@observe
            }

            Log.d("data", "weather not equal null, go to main page")

            setFragmentResult(REQUEST_KEY, bundleOf("weather" to weather))
            findNavController().navigateUp()
        }


        binding.apply.setOnClickListener {
            val chosenCityName = binding.cytyName.text.toString()

            Log.d("data", "try to get weather")
            settigsViewModel.getWeather(chosenCityName)
        }

        binding.apply {
            rcView.layoutManager = LinearLayoutManager(context)
            rcView.adapter = adapter
        }
        adapter.addCities(listCity)
    }

    companion object {
        const val REQUEST_KEY = "request key"
    }


}




