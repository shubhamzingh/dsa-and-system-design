package amazon;

import java.util.*;

public class PrimeStrings {

    static final int MOD =1000000007;

    // Function to check whether a number
// is a prime number or not
    static boolean isPrime(String number)
    {
        int num = Integer.valueOf(number);

        for(int i = 2; i * i <= num; i++)
        {
            if ((num % i) == 0)
                return false;
        }
        return num > 1 ? true : false;
    }

    // Function to find the count
// of ways to split String
// into prime numbers
    static int countPrimeStrings(String number,
                                 int i)
    {

        // 1 based indexing
        if (i == 0)
            return 1;

        int cnt = 0;

        // Consider every suffix up to 6 digits
        for(int j = 1; j <= 6; j++)
        {

            // Number should not have
            // a leading zero and it
            // should be a prime number
            if (i - j >= 0 &&
                    number.charAt(i - j) != '0' &&
                    isPrime(number.substring(i - j, i)))
            {
                cnt += countPrimeStrings(number,
                        i - j);
                cnt %= MOD;
            }
        }

        // Return the final result
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeStrings("11373", 5));
    }
}
