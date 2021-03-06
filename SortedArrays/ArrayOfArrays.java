package SortedArrays;

import java.util.Arrays;

public class ArrayOfArrays
{

    /**
     * Finds the median of arrays that have been sorted already. If one of the arrays is empty, it just finds the median on a single array
     * @param nums1 int[]
     * @param nums2 int[]
     * @return double
     */
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

        int[] combinedArray = sortArrays2(nums1, nums2);
        return calculateMedian(combinedArray);
    }

    /**
     * Calculates the median of a sorted array
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
     * Combines two sorted arrays into one. Then sorts the combined array by first comparing the first element of the first array
     * and the first element of the second array. If the first element of the first array is larger than the first element of the second array,
     * they swap places and then the placement in the second array compares itself to the next element and continues to swap elements
     * until the anchor point element is smaller/equal than the next element. The anchor point then resets itself back to the original index of
     * the first array in the combined array.
     * @param arrayOne int[]
     * @param arrayTwo int[]
     * @return int[]
     */
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

            int savedAnchor = anchor;
            while ((anchor + 1 < answer.length-1) && answer[anchor] > answer[anchor + 1])
            {
                int temp = answer[anchor];
                answer[anchor] = answer[anchor + 1];
                answer[anchor + 1] = temp;
                anchor++;
            }
            anchor = savedAnchor;
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

        int[] newTest = {1, 2, 6};
        int[] newTest2 = {3, 4, 5};

        double answer = rawrs.findMedianSortedArrays(secondArraySmaller, oneAndThrees2);
    }
}
