package com.calebnhay.mc.shieldblockstnt;

import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;

public class ExplosionDamageSource extends DamageSource {
	private final Explosion explosion;

	public ExplosionDamageSource(Explosion explosion) {
		super("explosion");

		this.explosion = explosion;
	}

	@Override
	public Vec3d getDamageLocation() {
		return explosion.getPosition();
	}
}
