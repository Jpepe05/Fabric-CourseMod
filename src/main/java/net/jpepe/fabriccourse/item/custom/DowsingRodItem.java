package net.jpepe.fabriccourse.item.custom;

import net.jpepe.fabriccourse.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DowsingRodItem extends Item {
  public DowsingRodItem(Settings settings) {
    super(settings);
  }

  @Override
  public void appendTooltip(
      ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
    if (Screen.hasShiftDown()) {
      tooltip.add(new TranslatableText("item.mccourse.downsing_rod.tooltip.shift"));
    } else {
      tooltip.add(new TranslatableText("item.mccourse.downsing_rod.tooltip"));
    }
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    if (context.getWorld().isClient) {
      BlockPos positionClicked = context.getBlockPos();
      PlayerEntity player = context.getPlayer();
      boolean foundBlock = false;

      for (int i = 0; i <= positionClicked.getY(); i++) {
        BlockState stateBelow = context.getWorld().getBlockState(positionClicked.down(i));
        Block blockBelow = stateBelow.getBlock();

        if (isValuableBlock(stateBelow)) {
          outputValuableCoordinates(
              positionClicked, player, blockBelow, positionClicked.getY() - i);
          foundBlock = true;
          break;
        }
      }

      if (!foundBlock) {
        player.sendMessage(new TranslatableText("item.mccourse.dowsing_rod.no_valuables"), false);
      }
    }

    context
        .getStack()
        .damage(
            1,
            context.getPlayer(),
            playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

    return super.useOnBlock(context);
  }

  private void outputValuableCoordinates(
      BlockPos blockPos, PlayerEntity player, Block blockBelow, int yFound) {
    player.sendMessage(
        new LiteralText(
            "Found "
                + blockBelow.asItem().getName().getString()
                + " at ("
                + blockPos.getX()
                + ", "
                + yFound
                + ", "
                + blockPos.getZ()
                + ")"),
        false);
  }

  private boolean isValuableBlock(BlockState block) {
    return block.isIn(ModTags.Blocks.DOWSING_ROD_DETECTABLE_BLOCKS);
  }
}
