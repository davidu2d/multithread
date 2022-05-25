package com.u2d.threads.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {

    @Async("asyncDefaultExecutor")
    public void asyncMethodWithConfiguredExecutor() {
        log.info("Execute method with configured executor - "+ Thread.currentThread().getName());
    }
}
