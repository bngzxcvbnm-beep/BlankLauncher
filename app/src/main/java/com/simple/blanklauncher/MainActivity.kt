package com.simple.blanklauncher

import android.app.WallpaperManager
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var wallpaperImage: ImageView

    // Launcher để chọn ảnh từ thư viện khi long-press
    private val pickImageLauncher = registerForActivityResult(
        androidx.activity.result.contract.ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { setCustomWallpaper(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wallpaperImage = findViewById(R.id.wallpaperImage)

        loadWallpaper()

        // Giữ (long-press) trên màn hình để đổi hình nền riêng cho launcher.
        // Nếu bạn không muốn cả tính năng này, có thể xoá khối bên dưới.
        wallpaperImage.setOnLongClickListener {
            pickImageLauncher.launch("image/*")
            true
        }
    }

    // Lấy hình nền hệ thống hiện tại để hiển thị (đồng bộ với wallpaper máy)
    private fun loadWallpaper() {
        try {
            val wallpaperManager = WallpaperManager.getInstance(this)
            val drawable = wallpaperManager.drawable
            wallpaperImage.setImageDrawable(drawable)
        } catch (e: Exception) {
            // Không có quyền hoặc lỗi -> giữ nền đen mặc định
        }
    }

    private fun setCustomWallpaper(uri: Uri) {
        try {
            wallpaperImage.setImageURI(uri)
        } catch (e: Exception) {
            Toast.makeText(this, "Không thể tải ảnh này", Toast.LENGTH_SHORT).show()
        }
    }
}
