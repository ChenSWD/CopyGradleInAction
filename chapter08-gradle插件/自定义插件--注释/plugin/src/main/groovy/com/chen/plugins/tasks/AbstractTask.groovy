package com.chen.plugins.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input

abstract class AbstractTask extends DefaultTask {
    /**可以配置的task属性：
     * Gradle 自动为所有属性生成getter和setter方法*/
    @Input
    String myId
    @Input
    String myName
    @Input
    String myGroup

    AbstractTask(String description) {
        this.description = description
        /**指定task的group*/
        group = 'CustomPlugin'
    }

    /**定义一个action*/
    @TaskAction
    void start() {
        BuildTasksParam param = new BuildTasksParam()
        /**直接使用getter方法获取属性值*/
        param.setMyId(getMyId())
        param.setMyName(getMyName())
        param.setMyGroup(getMyGroup())
        try {
            executeAction(param)
        }
        catch (Exception e) {
            logger.error "Failed to execute MyTask ", e
            throw new GradleException(e.message)
        }
    }

    abstract void executeAction(BuildTasksParam param)
}