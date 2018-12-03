package com.amyu.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class DetailActivity : AppCompatActivity() {
    companion object {
        fun createIntent(
                context: Context,
                title: String,
                background: Int,
                logo: Int
        ): Intent = Intent(context, DetailActivity::class.java).apply {
            this["title"] = title
            this["background"] = background
            this["logo"] = logo
        }
    }

    val title: String by getStringExtra("title")
    val background: Int by getIntExtra("background")
    val logo: Int by getIntExtra("logo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        findViewById<RelativeLayout>(R.id.relative_layout).apply {
            setBackgroundResource(this@DetailActivity.background)
        }
        findViewById<TextView>(R.id.title_text_view).apply {
            text = title
        }
        findViewById<ImageView>(R.id.logo_image_view).apply {
            setImageResource(logo)
        }
        findViewById<TextView>(R.id.text_view).apply {
            text = title
        }
    }
}

fun AppCompatActivity.getStringExtra(extra: String): ReadOnlyProperty<AppCompatActivity, String> =
        object : ReadOnlyProperty<AppCompatActivity, String> {
            override fun getValue(
                    thisRef: AppCompatActivity,
                    property: KProperty<*>
            ): String = thisRef.intent.getStringExtra(extra)
        }

fun AppCompatActivity.getIntExtra(extra: String): ReadOnlyProperty<AppCompatActivity, Int> =
        object : ReadOnlyProperty<AppCompatActivity, Int> {
            override fun getValue(
                    thisRef: AppCompatActivity,
                    property: KProperty<*>
            ): Int = thisRef.intent.getIntExtra(extra, 0)
        }

operator fun Intent.set(name: String, value: String) {
    putExtra(name, value)
}

operator fun Intent.set(name: String, value: Int) {
    putExtra(name, value)
}