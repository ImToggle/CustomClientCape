package me.imtoggle.customclientcape.mixin;

import me.imtoggle.customclientcape.UtilKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayer.class)
public class AbstractClientPlayerMixin {

    @Inject(method = "getLocationCape", at = @At("HEAD"), cancellable = true)
    private void overrideCape(CallbackInfoReturnable<ResourceLocation> cir) {
       if ((AbstractClientPlayer) (Object) this == Minecraft.getMinecraft().thePlayer) cir.setReturnValue(UtilKt.getLocation());
    }
}
