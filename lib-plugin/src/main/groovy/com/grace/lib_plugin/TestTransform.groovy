package com.grace.lib_plugin

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils
import com.grace.asm.TestClassVisitor
import groovy.io.FileType
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter

class TestTransform extends Transform {
    @Override
    String getName() {
        return "TestTransform";
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS;
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.PROJECT_ONLY;
    }

    @Override
    boolean isIncremental() {
        return false;
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        super.transform(transformInvocation)

        //拿到所有的class文件
        Collection<TransformInput> transformInputs = transformInvocation.getInputs()
        def outputProvider = transformInvocation.outputProvider
        for (TransformInput transformInput : transformInputs) {
            //gradle3.6.0以后R类不会转为R.class文件而会转成R.jar,所以要单独拷贝
            transformInput.getJarInputs().each {
                def destJar = outputProvider.getContentLocation(it.name, it.contentTypes, it.scopes, Format.JAR)
                FileUtils.copyFile(it.file, destJar)
            }
            Collection<DirectoryInput> directoryInputs = transformInput.getDirectoryInputs();
            for (DirectoryInput directoryInput : directoryInputs) {
                File dir = directoryInput.getFile()
                if (dir) {
                    dir.traverse(type: FileType.FILES, nameFile: ~/.*\.class/) {
                        ClassReader reader = new ClassReader(it.bytes)
                        ClassWriter classWriter = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS)
                        ClassVisitor visitor = new TestClassVisitor(classWriter)
                        reader.accept(visitor, ClassReader.EXPAND_FRAMES)
                        byte[] bytes = classWriter.toByteArray()
                        FileOutputStream outputStream = new FileOutputStream(it.path)
                        outputStream.write(bytes)
                        outputStream.close()
                    }
                }
                def dest = outputProvider.getContentLocation(directoryInput.name, directoryInput.contentTypes, directoryInput.scopes, Format.DIRECTORY)
                FileUtils.copyDirectory(directoryInput.file, dest)
            }

        }
    }
}
