import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
//        System.out.println(getMazePathWithD(0, 0, 2, 2));
//        System.out.println(getMazePathWithJump(0, 0, 2, 2));
//        System.out.println(getPermutation("abc", ""));
       ArrayList<String>ans=storePermutations("abc","");
        System.out.println(ans);
    }

    private static ArrayList<String> getMazePathWithD(int row, int col, int n, int m) {
        if (row == n - 1 && col == m - 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        } else if (row >= n || col >= m) {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        ArrayList<String> left = getMazePathWithD(row, col + 1, n, m);
        ArrayList<String> Daig = getMazePathWithD(row + 1, col + 1, n, m);
        ArrayList<String> down = getMazePathWithD(row + 1, col, n, m);
        ArrayList<String> ans = new ArrayList<>();
        for (String s : left) {
            ans.add("V" + s);
        }
        for (String s : Daig) {
            ans.add("D" + s);
        }
        for (String s : down) {
            ans.add("H" + s);
        }
        return ans;
    }

    private static ArrayList<String> getMazePathWithJump(int row, int col, int n, int m) {
        if (row == n - 1 && col == m - 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        } else if (row >= n || col >= m) {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int ms = 1; ms <= n - row && ms <= m - col; ms++) {
            ArrayList<String> left = getMazePathWithD(row, col + 1, n, m);
            for (String s : left) {
                ans.add("D" + ms + s);
            }
        }
        for (int ms = 1; ms < n - row; ms++) {
            ArrayList<String> left = getMazePathWithD(row, col + 1, n, m);
            for (String s : left) {
                ans.add("H" + ms + s);
            }
        }
        for (int ms = 1; ms < m - col; ms++) {
            ArrayList<String> left = getMazePathWithD(row, col + 1, n, m);
            for (String s : left) {
                ans.add("V" + ms + s);
            }
        }


        return ans;
    }
   static ArrayList<String>li=new ArrayList<>();
private static ArrayList<String> getPermutationWithRepetatins(String s,String stringmade){
        if(stringmade.length()==s.length()){
            li.add(stringmade);
            return li;
        } else if (stringmade.length()>=s.length()) {
            ArrayList<String>bc=new ArrayList<>();
            return bc;
        }
    for(int i=0;i<s.length();i++){
        getPermutationWithRepetatins(s,stringmade+s.charAt(i));
        }
        return li;
}
       static ArrayList<String>listOfPermutations=new ArrayList<>();
       private static ArrayList<String> storePermutations(String s,String asf){
        if(s.length()==0){
            listOfPermutations.add(asf);
            return listOfPermutations;
        }
          for(int i=0;i<s.length();i++){
              char ch=s.charAt(i);
              String leftRemaining=s.substring(0,i);
              String rightRemaining=s.substring(i+1);
              storePermutations(leftRemaining+rightRemaining,asf+ch);
          }
          return listOfPermutations;
       }
}
