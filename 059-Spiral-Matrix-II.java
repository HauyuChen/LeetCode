59. Spiral Matrix II

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
```
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```

思路：
题意要求根据 n ，创建一个 n*n 的回旋矩阵。
1. 设置 direction ，表示构造方向（向右，向下，向左，向上）；
2. 设置 left、right、top、buttom ，分别指示矩阵左边界、右边界、上边界、下边界；
3. 设置 count 指示当前的数值；
4. 按右-下-左-上的顺序不断循环构造，直至 left>right 或 top>buttom 。



class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        if(n==0){
            return ret;
        }
        int count = 1;
        int direction = 1;
        int left = 0;
        int right = n-1;
        int top = 0;
        int buttom = n-1;
        
        while(left<=right&&top<=buttom){
            if(direction==1){
                for(int i=left;i<=right;i++){
                    ret[top][i] = count;
                    count++;     
                }
                top++;
                direction = 2;
            }else if(direction==2){
                for(int i=top;i<=buttom;i++){
                    ret[i][right] = count;
                    count++;                 
                }
                right--;
                direction = 3;
            }else if(direction==3){
                for(int i=right;i>=left;i--){
                    ret[buttom][i] = count;
                    count++;   
                }
                buttom--;
                direction = 4;  
            }else if(direction==4){
                for(int i=buttom;i>=top;i--){
                    ret[i][left] = count;
                    count++;
                    
                }
                left++;
                direction = 1;   
            }
        }
        
        return ret;
    }
}