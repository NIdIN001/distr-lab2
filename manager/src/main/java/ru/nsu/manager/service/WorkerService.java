package ru.nsu.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.nsu.manager.data.CrackHashManagerRequest;
import ru.nsu.manager.model.dto.CrackRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final RestTemplate restTemplate;

    public void crackHash(CrackRequest crackRequest, UUID uuid) {
        CrackHashManagerRequest.Alphabet alphabet = new CrackHashManagerRequest.Alphabet();
        alphabet.getSymbols().addAll(generateAlphabet());

        CrackHashManagerRequest request = new CrackHashManagerRequest();
        request.setHash(crackRequest.getHash());
        request.setRequestId(uuid.toString());
        request.setMaxLength(crackRequest.getMaxLength());
        request.setPartCount(1);
        request.setPartNumber(1);
        request.setAlphabet(alphabet);

        ResponseEntity<Void> response = restTemplate
                .postForEntity("/internal/api/worker/hash/crack/task", request, Void.TYPE);
    }

    private List<String> generateAlphabet() {
        List<String> result = new ArrayList<>();
        for (int i = Character.valueOf('a'); i <= Character.valueOf('z'); i++) {
            result.add(((Character) (char) i).toString());
        }

        for (int i = Character.valueOf('0'); i <= Character.valueOf('9'); i++) {
            result.add(((Character) (char) i).toString());
        }

        return result;
    }

}
