package marcos.mysticcreationsteam.totemfactory.neoforge;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.common.util.FakePlayer;

public class ModLoaderHelperImpl {
    public static boolean isFakePlayer(ServerPlayer player) {
        return player instanceof FakePlayer;
    }
}
