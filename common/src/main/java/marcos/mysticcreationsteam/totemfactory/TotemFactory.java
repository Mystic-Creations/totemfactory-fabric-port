package marcos.mysticcreationsteam.totemfactory;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import marcos.mysticcreationsteam.totemfactory.init.TfArmorMaterials;
import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

public final class TotemFactory {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "totemfactory";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);

    public static void load() {
        try { // Forcefully disable data generation on our Registrate instance, we don't need it.
            Field doDatagenField = AbstractRegistrate.class.getDeclaredField("doDatagen");
            doDatagenField.setAccessible(true);
            doDatagenField.set(REGISTRATE, (NonNullSupplier<Boolean>) () -> false);
        } catch (Throwable ignored) {}

        TfBlocks.load();
        TfItems.load();
        TfArmorMaterials.load();
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
