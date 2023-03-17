package ru.nsu.manager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nsu.manager.data.CrackHashWorkerResponse;
import ru.nsu.manager.exception.RequestNotFoundException;
import ru.nsu.manager.model.dto.CrackRequest;
import ru.nsu.manager.model.dto.CrackRequestResponse;
import ru.nsu.manager.model.entity.CrackEntity;
import ru.nsu.manager.model.entity.CrackStatus;
import ru.nsu.manager.repository.CrackHashRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrackService {

    private final WorkerService workerService;
    private final CrackHashRepository crackHashRepository;

    public void saveCrackResult(CrackHashWorkerResponse response) {
        CrackEntity crackEntity = getCrackEntityById(response.getRequestId());

        mergeResult(crackEntity, response.getAnswers().getWords());

        crackHashRepository.save(crackEntity);
    }

    private void mergeResult(CrackEntity crackEntity, List<String> result) {
        if (crackEntity.getData() == null) {
            crackEntity.setData(new ArrayList<>(result));
            crackEntity.setStatus(CrackStatus.READY);
        } else {
            crackEntity.getData().addAll(result);
            crackEntity.setStatus(CrackStatus.READY);
        }
    }

    public CrackEntity getCrackEntityById(String requestId) {
        return crackHashRepository.findByRequestId(requestId)
                .orElseThrow(RequestNotFoundException::new);
    }

    public CrackRequestResponse crackHash(CrackRequest crackRequest) {
        var uuid = UUID.randomUUID();
        crackHashRepository.save(new CrackEntity(uuid, CrackStatus.IN_PROGRESS, null));

        workerService.crackHash(crackRequest, uuid);
        return new CrackRequestResponse(uuid);
    }
}
