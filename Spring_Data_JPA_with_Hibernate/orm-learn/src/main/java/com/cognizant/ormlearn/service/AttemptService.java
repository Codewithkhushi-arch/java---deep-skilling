package com.cognizant.ormlearn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.repository.AttemptRepository;

@Service
public class AttemptService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttemptService.class);
    private final AttemptRepository attemptRepository;

    @Autowired
    public AttemptService(AttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }

    @Transactional(readOnly = true)
    public Attempt getAttempt(int userId, int attemptId) {
        LOGGER.info("Get attempt start");
        return attemptRepository.getAttempt(userId, attemptId);
    }
}
