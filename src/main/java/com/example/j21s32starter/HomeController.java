package com.example.j21s32starter;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
@Observed
public class HomeController {
    @GetMapping
    public String home() {
        String traceId = MDC.get("traceId");
        log.info("Incoming request to path / {}", MDC.getCopyOfContextMap());
        return "Hello, world! ".concat(traceId);
    }
}
