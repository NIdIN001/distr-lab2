package ru.nsu.manager.repository;

import ru.nsu.manager.model.entity.CrackEntity;

import java.util.Optional;

public interface CrackHashRepository {

    Optional<CrackEntity> findByRequestId(String requestId);

    CrackEntity save(CrackEntity entity);
}
