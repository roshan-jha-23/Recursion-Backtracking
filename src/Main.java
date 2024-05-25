import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        System.out.println(getStairPath(3));
//        System.out.println(getStairPath2ndmethod(5));
//        printDecreasing(10);
//        System.out.println(getMazePath(0,0,2,2));

//        printInc(5);
//        PDI(5);
//        System.out.println(fact(5));
//        System.out.println(power(5,2));
//        System.out.println(power2(5,2));
//        pzz(4);
//        towerOfHanoi(3,1,2,3);
//        displayArr(new int[]{1,2,3,4,5,6,7,8},0);
//        displayArrRev(new int[]{1,2,3,4,5,6,7,8},0);
//        System.out.println(maxOfArr(new int[]{1,2,3,4,5,6,7,8},0));
//        System.out.println(returnFirstOccurrence(new int[]{1,2,3,4,5,6,7,8,5},0,5));
//          System.out.println(returnIndexLast(new int[]{1,2,6,3,4,5,6,7,8,5},0,6));
//          System.out.println(Arrays.toString(fxn(new int[]{1,2,6,3,4,6,5,6,7,6,8,5},6,0,0)));
//        System.out.println(getSubSeq("abc"));
//        System.out.println(getStairPath(4));
    }

    private static void printDecreasing(int n){
        if(n==0)return;
        System.out.println(n);
        printDecreasing(n-1);
    }
    private static void printInc(int n){
        if(n==0)return;
        printInc(n-1);
        System.out.println(n);
    }
    static void PDI(int n){
        if(n==0)return;
        System.out.println(n);
        PDI(n-1);
        System.out.println(n);
    }
    static int fact(int n){
        if(n==0)return 1;//identity
        int prod=n*fact(n-1);
        return prod;
    }
    static int fact1(int n){
        if(n==0)return 1;//identity
        int prod=fact(n-1);
        int prod1=n*prod;
        return prod1;
    }
    static int power(int x,int n){
        if(n==0)return 1;
        int prod=power(x,n-1);
        int prod2=x*prod;
        return prod2;
    }
    static int power2(int x,int n){
        if(n==0)return 1;
        return power2(x,n-1)*x;
    }
    static int powerUsingLog(int x,int n){
        if(x==0)return 1;
        int xpnb2=power(x,n/2);
        int xn=xpnb2*xpnb2;
        if((n&1)==1){
            xn=xn*x;
        }
        return xn;
    }
    static void pzz(int n){
        if(n==0)return ;
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
    }
    public static void towerOfHanoi(int N, int from, int to, int aux) {
        if (N == 0) {
            return;
        }
        towerOfHanoi(N-1, from, aux, to);
        System.out.println("Move disk " + N + " from rod " + from + " to rod " + to);
        towerOfHanoi(N-1, aux, to, from);
    }
    public static void displayArr(int[]arr,int i){
        if(i>=arr.length)return;
        System.out.println(arr[i]);
        displayArr(arr,i+1);
    }

    public static void displayArrRev(int[] arr,int i) {
        if(i==arr.length)return;
        displayArrRev(arr,i+1);
        System.out.println(arr[i]);
    }
    static int max=-(int)(1e9);
    static int maxOfArr(int[]arr,int i){
//        if(i==arr.length)return -(int)(1e9);
//        max=Math.max(max,arr[i]);
//        maxOfArr(arr,i+1);
//        return max;
          if(i==arr.length-1)return arr[i];
          int misa=maxOfArr(arr,i+1);
          if(misa>arr[i]){
              return misa;
          }else{
              return arr[i];
        }

    }
    static int returnFirstOccurance(int[]arr,int i,int tar){
        if(i==arr.length) return -1;
        if(arr[i]==tar) return i;
        else {
            int fissa = returnFirstOccurance(arr, i + 1, tar);
            return fissa;
        }
    }
        static int returnIndexLast(int[]arr,int i,int tar){
            if(i==arr.length) return -1;
            int lissa = returnIndexLast(arr, i + 1, tar);
                if(lissa==-1){
                     if(arr[i]==tar) return i;//ab ye baar baar lisa return karega toh
                     else return -1;
                }else return lissa;
        }
        static int[] fxn(int [] arr,int tar,int i,int fsf){
        if(i==arr.length)return new int[fsf];
          if(arr[i]==tar){
              int[] ans=fxn(arr,tar,i+1,fsf+1);
              ans[fsf]=i;
              return ans;
          }else{
              int[] ans=fxn(arr,tar,i+1,fsf);
              return ans;
          }
        }
        static ArrayList<String> getSubSeq(String s){
         if(s.length()==0){
             ArrayList<String>bres=new ArrayList<>();
             bres.add("");
             return bres;
         }
         char ch=s.charAt(0);
         String ros=s.substring(1);
         ArrayList<String> take=getSubSeq(ros);
         ArrayList<String>res=new ArrayList<>();
            for (String str:take
                 ) {
                res.add(""+str);
            }
            for (String str:take
                 ) {
                res.add(ch+str);
            }
               return res;
        }

  static ArrayList<String>  getStairPath(int n){
    ArrayList<String>ans=helperFunc(n,"");
       return ans;
  }
 static ArrayList<String>res=new ArrayList<>();
  static ArrayList<String> helperFunc(int n,String s){
        if(n==0){
            res.add(s);
            return res;
        }
        if(n<0){
            ArrayList<String>haah=new ArrayList<>();
            return haah;
        }
      helperFunc(n-1,s+"1");
      helperFunc(n-2,s+"2");
      helperFunc(n-3,s+"3");
        return res;
  }
    static ArrayList<String>  getStairPath2ndmethod(int n){
      if(n==0){
          ArrayList<String>bres=new ArrayList<>();
          bres.add("");
          return bres;
      } else if (n<0) {
          ArrayList<String>bres=new ArrayList<>();

          return bres;
      }
        ArrayList<String>paths1=getStairPath2ndmethod(n-1);
        ArrayList<String>paths2=getStairPath2ndmethod(n-2);
        ArrayList<String>paths3=getStairPath2ndmethod(n-3);
        ArrayList<String>paths=new ArrayList<>();
        for(String s:paths1)paths.add(1+s);
        for(String s:paths2)paths.add(2+s);
        for(String s:paths3)paths.add(3+s);
        return paths;
    }
    private static ArrayList<String> getMazePath(int row,int col,int n,int m){
        if(row==n-1&&col==m-1){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }else if(row>=n || col>=m){
            ArrayList<String>base=new ArrayList<>();
            return base;
        }
        ArrayList<String>left=getMazePath(row,col+1,n,m);
        ArrayList<String>down=getMazePath(row+1,col,n,m);
        ArrayList<String> ans=new ArrayList<>();
        for(String s:left){
            ans.add("l"+s);
        }for(String s:down){
            ans.add("d"+s);
        }
        return ans;
    }




}


