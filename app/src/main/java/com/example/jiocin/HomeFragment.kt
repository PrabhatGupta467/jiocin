package com.example.jiocin

import android.os.Bundle
import android.text.TextUtils
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
    private lateinit var arrContactTwo:ArrayList<ModelTwo>
    private lateinit var arrContactThree:ArrayList<ModelThree>
    private lateinit var arrContactExplore:ArrayList<ModelExplore>
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
    private lateinit var recyclerViewExplore: RecyclerView

    var viewPager: ViewPager? = null
    private var recommendation:HashMap<Int,Int>?=HashMap<Int, Int> ()
    private var recommendationKey:Int=601
    private var recommendationValue:Int=0
    private val list: MutableList<Media> =mutableListOf<Media>()
    var carouselViewPagerAdapter: CarouselViewPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        payload="[ { \"svcDetails\": [ { \"DeviceType\": \"SMARTPHONE\", \"ServiceID\": 1, \"svcData\": [ { \"subscriberid\": \"1234567890\", \"RecommType\": 601, \"Recommendation\": [ { \"media_id\": \"b6304f3e036952e799bdeaf7f89c16e1\", \"thumbnail\": \"https://i.redd.it/6nfr6i4upjca1.jpg\", \"title\": \"Nenu Naa Rakshasi\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"fbbd3f3924ed56e5b2fd35c10b7b6b19\", \"thumbnail\": \"https://i.redd.it/9tdncqarhica1.gif\", \"title\": \"Savyasachi\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 602, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://i.redd.it/6nfr6i4upjca1.jpg\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 603, \"Recommendation\": [ { \"based_on\": \"MOVIE/SHOW Based on\", \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"based_on\": \"MOVIE/SHOW Based on\", \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 604, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 605, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 606, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 607, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 608, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 609, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 610, \"Recommendation\": [ { \"rank\": \"1\", \"genre\": \"Romantic\", \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"rank\": \"1\", \"genre\": \"Action\", \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 611, \"Recommendation\": [ { \"rank\": \"1\", \"language\": \"Telgu\", \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\" }, { \"rank\": \"1\", \"language\": \"Tamil\", \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\" } ] }, { \"RecommType\": 612, \"Recommendation\": [ { \"rank\": \"1\", \"media_id\": \"e3844a93171c500e8669b51d0ea12cb5\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Greenland\", \"description\": \"this movie is based on ......\" }, { \"rank\": \"20\", \"media_id\": \"92fd25a0b4ca11ec8ec6653f060ba240\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Dasvi\", \"description\": \"this movie is based on ......\" } ] }, { \"RecommType\": 613, \"Recommendation\": [ { \"rank\": \"1\", \"media_id\": \"92fd25a0b4ca11ec8ec6653f060ba240\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Dasvi\", \"description\": \"this movie is based on ......\" }, { \"rank\": \"20\", \"media_id\": \"28693604aedf506db3cccb6eaac837c5\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"83\", \"description\": \"this movie is based on ......\" } ] } ] } ] } ]"
        // Inflate the layout for this fragment
        var view:View=inflater.inflate(R.layout.fragment_home, container, false)

        val nudgeRespone:NudgeResponse  = NudgeResponse("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJTdWJJRCI6IjEyMzQ1Njc4OTAiLCJFeHBpcmUiOjI2NzMyNDI5NDJ9.UvfkNy7uVvn0U8t3WjEUP-jEXk2GfGCkVvRg4TcWLJ0","https://pp-api-raasgw.jio.com/v2/fetchdetails/","{\"buffer_type\":\"Request\", \"AppType\":4, \"buffer\":{ \"request_type\":4,\"Body\":{ \"ServiceInfo\":[{ \"DeviceType\":\"STB\", \"ServiceID\":1, \"Subscriberdetails\":[{ \"SubscriberId\":\"1000051032\", \"Personalized\":{ \"RecommType\":1}}]}]}}}")
        val thread:Thread =  Thread(nudgeRespone)
        thread.start()
        thread.join()
        val res:String = nudgeRespone.value
        Log.e("result",res)
        if(!TextUtils.isEmpty(res)){
            val jsonObject: JSONObject = JSONObject(res)
            val jsonObject1: JSONObject =jsonObject.optJSONObject("responseBuffer")
            val jsonObject2: JSONObject =jsonObject1.optJSONObject("body")
            val jsonArray: JSONArray =jsonObject2.optJSONArray("RecommendationDetails")
            val jsonObject3: JSONObject =jsonArray.optJSONObject(0)
            val jsonArray1: JSONArray =jsonObject3.optJSONArray("svcDetails")
            val jsonObject4: JSONObject =jsonArray1.optJSONObject(0)
            val jsonArray2: JSONArray =jsonObject4.optJSONArray("svcData")
            val jsonObject5: JSONObject =jsonArray2.optJSONObject(0)
            Log.e("subscriberid",jsonObject5.optString("subscriberid"))
            Log.e("RecommType", jsonObject5.optInt("RecommType").toString())
            Log.e("Recommendation",jsonObject5.optString("Recommendation"))
        }

        for(i in 0 until 13){
            recommendation?.put(recommendationKey, recommendationValue)
            recommendationKey++
            recommendationValue++
        }

        carouselPart(view)
        set602(view)
        set603(view)
        set604(view)
        set605(view)
        set606(view)
        setExplore(view)
        set607(view)
        set608(view)
        set609(view)
        set610(view)
        set611(view)
        set612(view)
        set613(view)
        
        return view
    }

    private fun setExplore(view: View) {
        arrContactExplore=ArrayList()
        recyclerViewExplore=view.findViewById(R.id.recyclerExplore)
        recyclerViewExplore.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        arrContactExplore.add(ModelExplore(R.drawable.img_10))
        arrContactExplore.add(ModelExplore(R.drawable.img_5))
        arrContactExplore.add(ModelExplore(R.drawable.img_6))
        arrContactExplore.add(ModelExplore(R.drawable.img_7))
        arrContactExplore.add(ModelExplore(R.drawable.img_8))
        arrContactExplore.add(ModelExplore(R.drawable.img_9))
        val recycler = RecyclerAdapterExplore(view.context,arrContactExplore)
        recyclerViewExplore.adapter=recycler
    }

    private fun set611(view: View) {

    }

    private fun set610(view: View) {
        arrContactTwo=ArrayList()
        recyclerView9=view.findViewById(R.id.recycler9)
        recyclerView9.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(610)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContactTwo.add(ModelTwo(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail")))

        }
        val recycler = RecyclerAdapterTwo(view.context,arrContactTwo)
        recyclerView9.adapter=recycler
    }

    private fun set613(view: View) {

    }

    private fun set612(view: View) {

    }

    private fun set609(view: View) {
        arrContactTwo=ArrayList()
        recyclerView8=view.findViewById(R.id.recycler8)
        recyclerView8.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(609)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContactTwo.add(ModelTwo(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail")))

        }
        val recycler = RecyclerAdapterTwo(view.context,arrContactTwo)
        recyclerView8.adapter=recycler
    }

    private fun set608(view: View) {
        arrContactThree=ArrayList()
        recyclerView7=view.findViewById(R.id.recycler7)
        recyclerView7.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(607)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContactThree.add(ModelThree(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail")))
        }
        val recycler = RecyclerAdapterThree(view.context,arrContactThree)
        recyclerView7.adapter=recycler
    }

    private fun set607(view: View) {
        arrContact=ArrayList()
        recyclerView6=view.findViewById(R.id.recycler6)
        recyclerView6.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(607)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContact.add(ContactModel(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail"),jsonArrayForContinueWatching.getJSONObject(i).getString("description")))
        }
        val recycler = RecyclerAddapter(view.context,arrContact)
        recyclerView6.adapter=recycler
    }

    private fun set606(view: View) {
        arrContactTwo=ArrayList()
        recyclerView5=view.findViewById(R.id.recycler5)
        recyclerView5.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(606)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContactTwo.add(ModelTwo(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail")))

        }
        val recycler = RecyclerAdapterTwo(view.context,arrContactTwo)
        recyclerView5.adapter=recycler
    }

    private fun set605(view: View) {
        arrContactTwo=ArrayList()
        recyclerView4=view.findViewById(R.id.recycler4)
        recyclerView4.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(605)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContactTwo.add(ModelTwo(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail")))

        }
        val recycler = RecyclerAdapterTwo(view.context,arrContactTwo)
        recyclerView4.adapter=recycler
    }

    private fun set604(view: View) {
        arrContactTwo=ArrayList()
        recyclerView3=view.findViewById(R.id.recycler3)
        recyclerView3.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(604)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContactTwo.add(ModelTwo(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail")))

        }
        val recycler = RecyclerAdapterTwo(view.context,arrContactTwo)
        recyclerView3.adapter=recycler
    }

    private fun set603(view: View) {
        arrContact=ArrayList()
        recyclerView2=view.findViewById(R.id.recycler2)
        recyclerView2.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(603)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContact.add(ContactModel(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail"),jsonArrayForContinueWatching.getJSONObject(i).getString("description")))
        }
        val recycler = RecyclerAddapter(view.context,arrContact)
        recyclerView2.adapter=recycler
    }

    private fun set602(view: View) {
        arrContact=ArrayList()
        recyclerView1=view.findViewById(R.id.recycler1)
        recyclerView1.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        val jsonArrayForContinueWatching:JSONArray=jsonParser(602)
        for(i in 0 until jsonArrayForContinueWatching.length()){
            arrContact.add(ContactModel(jsonArrayForContinueWatching.getJSONObject(i).getString("thumbnail"),jsonArrayForContinueWatching.getJSONObject(i).getString("description")))
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
        viewPager = view.findViewById(R.id.carouselViewPager)
        val carouselTab: TabLayout = view.findViewById<TabLayout>(R.id.carouselTab)
        carouselTab.setupWithViewPager(viewPager, true)
        val jsonArrayForBanner:JSONArray=jsonParser(601)
        for(i in 0 until jsonArrayForBanner.length()){
            val media=Media()
            media.mediaUrl=jsonArrayForBanner.getJSONObject(i).getString("thumbnail")
            list.add(media)
        }
        if (list != null) {
            carouselViewPagerAdapter = CarouselViewPagerAdapter(view.context, list)
            viewPager?.adapter = carouselViewPagerAdapter
        } else {
         Log.e("Carousel","no media file")
        }

    }

   

}