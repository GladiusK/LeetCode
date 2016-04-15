package com.yx.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * @author yuxuan
 *
 */
public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 1, 2, 3 };
		double d = findMedianSortedArrays(nums1, nums2);
		System.out.println(d);
	}

	/**
	 * 使用 midv 记录当前数据中的值, midp 记录当前数据前一个值
	 * 2079 / 2079 test cases passed.
	 * Runtime: 5 ms
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int sum = nums1.length + nums2.length;
		boolean flag = sum % 2 == 0 ? true : false;
		int mid = sum / 2;
		
		int midv = 0;
		int midp = 0;

		int idx = 0;
		int idxa = 0;
		int idxb = 0;
		while (idx++ != (mid + 1)) {
			if (idxa == nums1.length) {
				midp = midv;
				midv = nums2[idxb++];
				continue;
			}

			if (idxb == nums2.length) {
				midp = midv;
				midv = nums1[idxa++];
				continue;
			}

			if (nums1[idxa] > nums2[idxb]) {
				midp = midv;
				midv = nums2[idxb++];

			} else {
				midp = midv;
				midv = nums1[idxa++];
			}

		}

		if (flag) {
			return (midp + midv) / 2.0;
		} else {
			return midv;
		}

	}

	/**
	 * 将2个数组中的数据 按照顺序写到 tmp 数组中，写tmp数组个数为 中位数个数
	 * 
	 * 2079 / 2079 test cases passed. 
	 * Runtime: 5 ms
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int sum = nums1.length + nums2.length;
		boolean flag = sum % 2 == 0 ? true : false;
		int mid = sum / 2;

		int idx = 0;
		int idxa = 0;
		int idxb = 0;
		int[] tmp = new int[sum];
		while (idx != (mid + 1)) {
			if (idxa == nums1.length) {
				tmp[idx++] = nums2[idxb++];
				continue;
			}

			if (idxb == nums2.length) {
				tmp[idx++] = nums1[idxa++];
				continue;
			}

			if (nums1[idxa] > nums2[idxb]) {
				tmp[idx++] = nums2[idxb++];

			} else {
				tmp[idx++] = nums1[idxa++];
			}

		}
		if (flag) {
			return (tmp[mid] + tmp[mid - 1]) / 2.00;
		} else {
			return tmp[mid];
		}

	}
}
