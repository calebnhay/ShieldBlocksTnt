package com.calebnhay.mc.shieldblockstnt;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class DamageSourceClassAdapter extends ClassVisitor implements Opcodes {
	private static final String casueExplosionDamageMethodDescriptor = "(Lnet/minecraft/world/Explosion;)Lnet/minecraft/util/DamageSource;";

	public DamageSourceClassAdapter(ClassVisitor cv) {
		super(ASM4, cv);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		MethodVisitor visitor = super.visitMethod(access, name, desc, signature, exceptions);

		if ((!name.equals("causeExplosionDamage") && !name.equals("func_94539_a"))
				|| !desc.equals(casueExplosionDamageMethodDescriptor)) {
			return visitor;
		}

		return new CauseExplosionDamageMethod(visitor);
	}

	private static class CauseExplosionDamageMethod extends MethodVisitor {
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
					"causeExplosionDamage", casueExplosionDamageMethodDescriptor, false);
			target.visitInsn(ARETURN);
			target.visitMaxs(1, 1);
			target.visitEnd();
		}
	}
}
