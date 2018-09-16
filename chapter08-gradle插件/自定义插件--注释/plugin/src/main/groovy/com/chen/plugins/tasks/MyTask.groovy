package com.chen.plugins.tasks

import org.gradle.api.tasks.Input

class MyTask extends AbstractTask {

    @Input
    String myAddress

    MyTask() {
        super('Returns the basic information about an application.')
    }

    @Override
    void executeAction(BuildTasksParam param) {
        /**拿到映射中的赋值，并打印出来*/
        logger.quiet "myId       is    : $param.myId"
        logger.quiet "myName     is    : $param.myName"
        logger.quiet "myGroup    is    : $param.myGroup"
        logger.quiet "myAddress  is    : " + getMyAddress()
    }
}