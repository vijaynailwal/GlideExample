package com.example.glideexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.drawable.Drawable
import com.bumptech.glide.request.RequestListener
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.target.Target


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        val imageView = ImageView(this)

        /*Glide.with(this)
            .load("https://moodle.htwchur.ch/pluginfile.php/124614/mod_page/content/4/example.jpg")
            .into(imageView)
        linearLayout.addView(imageView)

        Glide.with(this)
            .load("https://moodle.htwchur.ch/pluginfile.php/124614/mod_page/content/4/example.jpg")
            .override(300, 200)
            .into(resizeImage);

        Glide.with(this)
            .load("https://moodle.htwchur.ch/pluginfile.php/124614/mod_page/content/4/example.jpg")
            .placeholder(R.drawable.ic_launcher_backgroun) //placeholder
            .error(R.drawable.ic_error) //error
            .into(placeholdeImage);


        Glide.with(this)
            .load("https://moodle.htwchur.ch/pluginfile.php/124614/mod_page/content/4/example.jpg")
            .centerCrop()
            .into(cropImage);


*/

        progressBar.setVisibility(View.VISIBLE)
        Glide.with(this)
            .load("https://moodle.htwchur.ch/pluginfil.php/124614/mod_page/content/4/example.jpg")
            .error(R.drawable.ic_error) //error
            .listener(object : RequestListener<Drawable> {
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.setVisibility(View.GONE)
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.setVisibility(View.GONE)
                    return false // important to return false so the error placeholder can be placed
                }


            })
            .into(afterloadimage)

    }
}