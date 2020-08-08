package com.javagda34.bookstore.config;

import com.javagda34.bookstore.component.ISBNValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class BasicConfig {
    @Bean
    public ISBNValidator createISBNValidator(){
        return new ISBNValidator();
    }

    // nadpisuje domyślny scheduler takim, który działa na 4 wątkach
    // mogę równolegle wystartować 4 zadania asynchroniczne
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(4);
        return threadPoolTaskScheduler;
    }
}
