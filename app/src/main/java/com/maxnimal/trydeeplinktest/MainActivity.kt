package com.maxnimal.trydeeplinktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maxnimal.trydeeplinktest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        handleDeepLink()
        initView()
    }

    private fun handleDeepLink() {
        val data = intent.data
        data?.let { _data ->
            val url = _data.toString()
            val firstPath = _data.pathSegments[0]

            if (firstPath == "list") {
                val itemId = _data.pathSegments[1]
                if (itemId != null) {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra("id", itemId)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@MainActivity, ListActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun initView() = with(binding) {
        btnToList.setOnClickListener {
            val intent = Intent(this@MainActivity, ListActivity::class.java)
            startActivity(intent)
        }
    }
}