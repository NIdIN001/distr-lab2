package ru.nsu.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.manager.data.CrackHashWorkerResponse;
import ru.nsu.manager.service.CrackService;


@RestController
@RequestMapping("/internal/api/manager/hash/crack")
@RequiredArgsConstructor
public class ManagerController {

    private final CrackService crackService;

    @PatchMapping("/request")
    public void getCrackResult(@RequestBody CrackHashWorkerResponse response) {
        crackService.saveCrackResult(response);
    }
}
