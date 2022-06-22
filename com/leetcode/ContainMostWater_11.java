package com.leetcode;

public class ContainMostWater_11 {

	public static void main(String[] args) {
        int [] height= {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
	}

	public static  int maxArea(int[] height) {

		int max_area = 0;
		
		int left = 0;
		int right =  height.length -1;
		
		while(left < right) {
			int dis = right -left;
			
			int min_height = Math.min(height[left], height[right]);
			
			int cur_area = min_height * dis;
			
			if(max_area < cur_area) {
				max_area = cur_area;
			}
			
			if(height[left] > height[right]) {
				right--;
			}else {
				left++;
			}
			
		}
		return max_area;
	}

}
