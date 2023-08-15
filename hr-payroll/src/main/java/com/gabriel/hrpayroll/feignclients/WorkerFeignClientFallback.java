package com.gabriel.hrpayroll.feignclients;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gabriel.hrpayroll.entities.Worker;

@Component
public class WorkerFeignClientFallback implements WorkerFeignClient{
	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker worker = new Worker(1L, "CircuitBreaker Fallback", 0.0);
		return ResponseEntity.ok(worker);
	}
}
