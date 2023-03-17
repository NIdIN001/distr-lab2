package ru.nsu.manager.model.dto;

import lombok.Data;
import ru.nsu.manager.model.entity.CrackStatus;

import java.util.List;

@Data
public class CrackResponse {

    private CrackStatus status;

    private List<String> data;
}
