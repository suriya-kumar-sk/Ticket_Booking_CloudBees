package com.booking.repository;

import com.booking.models.Train;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class TrainRepositoryDao implements TrainRepository{
    Set<Train> trains = new HashSet<>();
    @Override
    public Train getTrainByNumber(String trainNumber) {
        return trains.
                stream().
                filter(train -> train.getTrainNumber().equals(trainNumber)).
                findFirst().orElse(null);
    }

    @Override
    public boolean addTrain(Train train) {
        return trains.add(train);
    }
}
