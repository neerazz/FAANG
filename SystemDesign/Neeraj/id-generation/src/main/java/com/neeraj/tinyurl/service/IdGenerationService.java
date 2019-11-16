package com.neeraj.tinyurl.service;

import com.neeraj.tinyurl.model.IdEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neeraj.tinyurl.repository.IdGenerationRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class IdGenerationService {

    private static final char[] BASE_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    private static final int ID_LENGTH = 6;

    @Autowired
    private IdGenerationRepo idGenerationRepo;

    public String getId(String serviceName) {
        IdEntity first = idGenerationRepo.findFirstByTakenIsNull();
        if (first == null){
            List<IdEntity> idEntities = createUniqueIds(idGenerationRepo.count());
            first = idGenerationRepo.saveAll(idEntities).get(0);
            first.setTaken(LocalDateTime.now());
        }
        first.setServiceName(serviceName);
        first.setTaken(LocalDateTime.now());
        return idGenerationRepo.save(first).getUniqueId();
    }

    private List<IdEntity> createUniqueIds(long counter) {
        List<IdEntity> idEntities = new ArrayList<>();
//        Generate 100 unique id's.
        for (int i = 0; i < 100; i++) {
            idEntities.add(IdEntity.builder().uniqueId(getUniqueString(++counter)).build());
        }
        return idEntities;
    }

    private String getUniqueString(long counter) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ID_LENGTH; i++) {
            sb.append(BASE_CHARS[(int) (counter % BASE_CHARS.length)]);
            counter /= BASE_CHARS.length;
        }
        return sb.toString();
    }
}
