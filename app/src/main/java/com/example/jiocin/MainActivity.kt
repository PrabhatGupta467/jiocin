package com.example.jiocin

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.fragment.app.Fragment
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView
    private lateinit var searchBar:LinearLayout
    private lateinit var hideOrShow:FrameLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.BLACK
            window.navigationBarColor=Color.BLACK
        }






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

//        val nudgeRespone:NudgeResponse  = NudgeResponse("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJTdWJJRCI6IjEyMzQ1Njc4OTAiLCJFeHBpcmUiOjI2NzMyNDI5NDJ9.UvfkNy7uVvn0U8t3WjEUP-jEXk2GfGCkVvRg4TcWLJ0","https://dummy.restapiexample.com/api/v1/create","\t{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}")
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

//        searchBar=findViewById(R.id.searchBar)
//        hideOrShow=findViewById(R.id.container)
//
//        hideOrShow.setOnTouchListener(object :View.OnTouchListener{
//            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
//                TODO("Not yet implemented")
//                if(p1?.action==MotionEvent.ACTION_DOWN){
//                   searchBar.visibility=View.VISIBLE
//                }
//                if(p1?.action==MotionEvent.ACTION_UP){
//                    searchBar.visibility=View.GONE
//                }
//            }
//        })



    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

}