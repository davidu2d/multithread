package com.u2d.threads.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class MultiThreadConfig {

    @Bean(name = "asyncDefaultExecutor")
    public Executor asyncExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1000);
        executor.setMaxPoolSize(1000);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(5);
        executor.setThreadNamePrefix("ThreadAppExecutor-");
        return executor;
    }
}
