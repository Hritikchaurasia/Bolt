package com.example.bolt.ui.home

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bolt.BaseApplication
import com.example.greentaxi.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private var app: BaseApplication
) : ViewModel() {

    val tempLocation : LatLng = LatLng(21.8089308483, 79.90230327371)
    var userLocation: LatLng? = null
    var searchedLatLng: LatLng? = null

    fun drawPolyLine(map: GoogleMap?) {
        viewModelScope.launch {

            map?.clear()

            map?.addMarker(
                MarkerOptions().position(
                    userLocation ?: tempLocation
                ).title("starting location")


            )
            delay(1000)

            map?.animateCamera(
                CameraUpdateFactory.newLatLngZoom(userLocation ?: tempLocation, 15f)
            )

            delay(1000)

            map?.addMarker(
                MarkerOptions().position(
                    searchedLatLng ?: LatLng(tempLocation.latitude+0.01 , tempLocation.longitude - 0.01)
                ).title("destination")


            )
            delay(1000)
            map?.addPolyline(
                PolylineOptions().clickable(true)
                    .add(
                        userLocation ?: tempLocation,
                        searchedLatLng ?: LatLng(tempLocation.latitude + 0.01, tempLocation.longitude -0.01)
                    )
                    .color(Color.GREEN)
            )


        }
    }


    fun addMapMarker(map: GoogleMap?, markerLocation: LatLng) {
        viewModelScope.launch {

            map?.addMarker(
                MarkerOptions().position(
                    markerLocation
                ).title("My Location")

            )

            delay(1000)

            map?.animateCamera(
                CameraUpdateFactory.newLatLngZoom(markerLocation, 15f)
            )

            delay(1000)

            val temp1 = LatLng(markerLocation.latitude - 0.003, markerLocation.longitude + 0.003)

            map?.addMarker(
                MarkerOptions().position(
                    temp1
                ).title("taxi 1")
                    .icon(BitmapDescriptorFactory.fromBitmap(generateSmallIcon(app)))

            )

            delay(1000)

            val temp2 = LatLng(markerLocation.latitude + 0.001, markerLocation.longitude - 0.001)


            map?.addMarker(
                MarkerOptions().position(
                    temp2
                ).title("taxi 2")
                    .icon(BitmapDescriptorFactory.fromBitmap(generateSmallIcon(app)))
            )

            delay(1000)

            val temp3 = LatLng(markerLocation.latitude + 0.002, markerLocation.longitude + 0.003)


            map?.addMarker(
                MarkerOptions().position(
                    temp3
                ).title("taxi 3")
                    .icon(BitmapDescriptorFactory.fromBitmap(generateSmallIcon(app)))
            )

        }

    }

    private fun generateSmallIcon(context: Context): Bitmap {
        val height = 200
        val width = 200
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.taxi)
        return Bitmap.createScaledBitmap(bitmap, width, height, false)
    }


    //random number
    fun generateRandomNumber(startValue: Int, endValue: Int): String {
        val number = (startValue..endValue).random()
        return number.toString()
    }

}