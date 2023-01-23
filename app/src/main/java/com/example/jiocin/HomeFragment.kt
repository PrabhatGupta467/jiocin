package com.example.jiocin

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import kotlin.coroutines.coroutineContext

class HomeFragment : Fragment() {
    private lateinit var nudgeRespone:NudgeResponse
    private  var payload:String?=""
    private lateinit var arrContact:ArrayList<ContactModel>
    private lateinit var arrContactTwo:ArrayList<ModelTwo>
    private lateinit var arrContactThree:ArrayList<ModelThree>
    private lateinit var arrContactFour:ArrayList<ModelFour>
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
    private lateinit var recyclerViewKeyTour: RecyclerView
    private lateinit var searchBar: LinearLayout
    private lateinit var hideOrShow: ScrollView

    var viewPager: ViewPager? = null
    private var recommendation:HashMap<Int,Int>?=HashMap<Int, Int> ()
    private var recommendationKey:Int=601
    private var recommendationValue:Int=0
    private val list: MutableList<Media> =mutableListOf<Media>()
    var carouselViewPagerAdapter: CarouselViewPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        nudgeRespone= NudgeResponse("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJTdWJJRCI6IjEyMzQ1Njc4OTAiLCJFeHBpcmUiOjI2NzMyNDI5NDJ9.UvfkNy7uVvn0U8t3WjEUP-jEXk2GfGCkVvRg4TcWLJ0","https://pp-api-raasgw.jio.com/v2/fetchdetails/","{\"buffer_type\":\"Request\", \"AppType\":4, \"buffer\":{ \"request_type\":4,\"Body\":{ \"ServiceInfo\":[{ \"DeviceType\":\"STB\", \"ServiceID\":1, \"Subscriberdetails\":[{ \"SubscriberId\":\"1000051032\", \"Personalized\":{ \"RecommType\":1}}]}]}}}")

        payload="{ \"status\": \"success\", \"AppType\": 1, \"responseBuffer\": { \"statuscode\": \"200\", \"result\": \"success\", \"request_type\": 4, \"body\": { \"RecommendationDetails\": [ { \"svcDetails\": [ { \"DeviceType\": \"SMARTPHONE\", \"ServiceID\": 1, \"svcData\": [ { \"subscriberid\": \"1234567890\", \"RecommType\": 601, \"Recommendation\": [ { \"media_id\": \"b6304f3e036952e799bdeaf7f89c16e1\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Nenu Naa Rakshasi\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"media_id\": \"fbbd3f3924ed56e5b2fd35c10b7b6b19\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Savyasachi\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 602, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 603, \"Recommendation\": [ { \"based_on\": \"MOVIE/SHOW Based on\", \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"based_on\": \"MOVIE/SHOW Based on\", \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 604, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 605, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 606, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 607, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 608, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 609, \"Recommendation\": [ { \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 610, \"Recommendation\": [ { \"rank\": \"1\", \"genre\": \"Romantic\", \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"rank\": \"1\", \"genre\": \"Action\", \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"subscriberid\": \"1234567890\", \"RecommType\": 611, \"Recommendation\": [ { \"rank\": \"1\", \"language\": \"Telgu\", \"media_id\": \"b7968650914f11e9b12279bd2b689533\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Roja Puthu Roja\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"rank\": \"1\", \"language\": \"Tamil\", \"media_id\": \"2beb7e7878075583b2de4378aeed6e0e\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Love in Simla\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] }, { \"RecommType\": 612, \"Recommendation\": [ { \"rank\": \"1\", \"media_id\": \"e3844a93171c500e8669b51d0ea12cb5\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Greenland\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"rank\": \"20\", \"media_id\": \"92fd25a0b4ca11ec8ec6653f060ba240\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Dasvi\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] } ] } ] } ] } } }"

        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment_home, container, false)
