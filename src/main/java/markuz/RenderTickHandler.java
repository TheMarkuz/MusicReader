package markuz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderTickHandler
{
	
	public RenderTickHandler (String path, int color)
	{
		//sets up the variables that we got from the config file 
		this.Path = path;
		this.color = color;
	}
	
	public String Path = "";
	public int color = 0;
	
	//called every time the client render ticks
	@SubscribeEvent
	public void onRenderTick(RenderTickEvent event)
	{
		
		//lots of Try / catch ing to prevent crashes
		try
		{
			//creates a reader for the file in the Patch variable
			BufferedReader reader = new BufferedReader(new FileReader(Path));
			try
			{
				//checks if there's not GUI screens open 
				if (Minecraft.getMinecraft().currentScreen == null)
				{
					//draws text at x1 z1 
					Minecraft.getMinecraft().fontRenderer.drawString(reader.readLine(), 1, 1, color);
					
					//closes the reader to prevent memory leaks
					reader.close();
				}
			} 
			catch (IOException e)
			{
				
			}

		} 
		catch (FileNotFoundException e)
		{
		
		}
	}
}
