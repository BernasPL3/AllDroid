package com.alldroid.app

import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        setupButton(R.id.btnA, "A")
        setupButton(R.id.btnB, "B")
        setupButton(R.id.btnUp, "UP")
        setupButton(R.id.btnDown, "DOWN")
        setupButton(R.id.btnLeft, "LEFT")
        setupButton(R.id.btnRight, "RIGHT")
        setupButton(R.id.btnStart, "START")
        setupButton(R.id.btnSelect, "SELECT")
    }

    private fun setupButton(id: Int, key: String) {
        val btn = findViewById<Button>(id)

        btn.setOnTouchListener { _, event ->

            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    println("$key pressionado")
                }

                MotionEvent.ACTION_UP -> {
                    println("$key solto")
                }
            }

            true
        }
    }
}
