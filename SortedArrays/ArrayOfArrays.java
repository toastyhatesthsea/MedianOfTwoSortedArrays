package SortedArrays;

public class ArrayOfArrays
{

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length != nums2.length)
        {
            return findMedianOfNonEqualArrays(nums1, nums2);
        }
        else
        {
            return findMedianOfEqualArrayLengths(nums1, nums2);
        }

    }

    public double findMedianOfEqualArrayLengths(int[] firstArray, int[] secondArray)
    {
        if (firstArray[firstArray.length - 1] > secondArray[secondArray.length - 1])
        {
            return ((double)(firstArray[0] + secondArray[secondArray.length - 1]) / 2);
        }
        else
        {
            return ((double)(firstArray[firstArray.length - 1] + secondArray[0]) / 2);
        }
    }

    public double findMedianOfNonEqualArrays(int[] firstArray, int[] secondArray)
    {
        if (firstArray[firstArray.length - 1] > secondArray[secondArray.length - 1])
        {
            if (firstArray.length > secondArray.length)
            {
                return firstArray[0];
            }
            else
            {
                return secondArray[secondArray.length - 1];
            }
        }
        else
        {
            return firstArray[firstArray.length - 1];
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

        double answer = rawrs.findMedianOfEqualArrayLengths(oneThree, justTwo);
    }
}
