package com.booking.repository;

import com.booking.models.Train;

public interface TrainRepository {
    Train getTrainByNumber(String trainNumber);

    boolean addTrain(Train train);
}
