package net.jpepe.fabriccourse.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jpepe.fabriccourse.MCCourseMod;
import net.jpepe.fabriccourse.block.custom.SpeedyBlock;
import net.jpepe.fabriccourse.item.ModItemGroups;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

public class ModBlocks {

  public static final Block ORICHALCUM_BLOCK =
      registerBlock(
          "orichalcum_block", createBlock(Material.METAL, 6f, true), ModItemGroups.COURSE);

  public static final Block ORICHALCUM_ORE =
      registerBlock(
          "orichalcum_ore", createBlock(Material.STONE, 4.5f, true), ModItemGroups.COURSE);

  public static final Block RAW_ORICHALCUM_BLOCK =
      registerBlock(
          "raw_orichalcum_block", createBlock(Material.STONE, 4f, true), ModItemGroups.COURSE);

  public static final Block DEEPSLATE_ORICHALCUM_ORE =
      registerBlock(
          "deepslate_orichalcum_ore", createBlock(Material.STONE, 4f, true), ModItemGroups.COURSE);

  public static final Block SPEEDY_BLOCK =
      registerBlock(
          "speedy_block",
          new SpeedyBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()),
          ModItemGroups.COURSE);

  public static final Block ORICHALCUM_STAIRS =
      registerBlock(
          "orichalcum_stairs",
          new StairsBlock(
              ORICHALCUM_BLOCK.getDefaultState(),
              FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
          ModItemGroups.COURSE);

  public static final Block ORICHALCUM_SLAB =
      registerBlock(
          "orichalcum_slab",
          new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
          ModItemGroups.COURSE);

  public static final Block ORICHALCUM_BUTTON =
      registerBlock(
          "orichalcum_button",
          new StoneButtonBlock(
              FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
          ModItemGroups.COURSE);

  public static final Block ORICHALCUM_PRESSURE_PLATE =
      registerBlock(
          "orichalcum_pressure_plate",
          new PressurePlateBlock(
              PressurePlateBlock.ActivationRule.EVERYTHING,
              FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
          ModItemGroups.COURSE);

  public static final Block ORICHALCUM_FENCE =
      registerBlock(
          "orichalcum_fence",
          new FenceBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
          ModItemGroups.COURSE);

  public static final Block ORICHALCUM_FENCE_GATE =
      registerBlock(
          "orichalcum_fence_gate",
          new FenceGateBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
          ModItemGroups.COURSE);

  public static final Block ORICHALCUM_WALL =
      registerBlock(
          "orichalcum_wall",
          new WallBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
          ModItemGroups.COURSE);

  public static final Block CHERRY_BLOSSOM_DOOR =
      registerBlock(
          "cherry_blossom_door",
          new DoorBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool().nonOpaque()),
          ModItemGroups.COURSE);

  public static final Block CHERRY_BLOSSOM_TRAPDOOR =
      registerBlock(
          "cherry_blossom_trapdoor",
          new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool().nonOpaque()),
          ModItemGroups.COURSE);

  @NotNull
  private static Block createBlock(Material stone, float strength, boolean requireTool) {
    var blockSettings = FabricBlockSettings.of(stone).strength(strength);
    return requireTool ? new Block(blockSettings.requiresTool()) : new Block(blockSettings);
  }

  private static Block registerBlock(String name, Block block, ItemGroup group) {
    registerBlockItem(name, block, group);
    return Registry.register(Registry.BLOCK, new Identifier(MCCourseMod.MOD_ID, name), block);
  }

  private static Item registerBlockItem(String name, Block block, ItemGroup group) {
    return Registry.register(
        Registry.ITEM,
        new Identifier(MCCourseMod.MOD_ID, name),
        new BlockItem(block, new FabricItemSettings().group(group)));
  }

  public static void registerModBlocks() {
    System.out.println("Registering Mod Blocks for " + MCCourseMod.MOD_ID);
  }
}
