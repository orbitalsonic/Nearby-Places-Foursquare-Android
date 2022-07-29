package com.orbitalsonic.nearbyplacesfoursquare

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.orbitalsonic.nearbyplacesfoursquare.LocationHandler.isGpsEnabled
import com.orbitalsonic.nearbyplacesfoursquare.LocationHandler.isLocationApproved
import com.orbitalsonic.nearbyplacesfoursquare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: AdapterNearby

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        createRecyclerView()

    }

    private fun createRecyclerView() {
        mAdapter = AdapterNearby()
        val layoutManager = LinearLayoutManager(this)
        binding.nbRecyclerview.adapter = mAdapter
        binding.nbRecyclerview.layoutManager = layoutManager
        mAdapter.submitList(NearbyDataProvider.getNearbyList(this).toList())

        mAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                nextActivity(mAdapter.currentList[position].categoryType)
            }

        })

    }

    private fun nextActivity(categoryType:String){
        if (isLocationApproved()) {
            if (isGpsEnabled()) {
                val mIntent = Intent(this@MainActivity,NearbyDetailsActivity::class.java)
                mIntent.putExtra("category_type",categoryType)
                startActivity(mIntent)
            } else {
                try {
                    startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                }catch (e:Exception){

                }
            }

        } else {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LocationHandler.LOCATION_PERMISSION
            )
        }
    }

}