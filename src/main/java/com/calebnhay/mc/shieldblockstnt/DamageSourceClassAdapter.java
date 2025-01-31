package com.calebnhay.mc.shieldblockstnt;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class DamageSourceClassAdapter extends ClassVisitor implements Opcodes {
	public DamageSourceClassAdapter(int api, ClassVisitor cv) {
		super(api, cv);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		MethodVisitor visitor = super.visitMethod(access, name, desc, signature, exceptions);

		if (!name.equals("net/minecraft/util/DamageSource")
				|| !desc.equals("(Lnet/minecraft/world/Explosion;)Lnet/minecraft/util/DamageSource;")) {
			return visitor;
		}

//		MethodNode node = new MethodNode(access, name, desc, signature, exceptions);
//
//		node.visitCode();
//		node.visitVarInsn(ALOAD, 0);
//		node.visitMethodInsn(INVOKESTATIC, "com/calebnhay/mc/shieldblockstnt/DamageSourcesExtension",
//				"causeExplosionDamage", "(Lnet/minecraft/world/Explosion;)Lnet/minecraft/util/DamageSource;", false);
//		node.visitInsn(ARETURN);
//		node.visitMaxs(1, 1);
//		node.visitEnd();
//
//		return node;

		CauseExplosionDamageMethod newMethod = new CauseExplosionDamageMethod(visitor);

		return newMethod;
	}

	static class CauseExplosionDamageMethod extends MethodVisitor {
		private final MethodVisitor target;

		public CauseExplosionDamageMethod(MethodVisitor mv) {
			super(ASM4);

			target = mv;
		}

		@Override
		public void visitCode() {

			target.visitCode();
			target.visitVarInsn(ALOAD, 0);
			target.visitMethodInsn(INVOKESTATIC, "com/calebnhay/mc/shieldblockstnt/DamageSourcesExtension",
					"causeExplosionDamage", "(Lnet/minecraft/world/Explosion;)Lnet/minecraft/util/DamageSource;",
					false);
			target.visitInsn(ARETURN);
			target.visitMaxs(1, 1);
			target.visitEnd();
		}
	}
}
