package marcos.lumynitystudios.totemfactory.equipment;

import marcos.lumynitystudios.totemfactory.init.TfItems;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TumbagaSword extends SwordItem {
    public TumbagaSword() {
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
                return 5;
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
        }, 0, -2.4f, new Properties().stacksTo(1).rarity(Rarity.COMMON));
        //i - Attack Damage Modifier (final_dmg = base_damage + f)
        //f - Attack Speed Modifier (f = desired_speed - 4.0)
    }
}
