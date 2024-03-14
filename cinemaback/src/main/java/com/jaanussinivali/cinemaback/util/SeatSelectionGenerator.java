package com.jaanussinivali.cinemaback.util;

import com.jaanussinivali.cinemaback.dto.SeatResponse;

import java.util.ArrayList;
import java.util.List;

public class SeatSelectionGenerator {

    public static List<Integer> offerSeatIndexes(Integer numberOfSeatsRequest, List<Integer> reservedSeatIds, List<List<SeatResponse>> hall) {

        //Current version of offerSeatIndexes works only with the next hall model
        //The generator has to be modified if new halls are added or if this hall is modified

        //   1 2 3 4 5 6 7 8 9 10
        //1  o o o o o o o o o o
        //2  o o o o o o o o o o
        //3  o o o o o o o o o o
        //4  o o o o o o o o o o
        //5  o o o o o o o o o o
        //6  o o o o o o o o o o
        //7  o o o o o o o o o o
        //8  o o o o o o o o o o
        //9  o o o o o o o o o o
        //10 o o o o o o o o o o
        //11 o o o o o o o o o o
        //12 o o o o o o o o o o

        List<Integer> proposedSeatsForReservation = new ArrayList<>();

        int[] preferredRowNumbers = {5, 6, 7, 8, 9, 4, 10, 11, 3, 12, 2, 1};
        int[] preferredSeatNumbers = {3, 4, 5, 6, 7, 8, 2, 9, 1, 10};

        if (numberOfSeatsRequest >= 20) {
            for (int j = 11; j >= 0; j--) {
                for (int i = 9; i >= 0; i--) {
                    if (hall.get(j).get(i).getAvailable()) {
                        proposedSeatsForReservation.add(((j) * 10) + i);
                    }
                }
            }
        } else if (numberOfSeatsRequest <= 10) {
            do {
                int startSeat = 3;
                int endSeat = 8;
                int check = 0;
                for (int j = 0; j < preferredRowNumbers.length; j++) {
                    for (int i = 3; i >= 0; i++) {
                        if (hall.get(j).get(i).getAvailable()) {
                            check++;
                        } else {
                            check = 0;
                        }
                        if (check == numberOfSeatsRequest) {
                            for (int k = 0; k < numberOfSeatsRequest; k++) {
                                proposedSeatsForReservation.add((preferredRowNumbers[j] * 10) + i - k);
                            }
                            break;
                        }

                    }
                    if (j == preferredRowNumbers.length - 1) {
                        if (startSeat >= 1 && endSeat <= 10) {
                            startSeat -= 1;
                            endSeat += 1;
                        } else {
                            //other options ???
                            break;
                        }
                    }
                }
            }
            while (reservedSeatIds.size() == numberOfSeatsRequest);
        }
//        else {
//        }
        return proposedSeatsForReservation;

    }

}
