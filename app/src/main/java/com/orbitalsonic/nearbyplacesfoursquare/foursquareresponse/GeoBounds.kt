package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse

import com.google.gson.annotations.SerializedName
import com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse.Circle


data class GeoBounds (

    @SerializedName("circle" ) var circle : Circle? = Circle()

)