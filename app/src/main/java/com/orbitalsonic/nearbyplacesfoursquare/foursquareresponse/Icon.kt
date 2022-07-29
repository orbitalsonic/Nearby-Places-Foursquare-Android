package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse

import com.google.gson.annotations.SerializedName


data class Icon (

    @SerializedName("prefix" ) var prefix : String? = null,
    @SerializedName("suffix" ) var suffix : String? = null

)