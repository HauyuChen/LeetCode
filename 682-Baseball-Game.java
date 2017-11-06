682. Baseball Game

You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.

Example 1:
Input: ["5","2","C","D","+"]
Output: 30
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get 2 points. The sum is: 7.
Operation 1: The round 2's data was invalid. The sum is: 5.  
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
Example 2:
Input: ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get -2 points. The sum is: 3.
Round 3: You could get 4 points. The sum is: 7.
Operation 1: The round 3's data is invalid. The sum is: 3.  
Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
Round 5: You could get 9 points. The sum is: 8.
Round 6: You could get -4 + 9 = 5 points. The sum is 13.
Round 7: You could get 9 + 5 = 14 points. The sum is 27.
Note:
The size of the input list will be between 1 and 1000.
Every integer represented in the list will be between -30000 and 30000.




思路：
本题应想到用 LinkedList 来实现，链表最后一个元素为前一轮的得分，倒数第二个元素为前前一轮的得分，每一轮记得更新链表。
1. “C”： score 减去链表最后的元素，并删除链表最后的元素；
2. “D”： score 加上链表最后元素的2倍，并将链表最后元素的2倍添加到链表最后；
3. “+”： score 加上链表倒数第一、第二个元素，并将倒数第一第二元素的和添加到链表最后；
4. 数值：score 加上该数值，并将该数值添加到链表最后。




class Solution {
    public int calPoints(String[] ops) {
        int score = 0;
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C")){
                score -= list.removeLast();
            }else if(ops[i].equals("D")){
                score += list.getLast()*2;
                list.add(list.getLast()*2);
            }else if(ops[i].equals("+")){
                int t1 = list.removeLast();
                int t2 = list.getLast();
                score += t1+t2;
                list.add(t1);
                list.add(t1+t2);
            }else{
                list.add(Integer.parseInt(ops[i]));
                score += list.getLast();             
            }
        }
        
        return score;
    }
}