package com.maxnimal.trydeeplinktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maxnimal.trydeeplinktest.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private val binding: ActivityListBinding by lazy {
        ActivityListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, ListFragment.newInstance())
                .commit()
        }

    }
}