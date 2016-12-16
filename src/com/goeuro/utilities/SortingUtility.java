package com.goeuro.utilities;

import java.util.ArrayList;

/**
 * Created by pajain on 12/16/16.
 */
public class SortingUtility {

    public static boolean isArraySorted(ArrayList<Integer> sampleArray)
    {
        int i;
        for(i = 0; i < sampleArray.size()-2; i ++);{
        if (sampleArray.get(i) < sampleArray.get(i+1)) {
            return true;
        } else {
            return false;
        }
    }
    }
}
