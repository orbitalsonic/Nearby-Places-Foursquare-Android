package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse

import com.google.gson.annotations.SerializedName


data class Geocodes (

    @SerializedName("main" ) var main : Main? = Main()

)