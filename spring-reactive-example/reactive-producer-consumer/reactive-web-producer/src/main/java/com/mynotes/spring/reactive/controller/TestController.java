package com.mynotes.spring.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynotes.spring.reactive.basic.BasicFluxMono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("test")
public class TestController {

	@GetMapping("/createFluxFromValues")
	public Flux<String> createFluxFromValues() {
		
		BasicFluxMono flux = new BasicFluxMono();
		
		Flux<String> flux2 = flux.createFluxFromValues().map(cadena -> cadena.toUpperCase().concat(" "));
		
		return flux2;
	}
	
	@GetMapping("/counter")
	public Flux<Long> counter() {
		
		BasicFluxMono flux = new BasicFluxMono();
		
		Flux<Long> flux2 = flux.counter();
		
		return flux2;
	}
	
	@GetMapping("/fooMono")
	public Mono<String> fooMono() {
		
		BasicFluxMono flux = new BasicFluxMono();
		
		Mono<String> flux2 = flux.fooMono();
		
		return flux2;
	}
}
