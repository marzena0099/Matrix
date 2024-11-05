package org.example;

import org.example.ProcessingImage.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>(Arrays.asList(Arrays.asList(1, 2, 3,11),
                Arrays.asList(4, 5, 6,12),
                Arrays.asList(7, 8, 9,13),
                Arrays.asList(10,11,12,14)));
        Transposition transposition = new Transposition(matrix,90,"Clock");
        System.out.println(transposition.rotationMatrixXTimes());
        ImageLoader imageLoader = new ImageLoader(270);
        imageLoader.transform();
    }
}