package ru.nsu.manager.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("worker")
public class WorkerProperties {

    private String host;
}
