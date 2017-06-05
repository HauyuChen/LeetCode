69. Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x.






class Solution {
public:
    int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int low=1,high=x;
        int mid;
        while(1){
            mid = (low+high)/2;
            if(mid>x/mid){
                high = mid-1;
            }
            else{
                if((mid+1)>(x/(mid+1))){
                    return mid;
                }
                low = mid+1;
            }
        }
    }
};