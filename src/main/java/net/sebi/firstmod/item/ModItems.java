package net.sebi.firstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.sebi.firstmod.FirstMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sebi.firstmod.armor.Armor;
import org.apache.commons.lang3.ObjectUtils;
import java.util.Map;
import java.util.function.Function;

public class ModItems {
    //Item.Settings() are mai multe metode care pot fi acesate ca ..ttings().method().method1()
    public static final Item TITANIUM = registerItem("titanium", settings -> new Item(settings.fireproof()));
    // adding the item to the game                         item_name                       default item properties
    public static final Item TITANIUM_BOOTS = registerItem("titanium_boots",settings -> new Item(settings.armor(Armor.TITANIUM,EquipmentType.BOOTS).fireproof()));
    public static final Item TITANIUM_LEGGINGS = registerItem("titanium_leggings",settings -> new Item(settings.armor(Armor.TITANIUM,EquipmentType.LEGGINGS).fireproof()));
    public static final Item TITANIUM_CHESTPLATE = registerItem("titanium_chestplate",settings -> new Item(settings.armor(Armor.TITANIUM,EquipmentType.CHESTPLATE).fireproof()));
    public static final Item TITANIUM_HELMET = registerItem("titanium_helmet",settings -> new Item(settings.armor(Armor.TITANIUM,EquipmentType.HELMET).fireproof()));

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
        FirstMod.LOGGER.info("Done Registering");
    }
    // Definition for adding an item
}