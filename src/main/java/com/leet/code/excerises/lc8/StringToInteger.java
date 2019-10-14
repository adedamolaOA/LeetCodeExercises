/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leet.code.excerises.lc8;

/**
 *
 * @author Ade
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character. Assume we
 * are dealing with an environment which could only store integers within the
 * 32-bit signed integer range: [−231, 231 − 1]. If the numerical value is out
 * of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is
 * returned.
 *
 * Example 1: Input: "42" Output: 42
 *
 * Example 2: Input: " -42" Output: -42 Explanation: The first non-whitespace
 * character is '-', which is the minus sign. Then take as many numerical digits
 * as possible, which gets 42.
 *
 * Example 3: Input: "4193 with words" Output: 4193 Explanation: Conversion
 * stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4: Input: "words and 987" Output: 0 Explanation: The first
 * non-whitespace character is 'w', which is not a numerical digit or a +/-
 * sign. Therefore no valid conversion could be performed. Example 5:
 *
 * Input: "-91283472332" Output: -2147483648 Explanation: The number
 * "-91283472332" is out of the range of a 32-bit signed integer. Thefore
 * INT_MIN (−231) is returned.
 */
public class StringToInteger {

    public static void main( String[] args ) {
        System.out.println( myAtoi( 

"-91283472332" ) );
    }

    public static int myAtoi( String str ) {
        int atoi = 0;
        int count = 0;
        StringBuilder numberBuilder = new StringBuilder();
        char[] readChars = str.toCharArray();
        boolean started = false;
        int byMinus = 1;
        while (count < str.length())
        {
            System.out.println( atoi );
            
            if (str.length() == 0) return atoi;
          
            if (atoi >= Integer.MAX_VALUE )  return Integer.MAX_VALUE;            

            if (atoi <= Integer.MIN_VALUE ) return Integer.MIN_VALUE;            

            char selectedChar = readChars[count];  
            
             if (!Character.isLetterOrDigit( selectedChar ) && !Character.isSpaceChar( selectedChar ) && 
                 !String.valueOf( selectedChar).equals( "-" ) && !String.valueOf( selectedChar).equals( "+" )){
                atoi = numberBuilder.toString().isEmpty() ? 0 : Integer.parseInt( numberBuilder.toString() )*byMinus;
                return atoi;
            }
            

            if (selectedChar == '-' && byMinus == 1)
            {
                byMinus = -1;
            }
            
            if (( Character.isSpaceChar( selectedChar ) || !Character.isAlphabetic( selectedChar ) ) && started == false)
            {
                started = !started;
                if(Character.isDigit(selectedChar ) ){
                    numberBuilder.append( selectedChar );
                }

            }
            else if (started && !Character.isSpaceChar( selectedChar ) && Character.isDigit( selectedChar ))
            {

                numberBuilder.append( selectedChar );
                if (atoi >= Integer.MAX_VALUE/10 )  return Integer.MAX_VALUE;            

                if (atoi <= Integer.MIN_VALUE/10 ) return Integer.MIN_VALUE;  
                atoi = numberBuilder.toString().isEmpty() ? 0 : Integer.parseInt( numberBuilder.toString()  )*byMinus;

            } else if (started && 
                       ( (Character.isSpaceChar( selectedChar ) && 
                          ! Character.isSpaceChar( str.charAt( count-1))) || 
                         Character.isAlphabetic( selectedChar )))
            {              
               
                atoi = numberBuilder.toString().isEmpty() ? 0 : Integer.parseInt( numberBuilder.toString() )*byMinus;
                return atoi;
            } else if(!Character.isLetterOrDigit( selectedChar ) && 
                          ! Character.isLetterOrDigit( str.charAt( count-1)) && ! Character.isSpaceChar( str.charAt( count-1)) && ! Character.isSpaceChar( str.charAt( count))){
                 atoi = numberBuilder.toString().isEmpty() ? 0 : Integer.parseInt( numberBuilder.toString() )*byMinus;
                return atoi;
            }
            

            count++;
        }
        return atoi;
    }
}
