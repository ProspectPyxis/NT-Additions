package prospectpyxis.ntadditions;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import prospectpyxis.ntadditions.proxy.CommonProxy;
import prospectpyxis.ntadditions.registry.BlockRegisterer;
import prospectpyxis.ntadditions.registry.ItemRegisterer;

@Mod(modid = NTAdditions.modid, name = NTAdditions.name, version = NTAdditions.version)
public class NTAdditions {

    public static final String modid = "ntadditions";
    public static final String name = "NullTeknika Additions";
    public static final String version = "1.12.2-0.2.0";

    public static Logger logger;

    @SidedProxy(serverSide = "prospectpyxis.ntadditions.proxy.ServerProxy", clientSide = "prospectpyxis.ntadditions.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static final CreativeTabs CTAB = new CreativeTabs(modid) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemRegisterer.Items.CRUDE_COPPER_AXE);
        }
    };

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("Now loading " + name);
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        /*
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            BlockRegisterer.register(event.getRegistry());
        }
        */

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ItemRegisterer.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ItemRegisterer.registerModels();
            // BlockRegisterer.registerModels();
        }

    }

}
