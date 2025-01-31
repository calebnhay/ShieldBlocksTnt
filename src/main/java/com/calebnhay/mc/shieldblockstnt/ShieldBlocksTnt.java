package com.calebnhay.mc.shieldblockstnt;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.Explosion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

//@Mod(modid = "shieldblockstnt", name = "Shield Blocks TNT", version = "0.0.1")
@IFMLLoadingPlugin.Name("Shield Blocks TNT Core Mod")
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
	
    public static DamageSource causeExplosionDamage(@Nullable Explosion explosionIn)
    {
    	return DamageSourcesExtension.causeExplosionDamage(explosionIn);
    }
}
