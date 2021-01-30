package com.mohshub.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mohshub.os.api.common.Payment;
import com.mohshub.os.api.common.TransactionRequest;
import com.mohshub.os.api.common.TransactionResponse;
import com.mohshub.os.api.entity.OrderEntity;
import com.mohshub.os.api.interfaces.IOrderService;
import com.mohshub.os.api.repository.OrderRepository;

@Service
public class OrderService implements IOrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public TransactionResponse saveOrder(TransactionRequest request) {
		
		OrderEntity order = orderRepository.save(request.getOrderEntity());
		
		Payment payment = request.getPayment();
		payment.setAmount(request.getOrderEntity().getAmount());
		payment.setOrderId(order.getId());
		
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		String message = paymentResponse.getPaymentStatus().equals("Success") ? "Payment Successful, order placed" : "There is issue with payment servie, order saved to cart";
		
		TransactionResponse response = new TransactionResponse(order,paymentResponse.getTransactionId(),paymentResponse.getAmount(),message);
		return response;
	}

}
