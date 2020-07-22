/**
 * Given a List of N number a1,a2,a3........an, You have to find smallest number
 * from the List that is repeated in the List exactly K number of times.
 * 
 * Input Format
 * 
 * First Line of Input Contain Single Value N, Size of List Second Line of Input
 * Contain N Space Separated Integers Third Line of Input Contain Single Value K
 * 
 * Output Format
 * 
 * Smallest Integer Value That is Repeated Exactly K Number of Time
 * 
 * Constraints
 * 
 * 0 < N < 100001 0 <= K < 100001 0 <= ai < 100001 NOTE There Will Be Atleast
 * One Variable Which Is Repeated K Times
 */

public class blaine_beltran_ktimes {
    static void smallElement(int elements[], int K) {
        int num = elements.length;
        boolean flag = false; // This variable will tell us if we found an elemnt with
                              // frequency k
        int answer = 0;
        for (int i = 0; i < num; i++) {
            int count = 0;
            for (int j = 0; j < num; j++) {
                if (elements[i] == elements[j]) {
                    count++;
                }
            }
            if (count == K) {
                if (flag == false) {
                    flag = true;
                    answer = elements[i];
                } else {
                    answer = Math.min(answer, elements[i]);
                }
            }
        }
        if (flag == false) {
            System.out.print("There was no element found with frequency K");
        } else {
            System.out.print("Smallest element found with frequency K is: " + answer);
        }
        return;
    }

    public static void main(String[] args) {
        int elements[] = { 1, 2, 2, 5, 5, 2, 5 };
        int K = 3;
        smallElement(elements, K);
    }
}