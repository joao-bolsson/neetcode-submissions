/*

1 2 3 4 5 6 7 8 9

1 2 3 4


1 1 2 2 3 3 4 4 5 6 7 8 9
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var a = nums1;
        var b = nums2;

        if (b.length < a.length) {
            var temp = a;
            a = b;
            b = temp;
        }

        int total = a.length + b.length;
        int half = (total + 1) / 2;

        int l = 0, r = a.length; // do binary search in A

        var cond = 1 > 0;
        while (cond) {
            int i = (l + r) / 2; // number of elements from a in left partition
            int j = half - i; // number of elements from b in left partition

            var Aleft = i > 0 ? a[i - 1] : Integer.MIN_VALUE;
            var Aright = i < a.length ? a[i] : Integer.MAX_VALUE;
            var Bleft = j > 0 ? b[j - 1] : Integer.MIN_VALUE;
            var Bright = j < b.length ? b[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                // found median
                if (total % 2 == 0) return ((double) Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                return Math.max(Aleft, Bleft);
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return 0d;
    }
}
