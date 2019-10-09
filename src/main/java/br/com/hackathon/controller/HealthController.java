package br.com.hackathon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@RestController
@RequestMapping("/health")
public class HealthController {

	@GetMapping
	public boolean health() {
		return true;
	}
}
