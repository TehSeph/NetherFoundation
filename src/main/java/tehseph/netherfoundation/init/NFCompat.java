package tehseph.netherfoundation.init;

import tehseph.netherfoundation.common.block.BlockNetherOre;

import cofh.core.fluid.BlockFluidInteractive;
import cofh.thermalfoundation.init.TFFluids;

import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.Loader;

public class NFCompat {

    public static void preInitCommon() {

        if (Loader.isModLoaded("waila")) {

            FMLInterModComms.sendMessage("waila", "register", "tehseph.netherfoundation.compat.WailaCompatibility.register");

        }

        IBlockState netherLead = NFBlocks.NETHER_ORE.getDefaultState().withProperty(BlockNetherOre.VARIANT, BlockNetherOre.Type.LEAD);
        IBlockState netherGold = NFBlocks.NETHER_ORE.getDefaultState().withProperty(BlockNetherOre.VARIANT, BlockNetherOre.Type.GOLD);
        ((BlockFluidInteractive) TFFluids.blockFluidMana).addInteraction(netherLead, netherGold);

        IBlockState netherSilver  = NFBlocks.NETHER_ORE.getDefaultState().withProperty(BlockNetherOre.VARIANT, BlockNetherOre.Type.SILVER);
        IBlockState netherMithril = NFBlocks.NETHER_ORE.getDefaultState().withProperty(BlockNetherOre.VARIANT, BlockNetherOre.Type.MITHRIL);
        ((BlockFluidInteractive) TFFluids.blockFluidMana).addInteraction(netherSilver, netherMithril);

    }

}
