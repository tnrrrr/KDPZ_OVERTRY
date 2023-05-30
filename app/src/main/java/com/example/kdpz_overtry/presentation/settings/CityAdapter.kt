package com.example.kdpz_overtry.presentation.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kdpz_overtry.R
import com.example.kdpz_overtry.data.local.city.City
import com.example.kdpz_overtry.databinding.CityItemBinding

class CityAdapter(val launchfargment: (String) -> Unit) :
    RecyclerView.Adapter<CityAdapter.CityHolder>() {

    val cityList = ArrayList<City>()

    inner class CityHolder(item: View) : RecyclerView.ViewHolder(item) {
        val bind = CityItemBinding.bind(item)
        fun bindFun(city: City) {
            bind.exit.setOnClickListener {
                launchfargment(city.name)
            }

            Glide.with(bind.cityImage.context)
                .load(city.image)
                .into(bind.cityImage)


            bind.cityName.text = city.name


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
        return CityHolder(view)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.bindFun(cityList[position])
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    fun addCity(city: City) {
        cityList.add(city)
        notifyDataSetChanged()
    }

    fun addCities(city: List<City>) {
        cityList.addAll(city)
        notifyDataSetChanged()
    }


}