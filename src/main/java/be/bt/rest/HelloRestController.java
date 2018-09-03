package be.bt.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	@GetMapping("/public")
	public String sayPublicMessage() {
		return "hello,this is a public Messages";
	}
	@GetMapping("/secret")
public String saySecurityMessage() {
		return "Secret, Secret, keep it.....";
	}

}
