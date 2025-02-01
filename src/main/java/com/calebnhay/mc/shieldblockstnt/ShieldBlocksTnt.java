package com.calebnhay.mc.shieldblockstnt;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("Shield Blocks TNT Coremod")
@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.TransformerExclusions("com.calebnhay.mc.shieldblockstnt")
@IFMLLoadingPlugin.SortingIndex(1500)
public class ShieldBlocksTnt implements IFMLLoadingPlugin {
	@Override
	public String[] getASMTransformerClass() {
		return new String[] { Transformer.class.getName() };
	}

	@Override
	public String getModContainerClass() {
		return ModContainer.class.getName();
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) { }

	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}
