package com.alldroid.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin
import kotlin.math.sqrt

class GameActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "AllDroid"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)

        setupButton(R.id.btnA, "A")
        setupButton(R.id.btnB, "B")
        setupButton(R.id.btnStart, "START")
        setupButton(R.id.btnSelect, "SELECT")

        setupAnalog()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupButton(
        buttonId: Int,
        buttonName: String
    ) {

        val button = findViewById<Button>(buttonId)

        button.setOnTouchListener { _, event ->

            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    Log.d(TAG, "$buttonName pressionado")
                }

                MotionEvent.ACTION_UP -> {
                    Log.d(TAG, "$buttonName solto")
                }
            }

            true
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupAnalog() {

        val base = findViewById<View>(R.id.analogBase)
        val stick = findViewById<View>(R.id.analogStick)

        base.post {

            val centerX = base.width / 2f
            val centerY = base.height / 2f

            stick.x = centerX - stick.width / 2f
            stick.y = centerY - stick.height / 2f
        }

        base.setOnTouchListener { _, event ->

            val centerX = base.width / 2f
            val centerY = base.height / 2f

            val dx = event.x - centerX
            val dy = event.y - centerY

            val distance =
                sqrt(dx * dx + dy * dy)

            val maxRadius =
                (base.width / 2f) -
                (stick.width / 2f)

            when (event.action) {

                MotionEvent.ACTION_DOWN,
                MotionEvent.ACTION_MOVE -> {

                    val limitedDistance =
                        min(distance, maxRadius)

                    val angle =
                        atan2(dy, dx)

                    stick.x =
                        centerX +
                        cos(angle) *
                        limitedDistance -
                        stick.width / 2f

                    stick.y =
                        centerY +
                        sin(angle) *
                        limitedDistance -
                        stick.height / 2f

                    val xAxis =
                        (dx / maxRadius)
                            .coerceIn(-1f, 1f)

                    val yAxis =
                        (dy / maxRadius)
                            .coerceIn(-1f, 1f)

                    Log.d(
                        TAG,
                        "Analog X=$xAxis Y=$yAxis"
                    )
                }

                MotionEvent.ACTION_UP -> {

                    stick.x =
                        centerX -
                        stick.width / 2f

                    stick.y =
                        centerY -
                        stick.height / 2f

                    Log.d(
                        TAG,
                        "Analógico centralizado"
                    )
                }
            }

            true
        }
    }
}
