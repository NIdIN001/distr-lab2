package ru.nsu.manager.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CrackEntity {

    private UUID requestId;

    private CrackStatus status;

    private List<String> data;
}
