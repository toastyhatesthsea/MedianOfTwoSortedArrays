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

        }
    }


}
