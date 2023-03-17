package ru.nsu.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.manager.model.dto.CrackRequest;
import ru.nsu.manager.model.dto.CrackRequestResponse;
import ru.nsu.manager.model.dto.CrackResponse;
import ru.nsu.manager.model.entity.CrackEntity;
import ru.nsu.manager.service.CrackService;

@Slf4j
@RestController
@RequestMapping("/api/hash")
@RequiredArgsConstructor
public class HashCrackController {

    private final CrackService crackService;

    @GetMapping("/status")
    public ResponseEntity<CrackResponse> getCrackRequestStatus(@RequestParam String requestId) {
        CrackEntity crackEntity = crackService.getCrackEntityById(requestId);

        CrackResponse crackResponse = new CrackResponse();
        crackResponse.setData(crackEntity.getData());
        crackResponse.setStatus(crackEntity.getStatus());

        return ResponseEntity.ok(crackResponse);
    }

    @PostMapping("/crack")
    public ResponseEntity<CrackRequestResponse> postCrackRequest(@RequestBody CrackRequest request) {
        var response = crackService.crackHash(request);

        return ResponseEntity.ok(response);
    }

}
