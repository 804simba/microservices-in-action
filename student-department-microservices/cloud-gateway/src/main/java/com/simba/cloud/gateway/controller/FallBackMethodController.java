package com.simba.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    // https://reflectoring.io/retry-with-resilience4j/#what-is-resilience4j

    @GetMapping("/user-service-fallback")
    public String UserServiceFallBackMethod() {
        return "User service is taking longer than expected, please, try again";
    }

    @GetMapping("/department-service-fallback")
    public String DepartmentServiceFallBackMethod() {
        return "Department service is taking longer than expected, please, try again";
    }
}
