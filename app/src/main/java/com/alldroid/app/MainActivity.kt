package com.alldroid.app

import android.os.Bundle
import android.os.Environment
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val tv = TextView(this)
        setContentView(tv)

        val roms = RomScanner.scan(
            Environment.getExternalStorageDirectory()
        )

        val builder = StringBuilder()

        builder.append("ROMs encontradas: ${roms.size}\n\n")

        roms.forEach {

            builder.append("${it.system}\n")
            builder.append("${it.name}\n")
            builder.append("\n")
        }

        tv.text = builder.toString()
    }
}
