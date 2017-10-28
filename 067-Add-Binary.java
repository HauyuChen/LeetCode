67. Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".



思路：
1. 设置flag表示进位标志，将字符串 a 和 b 依次拿出来“相加”，并将相加的结果存放在 char 数组；
2. 假设字符串 a 已经结束，若字符串 b 还有没处理的字符，则操作 b ，注意是否还有进位；反之同理；
3. 将 char 数组转换成 String 返回。

注意：
1. 这种题难度不大，但要考虑全面，细心！！
2. 通过常规的解法，时间复杂度为 O(n)；
3. 注意最后是否进位，若是 char 数组的首字符为‘1’，否则为空。



class Solution {
    public String addBinary(String a, String b) {
        if(a==null){
            return b;
        }else if(b==null){
            return a;
        }
        int lenA = a.length();
        int lenB = b.length();
        int lenC = Math.max(lenA,lenB)+1;
        int indexA = lenA-1;
        int indexB = lenB-1;
        int indexC = lenC-1;
        int flag = 0;
        char[] ch = new char[lenC];
        
        while(indexA>=0 && indexB>=0){
            if(a.charAt(indexA)=='1'&&b.charAt(indexB)=='1'){
                ch[indexC] = flag==1?'1':'0';
                flag = 1;
            }else if(a.charAt(indexA)=='0'&&b.charAt(indexB)=='0'){
                ch[indexC] = flag==1?'1':'0';
                flag = 0;
            }else{
                ch[indexC] = flag==1?'0':'1';
                flag = flag==1?1:0;
            }
            indexA--;
            indexB--;
            indexC--;
        }
        
        while(indexA>=0){
            if(a.charAt(indexA)=='1'){
                if(flag==1){
                    ch[indexC] = '0';
                    flag = 1;
                }else{
                    ch[indexC] = '1';
                    flag = 0;
                }
            }else{
                ch[indexC] = flag==1?'1':'0';
                flag = 0;
            }
            indexA--;
            indexC--;
        }
        
        while(indexB>=0){
            if(b.charAt(indexB)=='1'){
                if(flag==1){
                    ch[indexC] = '0';
                    flag = 1;
                }else{
                    ch[indexC] = '1';
                    flag = 0;
                }
            }else{
                ch[indexC] = flag==1?'1':'0';
                flag = 0;
            }
            indexB--;
            indexC--;
        }
        if(flag==1){
            ch[0] = '1';
        }
        
        return new String(ch).trim();
    }
}


