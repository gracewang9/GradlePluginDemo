package com.grace.lib_plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def android = project.extensions.getByType(AppExtension)
        TestTransform testTransform = new TestTransform()
        android.registerTransform(testTransform)
    }
}
