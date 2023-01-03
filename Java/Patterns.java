import java.util.Scanner;
// Source : https://www.tutorjoes.in/c_programming_tutorial/for_loop_pattern_examples

public class Patterns{

    public static void b1(int n){
        /* Pattern 1 (n = 3)
         * 1
         * 22
         * 333
         */
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= i; ++j)
                System.out.print(i);
            System.out.println();
        }
        System.out.println("------------------");
        /* Pattern 2 (n = 3)
         * 1
         * 12
         * 123
         */
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= i; ++j)
                System.out.print(j);
            System.out.println();
        }
        System.out.println("------------------");
        /* Pattern 3 (n = 5)
        * 1
        * 2 3
        * 4 5 6
        * 7 8 9 10
        * 11 12 13 14 15
        */
        int ctr = 1;
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                System.out.print(ctr + " ");
                ctr += 1;
            }
            System.out.println();
        }
        System.out.println("------------------");
        /* Pattern 4 (n = 5)
        * 1
        * 21
        * 321
        * 4321
        * 54321
        */
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j < i; ++j)
            System.out.print(i-j);
            System.out.println();
        }
        System.out.println("------------------");
        /* Pattern 5 (n = 5)
         *     1
         *    12
         *   123
         *  1234
         * 12345
         */
        for(int i = 1; i <= n; ++i){
            for(int j = i; j < n; ++j)
            System.out.print(" ");
            for(int j = 1; j <= i; ++j)
            System.out.print(j);
            System.out.println();
        }
        System.out.println("------------------");
        /* Pattern 6 (n = 5)
        * 54321
        * 4321
        * 321
        * 21
        * 1
        */
        for(int i = n; i >=1; --i){
            for(int j = i; j >= 1; --j)
            System.out.print(j);
            System.out.println();
        }
        System.out.println("------------------");
        /* Pattern 7 (n = 5)
        * 12345
        *  1234
        *   123
        *    12
        *     1
        */
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j < i; ++j)
            System.out.print(" ");
            for(int j = 1; j <= n+1-i; ++j)
            System.out.print(j);
            System.out.println();
        }
        System.out.println("------------------");
    }

    public static void b2(int n){
        /* Pattern 8 (n = 5)
         *|    1
         *|   121
         *|  12321
         *| 1234321
         *|123454321
         *| 1234321
         *|  12321
         *|   121
         *|    1
         */
        for(int i = 1; i <= n; ++i){
            // Spaces
            for(int j = i; j < n; ++j)
                System.out.print(" ");
            // From 1 to i
            for(int j = 1; j <= i; ++j)
                System.out.print(j);
            // From i-1 to 1
            for(int j = i-1; j >= 1; --j)
                System.out.print(j);
                System.out.println();
            }
            // Reverse
            for(int i = n-1; i >= 1; --i){
                for(int j = 1; j <= n-i; ++j)
                    System.out.print(" ");
                // From 1 to i
                for(int j = 1; j <= i; ++j)
                    System.out.print(j);
                // From i-1 to 1
                for(int j = i-1; j >= 1; --j)
                    System.out.print(j);
                System.out.println();
        }
        System.out.println("------------------");
        /* Pattern 9 (n = 5) TODO
         * |    5
         * |   545
         * |  54345
         * | 5432345
         * |543212345
         * | 5432345
         * |  54345
         * |   545
         * |    5
         */
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of n");
        int n = scanner.nextInt();
        System.out.println("------------------");
        //b1(n); // Basic Patterns 1
        b2(n); // Basic Patterns 2
        scanner.close();
    }
}