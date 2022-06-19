package net.jpepe.fabriccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jpepe.fabriccourse.MCCourseMod;
import net.jpepe.fabriccourse.item.custom.DowsingRodItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

  public static final Item ORICHALCUM_INGOT =
      registerItem(
          "orichalcum_ingot", new Item(new FabricItemSettings().group(ModItemGroups.COURSE)));

  public static final Item ORICHALCUM_NUGGET =
      registerItem(
          "orichalcum_nugget", new Item(new FabricItemSettings().group(ModItemGroups.COURSE)));

  public static final Item RAW_ORICHALCUM =
      registerItem(
          "raw_orichalcum", new Item(new FabricItemSettings().group(ModItemGroups.COURSE)));

  public static final Item DOWSING_ROD =
      registerItem(
          "dowsing_rod",
          new DowsingRodItem(new FabricItemSettings().group(ModItemGroups.COURSE).maxDamage(32)));

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registry.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
  }

  public static void registerModItems() {
    System.out.println("Registering Mod Items for " + MCCourseMod.MOD_ID);
  }
}
