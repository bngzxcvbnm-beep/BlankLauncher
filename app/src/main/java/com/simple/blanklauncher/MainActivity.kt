package com.simple.blanklauncher

import android.app.WallpaperManager
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var wallpaperImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wallpaperImage = findViewById(R.id.wallpaperImage)

        loadWallpaper()
    }

    private fun loadWallpaper() {
        try {
            val wallpaperManager = WallpaperManager.getInstance(this)
            val drawable = wallpaperManager.drawable
            wallpaperImage.setImageDrawable(drawable)
        } catch (e: Exception) {
        }
    }
}
