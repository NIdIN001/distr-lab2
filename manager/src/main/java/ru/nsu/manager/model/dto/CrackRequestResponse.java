package ru.nsu.manager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CrackRequestResponse {

    private UUID requestId;

}
