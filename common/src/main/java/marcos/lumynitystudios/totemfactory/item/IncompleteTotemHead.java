package marcos.lumynitystudios.totemfactory.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class IncompleteTotemHead extends Item {
	public IncompleteTotemHead() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}
