package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArticleStacks {
    /**
     * 钻石 * 1
     */
    public final static ItemStack DIAMOND_STACK_1 = getItemStack(Items.DIAMOND, 1);
    /**
     * 土块 * 1
     */
    public final static ItemStack DIRT_STACK_1 = getItemStack(Blocks.DIRT, 1);

    /**
     * 沙子 * 1
     */
    public final static ItemStack SAND_STACK_1 = getItemStack(Blocks.SAND, 1);

    /**
     * 命令方块 * 1
     */
    public final static ItemStack COMMAND_BLACK_1 = getItemStack(Blocks.COMMAND_BLOCK, 1);


    public final static ItemStack WHEAT_SEED = getItemStack(Items.WHEAT_SEEDS, 1);


    public final static ItemStack EXPERIENCE_BOTTLE = getItemStack(Items.EXPERIENCE_BOTTLE, 1);

    /**
     *
     * @param item
     *            物品
     * @param count
     *            物品数量
     * @return
     */
    public static ItemStack getItemStack(Item item, int count) {
        return new ItemStack(item, count);
    }

    /**
     *
     * @param block
     *            方块
     * @param count
     *            方块数量
     * @return
     */
    public static ItemStack getItemStack(Block block, int count) {
        return new ItemStack(block, count);
    }

    /**
     *
     * @param block
     *            方块
     * @param count
     *            方块数量
     * @param metaData
     *            元数据，如方块是羊毛Wool的话，metaData的值是0～15，表示不同的颜色。
     * @return
     */
    public static ItemStack getItemStack(Block block, int count, int metaData) {
        return new ItemStack(block, count, metaData);
    }
}
