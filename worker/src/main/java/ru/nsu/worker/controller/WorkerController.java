package ru.nsu.worker.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.manager.data.CrackHashManagerRequest;
import ru.nsu.worker.service.CrackService;

@Slf4j
@RestController
@RequestMapping("/internal/api/worker/hash/crack")
@RequiredArgsConstructor
public class WorkerController {

    private final CrackService crackService;

    @PostMapping("/task")
    public ResponseEntity<Void> postTask(@RequestBody CrackHashManagerRequest request) {
        crackService.crackHash(request);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}