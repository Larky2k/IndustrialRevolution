package com.larky2k.irc;

import com.larky2k.irc.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = IRCGlobal.MODID, name = IRCGlobal.MODNAME, version = IRCGlobal.VERSION)

public class Main {
	
	@SidedProxy(clientSide = IRCGlobal.IRC_CLIENT_PROXY, serverSide = IRCGlobal.IRC_COMMON_PROXY)
			
	public static CommonProxy proxy;

	@Instance(IRCGlobal.MODID)
	public static Main instance = new Main();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
		this.proxy.preInit(preEvent);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		this.proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent postEvent) {
		this.proxy.postInit(postEvent);
	}
	


}
