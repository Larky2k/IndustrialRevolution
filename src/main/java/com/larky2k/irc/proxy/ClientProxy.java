package com.larky2k.irc.proxy;

import com.larky2k.irc.render.IRCBlockRender;
import com.larky2k.irc.render.IRCItemRender;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent preEvent) {
        super.preInit(preEvent);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    
        IRCBlockRender.regsterBlockRender();
        IRCItemRender.registerItemRender();
        
       
        
    }
     
    @Override
    public void postInit(FMLPostInitializationEvent postEvent) {
        super.postInit(postEvent);
    }

}
