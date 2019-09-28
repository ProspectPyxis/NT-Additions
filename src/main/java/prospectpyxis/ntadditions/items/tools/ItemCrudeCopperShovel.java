package prospectpyxis.ntadditions.items.tools;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import prospectpyxis.ntadditions.registry.ItemRegisterer;

public class ItemCrudeCopperShovel extends ItemBaseShovel {

    public ItemCrudeCopperShovel(ToolMaterial mat) {
        super(mat);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        checkItemBreak(stack, worldIn, entityLiving, 1);
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        checkItemBreak(stack, attacker.getEntityWorld(), attacker, 2);
        return super.hitEntity(stack, target, attacker);
    }

    private void checkItemBreak(ItemStack stack, World world, EntityLivingBase entity, int toDamage) {
        if (!world.isRemote && entity instanceof EntityPlayer && stack.getItemDamage() + toDamage > stack.getMaxDamage()) {
            EntityPlayer player = (EntityPlayer)entity;
            ItemStack bladeItem = new ItemStack(ItemRegisterer.bluntCopperBlade);
            boolean flag = player.inventory.addItemStackToInventory(bladeItem);

            if (!flag) {
                EntityItem ei = player.dropItem(bladeItem, false);

                if (ei != null) {
                    ei.setNoPickupDelay();
                    ei.setOwner(player.getName());
                }
            }
        }
    }
}
