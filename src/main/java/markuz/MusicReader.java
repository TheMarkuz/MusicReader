package markuz;

import java.io.File;

import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="MusicReader")
public class MusicReader
{
	
	//called when the game loads up
	@EventHandler
	public void preinint(FMLPreInitializationEvent event)
	{
		
		//Makes the config file...
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	
		//starts the setup the config
		config.load();
		
		//registers the tick handler with values taken from config
		FMLCommonHandler.instance().bus().register(new RenderTickHandler(config.get("FilePath", "path", "").getString(), config.get("Color", "color", "0xFFFFFF").getInt()));

		//ends the config setup
		config.save();
	
	}

}
