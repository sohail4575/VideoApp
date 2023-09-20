package com.example.videoapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    lateinit var videoView : VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoUrl = "https://resource.flexclip.com/templates/video/226p/movie-trailer.mp4"

        videoView = findViewById(R.id.videoView)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setVideoURI(Uri.parse(videoUrl))
        videoView.setMediaController(mediaController)
        videoView.requestFocus()
        videoView.start()

        videoView.setOnCompletionListener {
            Toast.makeText(applicationContext,"video is completed",Toast.LENGTH_SHORT).show()
        }
        videoView.setOnErrorListener{ mp, what, extra ->
            Toast.makeText(applicationContext,"No internet",Toast.LENGTH_SHORT).show()
            true
        }
    }
}