scoreboard players set @s inactive_totems_in_inv_check 0
scoreboard players set @s inactive_totems_in_inv 0
scoreboard players set @s totems_in_inv_check 0
scoreboard players set @s totems_in_inv 0

execute store result score @s inactive_totems_in_inv_check if items entity @s inventory.* totemfactory:inactive_totem
scoreboard players operation @s inactive_totems_in_inv += @s inactive_totems_in_inv_check
execute store result score @s inactive_totems_in_inv_check if items entity @s hotbar.* totemfactory:inactive_totem
scoreboard players operation @s inactive_totems_in_inv += @s inactive_totems_in_inv_check
execute store result score @s inactive_totems_in_inv_check if items entity @s weapon.offhand totemfactory:inactive_totem
scoreboard players operation @s inactive_totems_in_inv += @s inactive_totems_in_inv_check
execute store result score @s totems_in_inv_check if items entity @s inventory.* minecraft:totem_of_undying
scoreboard players operation @s totems_in_inv += @s totems_in_inv_check
execute store result score @s totems_in_inv_check if items entity @s hotbar.* minecraft:totem_of_undying
scoreboard players operation @s totems_in_inv += @s totems_in_inv_check
execute store result score @s totems_in_inv_check if items entity @s weapon.offhand minecraft:totem_of_undying
scoreboard players operation @s totems_in_inv += @s totems_in_inv_check

execute if entity @s[scores={inactive_totems_in_inv=37..}] run advancement grant @s only totemfactory:inactive_totem_full_inventory
execute if entity @s[scores={totems_in_inv=37..}] run advancement grant @s only totemfactory:totem_full_inventory