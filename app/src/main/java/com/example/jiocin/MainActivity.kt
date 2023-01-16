package com.example.jiocin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
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

//        val nudgeRespone:NudgeResponse  = NudgeResponse()
//        val thread:Thread =  Thread(nudgeRespone)
//        thread.start()
//        thread.join()
//        val res:String = nudgeRespone.value
//        Log.e("result",res)
//        if(!TextUtils.isEmpty(res)){
//            val jsonObject:JSONObject= JSONObject(res)
//            val jsonObject1:JSONObject=jsonObject.optJSONObject("responseBuffer")
//            val jsonObject2:JSONObject=jsonObject1.optJSONObject("body")
//            val jsonArray:JSONArray=jsonObject2.optJSONArray("RecommendationDetails")
//            val jsonObject3:JSONObject=jsonArray.optJSONObject(0)
//            val jsonArray1:JSONArray=jsonObject3.optJSONArray("svcDetails")
//            val jsonObject4:JSONObject=jsonArray1.optJSONObject(0)
//            val jsonArray2:JSONArray=jsonObject4.optJSONArray("svcData")
//            val jsonObject5:JSONObject=jsonArray2.optJSONObject(0)
//            Log.e("subscriberid",jsonObject5.optString("subscriberid"))
//            Log.e("RecommType", jsonObject5.optInt("RecommType").toString())
//            Log.e("Recommendation",jsonObject5.optString("Recommendation"))
//        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

}