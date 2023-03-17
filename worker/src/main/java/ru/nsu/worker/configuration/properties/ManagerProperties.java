package ru.nsu.worker.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("manager")
public class ManagerProperties {

    private String host;
}
