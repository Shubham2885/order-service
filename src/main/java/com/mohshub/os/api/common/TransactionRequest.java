package com.mohshub.os.api.common;

import com.mohshub.os.api.entity.OrderEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

	private OrderEntity orderEntity;
	private Payment payment;
}
