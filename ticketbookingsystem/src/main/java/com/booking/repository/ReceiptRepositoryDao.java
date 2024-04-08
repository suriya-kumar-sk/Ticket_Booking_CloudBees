package com.booking.repository;

import com.booking.models.Receipt;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ReceiptRepositoryDao implements ReceiptRepository {
    List<Receipt> receiptList = new ArrayList<>();

    @Override
    public boolean saveReceipt(Receipt receipt) {
        return receiptList.add(receipt);
    }

    @Override
    public Receipt getReceiptByUserId(String userId) {
        return receiptList.
                stream().
                filter(receipt -> receipt.getUser().getId().equals(userId)).
                findFirst().orElse(null);
    }
}
