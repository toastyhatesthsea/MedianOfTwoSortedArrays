package SortedArrays;

public class ArrayOfArrays
{

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {




        return 0;

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
