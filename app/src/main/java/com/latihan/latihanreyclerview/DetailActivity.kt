@file:Suppress("DEPRECATION")

package com.latihan.latihanreyclerview


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.latihan.latihanreyclerview.Anime

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.apply {
            title = getString(R.string.Detail)
        }

        val btnMoveActivity: Button = findViewById(R.id.button)
        btnMoveActivity.setOnClickListener(this)

        val dataAnime = intent.getParcelableExtra<Anime>("key_hero") as Anime

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)

        Glide.with(this)
            .load(dataAnime.photo)
            .apply(RequestOptions())
            .into(ivDetailPhoto)
        tvDetailName.text = dataAnime.name
        tvDetailDescription.text = dataAnime.description

        val url2: String = tvDetailName.text.toString()
        val url = "https://myanimelist.net/ Judul:$url2"
        val imageButton = findViewById<ImageButton>(R.id.btn_kirim)

        imageButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "AnimeKu Web $url")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)


        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
