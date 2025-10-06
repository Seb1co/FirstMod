package net.sebi.firstmod.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sebi.firstmod.FirstMod;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> incorrectBlocksForTitanium = createTag("incorrect_blocks_for_titanium");
        public static final TagKey<Block> NEEDS_TITANIUM_TOOL = createTag("needs_titanium_tool");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FirstMod.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> TITANIUM_REPAIR = createTag("titanium_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(FirstMod.MOD_ID, name));
        }
    }
}
