package com.javagda34.bookstore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {

    @Scheduled(fixedRateString = "1000", initialDelayString = "5000")
    public void sendHeartbeat() {
        log.info("Siema!");
    }
}
