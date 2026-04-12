package marcos.lumynitystudios.totemfactory.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class IncompleteTotemBody extends Item {
	public IncompleteTotemBody() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}
