package prospectpyxis.ntadditions.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.ntadditions.NTAdditions;

public class BlockRegisterer {

    public static void register(IForgeRegistry<Block> registry) {
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
    }

    public static void registerModels() {
    }

    @GameRegistry.ObjectHolder(NTAdditions.modid)
    public static class Blocks {

    }

}
