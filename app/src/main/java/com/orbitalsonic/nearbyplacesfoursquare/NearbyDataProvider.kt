package com.orbitalsonic.nearbyplacesfoursquare

import android.content.Context


object NearbyDataProvider {

    /**
     * Find Category Types here
     * https://developer.foursquare.com/docs/categories
     */

    fun getNearbyList(context: Context): ArrayList<NearbyPlacesItem> {
        val mList: ArrayList<NearbyPlacesItem> = ArrayList()

        /**
         * Health
         */
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.health_medicine),
                categoryType = "15000"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.ambulance_service),
                categoryType = "15009"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.blood_bank),
                categoryType = "15005"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.pharmacy),
                categoryType = "15011"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.healthcare_clinic),
                categoryType = "15011"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.dentist),
                categoryType = "15007"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.hospital),
                categoryType = "15014"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.medical_lab),
                categoryType = "15017"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.psychologist),
                categoryType = "15020"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.urgent_care_center),
                categoryType = "15053"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.veterinarian),
                categoryType = "15054"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.women_health_clinic),
                categoryType = "15056"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.physician),
                categoryType = "15027"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.home_health_care_service),
                categoryType = "15012"
            )
        )

        /**
         * Entertainment
         */


        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.amusement_park),
                categoryType = "10001"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.bowling),
                categoryType = "10006"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.internet_cafe),
                categoryType = "10020"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.movie_theatre),
                categoryType = "10024"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.party_center),
                categoryType = "10034"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.water_park),
                categoryType = "10055"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.zoo),
                categoryType = "10056"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.gaming_cafe),
                categoryType = "10018"
            )
        )


        /**
         * Food and Drinks
         */


        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.bakery),
                categoryType = "13002"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.cafes),
                categoryType = "13032"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.coffee),
                categoryType = "13033"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.bar),
                categoryType = "13003"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.breakfast),
                categoryType = "13028"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.tea_houses),
                categoryType = "13035"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.cafeteria),
                categoryType = "13037"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.dessert_shop),
                categoryType = "13040"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.food_court),
                categoryType = "13052"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.restaurant),
                categoryType = "13065"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.bbq_joint),
                categoryType = "13026"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.chinese_restaurant),
                categoryType = "13099"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.indian_restaurant),
                categoryType = "13199"
            )
        )


        /**
         * Services
         */


        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.advertising),
                categoryType = "11001"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.architecture),
                categoryType = "11003"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.automotive),
                categoryType = "11009"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.child_care_service),
                categoryType = "11025"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.construction),
                categoryType = "11028"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.event_service),
                categoryType = "11038"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.atm),
                categoryType = "11044"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.funeral_home),
                categoryType = "11059"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.health_and_beauty_service),
                categoryType = "11061"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.carpenter),
                categoryType = "11078"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.interior_designer),
                categoryType = "11090"
            )
        )


        /**
         * Travel and Transport
         */


        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.bike_rental),
                categoryType = "19002"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.boat_rental),
                categoryType = "19003"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.cruise),
                categoryType = "19005"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.fuel_station),
                categoryType = "19007"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.bus_stop),
                categoryType = "19043"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.hotel),
                categoryType = "19014"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.parking),
                categoryType = "19020"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.tourist_service),
                categoryType = "19029"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.airport),
                categoryType = "19031"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.bus_station),
                categoryType = "19042"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.rental_car),
                categoryType = "19048"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.taxi_stand),
                categoryType = "19049"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.public_transportation),
                categoryType = "19054"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.travel_agency),
                categoryType = "19055"
            )
        )


        /**
         * Event
         */

        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.festival),
                categoryType = "14004"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.entertainment_event),
                categoryType = "14003"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.sporting_event),
                categoryType = "14007"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.christmas_market),
                categoryType = "14010"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.other_event),
                categoryType = "14015"
            )
        )


        /**
         * Landmark
         */


        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.hiking_trail),
                categoryType = "16019"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.beach),
                categoryType = "16029"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.farm),
                categoryType = "17065"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.forest),
                categoryType = "16015"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.mountain),
                categoryType = "16027"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.dog_park),
                categoryType = "16033"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.river),
                categoryType = "16043"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.palace),
                categoryType = "16031"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.historic_places),
                categoryType = "16020"
            )
        )


        /**
         * Sports
         */

        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.athletic_field),
                categoryType = "18001"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.baseball),
                categoryType = "18002"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.basketball),
                categoryType = "18007"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.football_club),
                categoryType = "18014"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.golf_club),
                categoryType = "18017"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.gym_and_studio),
                categoryType = "18021"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.hockey_club),
                categoryType = "18032"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.indoor_play_area),
                categoryType = "18035"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.tennis_club),
                categoryType = "18046"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.badminton_court),
                categoryType = "18041"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.skating),
                categoryType = "18054"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.swimming_pool),
                categoryType = "18075"
            )
        )


        /**
         * Shopping
         */

        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.supermarket),
                categoryType = "17069"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.shopping_mall),
                categoryType = "17114"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.automotive_retail),
                categoryType = "17005"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.boutique),
                categoryType = "17020"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.computers_electronics),
                categoryType = "17023"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.cosmetics_store),
                categoryType = "17030"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.eyecare_store),
                categoryType = "17037"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.fashion_retail),
                categoryType = "17039"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.food_store),
                categoryType = "17057"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.furniture_home_store),
                categoryType = "17082"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.gift_store),
                categoryType = "17089"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.perfume_store),
                categoryType = "17109"
            )
        )
        mList.add(
            NearbyPlacesItem(
                itemName = context.getString(R.string.wholesale_store),
                categoryType = "17139"
            )
        )

        return mList
    }


}