package com.orbitalsonic.nearbyplacesfoursquare.foursquareresponse

import com.google.gson.annotations.SerializedName


data class Location (

    @SerializedName("address"           ) var address          : String? = null,
    @SerializedName("country"           ) var country          : String? = null,
    @SerializedName("cross_street"      ) var crossStreet      : String? = null,
    @SerializedName("formatted_address" ) var formattedAddress : String? = null,
    @SerializedName("locality"          ) var locality         : String? = null,
    @SerializedName("postcode"          ) var postcode         : String? = null,
    @SerializedName("region"            ) var region           : String? = null

)