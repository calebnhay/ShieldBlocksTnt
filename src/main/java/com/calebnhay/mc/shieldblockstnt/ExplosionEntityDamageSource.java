package com.calebnhay.mc.shieldblockstnt;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;

public class ExplosionEntityDamageSource extends EntityDamageSource {
	private final Explosion explosion;

	public ExplosionEntityDamageSource(Explosion explosion, Entity source) {
		super("explosion.player", source);

		this.explosion = explosion;
	}

	@Override
	public Vec3d getDamageLocation() {
		return explosion.getPosition();
	}
}
