package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse

import com.google.gson.annotations.SerializedName


data class Context (

    @SerializedName("geo_bounds" ) var geoBounds : GeoBounds? = GeoBounds()

)