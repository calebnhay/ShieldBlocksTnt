package com.calebnhay.mc.shieldblockstnt;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;

public class DamageSourcesExtension {
	static final String damageType = "explosion";

	public static DamageSource causeExplosionDamage(@Nullable Explosion explosion) {
		EntityLivingBase placer = explosion != null ? explosion.getExplosivePlacedBy() : null;

		return (placer != null ? new ExplosionEntityDamageSource(explosion, placer)
				: new ExplosionDamageSource(explosion)).setDifficultyScaled().setExplosion();
	}
}
