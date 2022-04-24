package com.vickyhardian.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class splashScreen : AppCompatActivity() {

    private val splashScreenTimeout : Long = 2500

    private lateinit var anim: Animation
    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, splashScreenTimeout)

        anim = AnimationUtils.loadAnimation(this, R.anim.anim)
        imageView = findViewById(R.id.logo)
        imageView.animation = anim
    }
}