package marcos.lumynitystudios.totemfactory.fabric;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import marcos.lumynitystudios.totemfactory.init.fabric.TfTabsImpl;
import net.fabricmc.api.ModInitializer;

public class TotemFactoryFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		TotemFactory.LOGGER.info("Initializing Create: Totem Factory...");
        TotemFactory.load();
        TfTabsImpl.load();
        TotemFactory.REGISTRATE.register();
        //HAS TO BE THIS LOADING ORDER!!
	}
}
