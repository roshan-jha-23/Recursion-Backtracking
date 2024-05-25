import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
//        System.out.println(getMazePathWithD(0, 0, 2, 2));
//        System.out.println(getMazePathWithJump(0, 0, 2, 2));
//        System.out.println(getPermutation("abc", ""));
        ArrayList<String> ans = storePermutations("abc", "");
//        System.out.println(ans);
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        System.out.println(fxn(new int[]{10,20,30,40,50},0,new ArrayList<>(),res,60));
//        printEncoding("123", "");
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

    static ArrayList<String> li = new ArrayList<>();

    private static ArrayList<String> getPermutationWithRepetatins(String s, String stringmade) {
        if (stringmade.length() == s.length()) {
            li.add(stringmade);
            return li;
        } else if (stringmade.length() >= s.length()) {
            ArrayList<String> bc = new ArrayList<>();
            return bc;
        }
        for (int i = 0; i < s.length(); i++) {
            getPermutationWithRepetatins(s, stringmade + s.charAt(i));
        }
        return li;
    }

    static ArrayList<String> listOfPermutations = new ArrayList<>();

    private static ArrayList<String> storePermutations(String s, String asf) {
        if (s.length() == 0) {
            listOfPermutations.add(asf);
            return listOfPermutations;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String leftRemaining = s.substring(0, i);
            String rightRemaining = s.substring(i + 1);
            storePermutations(leftRemaining + rightRemaining, asf + ch);
        }
        return listOfPermutations;
    }

    private static void printEncoding(String s, String sof) {
        if (s.length() == 0) {
            System.out.println(sof);
            return;
        } else if (s.length() == 1) {
            if (s.charAt(0) == '0') return;
            else {
                int iv = s.charAt(0) - '0';
                char code = (char) (iv - 1 + 'a');
                System.out.println(sof + code);
            }
        } else {
            char ch = s.charAt(0);
            if (ch == '0') return;
            else {
                int iv = ch - '0';
                char code = (char) (iv - 1 + 'a');
                String ros = s.substring(1);
                printEncoding(ros, sof + code);
            }

            String f2c = s.substring(0, 2);
            String raf2c = s.substring(2);
            int iv = Integer.parseInt(f2c);
            if (iv <= 26) {
                char code = (char) (iv - 1 + 'a');
                printEncoding(raf2c, sof + code);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> fxn(int[] arr, int i, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res,int tar) {
        if (i >=arr.length ) {
            if(sum(temp)==tar)res.add(new ArrayList<>(temp));
            return res;
        }
        fxn(arr,i+1,temp,res,tar);
        temp.add(arr[i]);
        fxn(arr,i+1,temp,res,tar);
        temp.remove(temp.size()-1);
        return res;
    }

    private static int sum(ArrayList<Integer> temp) {
        int sum2=0;
        for(int x:temp)sum2+=x;
        return sum2;
    }
}

