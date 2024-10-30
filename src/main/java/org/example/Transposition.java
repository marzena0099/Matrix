package org.example;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
public class Transposition {
    List<List<Integer>> currentMatrix;
    int degree;

    List<List<Integer>> rotationMatrixXTimes() {
        int timesRotation = degree / 90;
        for (int i = 0; i < timesRotation; i++) {
            matrixRotate90ClockWise();
        }
        return currentMatrix;
    }

    void matrixRotate90ClockWise() {

        int rows = currentMatrix.size();
        int columns = currentMatrix.get(0).size();

        List<List<Integer>> result = IntStream.range(0, rows)
                .mapToObj(i -> IntStream.range(0, columns)
                        .mapToObj(j -> (Integer) null)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.get(i).set(j, currentMatrix.get(j).get(i));
            }
        }
        currentMatrix = result;


    }
}
