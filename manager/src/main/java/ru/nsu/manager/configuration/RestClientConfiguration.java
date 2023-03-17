package ru.nsu.manager.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.nsu.manager.configuration.properties.WorkerProperties;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RestClientConfiguration {

    private final WorkerProperties workerProperties;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .rootUri(workerProperties.getHost())
                .setConnectTimeout(Duration.ofMillis(500))
                .setReadTimeout(Duration.ofMillis(500))
                .build();
    }
}
