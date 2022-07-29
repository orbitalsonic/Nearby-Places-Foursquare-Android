package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse

import com.google.gson.annotations.SerializedName


data class NearbyResponse (

    @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf(),
    @SerializedName("context" ) var context : Context?           = Context()

)