//        searchBar=view.findViewById(R.id.searchBar)
//        hideOrShow=view.findViewById(R.id.container)
//        val hos:HideOrShow=HideOrShow(searchBar,hideOrShow)
//        hos.hideOrShow()
        val shimmerEffect: ShimmerFrameLayout = view.findViewById(R.id.shimerEffect)

        for(i in 0 until 13){
            recommendation?.put(recommendationKey, recommendationValue)
            recommendationKey++
            recommendationValue++
        }
         CoroutineScope(Dispatchers.IO).launch{
         Log.e("1::",Thread.currentThread().name)
          //payload=getNudgeResponse(nudgeRespone)
          Log.e("payload",payload!!)
         CoroutineScope(Dispatchers.Main).launch {
             Log.e("2::",Thread.currentThread().name)
             shimmerEffect.hideShimmer()
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
             setKeyTournaments(view)
             set611(view)
             set612(view)
            //set613(view)

         }

      }
        return view
    }

    private fun getNudgeResponse(nudgeRespone: NudgeResponse):String {
        return if(!TextUtils.isEmpty(nudgeRespone.gettingResponse())){
            nudgeRespone.gettingResponse()
        }else{
            ""
        }
    }

    private fun setKeyTournaments(view: View) {
        arrContactExplore=ArrayList()
        recyclerViewKeyTour=view.findViewById(R.id.recyclerx)
        recyclerViewKeyTour.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        arrContactExplore.add(ModelExplore(R.drawable.ipl))
        arrContactExplore.add(ModelExplore(R.drawable.saas))
        arrContactExplore.add(ModelExplore(R.drawable.nba))
        arrContactExplore.add(ModelExplore(R.drawable.bwf))
        arrContactExplore.add(ModelExplore(R.drawable.laliga))
        arrContactExplore.add(ModelExplore(R.drawable.fifa))
        val recycler = RecyclerAdapterExplore(view.context,arrContactExplore)
        recyclerViewKeyTour.adapter=recycler
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
        arrContactFour=ArrayList()
        recyclerView10=view.findViewById(R.id.recycler10)
        val set611:JSONArray=jsonParser(611)
if(set611.length()>0){
    recyclerView10.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
    for(i in 0 until set611.length()){
        arrContactFour.add(ModelFour(set611.optJSONObject(i).optString("thumbnail"),
            set611.optJSONObject(i).optString("description"),
            set611.optJSONObject(i).optString("language"),
            set611.optJSONObject(i).optInt("RecommType"),
            set611.optJSONObject(i).getString("media_id"),
            set611.optJSONObject(i).optString("title")))
    }
    val recycler = RecyclerAdapterFour(view.context,arrContactFour)
    recyclerView10.adapter=recycler

}

    }

    private fun set610(view: View) {
        arrContactFour=ArrayList()
        recyclerView9=view.findViewById(R.id.recycler9)
        val set610:JSONArray=jsonParser(610)
        if(set610.length()>0){
            recyclerView9.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...

            for(i in 0 until set610.length()){
                arrContactFour.add(ModelFour(set610.optJSONObject(i).optString("thumbnail"),
                    set610.optJSONObject(i).optString("description"),
                    set610.optJSONObject(i).optString("genre"),
                    set610.optJSONObject(i).optInt("RecommType"),
                    set610.optJSONObject(i).getString("media_id"),
                    set610.optJSONObject(i).optString("title")))
            }
            val recycler = RecyclerAdapterFour(view.context,arrContactFour)
            recyclerView9.adapter=recycler

        }

    }

    private fun set613(view: View) {
        arrContact=ArrayList()
        recyclerView12=view.findViewById(R.id.recycler12)
        val set613:JSONArray=jsonParser(613)
        if(set613.length()>0){
            recyclerView12.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...

            for(i in 0 until set613.length()){
                arrContact.add(ContactModel(set613.optJSONObject(i).optString("thumbnail"),
                    set613.optJSONObject(i).optString("description"),
                    set613.optJSONObject(i).optInt("RecommType"),
                    set613.optJSONObject(i).getString("media_id"),
                    set613.optJSONObject(i).optString("title")))
            }
            val recycler = RecyclerAddapter(view.context,arrContact)
            recyclerView12.adapter=recycler
        }


    }

    private fun set612(view: View) {
        arrContactThree=ArrayList()
        recyclerView11=view.findViewById(R.id.recycler11)
        val set612:JSONArray=jsonParser(612)
        if(set612.length()>0){
            recyclerView11.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...

            for(i in 0 until set612.length()){
                arrContactThree.add(ModelThree(set612.optJSONObject(i).optString("thumbnail"),
                    set612.optJSONObject(i).optString("description"),
                    set612.optJSONObject(i).optInt("RecommType"),
                    set612.optJSONObject(i).getString("media_id"),
                    set612.optJSONObject(i).optString("title")))
            }
            val recycler = RecyclerAdapterThree(view.context,arrContactThree)
            recyclerView11.adapter=recycler
        }

    }

    private fun set609(view: View) {
        arrContactTwo=ArrayList()
        recyclerView8=view.findViewById(R.id.recycler8)
        val set609:JSONArray=jsonParser(609)
        if(set609.length()>0){

            recyclerView8.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...

            for(i in 0 until set609.length()){
                arrContactTwo.add(ModelTwo(set609.optJSONObject(i).optString("thumbnail"),
                    set609.optJSONObject(i).optString("description"),
                    set609.optJSONObject(i).optInt("RecommType"),
                    set609.optJSONObject(i).getString("media_id"),
                    set609.optJSONObject(i).optString("title")))

            }
            val recycler = RecyclerAdapterTwo(view.context,arrContactTwo)
            recyclerView8.adapter=recycler
        }

    }

    private fun set608(view: View) {
        arrContactThree=ArrayList()
        recyclerView7=view.findViewById(R.id.recycler7)
        val set608:JSONArray=jsonParser(607)
        if(set608.length()>0){
            recyclerView7.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...

            for(i in 0 until set608.length()){
                arrContactThree.add(ModelThree(set608.optJSONObject(i).optString("thumbnail"),
                    set608.optJSONObject(i).optString("description"),
                    set608.optJSONObject(i).optInt("RecommType"),
                    set608.optJSONObject(i).getString("media_id"),
                    set608.optJSONObject(i).optString("title")))
            }
            val recycler = RecyclerAdapterThree(view.context,arrContactThree)
            recyclerView7.adapter=recycler
        }

    }

    private fun set607(view: View) {
        arrContact=ArrayList()
        recyclerView6=view.findViewById(R.id.recycler6)
        val set607:JSONArray=jsonParser(607)
        if(set607.length()>0){
            recyclerView6.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...

            for(i in 0 until set607.length()){
                arrContact.add(ContactModel(set607.optJSONObject(i).optString("thumbnail"),
                    set607.optJSONObject(i).optString("description"),
                    set607.optJSONObject(i).optInt("RecommType"),
                    set607.optJSONObject(i).getString("media_id"),
                    set607.optJSONObject(i).optString("title")))
            }
            val recycler = RecyclerAddapter(view.context,arrContact)
            recyclerView6.adapter=recycler

        }

    }

    private fun set606(view: View) {
        arrContactTwo=ArrayList()
        recyclerView5=view.findViewById(R.id.recycler5)
        val set606:JSONArray=jsonParser(606)
        if(set606.length()>0){
            recyclerView5.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...

            for(i in 0 until set606.length()){
                arrContactTwo.add(ModelTwo(set606.optJSONObject(i).optString("thumbnail"),
                    set606.optJSONObject(i).optString("description"),
                    set606.optJSONObject(i).optInt("RecommType"),
                    set606.optJSONObject(i).getString("media_id"),
                    set606.optJSONObject(i).optString("title")))

            }
            val recycler = RecyclerAdapterTwo(view.context,arrContactTwo)
            recyclerView5.adapter=recycler
        }

    }

    private fun set605(view: View) {
        arrContactTwo=ArrayList()
        recyclerView4=view.findViewById(R.id.recycler4)
        val set605:JSONArray=jsonParser(605)
        if(set605.length()>0){
            recyclerView4.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...

            for(i in 0 until set605.length()){
                arrContactTwo.add(ModelTwo(set605.optJSONObject(i).optString("thumbnail"),
                    set605.optJSONObject(i).optString("description"),
                    set605.optJSONObject(i).optInt("RecommType"),
                    set605.optJSONObject(i).getString("media_id"),
                    set605.optJSONObject(i).optString("title")))

            }
            val recycler = RecyclerAdapterTwo(view.context,arrContactTwo)
            recyclerView4.adapter=recycler
        }

    }

    private fun set604(view: View) {
        arrContactTwo=ArrayList()
        recyclerView3=view.findViewById(R.id.recycler3)
        val set604:JSONArray=jsonParser(604)
        if(set604.length()>0){
            recyclerView3.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...

            for(i in 0 until set604.length()){
                arrContactTwo.add(ModelTwo(set604.optJSONObject(i).optString("thumbnail"),
                    set604.optJSONObject(i).optString("description"),
                    set604.optJSONObject(i).optInt("RecommType"),
                    set604.optJSONObject(i).getString("media_id"),
                    set604.optJSONObject(i).optString("title")))

            }
            val recycler = RecyclerAdapterTwo(view.context,arrContactTwo)
            recyclerView3.adapter=recycler
        }

    }

    private fun set603(view: View) {
        arrContact=ArrayList()
        recyclerView2=view.findViewById(R.id.recycler2)
        val textView:TextView=view.findViewById(R.id.tv2)
        val set603:JSONArray=jsonParser(603)
        if(set603.length()>0){
            recyclerView2.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
            textView.text="Because You Watched ${set603.getJSONObject(0).getString("based_on")}"
            for(i in 0 until set603.length()){
                arrContact.add(ContactModel(set603.optJSONObject(i).optString("thumbnail"),
                    set603.optJSONObject(i).optString("description"),
                    set603.optJSONObject(i).optInt("RecommType"),
                    set603.optJSONObject(i).getString("media_id"),
                    set603.optJSONObject(i).optString("title")))
            }
            val recycler = RecyclerAddapter(view.context,arrContact)
            recyclerView2.adapter=recycler
        }

    }

    private fun set602(view: View) {
        arrContact=ArrayList()
        val set602:JSONArray=jsonParser(602)
        recyclerView1=view.findViewById(R.id.recycler1)
        if(set602.length()>0){
            recyclerView1.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
            for(i in 0 until set602.length()){
                arrContact.add(ContactModel(set602.optJSONObject(i).optString("thumbnail"),
                    set602.optJSONObject(i).optString("description"),
                    set602.optJSONObject(i).optInt("RecommType"),
                    set602.optJSONObject(i).getString("media_id"),
                    set602.optJSONObject(i).optString("title")))
            }
            val recycler = RecyclerAddapter(view.context,arrContact)
            recyclerView1.adapter=recycler
        }
    }

    private fun jsonParser(recommendationType: Int): JSONArray {

           val jsonObjectNew:JSONObject= JSONObject(payload)
           val jsonObjectNew2:JSONObject=jsonObjectNew.optJSONObject("responseBuffer")
           val jsonObjectNew3:JSONObject=jsonObjectNew2.optJSONObject("body")
           val jsonArray:JSONArray=jsonObjectNew3.optJSONArray("RecommendationDetails")
        //val jsonArray: JSONArray = JSONArray(payload)
            val jsonObject: JSONObject = jsonArray.optJSONObject(0)
            val jsonArray1: JSONArray = jsonObject.optJSONArray("svcDetails")
            val jsonObject1: JSONObject = jsonArray1.optJSONObject(0)
            val jsonArray2: JSONArray = jsonObject1.optJSONArray("svcData")
            val jsonObject2: JSONObject = jsonArray2.optJSONObject(recommendation?.get(recommendationType)!!)
            return jsonObject2.optJSONArray("Recommendation")

    }

