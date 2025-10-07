package net.sebi.firstmod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.sebi.firstmod.FirstMod;
import net.sebi.firstmod.blocks.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static RegistryKey<ConfiguredFeature<?,?>> TITANIUM_ORE_KEY = registerKey("titanium_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldTitanium = List.of(OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.TITANIUM_ORE.getDefaultState()));
        register(context,TITANIUM_ORE_KEY,Feature.ORE, new OreFeatureConfig(overworldTitanium,8));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(FirstMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
