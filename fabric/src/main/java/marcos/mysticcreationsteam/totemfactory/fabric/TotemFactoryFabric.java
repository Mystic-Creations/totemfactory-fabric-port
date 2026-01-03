package marcos.mysticcreationsteam.totemfactory.fabric;

import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.fabric.TfTabsImpl;
import net.fabricmc.api.ModInitializer;

public class TotemFactoryFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		TotemFactory.LOGGER.info("Initializing Create: Totem Factory...");
        TotemFactory.load();
        TfTabsImpl.load();
        TotemFactory.REGISTRATE.registerEventListeners();
	}
}