//    private  fun jsonParserTwo():JSONArray{
////////////////////////////////
////        val jsonObjectNewTwo:JSONObject= JSONObject(payload)
////        val jsonObjectNewTwo2:JSONObject=jsonObjectNewTwo.optJSONObject("responseBuffer")
////        val jsonObjectNewTwo3:JSONObject=jsonObjectNewTwo2.optJSONObject("body")
////        val jsonArrayTwo:JSONArray=jsonObjectNewTwo3.optJSONArray("RecommendationDetails")
///////////////////////////////
//
//
//
//        val jsonArrayTwo:JSONArray=JSONArray(payloadTwo)
//        val jsonObjectTwo:JSONObject=jsonArrayTwo.optJSONObject(0)
//        val jsonArrayTwo1:JSONArray=jsonObjectTwo.optJSONArray("svcDetails")
//        val jsonObjectTwo1:JSONObject=jsonArrayTwo1.optJSONObject(0)
//        val jsonArrayTwo2:JSONArray=jsonObjectTwo1.optJSONArray("svcData")
//        val jsonObjectTwo3:JSONObject=jsonArrayTwo2.optJSONObject(0)
//        //Log.e("recommendation type",jsonObjectTwo3.optString("RecommType"))
//        return jsonObjectTwo3.optJSONArray("Recommendation")
//    }

    private fun carouselPart(view: View) {
        viewPager = view.findViewById(R.id.carouselViewPager)
        val carouselTab: TabLayout = view.findViewById<TabLayout>(R.id.carouselTab)
        carouselTab.setupWithViewPager(viewPager, true)
        val jsonArrayForBanner:JSONArray=jsonParser(601)
        if(jsonArrayForBanner.length()>0){
            for(i in 0 until jsonArrayForBanner.length()){
                val media=Media()
                media.mediaUrl=jsonArrayForBanner.optJSONObject(i).optString("thumbnail")
                list.add(media)
            }
            if (list.size>0) {
                carouselViewPagerAdapter = CarouselViewPagerAdapter(view.context, list)
                viewPager?.adapter = carouselViewPagerAdapter
            } else {
                Log.e("Carousel","no media file")
            }
        }

    }
}