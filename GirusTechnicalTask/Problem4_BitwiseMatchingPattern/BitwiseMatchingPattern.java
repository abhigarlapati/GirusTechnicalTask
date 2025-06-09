import java.util.*;

public class BitwiseMatchingPattern {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();

        int next=getNext(n);
        System.out.println("Next larger number with same number of 1s: " + next);
        System.out.println("Binary: " + Integer.toBinaryString(n) + " → " + Integer.toBinaryString(next));
    }

    public static int getNext(int n) {
        int c=n;
        int c0=0;
        int c1=0;

        
        while (((c & 1)==0) && (c!=0)) {
            c0++;
            c >>=1;
        }

        while ((c & 1)==1) {
            c1++;
            c >>=1;
        }

        if (c0+c1==31 || c0+c1==0) return -1;

        int pos =c0+c1;

    
        n |=(1 << pos);

        n &=~((1 << pos)-1);

        n |=(1 << (c1 - 1))-1;

        return n;
    }
}
