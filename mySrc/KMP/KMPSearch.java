package KMP;

public class KMPSearch {
    public static void main(String[] args) {
        String s = "abcde";
        String p = "cds";
        System.out.println(kmpSearch(s,p));
    }

    public static int kmpSearch(String s, String p){
        int[] F = failure(p);
        int i = 0;
        int j = 0;
        while (i < s.length()){
            if (s.charAt(i) == p.charAt(j)){
                if (j == p.length() - 1){
                    return i-p.length() + 1;
                }else {
                    i++;
                    j++;
                }
            }else {
                if (j == 0){
                    i++;
                }else {
                    j = F[j-1];
                }
            }
        }
        return -1;
    }

    private static int[] failure(String p){
        int[] next = new int[p.length()];
        next[0] = 0;
        int i = 1;
        int j = 0;
        while (i < p.length()){
            if (p.charAt(i) == p.charAt(j)){
                next[i] = j+1;
                i++;
                j++;
            }else if (j > 0){
                j = next[j-1];
            }else {
                next[i] = 0;
                i++;
            }
        }
        return next;
    }
}
