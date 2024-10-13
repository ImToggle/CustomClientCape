package me.imtoggle.customclientcape

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.Button
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import cc.polyfrost.oneconfig.utils.dsl.runAsync
import java.io.File
import javax.imageio.ImageIO

object ModConfig : Config(Mod(CustomClientCape.NAME, ModType.UTIL_QOL), "${CustomClientCape.MODID}.json") {

    @Button(
        name = "Cape",
        text = "Browse"
    )
    var capeSelector = Runnable {
        runAsync {
            browse()
        }
    }

    var imagePath = ""

    init {
        initialize()
        val file = File(imagePath)
        if (file.exists() && file.isFile) {
            image = ImageIO.read(file)
        }
    }
}