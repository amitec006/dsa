package org.example.personal;

public class TestString
{
    public static void main(String[] args)
    {
        String s = new TestString().solve("aeiOUz");
        System.out.println(s);
    }

    public String solve(String A) {
        StringBuilder sb = new StringBuilder();
        int n = A.length();
        for(int i = 0; i < n ; i++){
            if(!('A' <= A.charAt(i) && A.charAt(i) <= 'Z')) {
                if ('a' == A.charAt(i) || 'e' == A.charAt(i) || 'i' == A.charAt(i) || 'o' == A.charAt(i) || 'u' == A.charAt(i)) {
                    sb.append("#");
                } else {
                    sb.append(A.charAt(i));
                }
            }
        }
        sb.append(sb);
        return sb.toString();
    }
}
