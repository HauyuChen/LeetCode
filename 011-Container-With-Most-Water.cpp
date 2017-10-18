11. Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.



思路：本题可以抽象为一个条形图，计算出两条直线能围成的面积（以短的直线为高，以两直线的距离为长）
1. 设置两个变量left和right，left指示最左边的直线，right指示最右边的直线。
2. 每次计算出当前left和right围成的面积，并通过area保存最大面积；
3. 当left比right短，left向右移动（left++），当right比left短，right向左移动（right--），以计算是否有更大的面积。


class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size()-1;
        int area = 0;
        
        while(left<right){
            area = max(area,min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        
        return area;
    }
};