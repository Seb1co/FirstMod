    package net.sebi.firstmod;

    import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
    import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
    import net.sebi.firstmod.datagen.*;

    public class FirstModDataGenerator implements DataGeneratorEntrypoint {
        @Override
        public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
            FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

            pack.addProvider(ModItemTagProvider::new);
            pack.addProvider(ModBlockTagProvider::new);
        }
    }
