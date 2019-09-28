package prospectpyxis.ntadditions.registry;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.ntadditions.NTAdditions;
import prospectpyxis.ntadditions.items.tools.ItemCrudeCopperAxe;
import prospectpyxis.ntadditions.items.tools.ItemCrudeCopperShovel;

public class ItemRegisterer {

    // Tools
    public static final Item.ToolMaterial CRUDECOPPER = EnumHelper.addToolMaterial("CRUDECOPPER", 1, 110, 1.5f, 0.5f, 10);

    public static Item ccAxe = new ItemCrudeCopperAxe(CRUDECOPPER).setRegistryName("crude_copper_axe").setUnlocalizedName(NTAdditions.modid + ".crude_copper_axe").setCreativeTab(NTAdditions.CTAB);
    public static Item ccShovel = new ItemCrudeCopperShovel(CRUDECOPPER).setRegistryName("crude_copper_shovel").setUnlocalizedName(NTAdditions.modid + ".crude_copper_shovel").setCreativeTab(NTAdditions.CTAB);

    public static Item bluntCopperBlade = new Item().setRegistryName("blunt_copper_blade").setUnlocalizedName(NTAdditions.modid + ".blunt_copper_blade").setCreativeTab(NTAdditions.CTAB);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                ccAxe,
                ccShovel,
                bluntCopperBlade
        );
    }

    public static void registerModels() {
        NTAdditions.proxy.registerItemRenderer(ccAxe, 0, "crude_copper_axe");
        NTAdditions.proxy.registerItemRenderer(ccShovel, 0, "crude_copper_shovel");
        NTAdditions.proxy.registerItemRenderer(bluntCopperBlade, 0, "blunt_copper_blade");
    }

    @GameRegistry.ObjectHolder(NTAdditions.modid)
    public static class Items {

        @GameRegistry.ObjectHolder("crude_copper_axe")
        public static final Item CRUDE_COPPER_AXE = null;

        @GameRegistry.ObjectHolder("rock_extra")
        public static final Item ROCK_ITEM = null;

    }

}
