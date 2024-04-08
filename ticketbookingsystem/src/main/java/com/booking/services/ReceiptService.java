package com.booking.services;

import com.booking.models.Receipt;
import com.booking.models.User;
import com.booking.repository.ReceiptRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {
    ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public void saveReceipt(User user, String departure, String destination,
                            LocalDateTime departureDate, LocalDateTime arrivalDate, Double price) {
        Receipt receipt = new Receipt();
        receipt.setUser(user);
        receipt.setArrivalDate(arrivalDate);
        receipt.setDepartureDate(departureDate);
        receipt.setDeparture(departure);
        receipt.setDestination(destination);
        receipt.setPrice(price);

        receiptRepository.saveReceipt(receipt);
    }

    public Receipt getReceiptByUser(String userId) {
        return receiptRepository.getReceiptByUserId(userId);
    }
}
