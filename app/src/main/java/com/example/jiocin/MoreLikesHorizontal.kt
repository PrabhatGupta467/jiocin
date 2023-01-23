package com.example.jiocin

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.media3.common.MediaItem
import androidx.media3.common.util.Util
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoreLikesHorizontal : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var arrContact:ArrayList<ModelHorizontal>
    private var player: ExoPlayer? = null
    private var playbackPosition=0L
    private var currentItem=0
    private var playWhenReady=true
    private lateinit var result: PlayerView
    private val mediaMp4 ="https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_likes)
        supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.BLACK
            window.navigationBarColor= Color.BLACK
        }
        result=findViewById(R.id.video_view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
//        arrContact=ArrayList()
//        val set602: JSONArray =jsonParser(602)
//        recyclerView=findViewById(R.id.recyclerView)
//        if(set602!=null){
//            recyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
//            for(i in 0 until set602.length()){
//                arrContact.add(ContactModel(set602.optJSONObject(i).optString("thumbnail"),set602.optJSONObject(i).optString("description")))
//            }
//            val recycler = RecyclerAddapter(this,arrContact)
//            recyclerView.adapter=recycler
//        }


        arrContact=ArrayList()
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=  GridLayoutManager(this,2) //setting layout manager...
        for(i in 0 until 15){
        arrContact.add(ModelHorizontal("https://picsum.photos/200/300","description"))
        }
        val recycler = RecyclerAdapterHorizontal(this,arrContact)
        recyclerView.adapter=recycler

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
}