package su.mellgrief.coin.handler;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import su.mellgrief.coin.MCoin;

public class PacketHandler {
	
	@SubscribeEvent
	public void onClientPacket(FMLNetworkEvent.ClientCustomPacketEvent event)
	{
		ByteBuf bb = event.packet.payload();
		ByteBufUtils.readUTF8String(bb);
		MCoin.render.moneyToRender = ByteBufUtils.readUTF8String(bb);
	}
}
