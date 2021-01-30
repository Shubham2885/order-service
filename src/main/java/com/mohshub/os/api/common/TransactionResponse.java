package com.mohshub.os.api.common;

import com.mohshub.os.api.entity.OrderEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

	private OrderEntity orderEntity;
	private String transactionId;
	private double amount;
	private String message;
}
