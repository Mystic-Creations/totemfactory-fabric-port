package marcos.mysticcreationsteam.totemfactory.neoforge;

import marcos.mysticcreationsteam.totemfactory.init.neoforge.TfArmorMaterialsImpl;
import marcos.mysticcreationsteam.totemfactory.init.neoforge.TfBlocksImpl;
import marcos.mysticcreationsteam.totemfactory.init.neoforge.TfItemsImpl;
import marcos.mysticcreationsteam.totemfactory.init.neoforge.TfTabsImpl;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import marcos.mysticcreationsteam.totemfactory.TotemFactory;

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
