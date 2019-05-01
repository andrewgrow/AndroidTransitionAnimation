package com.example.myapplication;

import android.support.annotation.NonNull;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Create objects for Adapter
 */
class ObjectGenerator {

    private static final List<String> listColors = Arrays.asList(
            "#530808", "#5e3105", "#344b0c", "#495534", "#707338", "#408f06", "#0f5705", "#446548",
            "#44655c", "#228369", "#0bc08f", "#0bb5c0", "#177e84", "#2c5052", "#063c53", "#2c5769",
            "#185bb7", "#181fb7", "#440e9d", "#41256f", "#4f256f", "#610f79", "#5d0c47", "#5d0c2e",
            "#610714");

    private static final List<Integer> listImages = Arrays.asList(R.drawable.ic_image0,
            R.drawable.ic_image1, R.drawable.ic_image2, R.drawable.ic_image3, R.drawable.ic_image4,
            R.drawable.ic_image5, R.drawable.ic_image6, R.drawable.ic_image7, R.drawable.ic_image8,
            R.drawable.ic_image9, R.drawable.ic_image10, R.drawable.ic_image11,
            R.drawable.ic_image12, R.drawable.ic_image13, R.drawable.ic_image14,
            R.drawable.ic_image15, R.drawable.ic_image16, R.drawable.ic_image17,
            R.drawable.ic_image18, R.drawable.ic_image19, R.drawable.ic_image20,
            R.drawable.ic_image21, R.drawable.ic_image22, R.drawable.ic_image23,
            R.drawable.ic_image24);

    @NonNull
    public static List<Pair<String, Integer>> generateObjects(int count) {
        if (count < 0) count = 0;
        Random random = new Random();
        List<Pair<String, Integer>> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int choice = random.nextInt(25);
            result.add(new Pair<>(listColors.get(choice), listImages.get(choice)));
        }
        return result;
    }
}
