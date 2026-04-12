package marcos.lumynitystudios.totemfactory.equipment;

import marcos.lumynitystudios.totemfactory.init.TfItems;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TumbagaAxe extends AxeItem {
    public TumbagaAxe() {
        super(new Tier() {
            @Override
            public int getUses() { //USES
                return 220;
            }

            @Override
            public float getSpeed() { //MINING SPEED
                return 12.0f;
            }

            @Override
            public float getAttackDamageBonus() { //BASE DAMAGE
                return 9;
            }

            @Override
            public int getLevel() { //TOOL LEVEL
                return 2;
            }

            @Override
            public int getEnchantmentValue() { //ENCHANTMENT VALUE
                return 14;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(TfItems.TUMBAGA_ALLOY.get());
            }
        }, -1.0f, -3.1f, new Properties().stacksTo(1).rarity(Rarity.COMMON));
        //f - Attack Damage Modifier (final_dmg = base_damage + f), sometimes it's weird and you need to make it -1
        //g - Attack Speed Modifier (final_speed = g + 4.0)
    }
}