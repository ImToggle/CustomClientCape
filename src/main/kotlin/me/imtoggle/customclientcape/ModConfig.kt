package me.imtoggle.customclientcape

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.data.*

object ModConfig : Config(Mod(CustomClientCape.NAME, ModType.UTIL_QOL), "${CustomClientCape.MODID}.json") {

    init {
        initialize()
    }
}