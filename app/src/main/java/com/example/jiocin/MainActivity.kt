package com.example.jiocin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jio.jioads.instreamads.vastparser.model.j
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        loadFragment(HomeFragment())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.sports -> {
                    loadFragment(SportsFragment())
                    true
                }
                R.id.movies -> {
                    loadFragment(MoviesFragment())
                    true
                }
                R.id.tv -> {
                    loadFragment(TvFragment())
                    true
                }
                R.id.menu -> {
                    loadFragment(MenuFragment())
                    true
                }
                else -> throw AssertionError()
            }
        }
//        val jioNudgeResponse:JioNudgeResponse= JioNudgeResponse()
//        jioNudgeResponse.getJioNudgeResponse()
        val nudgeRespone:NudgeResponse  = NudgeResponse()
        val thread:Thread =  Thread(nudgeRespone)
        thread.start()
        thread.join()
        val res:String = nudgeRespone.value
        Log.e("result",res)
        var jsonObject:JSONObject= JSONObject(res)
        var jsonObject1:JSONObject=jsonObject.getJSONObject("responseBuffer")
        var jsonObject2:JSONObject=jsonObject1.getJSONObject("body")
        var jsonArray:JSONArray=jsonObject2.getJSONArray("RecommendationDetails")
        var jsonObject3:JSONObject=jsonArray.getJSONObject(0)
        var jsonArray1:JSONArray=jsonObject3.getJSONArray("svcDetails")
        var jsonObject4:JSONObject=jsonArray1.getJSONObject(0)
        var jsonArray2:JSONArray=jsonObject4.getJSONArray("svcData")
        var jsonObject5:JSONObject=jsonArray2.getJSONObject(0)
        Log.e("subscriberid",jsonObject5.getString("subscriberid"))
        Log.e("RecommType", jsonObject5.getInt("RecommType").toString())
        Log.e("Recommendation",jsonObject5.getString("Recommendation"))


    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

}