package me.imtoggle.customclientcape

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.utils.dsl.mc
import net.minecraft.client.renderer.texture.DynamicTexture
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(modid = CustomClientCape.MODID, name = CustomClientCape.NAME, version = CustomClientCape.VERSION, modLanguageAdapter = "cc.polyfrost.oneconfig.utils.KotlinLanguageAdapter")
object CustomClientCape {
    const val MODID = "@ID@"
    const val NAME = "@NAME@"
    const val VERSION = "@VER@"

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        ModConfig
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun onTick(event: TickEvent) {
        if (event.stage != Stage.END) return
        image ?: return
        texture = DynamicTexture(image)
        image = null
        texture.updateDynamicTexture()
        location = mc.textureManager.getDynamicTextureLocation("customclientcape", texture)
    }
}