package ru.nsu.worker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.nsu.manager.data.CrackHashWorkerResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final RestTemplate restTemplate;

    public void sendCrackAnswer(List<String> answer, String requestId, int pathNumber) {
        CrackHashWorkerResponse.Answers answers = new CrackHashWorkerResponse.Answers();
        answers.getWords().addAll(answer);

        CrackHashWorkerResponse workerResponse = new CrackHashWorkerResponse();
        workerResponse.setAnswers(answers);
        workerResponse.setPartNumber(pathNumber);
        workerResponse.setRequestId(requestId);

        restTemplate.patchForObject("/internal/api/manager/hash/crack/request", workerResponse, Void.TYPE);
    }
}
