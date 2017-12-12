292. Nim Game

You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

Credits:


思路：

题意：有一堆石头，两个人分别每次可以拿 1 到 3 个石头（你先拿），拿走最后一个石头的人获胜。根据石头的个数，判断你是对否能赢。

这题很简单，只要找到规律即可。规律就是，只要 n 能被 4 整除，则不可能赢，否则一定赢。

比如，

1: true;
2: true;
3: true;
4: false;
5: true;
6: true;
7: true;
8: false;
9: true;
...

class Solution {
    public boolean canWinNim(int n) {
        if(n<=0){
            return false;
        }
        if(n%4==0){
            return false;
        }
        return true;
    }
}