package com.calebnhay.mc.shieldblockstnt;

import com.google.common.eventbus.EventBus;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;

public class ModContainer extends DummyModContainer {
	public ModContainer() {
		super(new ModMetadata());

		ModMetadata metadata = this.getMetadata();

		metadata.modId = "shieldblockstntcoremod";
		metadata.name = "Shield Blocks TNT";
		metadata.authorList.add("calebnhay");
		metadata.description = "Makes TNT explosions blockable with a shield";
		metadata.version = "0.0.1";
		metadata.url = "https://github.com/calebnhay/ShieldBlocksTnt";
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		return true;
	}
}
