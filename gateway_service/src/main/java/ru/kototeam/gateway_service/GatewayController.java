package ru.kototeam.gateway_service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GatewayController {

	@GetMapping( {"","/login","/reg"} )
	public String page() {
		return "forward:/index.html";
	}
}
