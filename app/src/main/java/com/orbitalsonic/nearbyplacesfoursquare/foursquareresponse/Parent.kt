package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse

import com.google.gson.annotations.SerializedName


data class Parent (

    @SerializedName("fsq_id" ) var fsqId : String? = null,
    @SerializedName("name"   ) var name  : String? = null

)