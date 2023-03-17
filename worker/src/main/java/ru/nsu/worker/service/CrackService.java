package ru.nsu.worker.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.nsu.manager.data.CrackHashManagerRequest;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import static org.paukov.combinatorics.CombinatoricsFactory.createPermutationWithRepetitionGenerator;
import static org.paukov.combinatorics.CombinatoricsFactory.createVector;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrackService {

    private final HashCodeService hashCodeService;
    private final ManagerService managerService;

    @Qualifier("hash-crack-executor")
    private final Executor executor;

    public void crackHash(CrackHashManagerRequest request) {
        executor.execute(() -> {
            List<String> result = new ArrayList<>();

            ICombinatoricsVector<String> vector = createVector(request.getAlphabet().getSymbols());

            for (int strLength = 1; strLength <= request.getMaxLength(); strLength++) {
                Generator<String> generator = createPermutationWithRepetitionGenerator(vector, strLength);

                for (ICombinatoricsVector<String> permutation : generator) {
                    String str = mergeVector(permutation.getVector());
                    String hash = hashCodeService.getMd5Hash(str.getBytes(StandardCharsets.UTF_8));

                    log.debug("str: {}, hash: {}", str, hash);
                    if (hash.equalsIgnoreCase(request.getHash())) {
                        result.add(str);
                    }
                }
            }

            managerService.sendCrackAnswer(result, request.getRequestId(), request.getPartNumber());
        });
    }

    private String mergeVector(List<String> vector) {
        StringBuilder builder = new StringBuilder();

        vector.forEach(builder::append);

        return builder.toString();
    }
}
