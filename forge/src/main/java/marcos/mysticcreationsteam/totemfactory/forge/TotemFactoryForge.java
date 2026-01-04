package marcos.mysticcreationsteam.totemfactory.forge;

import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.forge.TfBlocksImpl;
import marcos.mysticcreationsteam.totemfactory.init.forge.TfItemsImpl;
import marcos.mysticcreationsteam.totemfactory.init.forge.TfTabsImpl;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TotemFactory.MODID)
public class TotemFactoryForge {
    public TotemFactoryForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        TotemFactory.load();
        TotemFactory.REGISTRATE.registerEventListeners(modBus);
        TfBlocksImpl.REGISTER.register(modBus);
        TfItemsImpl.REGISTER.register(modBus);
        TfTabsImpl.REGISTER.register(modBus);
    }
}
