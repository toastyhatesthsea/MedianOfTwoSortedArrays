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
     * @param anArray int[]
     * @return double
     */
    public double calculateMedian(int[] anArray)
    {
        int totalLength = anArray.length;
        int middleLength = totalLength / 2;
        double answer = 0;

        if (totalLength % 2 == 0)
        {
            answer = ((double)anArray[middleLength] + anArray[middleLength - 1]) / 2 ;
        }
        else
        {
            answer = anArray[middleLength];
        }

        return answer;
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
        int arrayOneIndex = 0;
        while(arrayOneIndex < arrayOne.length-1  && arrayOne[arrayOneIndex] < arrayTwo[arrayTwo.length - 1])
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
            arrayOneIndex++;
        }
    }

    public int[] sortArrays2(int[] arrayOne, int[] arrayTwo)
    {
        int[] answer;
        int anchor;
        if (arrayOne[arrayOne.length - 1] > arrayTwo[arrayTwo.length - 1])
        {
            answer = Arrays.copyOfRange(arrayTwo, 0, arrayOne.length + arrayTwo.length);
            System.arraycopy(arrayOne, 0, answer, arrayTwo.length, arrayOne.length);
            anchor = arrayTwo.length;
        }
        else
        {
            answer = Arrays.copyOfRange(arrayOne, 0, arrayOne.length + arrayTwo.length);
            System.arraycopy(arrayTwo, 0, answer, arrayOne.length, arrayTwo.length);
            anchor = arrayOne.length;
        }

        int current = 0;

        while (answer[anchor -1] > answer[anchor])
        {
            while (answer[current] <= answer[anchor])
            {
                current++;
            }

            if (answer[current] > answer[anchor])
            {
                int temp = answer[anchor];
                answer[anchor] = answer[current];
                answer[current] = temp;
            }

            if (answer[anchor] > answer[anchor + 1])
            {
                anchor++;
            }
        }

        return answer;
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
        int[] secondArraySmaller = {2, 4, 5, 7, 8, 60};
        int[] equalLengthArray = {2, 3, 4, 8, 10, 50, 45};

        int[] oneThree = {1, 3};
        int[] oneTwo = {1, 2};
        int[] three = {3};
        int[] justTwo = {2};

        int[] emptyArray = {};

        int[] oneOne = {1, 1};
        //int[] oneTwo = {1, 2};

        int[] onesAndThrees = {1, 1, 3, 3};
        int[] oneAndThrees2 = {1, 1, 3, 3};

        int[] justFour = {4};
        int[] oneThruFive = {1, 2, 3, 5};

        int[] answer = rawrs.sortArrays2(secondArraySmaller, equalLengthArray);
    }
}
