package SortedArrays;

public class ArrayOfArrays
{

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;

    }

    public double findMedianOfOddArray(int[] firstArray, int[] secondArray)
    {
        if (firstArray.length > secondArray.length)
        {
            if (firstArray[firstArray.length - 1] > secondArray[0])
            {
                return firstArray[0];
            }
            else
            {
                return firstArray[firstArray.length - 1];
            }
        }
        else
        {
            if (secondArray[secondArray.length - 1] > firstArray[firstArray.length - 1])
            {
                return secondArray[0];
            }
            else
            {
                return secondArray[secondArray.length - 1];
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

        double answer = rawrs.findMedianOfOddArray(secondArraySmaller, firstArrayBigger);
    }
}