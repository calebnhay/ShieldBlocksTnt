package com.calebnhay.mc.shieldblockstnt;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import net.minecraft.launchwrapper.IClassTransformer;

public class Transformer implements IClassTransformer {
	public static final String damageSourceClassName = "net.minecraft.util.DamageSource";

	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) {
		if (basicClass == null || !transformedName.equals(damageSourceClassName)) {
			return basicClass;
		}

		ClassReader reader = new ClassReader(basicClass);
		ClassWriter writer = new ClassWriter(0);
		DamageSourceClassAdapter adapter = new DamageSourceClassAdapter(writer);

		reader.accept(adapter, 0);

		return writer.toByteArray();
	}

}
