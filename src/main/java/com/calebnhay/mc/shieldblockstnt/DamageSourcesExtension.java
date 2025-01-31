package com.calebnhay.mc.shieldblockstnt;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;

public class DamageSourcesExtension {
	public static DamageSource causeExplosionDamage(@Nullable Explosion explosion) {
		DamageSource damageSource;

		if (explosion == null) {
			damageSource = new DamageSource("explosion");
		} else {
			EntityLivingBase placer = explosion.getExplosivePlacedBy();

			damageSource = placer != null ? new ExplosionEntityDamageSource(explosion, placer)
					: new ExplosionDamageSource(explosion);
		}

		return damageSource.setDifficultyScaled().setExplosion();
	}
}
