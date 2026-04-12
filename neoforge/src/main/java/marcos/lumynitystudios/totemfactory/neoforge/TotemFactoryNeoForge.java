package marcos.lumynitystudios.totemfactory.neoforge;

import marcos.lumynitystudios.totemfactory.init.neoforge.TfArmorMaterialsImpl;
import marcos.lumynitystudios.totemfactory.init.neoforge.TfBlocksImpl;
import marcos.lumynitystudios.totemfactory.init.neoforge.TfItemsImpl;
import marcos.lumynitystudios.totemfactory.init.neoforge.TfTabsImpl;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import marcos.lumynitystudios.totemfactory.TotemFactory;

@Mod(TotemFactory.MODID)
public final class TotemFactoryNeoForge {
    public TotemFactoryNeoForge(IEventBus modBus) {

        TotemFactory.load();
        TfArmorMaterialsImpl.REGISTER.register(modBus);
        TotemFactory.REGISTRATE.registerEventListeners(modBus);
        TfBlocksImpl.REGISTER.register(modBus);
        TfItemsImpl.REGISTER.register(modBus);
        TfTabsImpl.REGISTER.register(modBus);
    }
}
