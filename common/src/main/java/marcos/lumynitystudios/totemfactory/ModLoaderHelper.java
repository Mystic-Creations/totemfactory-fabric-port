package marcos.lumynitystudios.totemfactory;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.server.level.ServerPlayer;

public class ModLoaderHelper {
    @ExpectPlatform
    public static boolean isFakePlayer(ServerPlayer player) {
        throw new IllegalStateException();
    }
}
