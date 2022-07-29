package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse


import com.google.gson.annotations.SerializedName
import com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse.Categories
import com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse.Geocodes
import com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse.Location
import com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse.RelatedPlaces


data class Results (

    @SerializedName("fsq_id"         ) var fsqId         : String?               = null,
    @SerializedName("categories"     ) var categories    : ArrayList<Categories> = arrayListOf(),
    @SerializedName("chains"         ) var chains        : ArrayList<String>     = arrayListOf(),
    @SerializedName("distance"       ) var distance      : Int?                  = null,
    @SerializedName("geocodes"       ) var geocodes      : Geocodes?             = Geocodes(),
    @SerializedName("link"           ) var link          : String?               = null,
    @SerializedName("location"       ) var location      : Location?             = Location(),
    @SerializedName("name"           ) var name          : String?               = null,
    @SerializedName("related_places" ) var relatedPlaces : RelatedPlaces?        = RelatedPlaces(),
    @SerializedName("timezone"       ) var timezone      : String?               = null

)