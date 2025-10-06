package net.sebi.firstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.sebi.firstmod.FirstMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sebi.firstmod.armor.Armor;
import net.sebi.firstmod.tools.ModTools;

import java.util.function.Function;

public class ModItems {
    //Item.Settings() are mai multe metode care pot fi acesate ca ..ttings().method().method1()
    public static final Item TITANIUM = registerItem("titanium", settings -> new Item(settings.fireproof()));
    // adding the item to the game                         item_name                       default item properties
    public static final Item TITANIUM_BOOTS = registerItem("titanium_boots",settings -> new Item(settings.armor(Armor.TITANIUM_ARMOR_MATERIAL,EquipmentType.BOOTS).fireproof().maxCount(1)));
    public static final Item TITANIUM_LEGGINGS = registerItem("titanium_leggings",settings -> new Item(settings.armor(Armor.TITANIUM_ARMOR_MATERIAL,EquipmentType.LEGGINGS).fireproof().maxCount(1)));
    public static final Item TITANIUM_CHESTPLATE = registerItem("titanium_chestplate",settings -> new Item(settings.armor(Armor.TITANIUM_ARMOR_MATERIAL,EquipmentType.CHESTPLATE).fireproof().maxCount(1)));
    public static final Item TITANIUM_HELMET = registerItem("titanium_helmet",settings -> new Item(settings.armor(Armor.TITANIUM_ARMOR_MATERIAL,EquipmentType.HELMET).fireproof().maxCount(1)));

    public static final Item TITANIUM_SWORD = registerItem("titanium_sword", settings -> new Item(settings.sword(ModTools.TITANIUM_TOOL_MATERIAL,6,1.6f)));
    public static final Item TITANIUM_PICKAXE = registerItem("titanium_pickaxe", settings -> new Item(settings.pickaxe(ModTools.TITANIUM_TOOL_MATERIAL,3,-2.8f)));
    public static final Item TITANIUM_AXE = registerItem("titanium_axe", settings -> new AxeItem(ModTools.TITANIUM_TOOL_MATERIAL,9,-3f,settings));
    public static final Item TITANIUM_SHOVEL = registerItem("titanium_shovel", settings -> new ShovelItem(ModTools.TITANIUM_TOOL_MATERIAL,3,-2.8f,settings));
    public static final Item TITANIUM_HOE = registerItem("titanium_hoe", settings -> new HoeItem(ModTools.TITANIUM_TOOL_MATERIAL,2,-2.5f,settings));

    //public static final Block TITANIUM_BLOCK = Blocks.registerBlock("titanium_block",settings -> new Block(Blocks.TITANIUM_BLOCK.getSettings()));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FirstMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        FirstMod.LOGGER.info("Registering Mod Items for " + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TITANIUM); // adding the item to the creative menu
        }); // Definition for adding an item to the creative menu
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->{
            entries.add(TITANIUM_BOOTS);
            entries.add(TITANIUM_LEGGINGS);
            entries.add(TITANIUM_CHESTPLATE);
            entries.add(TITANIUM_HELMET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries ->{
            entries.add(TITANIUM_SWORD);
            entries.add(TITANIUM_PICKAXE);
            entries.add(TITANIUM_AXE);
            entries.add(TITANIUM_SHOVEL);
            entries.add(TITANIUM_HOE);
        });

        FirstMod.LOGGER.info("Done Registering");
    }
    // Definition for adding an item
}