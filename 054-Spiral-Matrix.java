54. Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5].


思路：
给定一个矩阵，以回旋形式以此遍历矩阵中的每个元素。
1. 设置 direction ，表示遍历方向（向右，向下，向左，向上）；
2. 设置 left、right、top、buttom ，分别指示矩阵左边界、右边界、上边界、下边界；
3. 每遍历一个元素将其添加到 ret 中，直至 left>right 或 top>buttom 。


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ret = new LinkedList<Integer>();
        if(matrix.length==0){
            return ret;
        }
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int buttom = matrix.length-1;
        int direction = 1;
        
        while(left<=right&&top<=buttom){
            if(direction==1){
                for(int i=left;i<=right;i++){
                    ret.add(matrix[top][i]);
                }
                top++;
                direction = 2;
            }else if(direction==2){
                for(int i=top;i<=buttom;i++){
                    ret.add(matrix[i][right]);
                }
                right--;
                direction = 3;
            }else if(direction==3){
                for(int i=right;i>=left;i--){
                    ret.add(matrix[buttom][i]);
                }
                buttom--;
                direction = 4;
            }else if(direction==4){
                for(int i=buttom;i>=top;i--){
                    ret.add(matrix[i][left]);
                }
                left++;
                direction = 1;
            }
        }
        
        return ret;
    }
}