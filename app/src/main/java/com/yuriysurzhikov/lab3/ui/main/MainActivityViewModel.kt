package com.yuriysurzhikov.lab3.ui.main

import android.net.Uri
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.yuriysurzhikov.lab3.model.DataContact
import com.yuriysurzhikov.lab3.ui.list.groupedrecycler.ExampleGroupedAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val mContactsList = mutableListOf<DataContact>()
    private val mContactsObservable = MutableLiveData<ArrayList<ExampleGroupedAdapter.DataGroup>>()

    val isEmpty = ObservableBoolean()

    init {
        load()
    }

    fun load() {
        CoroutineScope(Dispatchers.IO).launch {
            val newList = arrayListOf(
                ExampleGroupedAdapter.DataGroup("Title 1", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1506112573664-1a1b66d93ff3?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8dmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRID4x3LaKWb4fIIyC7fk-GMxsptlk3slOznA&usqp=CAU")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzayBclNLVmEonTDbFCI-7NAjNzR7BgnsEQg&usqp=CAU")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrKVPi-XscI-HtgnsaFkWGxCkTermqbnUDw&usqp=CAU"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 2", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://eskipaper.com/images/view-wallpaper-hd-1.jpg")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1529974019031-b0cd38fd54fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://s2.best-wallpaper.net/wallpaper/iphone/1407/New-York-City-USA-Manhattan-skyscrapers-buildings-houses-twilight_iphone_320x480.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 3", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.pexels.com/photos/2105416/pexels-photo-2105416.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://townofpleasantview.com/images/pardue_ashlyn_002-crop-u58705.jpg?crc=4021793490")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://sase.org/wp-content/uploads/2018/06/NYCHotelsBestViews.jpg")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://cdn.theculturetrip.com/wp-content/uploads/2017/12/1024px-lubyanka_cdm_view_from_panoramic_view_point_05-2015_img07.jpg")),
                    DataContact("Title5", "Subhead5", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1600751371953-9f8ea72bbaac?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8YmVhdXRpZnVsJTIwdmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title6", "Subhead6", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb9gRMy1d6UjKnfYrIy1Dk_wLUk9784CdsIA&usqp=CAU")),
                    DataContact("Title7", "Subhead7", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo9J2GnEb1ZKdBQZIWeatlShtA-ysZPmoVhA&usqp=CAU")),
                    DataContact("Title8", "Subhead8", "+3131232123", Uri.parse("https://public-media.si-cdn.com/filer/d3/7e/d37e22b9-97a0-463f-b201-c4a3923f5402/italy_mobile.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 1", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1506112573664-1a1b66d93ff3?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8dmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRID4x3LaKWb4fIIyC7fk-GMxsptlk3slOznA&usqp=CAU")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzayBclNLVmEonTDbFCI-7NAjNzR7BgnsEQg&usqp=CAU")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrKVPi-XscI-HtgnsaFkWGxCkTermqbnUDw&usqp=CAU"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 2", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://eskipaper.com/images/view-wallpaper-hd-1.jpg")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1529974019031-b0cd38fd54fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://s2.best-wallpaper.net/wallpaper/iphone/1407/New-York-City-USA-Manhattan-skyscrapers-buildings-houses-twilight_iphone_320x480.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 3", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.pexels.com/photos/2105416/pexels-photo-2105416.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://townofpleasantview.com/images/pardue_ashlyn_002-crop-u58705.jpg?crc=4021793490")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://sase.org/wp-content/uploads/2018/06/NYCHotelsBestViews.jpg")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://cdn.theculturetrip.com/wp-content/uploads/2017/12/1024px-lubyanka_cdm_view_from_panoramic_view_point_05-2015_img07.jpg")),
                    DataContact("Title5", "Subhead5", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1600751371953-9f8ea72bbaac?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8YmVhdXRpZnVsJTIwdmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title6", "Subhead6", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb9gRMy1d6UjKnfYrIy1Dk_wLUk9784CdsIA&usqp=CAU")),
                    DataContact("Title7", "Subhead7", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo9J2GnEb1ZKdBQZIWeatlShtA-ysZPmoVhA&usqp=CAU")),
                    DataContact("Title8", "Subhead8", "+3131232123", Uri.parse("https://public-media.si-cdn.com/filer/d3/7e/d37e22b9-97a0-463f-b201-c4a3923f5402/italy_mobile.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 1", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1506112573664-1a1b66d93ff3?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8dmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRID4x3LaKWb4fIIyC7fk-GMxsptlk3slOznA&usqp=CAU")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzayBclNLVmEonTDbFCI-7NAjNzR7BgnsEQg&usqp=CAU")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrKVPi-XscI-HtgnsaFkWGxCkTermqbnUDw&usqp=CAU"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 2", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://eskipaper.com/images/view-wallpaper-hd-1.jpg")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1529974019031-b0cd38fd54fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://s2.best-wallpaper.net/wallpaper/iphone/1407/New-York-City-USA-Manhattan-skyscrapers-buildings-houses-twilight_iphone_320x480.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 3", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.pexels.com/photos/2105416/pexels-photo-2105416.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://townofpleasantview.com/images/pardue_ashlyn_002-crop-u58705.jpg?crc=4021793490")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://sase.org/wp-content/uploads/2018/06/NYCHotelsBestViews.jpg")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://cdn.theculturetrip.com/wp-content/uploads/2017/12/1024px-lubyanka_cdm_view_from_panoramic_view_point_05-2015_img07.jpg")),
                    DataContact("Title5", "Subhead5", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1600751371953-9f8ea72bbaac?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8YmVhdXRpZnVsJTIwdmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title6", "Subhead6", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb9gRMy1d6UjKnfYrIy1Dk_wLUk9784CdsIA&usqp=CAU")),
                    DataContact("Title7", "Subhead7", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo9J2GnEb1ZKdBQZIWeatlShtA-ysZPmoVhA&usqp=CAU")),
                    DataContact("Title8", "Subhead8", "+3131232123", Uri.parse("https://public-media.si-cdn.com/filer/d3/7e/d37e22b9-97a0-463f-b201-c4a3923f5402/italy_mobile.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 1", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1506112573664-1a1b66d93ff3?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8dmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRID4x3LaKWb4fIIyC7fk-GMxsptlk3slOznA&usqp=CAU")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzayBclNLVmEonTDbFCI-7NAjNzR7BgnsEQg&usqp=CAU")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrKVPi-XscI-HtgnsaFkWGxCkTermqbnUDw&usqp=CAU"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 2", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://eskipaper.com/images/view-wallpaper-hd-1.jpg")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1529974019031-b0cd38fd54fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://s2.best-wallpaper.net/wallpaper/iphone/1407/New-York-City-USA-Manhattan-skyscrapers-buildings-houses-twilight_iphone_320x480.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 3", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.pexels.com/photos/2105416/pexels-photo-2105416.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://townofpleasantview.com/images/pardue_ashlyn_002-crop-u58705.jpg?crc=4021793490")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://sase.org/wp-content/uploads/2018/06/NYCHotelsBestViews.jpg")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://cdn.theculturetrip.com/wp-content/uploads/2017/12/1024px-lubyanka_cdm_view_from_panoramic_view_point_05-2015_img07.jpg")),
                    DataContact("Title5", "Subhead5", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1600751371953-9f8ea72bbaac?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8YmVhdXRpZnVsJTIwdmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title6", "Subhead6", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb9gRMy1d6UjKnfYrIy1Dk_wLUk9784CdsIA&usqp=CAU")),
                    DataContact("Title7", "Subhead7", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo9J2GnEb1ZKdBQZIWeatlShtA-ysZPmoVhA&usqp=CAU")),
                    DataContact("Title8", "Subhead8", "+3131232123", Uri.parse("https://public-media.si-cdn.com/filer/d3/7e/d37e22b9-97a0-463f-b201-c4a3923f5402/italy_mobile.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 1", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1506112573664-1a1b66d93ff3?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8dmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRID4x3LaKWb4fIIyC7fk-GMxsptlk3slOznA&usqp=CAU")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzayBclNLVmEonTDbFCI-7NAjNzR7BgnsEQg&usqp=CAU")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrKVPi-XscI-HtgnsaFkWGxCkTermqbnUDw&usqp=CAU"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 2", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://eskipaper.com/images/view-wallpaper-hd-1.jpg")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1529974019031-b0cd38fd54fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://s2.best-wallpaper.net/wallpaper/iphone/1407/New-York-City-USA-Manhattan-skyscrapers-buildings-houses-twilight_iphone_320x480.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 3", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.pexels.com/photos/2105416/pexels-photo-2105416.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://townofpleasantview.com/images/pardue_ashlyn_002-crop-u58705.jpg?crc=4021793490")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://sase.org/wp-content/uploads/2018/06/NYCHotelsBestViews.jpg")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://cdn.theculturetrip.com/wp-content/uploads/2017/12/1024px-lubyanka_cdm_view_from_panoramic_view_point_05-2015_img07.jpg")),
                    DataContact("Title5", "Subhead5", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1600751371953-9f8ea72bbaac?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8YmVhdXRpZnVsJTIwdmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title6", "Subhead6", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb9gRMy1d6UjKnfYrIy1Dk_wLUk9784CdsIA&usqp=CAU")),
                    DataContact("Title7", "Subhead7", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo9J2GnEb1ZKdBQZIWeatlShtA-ysZPmoVhA&usqp=CAU")),
                    DataContact("Title8", "Subhead8", "+3131232123", Uri.parse("https://public-media.si-cdn.com/filer/d3/7e/d37e22b9-97a0-463f-b201-c4a3923f5402/italy_mobile.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 1", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1506112573664-1a1b66d93ff3?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8dmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRID4x3LaKWb4fIIyC7fk-GMxsptlk3slOznA&usqp=CAU")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzayBclNLVmEonTDbFCI-7NAjNzR7BgnsEQg&usqp=CAU")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrKVPi-XscI-HtgnsaFkWGxCkTermqbnUDw&usqp=CAU"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 2", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://eskipaper.com/images/view-wallpaper-hd-1.jpg")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1529974019031-b0cd38fd54fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://s2.best-wallpaper.net/wallpaper/iphone/1407/New-York-City-USA-Manhattan-skyscrapers-buildings-houses-twilight_iphone_320x480.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 3", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.pexels.com/photos/2105416/pexels-photo-2105416.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://townofpleasantview.com/images/pardue_ashlyn_002-crop-u58705.jpg?crc=4021793490")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://sase.org/wp-content/uploads/2018/06/NYCHotelsBestViews.jpg")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://cdn.theculturetrip.com/wp-content/uploads/2017/12/1024px-lubyanka_cdm_view_from_panoramic_view_point_05-2015_img07.jpg")),
                    DataContact("Title5", "Subhead5", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1600751371953-9f8ea72bbaac?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8YmVhdXRpZnVsJTIwdmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title6", "Subhead6", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb9gRMy1d6UjKnfYrIy1Dk_wLUk9784CdsIA&usqp=CAU")),
                    DataContact("Title7", "Subhead7", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo9J2GnEb1ZKdBQZIWeatlShtA-ysZPmoVhA&usqp=CAU")),
                    DataContact("Title8", "Subhead8", "+3131232123", Uri.parse("https://public-media.si-cdn.com/filer/d3/7e/d37e22b9-97a0-463f-b201-c4a3923f5402/italy_mobile.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 1", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1506112573664-1a1b66d93ff3?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8dmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRID4x3LaKWb4fIIyC7fk-GMxsptlk3slOznA&usqp=CAU")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzayBclNLVmEonTDbFCI-7NAjNzR7BgnsEQg&usqp=CAU")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrKVPi-XscI-HtgnsaFkWGxCkTermqbnUDw&usqp=CAU"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 2", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://eskipaper.com/images/view-wallpaper-hd-1.jpg")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1529974019031-b0cd38fd54fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://s2.best-wallpaper.net/wallpaper/iphone/1407/New-York-City-USA-Manhattan-skyscrapers-buildings-houses-twilight_iphone_320x480.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 3", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.pexels.com/photos/2105416/pexels-photo-2105416.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://townofpleasantview.com/images/pardue_ashlyn_002-crop-u58705.jpg?crc=4021793490")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://sase.org/wp-content/uploads/2018/06/NYCHotelsBestViews.jpg")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://cdn.theculturetrip.com/wp-content/uploads/2017/12/1024px-lubyanka_cdm_view_from_panoramic_view_point_05-2015_img07.jpg")),
                    DataContact("Title5", "Subhead5", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1600751371953-9f8ea72bbaac?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8YmVhdXRpZnVsJTIwdmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title6", "Subhead6", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb9gRMy1d6UjKnfYrIy1Dk_wLUk9784CdsIA&usqp=CAU")),
                    DataContact("Title7", "Subhead7", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo9J2GnEb1ZKdBQZIWeatlShtA-ysZPmoVhA&usqp=CAU")),
                    DataContact("Title8", "Subhead8", "+3131232123", Uri.parse("https://public-media.si-cdn.com/filer/d3/7e/d37e22b9-97a0-463f-b201-c4a3923f5402/italy_mobile.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 1", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1506112573664-1a1b66d93ff3?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8dmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRID4x3LaKWb4fIIyC7fk-GMxsptlk3slOznA&usqp=CAU")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzayBclNLVmEonTDbFCI-7NAjNzR7BgnsEQg&usqp=CAU")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrKVPi-XscI-HtgnsaFkWGxCkTermqbnUDw&usqp=CAU"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 2", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://eskipaper.com/images/view-wallpaper-hd-1.jpg")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1529974019031-b0cd38fd54fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://s2.best-wallpaper.net/wallpaper/iphone/1407/New-York-City-USA-Manhattan-skyscrapers-buildings-houses-twilight_iphone_320x480.jpg"))
                )),
                ExampleGroupedAdapter.DataGroup("Title 3", arrayListOf(
                    DataContact("Title1", "Subhead1", "+3131232123", Uri.parse("https://images.pexels.com/photos/2105416/pexels-photo-2105416.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")),
                    DataContact("Title2", "Subhead2", "+3131232123", Uri.parse("https://townofpleasantview.com/images/pardue_ashlyn_002-crop-u58705.jpg?crc=4021793490")),
                    DataContact("Title3", "Subhead3", "+3131232123", Uri.parse("https://sase.org/wp-content/uploads/2018/06/NYCHotelsBestViews.jpg")),
                    DataContact("Title4", "Subhead4", "+3131232123", Uri.parse("https://cdn.theculturetrip.com/wp-content/uploads/2017/12/1024px-lubyanka_cdm_view_from_panoramic_view_point_05-2015_img07.jpg")),
                    DataContact("Title5", "Subhead5", "+3131232123", Uri.parse("https://images.unsplash.com/photo-1600751371953-9f8ea72bbaac?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8YmVhdXRpZnVsJTIwdmlld3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")),
                    DataContact("Title6", "Subhead6", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb9gRMy1d6UjKnfYrIy1Dk_wLUk9784CdsIA&usqp=CAU")),
                    DataContact("Title7", "Subhead7", "+3131232123", Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo9J2GnEb1ZKdBQZIWeatlShtA-ysZPmoVhA&usqp=CAU")),
                    DataContact("Title8", "Subhead8", "+3131232123", Uri.parse("https://public-media.si-cdn.com/filer/d3/7e/d37e22b9-97a0-463f-b201-c4a3923f5402/italy_mobile.jpg"))
                ))
            )
            mContactsObservable.postValue(newList)
        }
    }

    fun observeContacts(owner: LifecycleOwner, observer: Observer<ArrayList<ExampleGroupedAdapter.DataGroup>>) {
        mContactsObservable.observe(owner, observer)
    }

    fun insertContact(contact: DataContact) {
        CoroutineScope(Dispatchers.IO).launch {
            mContactsList.add(contact)
            isEmpty.set(mContactsList.isEmpty())
        }
    }

    fun removeContact(contact: DataContact) {
        CoroutineScope(Dispatchers.IO).launch {
            mContactsList.remove(contact)
            isEmpty.set(mContactsList.isEmpty())
        }
    }
}