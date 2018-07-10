package SortedArrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayOfArrays
{

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0)
        {
            int middle = nums2.length / 2;
            if (nums2.length % 2 == 0)
            {
                return ((double) nums2[middle] + nums2[middle - 1]) / 2;
            }
            else
            {
                return (double) nums2[middle];
            }
        }
        else if (nums2.length == 0)
        {
            int middle = nums1.length / 2;
            if (nums1.length % 2 == 0)
            {
                return ((double) nums1[middle] + nums1[middle - 1]) / 2;
            }
            else
            {
                return (double) nums1[middle];
            }
        }

        double answer = 0;
        //First Array has largest integer
        //Puts the array with the largest last digit as first parameter
        if (nums1[nums1.length - 1] > nums2[nums2.length - 1])
        {
            sortArrays(nums1, nums2);
        }
        else
        {
            sortArrays(nums2, nums1);
        }

        if (nums1.length < nums2.length)
        {
            //Place smallest array first in parameters
            answer = calculateMedian(nums1, nums2);
        }
        else if(nums2.length < nums1.length)
        {
            answer = calculateMedian(nums2, nums1);
        }
        else
        {
            if (nums2[0] >= nums1[nums1.length - 1])
            {
                answer = calculateMedian(nums1, nums2);
            }
            else
            {
                answer = calculateMedian(nums2, nums1);
            }
        }
        return answer;
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
        int[] largestDigitArray;
        int[] smallestDigitArray;

        if (arrayOne[0] > arrayTwo[arrayTwo.length - 1])
        {
            largestDigitArray = arrayOne;
            smallestDigitArray = arrayTwo;
        }
        else
        {
            smallestDigitArray = arrayOne;
            largestDigitArray = arrayTwo;
        }

        if (arrayOne.length == arrayTwo.length)
        {
            return ((double)(smallestDigitArray[arrayOne.length - 1] + largestDigitArray[0]) / 2);
        }

        //Uneven arrays
        if (totalLength % 2 != 0)
        {
            if (smallestDigitArray.length > largestDigitArray.length)
            {
                return (double) smallestDigitArray[middleLength];
            }
            else
            {
                int index = (arrayTwo.length - middleLength) - 1;
                return (double)arrayTwo[index];
            }
        }
        else
        {
            if (smallestDigitArray.length > largestDigitArray.length)
            {
                int firstIndex = (smallestDigitArray.length - middleLength);
                int secondIndex = firstIndex + 1;
                return (((double)arrayTwo[firstIndex] + arrayTwo[secondIndex]) / 2);
            }
            else
            {
                int firstIndex = (arrayTwo.length - middleLength) - 1;
                int secondIndex = firstIndex + 1;
                return (((double)arrayTwo[firstIndex] + arrayTwo[secondIndex]) / 2);
            }
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

            if (arrayOne.length > 1 && arrayOne[0] > arrayOne[1])
            {
                int temp = arrayOne[1];
                arrayOne[1] = arrayOne[0];
                arrayOne[0] = temp;
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
        int[] oneTwo = {1, 2};
        int[] three = {3};
        int[] justTwo = {2};

        int[] emptyArray = {};

        int[] oneOne = {1, 1};
        //int[] oneTwo = {1, 2};

        int[] onesAndThrees = {1, 1, 3, 3};
        int[] oneAndThrees2 = {1, 1, 3, 3};

        double answer = rawrs.findMedianSortedArrays(oneThree, justTwo);
    }
}
