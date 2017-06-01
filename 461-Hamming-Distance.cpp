461. Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.




class Solution {
public:
    int hammingDistance(int x, int y) {
        int cnt=0;
        while(x>0||y>0){
            if(x%2!=y%2){
                cnt++;
            }
            x/=2;
            y/=2;
        }
        while(x>0){
            if(x%2==1){
                cnt++;
            }
            x/=2;
        }
        while(y>0){
            if(y%2==1){
                cnt++;
            }
            y/=2;
        }
        return cnt;
    }
};