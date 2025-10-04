package net.sebi.firstmod.armor;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.sebi.firstmod.FirstMod;
import net.sebi.firstmod.tags.ModTags;
import java.util.Map;

public class Armor {


    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> TITANIUM_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(FirstMod.MOD_ID, "titanium"));

    public static final ArmorMaterial TITANIUM_ARMOR_MATERIAL = new ArmorMaterial(450,createArmorType(4,7,9,4),20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,2.5f,0.1f, ModTags.Items.TITANIUM_REPAIR,TITANIUM_KEY);

    public static ArmorMaterial createArmorMaterial(int Durability, Map<EquipmentType,Integer> DefenseMap, int EnchantmentLuck, RegistryEntry<SoundEvent> ItemEquipSound, float Toughness, float KnockbackResistance, TagKey<Item> ItemTag, RegistryKey<EquipmentAsset> RegistryKey){
        return new ArmorMaterial(Durability,DefenseMap,EnchantmentLuck,ItemEquipSound,Toughness,KnockbackResistance,ItemTag,RegistryKey);
    }

    public static Map<EquipmentType,Integer> createArmorType (int BootsDefense, int LeggingsDefense, int ChestplateDefense, int HelmetDefense){
        return Map.of(
                EquipmentType.BOOTS,BootsDefense,
                EquipmentType.LEGGINGS,LeggingsDefense,
                EquipmentType.CHESTPLATE,ChestplateDefense,
                EquipmentType.HELMET,HelmetDefense
                );
    }
}
