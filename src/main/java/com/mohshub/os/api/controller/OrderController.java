package com.mohshub.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohshub.os.api.common.TransactionRequest;
import com.mohshub.os.api.common.TransactionResponse;
import com.mohshub.os.api.interfaces.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/saveOrder")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest request){
		return orderService.saveOrder(request);
	}
}
