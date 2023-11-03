package com.example.mad_practical9_21012011020

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity(),Animation.AnimationListener {

    lateinit var AnimationLogo : AnimationDrawable
    lateinit var logoImage : ImageView
    lateinit var logoAnimation : Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        logoImage = findViewById(R.id.imageview)
        logoImage.setBackgroundResource(R.drawable.logo_animation_list)
        AnimationLogo = logoImage.background as AnimationDrawable


        logoAnimation = AnimationUtils.loadAnimation(this , R.anim.twin_animation)
        logoAnimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus){
            logoImage.startAnimation(logoAnimation)
            AnimationLogo.start()

        }
        else{
            AnimationLogo.stop()
        }
        super.onWindowFocusChanged(hasFocus)
    }

    override fun onAnimationStart(p0: Animation?) {
        //animationAnd maintent no use kari bija ma redirect karvanu che
    }

    override fun onAnimationEnd(p0: Animation?) {

        Intent(this,MainActivity::class.java).apply { startActivity(this) }
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }

}