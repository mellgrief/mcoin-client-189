package su.mellgrief.coin;


import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import su.mellgrief.coin.handler.PacketHandler;
import su.mellgrief.coin.render.Render;

@Mod(modid = "mcoin", version = "mcoin")
public class MCoin {
	
	public static Render render = new Render();
	public static FMLEventChannel ch;
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(render);
		PacketHandler phandler = new PacketHandler();
		ch = NetworkRegistry.INSTANCE.newEventDrivenChannel("mcoin");
		ch.register(phandler);
		MinecraftForge.EVENT_BUS.register(phandler);
    }
}
