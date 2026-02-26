package com.springboot.demo.startup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 启动任务时，执行特定代码
 */
@Component
public class StartUpTask implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("应用启动参数："+args.getSourceArgs());
    }
}
