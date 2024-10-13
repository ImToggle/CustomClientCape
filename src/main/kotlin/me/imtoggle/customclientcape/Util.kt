package me.imtoggle.customclientcape

import cc.polyfrost.oneconfig.renderer.TinyFD
import cc.polyfrost.oneconfig.utils.Notifications
import cc.polyfrost.oneconfig.utils.dsl.mc
import net.minecraft.client.renderer.texture.DynamicTexture
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

var texture = DynamicTexture(64, 32)
var location = mc.textureManager.getDynamicTextureLocation("customclientcape", texture)

var image: BufferedImage? = null

fun notify(message: String) = Notifications.INSTANCE.send("CustomClientCape", message)

fun browse() {
    notify("A file dialogue has opened. You may need to tab out to see it.")

    val result = TinyFD.INSTANCE.openFileSelector(
        "Select an image",
        "",
        arrayOf("*.png", "*.jpg", "*.jpeg"),
        "Image Files"
    ) ?: run {
        notify("You must select an image.")
        return
    }

    ModConfig.imagePath = result.absolutePath.takeIf {
        it.endsWith(".png") || it.endsWith(".jpg") || it.endsWith(".jpeg")
    } ?: run {
        notify("You must select a PNG or JPG image.")
        return
    }

    val file = File(ModConfig.imagePath)
    if (!file.exists() || !file.isFile) return

    image = ImageIO.read(file)
}