package com.alldroid.app

import java.io.File

object RomScanner {

    private val romExtensions = setOf(
        "nes","smc","sfc",
        "gb","gbc","gba",
        "nds","3ds",
        "n64","z64","v64",
        "iso","bin","cue","cso"
    )

    fun scan(folder: File): List<Rom> {

        val result = mutableListOf<Rom>()

        if (!folder.exists()) return result

        folder.walkTopDown().forEach { file ->

            if (file.isFile) {

                val ext = file.extension.lowercase()

                if (ext in romExtensions) {

                    result.add(
                        Rom(
                            name = file.nameWithoutExtension,
                            path = file.absolutePath,
                            system = detectSystem(ext)
                        )
                    )
                }
            }
        }

        return result
    }

    private fun detectSystem(ext: String): String {

        return when(ext) {

            "nes" -> "NES"

            "smc","sfc" -> "SNES"

            "gb" -> "Game Boy"

            "gbc" -> "Game Boy Color"

            "gba" -> "Game Boy Advance"

            "nds" -> "Nintendo DS"

            "3ds" -> "Nintendo 3DS"

            "n64","z64","v64" -> "Nintendo 64"

            "iso","cso" -> "PSP / PS2"

            else -> "Unknown"
        }
    }
}
