advancement revoke @s only totemfactory:technical/inventory_changed

execute if entity @s[advancements={totemfactory:inactive_totem_full_inventory=false}] run function totemfactory:totem_inventory_check
execute if entity @s[advancements={totemfactory:totem_full_inventory=false}] run function totemfactory:totem_inventory_check