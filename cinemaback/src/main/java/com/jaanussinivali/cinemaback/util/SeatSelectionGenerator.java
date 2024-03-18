package com.jaanussinivali.cinemaback.util;

import com.jaanussinivali.cinemaback.dto.SeatResponse;

import java.util.ArrayList;
import java.util.List;

public class SeatSelectionGenerator {

    public static List<Integer> offerSeatIndexes(Integer numberOfSeatsRequest, List<Integer> reservedSeatIds, List<List<SeatResponse>> hall, Integer numberOfRows, Integer seatsInARow) {

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

        int numberOfRowsIndex = numberOfRows - 1;
        int seatsInARowIndex = seatsInARow - 1;

        if (numberOfSeatsRequest > 10) {
            manySeatsReservation(hall, numberOfRowsIndex, seatsInARowIndex, proposedSeatsForReservation);
        } else if (numberOfSeatsRequest <= 10 && numberOfSeatsRequest > 5) {
            notManySeatsReservation(numberOfSeatsRequest, reservedSeatIds, hall, seatsInARow, preferredRowNumbers,
                    proposedSeatsForReservation, numberOfRowsIndex, seatsInARowIndex);
        } else if (numberOfSeatsRequest <= 5) {
            notManySeatsReservation(numberOfSeatsRequest, reservedSeatIds, hall, seatsInARow, preferredRowNumbers,
                    proposedSeatsForReservation, numberOfRowsIndex, seatsInARowIndex);
        }
        return proposedSeatsForReservation;
    }

    private static void manySeatsReservation(List<List<SeatResponse>> hall, int numberOfRowsIndex, int seatsInARowIndex, List<Integer> proposedSeatsForReservation) {
        for (int j = numberOfRowsIndex - 1; j >= 0; j--) {
            for (int i = seatsInARowIndex; i >= 0; i--) {
                if (hall.get(j).get(i).getAvailable()) {

                    proposedSeatsForReservation.add(((j) * 10) + i);
                }
            }
        }
    }

    private static void notManySeatsReservation(Integer numberOfSeatsRequest, List<Integer> reservedSeatIds, List<List<SeatResponse>> hall, Integer seatsInARow,
                                                int[] preferredRowNumbers, List<Integer> proposedSeatsForReservation, int numberOfRowsIndex, int seatsInARowIndex) {
        do {
            int startSeat = 2;
            int endSeat = 7;
            int check = 0;
            for (int j = 0; j < preferredRowNumbers.length; j++) {
                for (int i = startSeat; i <= endSeat; i++) {
                    if (hall.get(j).get(i).getAvailable()) {
                        check++;
                    } else {
                        check = 0;
                    }
                    if (check == numberOfSeatsRequest) {
                        for (int k = 0; k < numberOfSeatsRequest; k++) {
                            proposedSeatsForReservation.add((preferredRowNumbers[j] * seatsInARow) + i - k);
                        }
                        break;
                    }
                }
                if (j == preferredRowNumbers.length - 1) {
                    if (startSeat > 1 && endSeat < 8) {
                        startSeat -= 1;
                        endSeat += 1;
                    } else {
                        manySeatsReservation(hall, numberOfRowsIndex, seatsInARowIndex, proposedSeatsForReservation);
                        break;
                    }
                }
            }
        } while (reservedSeatIds.size() == numberOfSeatsRequest);
    }

}
