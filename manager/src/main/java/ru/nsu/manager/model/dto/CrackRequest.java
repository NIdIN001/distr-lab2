package ru.nsu.manager.model.dto;

import lombok.Data;

@Data
public class CrackRequest {

    private String hash;

    private Integer maxLength;
}
