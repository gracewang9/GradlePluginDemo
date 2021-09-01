package com.grace.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class TestMethodVisitor extends MethodVisitor {
    private String className;
    private String methodName;

    public TestMethodVisitor(MethodVisitor mv, String className, String name) {
        super(Opcodes.ASM5, mv);
        this.className = className;
        this.methodName = name;
    }

    @Override
    public void visitCode() {
        super.visitCode();
        mv.visitLdcInsn("TAG");
        mv.visitLdcInsn(className + "--->" + methodName);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "android/util/Log", "i", "(Ljava/lang/String;Ljava/lang/String;)I", false);
        mv.visitInsn(Opcodes.POP);
    }
}
