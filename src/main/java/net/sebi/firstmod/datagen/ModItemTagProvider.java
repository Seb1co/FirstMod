package net.sebi.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.sebi.firstmod.item.ModItems;
import net.sebi.firstmod.tags.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.TITANIUM_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.TITANIUM_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.TITANIUM_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.TITANIUM_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.TITANIUM_HOE);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.TITANIUM_CHESTPLATE);
        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.TITANIUM_BOOTS);
        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.TITANIUM_HELMET);
        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.TITANIUM_LEGGINGS);

        valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.TITANIUM_LEGGINGS)
                .add(ModItems.TITANIUM_CHESTPLATE)
                .add(ModItems.TITANIUM_BOOTS)
                .add(ModItems.TITANIUM_HELMET);


        valueLookupBuilder(ModTags.Items.TITANIUM_REPAIR)
                .add(ModItems.TITANIUM);
    }
}
