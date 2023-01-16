package com.example.jiocin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import org.json.JSONArray
import org.json.JSONObject


class HomeFragment : Fragment() {
    private lateinit var payload:String
    private lateinit var arrContact:ArrayList<ContactModel>
    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView
    private lateinit var recyclerView4: RecyclerView
    private lateinit var recyclerView5: RecyclerView
    private lateinit var recyclerView6: RecyclerView
    private lateinit var recyclerView7: RecyclerView
    private lateinit var recyclerView8: RecyclerView
    private lateinit var recyclerView9: RecyclerView
    private lateinit var recyclerView10: RecyclerView
    private lateinit var recyclerView11: RecyclerView
    private lateinit var recyclerView12: RecyclerView

    var viewPager: ViewPager? = null
    private var recommendation:HashMap<Int,Int>?=HashMap<Int, Int> ()
    private var recommendationKey:Int=601
    private var recommendationValue:Int=0
    private val list: MutableList<Media> =mutableListOf<Media>()
    var carouselViewPagerAdapter: CarouselViewPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        payload="[ { \"svcDetails\": [ { \"DeviceType\": \"SMARTPHONE\", \"ServiceID\": 1, \"svcData\": [ { \"subscriberid\": \"1234567890\", \"RecommType\": 601, \"Recommendation\": [ { \"media_id\": \"b6304f3e036952e799bdeaf7f89c16e1\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Nenu Naa Rakshasi\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"fbbd3f3924ed56e5b2fd35c10b7b6b19\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Savyasachi\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 602, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 603, \"Recommendation\": [ { \"based_on\": \"MOVIE/SHOW Based on\", \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"based_on\": \"MOVIE/SHOW Based on\", \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 604, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 605, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 606, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 607, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 608, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 609, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 610, \"Recommendation\": [ { \"rank\": \"1\", \"genre\": \"Romantic\", \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"rank\": \"1\", \"genre\": \"Action\", \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 611, \"Recommendation\": [ { \"rank\": \"1\", \"language\": \"Telgu\", \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"rank\": \"1\", \"language\": \"Tamil\", \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"RecommType\": 612, \"Recommendation\": [ { \"rank\": \"1\", \"media_id\": \"e3844a93171c500e8669b51d0ea12cb5\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Greenland\", \"description\": \"this movie is based on ......\" }, { \"rank\": \"20\", \"media_id\": \"92fd25a0b4ca11ec8ec6653f060ba240\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Dasvi\", \"description\": \"this movie is based on ......\" } ] }, { \"RecommType\": 613, \"Recommendation\": [ { \"rank\": \"1\", \"media_id\": \"92fd25a0b4ca11ec8ec6653f060ba240\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Dasvi\", \"description\": \"this movie is based on ......\" }, { \"rank\": \"20\", \"media_id\": \"28693604aedf506db3cccb6eaac837c5\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"83\", \"description\": \"this movie is based on ......\" } ] } ] } ] } ]"
        // Inflate the layout for this fragment
        var view:View=inflater.inflate(R.layout.fragment_home, container, false)

        for(i in 0 until 13){
            recommendation?.put(recommendationKey, recommendationValue)
            recommendationKey++
            recommendationValue++
        }

        carouselPart(view)
        set_602(view)

//        arrContact=ArrayList()
//
//        recyclerView1=view.findViewById(R.id.recycler1)
//        recyclerView2=view.findViewById(R.id.recycler2)
//        recyclerView3=view.findViewById(R.id.recycler3)
//        recyclerView4=view.findViewById(R.id.recycler4)
//        recyclerView5=view.findViewById(R.id.recycler5)
//        recyclerView6=view.findViewById(R.id.recycler6)
//        recyclerView7=view.findViewById(R.id.recycler7)
//        recyclerView8=view.findViewById(R.id.recycler8)




//        setRecyclerView(arrContact,recyclerView1,view)
//        setRecyclerView(arrContact,recyclerView2,view)
//        setRecyclerView(arrContact,recyclerView3,view)
//        setRecyclerView(arrContact,recyclerView4,view)
//        setRecyclerView(arrContact,recyclerView5,view)
//        setRecyclerView(arrContact,recyclerView6,view)
//        setRecyclerView(arrContact,recyclerView7,view)
//        setRecyclerView(arrContact,recyclerView8,view)

