package com.johan.johansmod.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ItemModelProvider;
import net.minecraftforge.registries.RegistryObject;
import com.johan.johansmod.JohansMod;
import com.johan.johansmod.items.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JohansMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DIAMOND_CRAFTING_HAMMER);
        simpleItem(ModItems.NETHERITE_CRAFTING_HAMMER);
        simpleItem(ModItems.IRON_CRAFTING_HAMMER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), mcLoc("item/handheld"))
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }
}