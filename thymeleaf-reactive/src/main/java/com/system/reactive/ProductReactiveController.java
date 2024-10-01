package com.system.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class ProductReactiveController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list")
	public String showProducts(Model model) {
		// Reactive Variable
		IReactiveDataDriverContextVariable reactiveList = new ReactiveDataDriverContextVariable(productService.findAll(),1);
		model.addAttribute("productList",reactiveList);
		return "list";
	}
}
