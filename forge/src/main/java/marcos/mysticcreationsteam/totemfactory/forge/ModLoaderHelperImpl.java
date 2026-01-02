package marcos.mysticcreationsteam.totemfactory.forge;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.FakePlayer;

public class ModLoaderHelperImpl {
    public static boolean isFakePlayer(ServerPlayer player) {
        return player instanceof FakePlayer;
    }
}
