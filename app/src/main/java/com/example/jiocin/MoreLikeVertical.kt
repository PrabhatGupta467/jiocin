package com.example.jiocin

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.media3.common.MediaItem
import androidx.media3.common.util.Util
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class MoreLikeVertical : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var arrContact:ArrayList<ModelVertical>
    private var player: ExoPlayer? = null
    private var playbackPosition=0L
    private var currentItem=0
    private var payloadV:String=""
    private lateinit var nudgeResponseV:NudgeResponse
    private var playWhenReady=true
    private lateinit var result: PlayerView
    private val mediaMp4 ="https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var tvMoreLike: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_like_vertical)
        supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.BLACK
            window.navigationBarColor= Color.BLACK
        }
        payloadV="[ { \"svcDetails\": [ { \"DeviceType\": \"SMARTPHONE\", \"ServiceID\": 1, \"svcData\": [ { \"RecommType\": 613, \"Recommendation\": [ { \"rank\": \"1\", \"media_id\": \"92fd25a0b4ca11ec8ec6653f060ba240\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"Dasvi\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" }, { \"rank\": \"20\", \"media_id\": \"28693604aedf506db3cccb6eaac837c5\", \"thumbnail\": \"https://picsum.photos/200/300\", \"title\": \"83\", \"description\": \"this movie is based on ......\", \"release_date\": \"2022-10-20\" } ] } ] } ] } ]"
        val intent=intent
        val recmType=intent.getIntExtra("recmType",612)
        val mediaId=intent.getStringExtra("mediaId")
        val tittle=intent.getStringExtra("tittle")
        val des=intent.getStringExtra("description")

        result=findViewById(R.id.video_view)
        title=findViewById(R.id.tittle)
        description=findViewById(R.id.des)
        tvMoreLike=findViewById(R.id.tvMoreLike)

        title.text=tittle
        description.text=des
        tvMoreLike.text="More Like - ${tittle}"

        nudgeResponseV=NudgeResponse("","","")
        CoroutineScope(Dispatchers.IO).launch{
            Log.e("1V::",Thread.currentThread().name)
            //payloadH=getNudgeResponse(nudgeResponseH)
            Log.e("payloadV",payloadV!!)
            CoroutineScope(Dispatchers.Main).launch {
                Log.e("2V::",Thread.currentThread().name)
                setRecyclerView()
            }

        }
    }
    fun jsonParserV(): JSONArray {
        val jsonArray: JSONArray = JSONArray(payloadV)
        val jsonObject: JSONObject =jsonArray.getJSONObject(0)
        val jsonArray1: JSONArray =jsonObject.getJSONArray("svcDetails")
        val jsonObject1: JSONObject =jsonArray1.getJSONObject(0)
        val jsonArray2: JSONArray =jsonObject1.getJSONArray("svcData")
        val jsonObject2: JSONObject =jsonArray2.getJSONObject(0)
        return jsonObject2.getJSONArray("Recommendation")
    }
    private fun getNudgeResponse(nudgeRespone: NudgeResponse):String {
        return if(!TextUtils.isEmpty(nudgeRespone.gettingResponse())){
            nudgeRespone.gettingResponse()
        }else{
            ""
        }
    }

    private fun setRecyclerView() {
        arrContact=ArrayList()
        recyclerView=findViewById(R.id.recyclerView)
        val setVertical:JSONArray=jsonParserV()
        if(setVertical.length()>0){
            recyclerView.layoutManager=  GridLayoutManager(this,3) //setting layout manager...
            for(i in 0 until setVertical.length()){
                arrContact.add(ModelVertical(setVertical.getJSONObject(i).getString("thumbnail"),
                    setVertical.getJSONObject(i).getString("description"),
                    setVertical.optJSONObject(i).optInt("RecommType"),
                    setVertical.optJSONObject(i).getString("media_id"),
                    setVertical.optJSONObject(i).optString("title")))
            }
            val recycler = RecyclerAdapterVertical(this,arrContact)
            recyclerView.adapter=recycler
        }
    }
    @SuppressLint("UnsafeOptInUsageError")
    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initializePlayer()
        }
    }

    @SuppressLint("UnsafeOptInUsageError")
    override fun onResume() {
        super.onResume()
        hideSystemUi()
        if ((Util.SDK_INT <= 23 || player == null)) {
            initializePlayer()
        }
    }



    @SuppressLint("UnsafeOptInUsageError")
    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            releasePlayer()
        }
        finish()
    }

    @SuppressLint("UnsafeOptInUsageError")
    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            releasePlayer()
        }
    }
    @SuppressLint("UnsafeOptInUsageError")
    private fun initializePlayer() {
        player = ExoPlayer.Builder(this)
            .build()
            .also { exoPlayer ->
                result.player = exoPlayer
                //val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3))
                val firstMediaItem = MediaItem.fromUri(mediaMp4)
                exoPlayer.setMediaItem(firstMediaItem)

//                val secondMediaItem = MediaItem.fromUri(mediaMp3)
//                exoPlayer.addMediaItem(secondMediaItem)

                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentItem, playbackPosition)
                exoPlayer.prepare()
            }
    }
    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, result).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
    private fun releasePlayer() {
        player?.let { exoPlayer ->
            playbackPosition = exoPlayer.currentPosition
            currentItem = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        player = null
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}