package SortedArrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayOfArrays
{

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //First Array has largest integer
        if (nums1[nums1.length - 1] > nums2[nums2.length - 1])
        {
            sortArrays(nums1, nums2);
        }
        else
        {
            sortArrays(nums2, nums1);
        }
    }

    /**
     * First Array is the smallest of the input
     * @param arrayOne int[]
     * @param arrayTwo int[]
     * @return double
     */
    public double calculateMedian(int[] arrayOne, int[] arrayTwo)
    {
        int totalLength = arrayOne.length + arrayTwo.length;
        int middleLength = totalLength / 2;
        double answer = 0;

        if (arrayOne.length == arrayTwo.length)
        {
            return ((double)(arrayOne[arrayOne.length - 1] + arrayTwo[0]) / 2);
        }

        //Uneven arrays
        if (totalLength % 2 != 0)
        {
            int index = (arrayTwo.length - middleLength) - 1;
        }
        else
        {

        }


    }


    /**
     * Sorts first array into second array
     * @param arrayOne int[]
     * @param arrayTwo int[]
     * @return double
     */
    public void sortArrays(int[] arrayOne, int[] arrayTwo)
    {

        int current = 0;
        while(arrayOne[0] < arrayTwo[arrayTwo.length - 1])
        {


            while (arrayTwo[current] <= arrayOne[0])
            {
                current++;
            }

            if (arrayTwo[current] > arrayOne[0])
            {
                int temp = arrayOne[0];
                arrayOne[0] = arrayTwo[current];
                arrayTwo[current] = temp;
            }
        }
    }

}

class ArraysTesters
{
    public static void main(String[] araf)
    {
        ArrayOfArrays rawrs = new ArrayOfArrays();

        int[] firstArray = {2, 4, 5};
        int[] secondArray = {6, 7};

        int[] firstArrayBigger = {5, 6, 7};
        int[] secondArraySmaller = {2, 4};
        int[] equalLengthArray = {2, 3, 4};

        int[] oneThree = {1, 3};
        int[] justTwo = {2};

        double answer = rawrs.sortArrays(firstArray, equalLengthArray);
    }
}
