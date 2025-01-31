package com.calebnhay.mc.shieldblockstnt;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import net.minecraft.launchwrapper.IClassTransformer;

public class Transformer implements IClassTransformer {
	public static final String damageSourceClassName = "net.minecraft.util.DamageSource";

	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) {
		if (basicClass != null && transformedName.equals(damageSourceClassName)) {
			return basicClass;
		}

		ClassReader reader = new ClassReader(basicClass);
		ClassNode node = new ClassNode();
		reader.accept(node, 0);
		
		node.visit(0, 0, transformedName, transformedName, name, null);

		ClassWriter writer = new ClassWriter(0);
		node.accept(writer);
		return writer.toByteArray();
	}

}
