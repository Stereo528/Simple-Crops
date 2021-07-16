package io.github.stereo528.common

import io.github.stereo528.SimpleCrops

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.apache.logging.log4j.Level

object Items {

    //Seeds
    val TOMATO_SEEDS = register("tomato_seeds")
    val COTTON_SEEDS = register("cotton_seeds")
    val PEA_SEEDS = register("pea_seeds")

    //Saplings
    val APPLE_SAPLING = register("apple_sapling")
    val PEAR_SAPLING = register("pear_sapling")
    val PEACH_SAPLING = register("peach_sapling")
    val APRICOT_SAPLING = register("apricot_sapling")
    val CHERRY_SAPLING = register("cherry_sapling")

    //Vegetables
    val TOMATOES = register("tomatoes")
    val PEAS = register("peas")

    //Fruits
    val PEAR = register("pear")
    val PEACH = register("peach")
    val APRICOT = register("apricot")
    val CHERRIES = register("cherries")

    //Other
    val COTTON = register("cotton")

    //Foods

    private fun register(name: String): Item {
        return Registry.register(Registry.ITEM, Identifier(SimpleCrops.MOD_ID, name), Item(FabricItemSettings().group(SimpleCrops.ITEMS)))
    }

    //Fancy Log Message
    fun log(level: Level?, message: String) {
        SimpleCrops.LOGGER.log(level,"[${SimpleCrops.MOD_NAME}] $message")
    }

    fun init() {}
}