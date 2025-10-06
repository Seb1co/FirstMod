package net.sebi.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.sebi.firstmod.blocks.ModBlocks;
import net.sebi.firstmod.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.TITANIUM_BLOCK);

        valueLookupBuilder(ModTags.Blocks.incorrectBlocksForTitanium)
                .forceAddTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TITANIUM_BLOCK);

        valueLookupBuilder(ModTags.Blocks.NEEDS_TITANIUM_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TITANIUM_BLOCK);
    }
}
