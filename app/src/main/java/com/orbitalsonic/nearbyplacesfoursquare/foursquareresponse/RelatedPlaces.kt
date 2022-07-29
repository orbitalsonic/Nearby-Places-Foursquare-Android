package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse

import com.google.gson.annotations.SerializedName
import com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse.Parent


data class RelatedPlaces (

    @SerializedName("parent" ) var parent : Parent? = Parent()

)