        return view
    }

    private fun set_602(view: View) {
        arrContact=ArrayList()
        recyclerView1=view.findViewById(R.id.recycler1)
        recyclerView1.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(602)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContact.add(ContactModel(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail")))
        }
        val recycler = RecyclerAddapter(view.context,arrContact)
        recyclerView1.adapter=recycler
    }

    private fun jsonParser(recommendationType: Int): JSONArray {
        val jsonArray: JSONArray = JSONArray(payload)
        val jsonObject: JSONObject = jsonArray.getJSONObject(0)
        val jsonArray1: JSONArray = jsonObject.getJSONArray("svcDetails")
        val jsonObject1: JSONObject = jsonArray1.getJSONObject(0)
        val jsonArray2: JSONArray = jsonObject1.getJSONArray("svcData")
        val jsonObject2: JSONObject = jsonArray2.getJSONObject(recommendation?.get(recommendationType)!!)
        return jsonObject2.getJSONArray("Recommendation")
    }

    private fun carouselPart(view: View) {
//        val nudgeRespone:NudgeResponse  = NudgeResponse()
//        val thread:Thread =  Thread(nudgeRespone)
//        thread.start()
//        thread.join()
//        val res:String = nudgeRespone.value
//        Log.e("result",res)
//        if(!TextUtils.isEmpty(res)){
//            val jsonObject: JSONObject = JSONObject(res)
//            val jsonObject1: JSONObject =jsonObject.optJSONObject("responseBuffer")
//            val jsonObject2: JSONObject =jsonObject1.optJSONObject("body")
//            val jsonArray: JSONArray =jsonObject2.optJSONArray("RecommendationDetails")
//            val jsonObject3: JSONObject =jsonArray.optJSONObject(0)
//            val jsonArray1: JSONArray =jsonObject3.optJSONArray("svcDetails")
//            val jsonObject4: JSONObject =jsonArray1.optJSONObject(0)
//            val jsonArray2: JSONArray =jsonObject4.optJSONArray("svcData")
//            val jsonObject5: JSONObject =jsonArray2.optJSONObject(0)
//            Log.e("subscriberid",jsonObject5.optString("subscriberid"))
//            Log.e("RecommType", jsonObject5.optInt("RecommType").toString())
//            Log.e("Recommendation",jsonObject5.optString("Recommendation"))
//        }



        viewPager = view.findViewById(R.id.carouselViewPager)
        val carouselTab: TabLayout = view.findViewById<TabLayout>(R.id.carouselTab)
        carouselTab.setupWithViewPager(viewPager, true)
        val jsonArrayForBanner:JSONArray=jsonParser(601)
        for(i in 0 until jsonArrayForBanner.length()){
            val media=Media()
            media.mediaUrl=jsonArrayForBanner.getJSONObject(i).getString("thumbnail")
            media.hypUrl="hii"
            list.add(media)
        }

//        for (i in 0 until 7) {
//            val media = Media()
//            media.mediaUrl ="https://jiojap.akamaized.net/jiopush2/dev/5f09842d-f9c6-39c2-8f1a-0cfd9e220bf3_1667814568398_ii.jpg"
//            media.hypUrl ="Hii"
//            list.add(media)
//        }

        if (list != null) {
            carouselViewPagerAdapter = CarouselViewPagerAdapter(view.context, list)
            viewPager?.adapter = carouselViewPagerAdapter
        } else {
         Log.e("Carousel","no media file")
        }

    }

    private fun setRecyclerView(arrContact:ArrayList<ContactModel>,recyclerView: RecyclerView,view:View) {
//        recyclerView.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
//        arrContact.add(ContactModel(R.drawable.img))//setting the data
//        arrContact.add(ContactModel(R.drawable.img_1))
//        arrContact.add(ContactModel(R.drawable.img_2))
//        arrContact.add(ContactModel(R.drawable.img_3))
//        arrContact.add(ContactModel(R.drawable.img_4))
//        arrContact.add(ContactModel(R.drawable.img_5))
//        arrContact.add(ContactModel(R.drawable.img_1))
//        val recycler = RecyclerAddapter(view.context,arrContact)
//        recyclerView.adapter=recycler
    }

}