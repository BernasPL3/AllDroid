package com.alldroid.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LibraryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_library)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        val roms = listOf(

            Rom(
                title = "Super Mario Bros",
                system = "NES",
                path = "/roms/mario.nes",
                coverRes = R.drawable.cover_nes
            ),

            Rom(
                title = "Pokemon Emerald",
                system = "GBA",
                path = "/roms/pokemon.gba",
                coverRes = R.drawable.cover_gba
            ),

            Rom(
                title = "God of War",
                system = "PSP",
                path = "/roms/gow.cso",
                coverRes = R.drawable.cover_psp
            )
        )

        recyclerView.adapter =
            RomAdapter(roms)
    }
}
