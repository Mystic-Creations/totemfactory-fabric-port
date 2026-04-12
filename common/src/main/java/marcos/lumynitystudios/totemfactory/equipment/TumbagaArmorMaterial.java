package marcos.lumynitystudios.totemfactory.equipment;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import marcos.lumynitystudios.totemfactory.init.TfItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class TumbagaArmorMaterial implements ArmorMaterial {

    public static final TumbagaArmorMaterial INSTANCE = new TumbagaArmorMaterial();
    private static final int[] BASE_DURABILITY = {13, 15, 16, 11};
    private static final int DURABILITY_MULTIPLIER = 15;

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        switch (type) {
            case HELMET:
                return BASE_DURABILITY[0] * DURABILITY_MULTIPLIER;
            case CHESTPLATE:
                return BASE_DURABILITY[1] * DURABILITY_MULTIPLIER;
            case LEGGINGS:
                return BASE_DURABILITY[2] * DURABILITY_MULTIPLIER;
            case BOOTS:
                return BASE_DURABILITY[3] * DURABILITY_MULTIPLIER;
            default:
                return 0;
        }
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return switch (type) {
            case HELMET -> 2;
            case CHESTPLATE -> 6;
            case LEGGINGS -> 5;
            case BOOTS -> 2;
            default -> 0;
        };
    }

    @Override
    public int getEnchantmentValue() { return 9; }

    @Override
    public SoundEvent getEquipSound() { return SoundEvents.ARMOR_EQUIP_IRON; }

    @Override
    public Ingredient getRepairIngredient() {return Ingredient.of(TfItems.TUMBAGA_ALLOY.get());}

    @Override
    public String getName() {return TotemFactory.MODID + ":tumbaga";}

    @Override
    public float getToughness() { return 0f; }

    @Override
    public float getKnockbackResistance() { return 0.0f; }

}

