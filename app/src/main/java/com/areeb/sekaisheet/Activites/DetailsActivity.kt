package com.areeb.sekaisheet.Activites

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.core.widget.ContentLoadingProgressBar
import com.areeb.sekaisheet.R
import com.areeb.sekaisheet.databinding.ActivityDetailsBinding


import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


class DetailsActivity : AppCompatActivity() {

    lateinit var detailsActivity: ActivityDetailsBinding

    var urlink:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)



         urlink = intent.getStringExtra("wallpaper_link").toString()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        detailsActivity = ActivityDetailsBinding.inflate(layoutInflater)
        val view = detailsActivity.root
        setContentView(view)
        setWallpaper()

    }




    private fun setWallpaper(){

        detailsActivity.progressBar.visibility=View.GONE
        Glide.with(this).load(urlink).into(detailsActivity.detailsImage)


        detailsActivity.setHome.setOnClickListener {
            setWallpaperFun()
            Toast.makeText(this, "wallpaper set successfully", Toast.LENGTH_SHORT).show()

        }

        detailsActivity.setLock.setOnClickListener {
            setLockWallpaperFun()
            Toast.makeText(this, "wallpaper set successfully", Toast.LENGTH_SHORT).show()

        }
        detailsActivity.downloadBtn.setOnClickListener {
            Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show()
        }



    }

    private fun setWallpaperFun(){
        val bitmap:Bitmap = detailsActivity.detailsImage.drawable.toBitmap()
        var wallpaperManager = WallpaperManager.getInstance(applicationContext)
        try{
            wallpaperManager.setBitmap(bitmap)

        }catch (e:Exception){
            Toast.makeText(this, "Some error occur", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setLockWallpaperFun(){
        val bitmap:Bitmap = detailsActivity.detailsImage.drawable.toBitmap()
        var wallpaperManager= WallpaperManager.getInstance(applicationContext)

        try{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                wallpaperManager.setBitmap(bitmap,null,true,WallpaperManager.FLAG_LOCK)
            }else{
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }

        }catch (e:Exception){
            Toast.makeText(this, "some error occur", Toast.LENGTH_SHORT).show()
        }
    }


}

