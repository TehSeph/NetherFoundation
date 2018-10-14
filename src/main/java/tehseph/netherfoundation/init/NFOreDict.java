package tehseph.netherfoundation.init;

import tehseph.netherfoundation.common.block.BlockNetherOre;

import cofh.core.util.helpers.StringHelper;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class NFOreDict {

    public static void preInitCommon() {

        for (int i = 0; i < BlockNetherOre.Type.values().length; i++) {

            String oreName = BlockNetherOre.Type.byMetadata(i).getName();
            ItemStack oreStack = new ItemStack(NFBlocks.NETHER_ORE, 1, i);

            OreDictionary.registerOre("oreNether" + StringHelper.titleCase(oreName), oreStack);

        }

    }

}
