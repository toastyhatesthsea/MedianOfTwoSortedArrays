package SortedArrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayOfArrays
{

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1[nums1.length - 1] > nums2[nums2.length - 1])
        {
            return sortArrays(nums1, nums2);
        }
        else
        {
            return sortArrays(nums2, nums1);
        }
    }


    /**
     * Sorts first array into second array
     * @param arrayOne int[]
     * @param arrayTwo int[]
     * @return int[]
     */
    public double sortArrays(int[] arrayOne, int[] arrayTwo)
    {



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

        double answer = rawrs.findMedianSortedArrays(oneThree, justTwo);
    }
}
