package net.sebi.firstmod.tools;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.sebi.firstmod.tags.ModTags;

public class ModTools {
    public static final ToolMaterial TITANIUM_TOOL_MATERIAL = createToolMaterial(ModTags.Blocks.incorrectBlocksForTitanium,1679,9f,3.5f,20,ModTags.Items.TITANIUM_REPAIR);

    public static final ToolMaterial createToolMaterial(TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems){
        return new ToolMaterial(incorrectBlocksForDrops,durability,speed,attackDamageBonus,enchantmentValue,repairItems);
    }
}
