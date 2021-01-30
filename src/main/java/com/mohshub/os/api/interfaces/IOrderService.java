package com.mohshub.os.api.interfaces;

import com.mohshub.os.api.common.TransactionRequest;
import com.mohshub.os.api.common.TransactionResponse;

public interface IOrderService {

	public TransactionResponse saveOrder(TransactionRequest request);
}
