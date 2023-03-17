package ru.nsu.worker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorConfiguration {

    @Bean("hash-crack-executor")
    public Executor getHashCrachExecutor() {
        return Executors.newCachedThreadPool();
    }
}
