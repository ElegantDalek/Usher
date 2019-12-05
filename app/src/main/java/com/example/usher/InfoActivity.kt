package com.example.usher

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.snackbar.Snackbar

class InfoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val title = intent.getStringExtra(TITLE_INTENT)
        val toolbarLayout: CollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout)
        toolbarLayout.title = title

        val desc = intent.getStringExtra(DESCRIPTION_INTENT)
        val descriptionView: TextView = findViewById(R.id.info_description)
        descriptionView.text = desc

        val image = intent.getIntExtra(IMAGE_INTENT, -1)
        val imageView: ImageView = findViewById(R.id.toolbar_image)
//        imageView.setImageResource(image)

        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, image)
        imageView.setImageBitmap(ThumbnailUtils.extractThumbnail(bitmap, 1312, 1000))

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val snackbar = Snackbar.make(it, "Ticket purchased!", Snackbar.LENGTH_LONG)
                .setAction("Undo", View.OnClickListener{})
            snackbar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
            snackbar.show()
        }

    }
}
