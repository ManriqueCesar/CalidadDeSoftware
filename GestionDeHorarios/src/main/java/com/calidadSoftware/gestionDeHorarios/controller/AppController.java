package com.calidadSoftware.gestionDeHorarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
}
