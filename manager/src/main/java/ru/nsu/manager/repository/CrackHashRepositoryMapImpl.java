package ru.nsu.manager.repository;

import org.springframework.stereotype.Repository;
import ru.nsu.manager.model.entity.CrackEntity;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CrackHashRepositoryMapImpl implements CrackHashRepository {

    private final ConcurrentHashMap<UUID, CrackEntity> concurrentHashMap = new ConcurrentHashMap<>();

    @Override
    public Optional<CrackEntity> findByRequestId(String requestId) {
        return Optional.ofNullable(concurrentHashMap.get(UUID.fromString(requestId)));
    }

    @Override
    public CrackEntity save(CrackEntity entity) {
        return concurrentHashMap.put(entity.getRequestId(), entity);
    }
}
