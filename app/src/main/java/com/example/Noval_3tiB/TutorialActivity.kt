package com.example.Noval_3tiB

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class TutorialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbarTutorial)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}