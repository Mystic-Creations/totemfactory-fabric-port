package marcos.mysticcreationsteam.totemfactory.fabric;

import net.fabricmc.fabric.api.entity.FakePlayer;
import net.minecraft.server.level.ServerPlayer;

public class ModLoaderHelperImpl {
    public static boolean isFakePlayer(ServerPlayer player) {
        return player instanceof FakePlayer;
    }
}
