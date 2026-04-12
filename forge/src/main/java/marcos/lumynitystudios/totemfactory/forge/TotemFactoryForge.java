package marcos.lumynitystudios.totemfactory.forge;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import marcos.lumynitystudios.totemfactory.init.forge.TfBlocksImpl;
import marcos.lumynitystudios.totemfactory.init.forge.TfItemsImpl;
import marcos.lumynitystudios.totemfactory.init.forge.TfTabsImpl;
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
