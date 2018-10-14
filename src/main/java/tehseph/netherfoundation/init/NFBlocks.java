package tehseph.netherfoundation.init;

import tehseph.netherfoundation.Reference;
import tehseph.netherfoundation.common.block.*;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ObjectHolder(Reference.MOD_ID)
public class NFBlocks {

    public static final BlockHellfish HELLFISH   = new BlockHellfish();
    public static final BlockNetherOre NETHER_ORE = new BlockNetherOre();

    public static void preInitCommon() {

        if (NFConfig.HELLFISH) registerCommon(HELLFISH, new ItemBlock(HELLFISH), "hellfish");

        registerCommon(NETHER_ORE, new ItemBlockNetherOre(NETHER_ORE), "ore");

    }

    @SideOnly(Side.CLIENT)
    public static void preInitClient() {

        if (NFConfig.HELLFISH) registerClient(HELLFISH, 0, "inventory");

        for (int i = 0; i < BlockNetherOre.Type.values().length; i++) {
            registerClient(NETHER_ORE, i, "type=" + BlockNetherOre.Type.byMetadata(i).getName());
        }

    }

    private static void registerCommon(Block block, ItemBlock itemBlock, String name) {

        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);

        itemBlock.setRegistryName(name);
        ForgeRegistries.ITEMS.register(itemBlock);

    }

    @SideOnly(Side.CLIENT)
    private static void registerClient(Block block, int metadata, String variant) {

        ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), variant);
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), metadata, model);

    }

}
