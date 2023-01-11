package com.example.jiocin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment() {
    private lateinit var arrContact:ArrayList<ContactModel>
    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView
    private lateinit var recyclerView4: RecyclerView
    private lateinit var recyclerView5: RecyclerView
    private lateinit var recyclerView6: RecyclerView
    private lateinit var recyclerView7: RecyclerView
    private lateinit var recyclerView8: RecyclerView
    var viewPager: ViewPager? = null

    private val list: MutableList<Media> =mutableListOf<Media>()
    var carouselViewPagerAdapter: CarouselViewPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View=inflater.inflate(R.layout.fragment_home, container, false)

        arrContact=ArrayList()
        recyclerView1=view.findViewById(R.id.recycler1)
        recyclerView2=view.findViewById(R.id.recycler2)
        recyclerView3=view.findViewById(R.id.recycler3)
        recyclerView4=view.findViewById(R.id.recycler4)
        recyclerView5=view.findViewById(R.id.recycler5)
        recyclerView6=view.findViewById(R.id.recycler6)
        recyclerView7=view.findViewById(R.id.recycler7)
        recyclerView8=view.findViewById(R.id.recycler8)

        viewPager = view.findViewById(R.id.carouselViewPager)
        val carouselTab: TabLayout = view.findViewById<TabLayout>(R.id.carouselTab)
        carouselTab.setupWithViewPager(viewPager, true)

        for (i in 0 until 7) {
            val media = Media()
            media.mediaUrl ="https://jiojap.akamaized.net/jiopush2/dev/5f09842d-f9c6-39c2-8f1a-0cfd9e220bf3_1667814568398_ii.jpg"
            media.hypUrl ="Hii"
            list.add(media)
        }
        if (list != null) {
            carouselViewPagerAdapter = CarouselViewPagerAdapter(view.context, list)
            viewPager?.adapter = carouselViewPagerAdapter

        } else {

        }
        setRecyclerView(arrContact,recyclerView1,view)
        setRecyclerView(arrContact,recyclerView2,view)
        setRecyclerView(arrContact,recyclerView3,view)
        setRecyclerView(arrContact,recyclerView4,view)
        setRecyclerView(arrContact,recyclerView5,view)
        setRecyclerView(arrContact,recyclerView6,view)
        setRecyclerView(arrContact,recyclerView7,view)
        setRecyclerView(arrContact,recyclerView8,view)

        return view
    }
    private fun setRecyclerView(arrContact:ArrayList<ContactModel>,recyclerView: RecyclerView,view:View) {
        recyclerView.layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL,false) //setting layout manager...
        arrContact.add(ContactModel(R.drawable.img))//setting the data
        arrContact.add(ContactModel(R.drawable.img_1))
        arrContact.add(ContactModel(R.drawable.img_2))
        arrContact.add(ContactModel(R.drawable.img_3))
        arrContact.add(ContactModel(R.drawable.img_4))
        arrContact.add(ContactModel(R.drawable.img_5))
        arrContact.add(ContactModel(R.drawable.img_1))
        val recycler = RecyclerAddapter(view.context,arrContact)
        recyclerView.adapter=recycler
    }

}