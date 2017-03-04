/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listing22_14;

/**
 *
 * @author Benji
 */
public class Listing22_14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int NUMBER_PER_LINE = 0;
        int startingNum = 8000000;
     
        String formattedNums = String.format("%-20s%-30d%-30d%-30d%-30d%-30d%-30d", "",8000000, 10000000, 12000000,14000000, 16000000, 18000000);
        String formattedTime;
        System.out.println(formattedNums);
        System.out.print(String.format("%-20s", "Listing 22.5"));
        while(startingNum <= 18000000)
        {
            System.out.print(String.format("%-30s", Long.toString(primeNums(startingNum)) + " milliseconds"));
            startingNum+=2000000;
        }
        startingNum = 8000000;
        System.out.println("");
        System.out.print(String.format("%-20s", "Listing 22.6"));
        while(startingNum <= 18000000)
        {
            System.out.print(String.format("%-30s", Long.toString(efficientNum(startingNum)) + " milliseconds"));
            startingNum+=2000000;
        }
        startingNum = 8000000;
        System.out.println("");
        System.out.print(String.format("%-20s", "Listing 22.7"));
        while(startingNum <= 18000000)
        {
            System.out.print(String.format("%-30s", Long.toString(sievePrimes(startingNum)) + " milliseconds"));
            startingNum+=2000000;
        }
    }
    
    public static long primeNums(int testNum)
    {
        long startTime = System.currentTimeMillis();
        int number = 2;
        boolean isPrime;
        
        while(number <= testNum)
        {
            isPrime = true;
            for(int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++)
            {
                if(number%divisor == 0)
                {
                 isPrime = false;
                 break;
                }
                
            }
            number++;
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }
    
    public static long efficientNum(int testNum)
    {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        
        boolean isPrime = true;
        int number = 2;
        int squareRoot = 1;
        long startTime = System.currentTimeMillis();
       
        while(number < testNum)
        {
            if(squareRoot * squareRoot < number) squareRoot++;
            
            for(int k = 0; k < list.size() && list.get(k) <= squareRoot; k++)
            {
                if(number % list.get(k) == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime)
            {
                list.add(number);
            }
            number++;
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    public static long sievePrimes(int testNum)
    {
        long startTime = System.currentTimeMillis();
        boolean[] primes = new boolean[testNum +1];
        
        for(int i = 0; i < primes.length; i++)
        {
            primes[i] = true;
        }
        
        for(int k = 2; k <= testNum/k; k++)
        {
            if(primes[k])
            {
                for(int i = k; i <= testNum/k; i++)
                {
                    primes[k * i] = false;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
