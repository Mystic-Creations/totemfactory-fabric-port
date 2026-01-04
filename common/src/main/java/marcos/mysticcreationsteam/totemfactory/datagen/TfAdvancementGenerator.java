package marcos.mysticcreationsteam.totemfactory.datagen;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.TfAdvancements;
import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class TfAdvancementGenerator implements AdvancementSubProvider {
    @SuppressWarnings("removal")
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> output) {
        var tumbagaAlloy = Advancement.Builder.advancement()
            .parent(Create.asResource("burner"))
            .display(
                new DisplayInfo(
                    new ItemStack(TfItems.TUMBAGA_ALLOY.get()),
                    Component.translatable(TfAdvancements.TUMBAGA_ALLOY.toLanguageKey("advancement", "title")),
                    Component.translatable(TfAdvancements.TUMBAGA_ALLOY.toLanguageKey("advancement", "desc"))
                        .withColor(0xD1A75D),
                    Optional.empty(),
                    AdvancementType.TASK,
                    true, false, false
                )
            )
            .requirements(AdvancementRequirements.Strategy.OR)
            .addCriterion("tumbaga_alloy", InventoryChangeTrigger.TriggerInstance.hasItems(TfItems.TUMBAGA_ALLOY.get()))
            .rewards(
                AdvancementRewards.Builder.experience(4)
                    .addRecipe(TotemFactory.asResource("filling/totem_of_undying_from_experience"))
                    .addRecipe(TotemFactory.asResource("haunting/ghast_tear"))
                    .addRecipe(TotemFactory.asResource("item_application/tumbaga_alloy/casing/tumbaga_casing"))
                    .addRecipe(TotemFactory.asResource("mechanical_crafting/inactive_totem"))
                    .addRecipe(TotemFactory.asResource("mixing/tumbaga_alloy/tumbaga_alloy_from_mixing"))
                    .addRecipe(TotemFactory.asResource("pressing/tumbaga_alloy/tumbaga_sheet"))
                    .addRecipe(TotemFactory.asResource("sequenced_assembly/totem/totem_body"))
                    .addRecipe(TotemFactory.asResource("sequenced_assembly/totem/totem_body_casing"))
                    .addRecipe(TotemFactory.asResource("sequenced_assembly/totem/totem_head"))
                    .addRecipe(TotemFactory.asResource("sequenced_assembly/totem/totem_head_casing"))
                    .addRecipe(TotemFactory.asResource("sequenced_assembly/totem/totem_of_undying_deploy"))
                    // All Vanilla recipes should be handled by the data-generated recipe advancements.
            )
            .save(output, TfAdvancements.TUMBAGA_ALLOY.toString());

        var firstTotem = Advancement.Builder.advancement()
            .parent(tumbagaAlloy)
            .display(
                new DisplayInfo(
                    new ItemStack(AllItems.EXP_NUGGET.asItem()),
                    Component.translatable(TfAdvancements.FIRST_TOTEM.toLanguageKey("advancement", "title")),
                    Component.translatable(TfAdvancements.FIRST_TOTEM.toLanguageKey("advancement", "desc"))
                        .withColor(0xD1A75D),
                    Optional.empty(),
                    AdvancementType.TASK,
                    true, true, false
                )
            )
            .addCriterion("crafted", CriteriaTriggers.IMPOSSIBLE.createCriterion(new ImpossibleTrigger.TriggerInstance()))
            .save(output, TfAdvancements.FIRST_TOTEM.toString());

        var inactiveTotemFullInventory = Advancement.Builder.advancement()
            .parent(firstTotem)
            .display(
                new DisplayInfo(
                    new ItemStack(TfItems.INACTIVE_TOTEM.get()),
                    Component.translatable(TfAdvancements.INACTIVE_TOTEM_INVENTORY.toLanguageKey("advancement", "title")),
                    Component.translatable(TfAdvancements.INACTIVE_TOTEM_INVENTORY.toLanguageKey("advancement", "desc"))
                        .withColor(0xD1A75D),
                    Optional.empty(),
                    AdvancementType.TASK,
                    true, true, false
                )
            )
            .requirements(AdvancementRequirements.Strategy.OR)
            .addCriterion("totem_inventory", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(
                new InventoryChangeTrigger.TriggerInstance(Optional.of(
                    EntityPredicate.wrap(
                        EntityPredicate.Builder.entity()
                            .nbt(new NbtPredicate(inventoryFilledWithItem(provider, TfItems.INACTIVE_TOTEM.get())))
                    )
                ),
                    InventoryChangeTrigger.TriggerInstance.Slots.ANY,
                    List.of()
                ))
            )
            .rewards(AdvancementRewards.Builder.experience(24))
            .save(output, TfAdvancements.INACTIVE_TOTEM_INVENTORY.toString());

        var thousandTotems = Advancement.Builder.advancement()
            .parent(firstTotem)
            .display(
                new DisplayInfo(
                    new ItemStack(AllBlocks.EXPERIENCE_BLOCK.asItem()),
                    Component.translatable(TfAdvancements.THOUSAND_TOTEMS.toLanguageKey("advancement", "title")),
                    Component.translatable(TfAdvancements.THOUSAND_TOTEMS.toLanguageKey("advancement", "desc"))
                        .withColor(0xD1A75D),
                    Optional.empty(),
                    AdvancementType.CHALLENGE,
                    true, true, false
                )
            )
            .addCriterion("crafted", CriteriaTriggers.IMPOSSIBLE.createCriterion(new ImpossibleTrigger.TriggerInstance()))
            .save(output, TfAdvancements.THOUSAND_TOTEMS.toString());

        var totemFullInventory = Advancement.Builder.advancement()
            .parent(inactiveTotemFullInventory)
            .display(
                new DisplayInfo(
                    new ItemStack(Items.TOTEM_OF_UNDYING),
                    Component.translatable(TfAdvancements.TOTEM_INVENTORY.toLanguageKey("advancement", "title")),
                    Component.translatable(TfAdvancements.TOTEM_INVENTORY.toLanguageKey("advancement", "desc"))
                        .withColor(0xD1A75D),
                    Optional.empty(),
                    AdvancementType.GOAL,
                    true, true, true
                )
            )
            .requirements(AdvancementRequirements.Strategy.OR)
            .addCriterion("totem_inventory", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(
                new InventoryChangeTrigger.TriggerInstance(Optional.of(
                    EntityPredicate.wrap(
                        EntityPredicate.Builder.entity()
                            .nbt(new NbtPredicate(inventoryFilledWithItem(provider, Items.TOTEM_OF_UNDYING)))
                    )
                ),
                    InventoryChangeTrigger.TriggerInstance.Slots.ANY,
                    List.of()
                ))
            )
            .rewards(AdvancementRewards.Builder.experience(32))
            .save(output, TfAdvancements.TOTEM_INVENTORY.toString());

        var tumbagaArmor = Advancement.Builder.advancement()
            .parent(tumbagaAlloy)
            .display(
                new DisplayInfo(
                    new ItemStack(TfItems.TUMBAGA_CHESTPLATE.get()),
                    Component.translatable(TfAdvancements.TUMBAGA_ARMOR.toLanguageKey("advancement", "title")),
                    Component.translatable(TfAdvancements.TUMBAGA_ARMOR.toLanguageKey("advancement", "desc"))
                        .withColor(0xD1A75D),
                    Optional.empty(),
                    AdvancementType.TASK,
                    true, false, true
                )
            )
            .requirements(AdvancementRequirements.Strategy.AND)
            .addCriterion("tumbaga_armor", InventoryChangeTrigger.TriggerInstance.hasItems(
                TfItems.TUMBAGA_HELMET.get(),
                TfItems.TUMBAGA_CHESTPLATE.get(),
                TfItems.TUMBAGA_LEGGINGS.get(),
                TfItems.TUMBAGA_BOOTS.get()
            ))
            .save(output, TfAdvancements.TUMBAGA_ARMOR.toString());

        var tumbagaCasing = Advancement.Builder.advancement()
            .parent(tumbagaAlloy)
            .display(
                new DisplayInfo(
                    new ItemStack(TfBlocks.TUMBAGA_CASING.get()),
                    Component.translatable(TfAdvancements.TUMBAGA_CASING.toLanguageKey("advancement", "title")),
                    Component.translatable(TfAdvancements.TUMBAGA_CASING.toLanguageKey("advancement", "desc"))
                        .withColor(0xD1A75D),
                    Optional.empty(),
                    AdvancementType.TASK,
                    true, false, false
                )
            )
            .requirements(AdvancementRequirements.Strategy.OR)
            .addCriterion("crafted", CriteriaTriggers.IMPOSSIBLE.createCriterion(new ImpossibleTrigger.TriggerInstance()))
            .save(output, TfAdvancements.TUMBAGA_CASING.toString());
    }

    private static CompoundTag inventoryFilledWithItem(HolderLookup.Provider provider, Item item) {
        ItemStack stack = new ItemStack(item);
        CompoundTag tag = new CompoundTag();
        ListTag inventoryTag = new ListTag();

        for (byte i = 0; i < Inventory.INVENTORY_SIZE; i++) {
            CompoundTag slotTag = new CompoundTag();
            slotTag.putByte("Slot", i);

            inventoryTag.add(stack.save(provider, slotTag));
        }

        CompoundTag slotTag = new CompoundTag();
        slotTag.putByte("Slot", (byte) 150);
        inventoryTag.add(stack.save(provider, slotTag));

        tag.put("Inventory", inventoryTag);

        return tag;
    }
}
