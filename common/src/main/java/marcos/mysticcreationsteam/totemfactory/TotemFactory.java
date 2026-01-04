package marcos.mysticcreationsteam.totemfactory;

import com.simibubi.create.foundation.data.CreateRegistrate;
import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TotemFactory {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "totemfactory";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);

    public static void load() {
        TfBlocks.load();
        TfItems.load();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MODID, path);
    }
}
