package io.github.stereo528

import io.github.stereo528.common.Items
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


class SimpleCrops : ModInitializer {
    //Mod Wide Variables, useful in places like debug text or registering things
    companion object {
        val MOD_ID = "simplecrops" // Mod ID, Necessary
        var MOD_NAME: String? = null // Mod Name, not needed but for fancy log message
        var VERSION: String? = null  // Register the Version Variable for use elsewhere
        val LOGGER: Logger = LogManager.getLogger("Simple Crops") // Create the Logger

        val ITEMS = FabricItemGroupBuilder.create(Identifier(MOD_ID, "items")).icon { ItemStack(Items.CHERRIES) }.build()
    }


    override fun onInitialize() {
        //Get different Mod related variables, reads from fabric.mod.json
        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent { modContainer -> VERSION = modContainer.metadata.version.friendlyString }
        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent { modContainer -> MOD_NAME = modContainer.metadata.name }

        //Init Classes
        Items.init()


        log(Level.INFO, "Making Farming Better!")
        //Debug Text, will probably only include VERSION in production. Will be useful incase people report bugs on outdated builds, etc.
        log(Level.INFO, "MOD VERSION: $VERSION \nMOD ID: $MOD_ID \nMOD NAME: $MOD_NAME")
    }

    //Fancy Log Message
    fun log(level: Level?, message: String) {
        LOGGER.log(level,"[$MOD_NAME] $message")
    }

}
