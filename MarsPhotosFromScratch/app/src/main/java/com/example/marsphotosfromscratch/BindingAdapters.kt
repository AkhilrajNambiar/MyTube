package com.example.marsphotosfromscratch

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marsphotosfromscratch.data.MarsPhoto
import com.example.marsphotosfromscratch.model.MarsApiStatus

/*
* The @BindingAdapter annotation tells data binding to execute
* this binding adapter when a View item has the imageUrl attribute.*/

@BindingAdapter("imageUrl")
fun bindImage(imageView:ImageView, imgUrl: String?){
    //To convert the passed image URL to a Uri
    imgUrl?.let{
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        //Loading that image to the imageView
        imageView.load(imgUri) {
            placeholder(R.drawable.loading)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listItem")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsPhoto>?){
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(imgView: ImageView, status:MarsApiStatus){
    when(status){
        MarsApiStatus.LOADING -> {
            imgView.visibility = View.VISIBLE
            imgView.setImageResource(R.drawable.loading)
        }
        MarsApiStatus.FAILURE -> {
            imgView.visibility = View.VISIBLE
            imgView.setImageResource(R.drawable.ic_no_connection)
        }
        MarsApiStatus.SUCCESS -> {
            imgView.visibility = View.GONE
        }
    }
}