package com.booking.repository;

import com.booking.models.Receipt;

public interface ReceiptRepository {
    boolean saveReceipt(Receipt receipt);

    Receipt getReceiptByUserId(String userId);
}
