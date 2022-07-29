package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse

import com.google.gson.annotations.SerializedName
import com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse.Center


data class Circle (

    @SerializedName("center" ) var center : Center? = Center(),
    @SerializedName("radius" ) var radius : Int?    = null

)