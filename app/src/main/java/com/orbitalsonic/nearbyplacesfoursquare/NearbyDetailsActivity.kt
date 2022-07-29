package com.orbitalsonic.nearbyplacesfoursquare

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import com.orbitalsonic.nearbyplacesfoursquare.ScreenUtils.getScreenHeight
import com.orbitalsonic.nearbyplacesfoursquare.ScreenUtils.getScreenWidth
import com.orbitalsonic.nearbyplacesfoursquare.databinding.ActivityNearbyDetailsBinding
import com.orbitalsonic.nearbyplacesfoursquare.databinding.DialogDetailsBinding
import com.orbitalsonic.nearbyplacesfoursquare.databinding.DialogProgressBinding
import com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse.NearbyResponse

class NearbyDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNearbyDetailsBinding

    private lateinit var mAdapter: AdapterNearbyDetails

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    // Default current location is London
    private var currentLocation: MapLocation = MapLocation(51.507359, -0.136439)
    private var categoryType = "10000"

    private var progressDialog: Dialog? = null

    private var nearbyDetailsList: ArrayList<NearbyDetailItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nearby_details)

        categoryType = intent.getStringExtra("category_type")!!

        createRecyclerView()
        initProgressDialog()
        progressDialog?.show()
        Handler(Looper.getMainLooper()).postDelayed({
            getCurrentLocation()
        }, 500)

    }

    private fun initProgressDialog() {
        progressDialog = Dialog(this)
        val dialogBinding: DialogProgressBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.dialog_progress, null, false
        )
        progressDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        progressDialog?.setContentView(dialogBinding.root)
        progressDialog?.setCanceledOnTouchOutside(false)
        progressDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog?.setCancelable(false)

        dialogBinding.progressCard.requestLayout()
        dialogBinding.progressCard.layoutParams.width =
            (getScreenWidth() * .90).toInt()
        dialogBinding.progressCard.layoutParams.height =
            (getScreenHeight() * .10).toInt()
    }

    private fun createRecyclerView() {
        mAdapter = AdapterNearbyDetails()
        binding.nbdRecyclerview.adapter = mAdapter
        binding.nbdRecyclerview.layoutManager = LinearLayoutManager(this)

        mAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                showDetails(mAdapter.currentList[position])
            }
        })
    }

    @SuppressLint("MissingPermission")
    private fun getCurrentLocation() {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    currentLocation.placeLatitude = location.latitude
                    currentLocation.placeLongitude = location.longitude
                    fetchNearbyLocations()
                } else {
                    progressDialog?.dismiss()
                    binding.ivNothingFound.visibility = View.VISIBLE
                }

            }
            .addOnFailureListener {
                // fetch default london nearby places
                fetchNearbyLocations()
            }

    }

    private fun fetchNearbyLocations() {
        var resAddress = "Unknown"
        var resDistance = "00 km"
        var resLatitude: Double = 0.0
        var resLongitude: Double = 0.0

        val url =
            "https://api.foursquare.com/v3/places/search?ll=${currentLocation.placeLatitude}%2C${currentLocation.placeLongitude}&radius=20000&categories=${categoryType}"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Method.GET, url,
            Response.Listener { response ->
                try {
                    Log.d("nearbyDetailsTag", response)
                    val gson = Gson()
                    val emergencyResponse: NearbyResponse =
                        gson.fromJson(response, NearbyResponse::class.java)
                    var n = 0
                    emergencyResponse.results.forEach {

                        it.name?.let { address ->
                            if (address.isNotEmpty()) {
                                resAddress = address
                            } else {
                                resAddress = "UnKnown Place"
                            }
                            Log.d("nearbyDetailsTag", "Address: ${address}")
                        }
                        it.distance?.let { mDistance ->
                            val mDis: Double = mDistance.toDouble()
                            val dist: Double = mDis / 1000
                            resDistance = "${String.format("%.2f", dist)} km"
                            Log.d("nearbyDetailsTag", "${String.format("%.2f", dist)} km")

                        }
                        it.geocodes?.main?.let { main ->
                            main.latitude?.let { lat ->
                                resLatitude = lat
                                Log.d("nearbyDetailsTag", "Latitude: $lat")

                            }
                            main.longitude?.let { longi ->
                                resLongitude = longi
                                Log.d("nearbyDetailsTag", "longitude: $longi")

                            }

                        }



                        nearbyDetailsList.add(
                            n, NearbyDetailItem(
                                address = resAddress,
                                categoryType = categoryType,
                                distance = resDistance,
                                locLatitude = resLatitude,
                                locLongitude = resLongitude
                            )
                        )

                        n++
                    }
                    progressDialog?.dismiss()
                    if (nearbyDetailsList.isNotEmpty()) {
                        binding.ivNothingFound.visibility = View.GONE
                        mAdapter.submitList(nearbyDetailsList)
                        Log.d("nearbyDetailsTag", "List is not empty")
                    } else {
                        binding.ivNothingFound.visibility = View.VISIBLE
                        Log.d("nearbyDetailsTag", "List is empty")
                    }

                } catch (ex: Exception) {
                }

            },
            Response.ErrorListener {
                try {
                    progressDialog?.dismiss()
                    binding.ivNothingFound.visibility = View.VISIBLE
                    Log.e("nearbyDetailsTag", it.message.toString())
                } catch (e: Exception) {

                }

            }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = resources.getString(R.string.square_token_key)
                return headers
            }
        }

        queue.add(stringRequest)


    }

    private fun showDetails(nearByItem: NearbyDetailItem) {
        val mDialog = BottomSheetDialog(this)
        val dialogBinding: DialogDetailsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.dialog_details, null, false
        )
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setContentView(dialogBinding.root)
        mDialog.setCanceledOnTouchOutside(true)
        mDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val mDetails =
            "Address: ${nearByItem.address}\n\nDistance: ${nearByItem.distance}\n\nCategory Type: ${nearByItem.categoryType}\n\nLatitude: ${nearByItem.locLatitude}\nLongitude: ${nearByItem.locLongitude}"

        dialogBinding.tvDetails.text = mDetails

        mDialog.show()

    }

}