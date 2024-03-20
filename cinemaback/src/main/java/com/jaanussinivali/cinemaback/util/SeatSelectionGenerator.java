package com.jaanussinivali.cinemaback.util;

import com.jaanussinivali.cinemaback.dto.SeatResponse;

import java.util.ArrayList;
import java.util.List;

public class SeatSelectionGenerator {

    public static List<Integer> offerSeatIndexes(Integer numberOfSeatsRequest, List<List<SeatResponse>> hall, Integer numberOfRows, Integer seatsInARow) {

        //Current version of offerSeatIndexes works only with the next hall model
        //The generator has to be modified if new halls are added or if this hall is modified

        //   0 1 2 3 4 5 6 7 8 9
        //0  o o o o o o o o o o
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

        List<Integer> proposedSeatsForReservation = new ArrayList<>();
        int numberOfRowsIndex = numberOfRows - 1;
        int seatsInARowIndex = seatsInARow - 1;
        if (numberOfSeatsRequest > 10) {
            manySeatsReservation(hall, numberOfRowsIndex, seatsInARowIndex, proposedSeatsForReservation, numberOfSeatsRequest);
            //spilt seatRequest into many smaller requests for not many seats request
        } else if (numberOfSeatsRequest > 5) {
            notManySeatsReservation(numberOfSeatsRequest, hall, seatsInARow, proposedSeatsForReservation, numberOfRowsIndex, seatsInARowIndex);
        } else {
            notManySeatsReservation(numberOfSeatsRequest, hall, seatsInARow, proposedSeatsForReservation, numberOfRowsIndex, seatsInARowIndex);
        }
        return proposedSeatsForReservation;
    }

    private static void manySeatsReservation(List<List<SeatResponse>> hall, int numberOfRowsIndex, int seatsInARowIndex, List<Integer> proposedSeatsForReservation, Integer numberOfSeatsRequest) {
        for (int j = numberOfRowsIndex - 1; j >= 0; j--) {
            for (int i = seatsInARowIndex; i >= 0; i--) {
                if (hall.get(j).get(i).getAvailable()) {
                    proposedSeatsForReservation.add(((j) * 10) + i);
                    if (proposedSeatsForReservation.size() == numberOfSeatsRequest) break;
                }
            }
            if (proposedSeatsForReservation.size() == numberOfSeatsRequest) break;
        }
    }

    private static void notManySeatsReservation(Integer numberOfSeatsRequest, List<List<SeatResponse>> hall, Integer seatsInARow,
                                                List<Integer> proposedSeatsForReservation, int numberOfRowsIndex, int seatsInARowIndex) {

        int startSeat = 0;
        int endSeat = 9;
        switch (numberOfSeatsRequest) {
            case 1:
            case 2:
                startSeat = 4;
                endSeat = 5;
                break;
            case 3:
            case 4:
                startSeat = 3;
                endSeat = 6;
                break;
            case 5:
            case 6:
                startSeat = 2;
                endSeat = 7;
                break;
            case 7:
            case 8:
                startSeat = 1;
                endSeat = 8;
                break;
        }
        int[] preferredRowNumbers = {4, 5, 6, 7, 8, 3, 9, 10, 2, 11, 1, 0};

        while (numberOfSeatsRequest > proposedSeatsForReservation.size()) {
            int check = 0;
            for (int j = 0; j < preferredRowNumbers.length; j++) {
                for (int i = startSeat; i <= endSeat; i++) {
                    if (hall.get(preferredRowNumbers[j]).get(i).getAvailable()) {
                        check++;
                        if (check == numberOfSeatsRequest) {
                            for (int k = 0; k < numberOfSeatsRequest; k++) {
                                proposedSeatsForReservation.add((preferredRowNumbers[j] * seatsInARow) + i + 1 - k);
                            }
                            break;
                        }
                    } else {
                        check = 0;
                    }
                }
                if (j == preferredRowNumbers.length - 1) {
                    if (startSeat > 1 && endSeat < 8) {
                        startSeat -= 1;
                        endSeat += 1;
                    } else {
                        manySeatsReservation(hall, numberOfRowsIndex, seatsInARowIndex, proposedSeatsForReservation, numberOfSeatsRequest);
                        break;
                    }
                }
                if (proposedSeatsForReservation.size() == numberOfSeatsRequest) break;
            }
        }
    }
}
