    package net.sebi.firstmod;

    import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
    import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
    import net.minecraft.registry.RegistryBuilder;
    import net.minecraft.registry.RegistryKeys;
    import net.sebi.firstmod.datagen.*;
    import net.sebi.firstmod.world.ModConfiguredFeatures;
    import net.sebi.firstmod.world.ModPlacedFeatures;

    public class FirstModDataGenerator implements DataGeneratorEntrypoint {
        @Override
        public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
            FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

            pack.addProvider(ModItemTagProvider::new);
            pack.addProvider(ModBlockTagProvider::new);
            pack.addProvider(ModLootTableProvider::new);
        }
        @Override
        public void buildRegistry(RegistryBuilder registryBuilder) {

            registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
            registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
        }
    }
