/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leet.code.excerises.lc7;

/**
 *
 * @author Ade
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123 Output: 321
 *
 * Example 2:
 *
 * Input: -123 Output: -321
 *
 * Example 3:
 *
 * Input: 120 Output: 21
 *
 * Note: Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−231, 231 − 1]. For the
 * purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 */
public class ReverseInteger {

    public static void main( String[] args ) {
        System.out.println( reverse(-123) );
    }
    public static int reverse( int x ) {
        int reversedX = 0;
        while(x!=0){
            int valueToshift = x % 10;
            x/=10;            
            if(reversedX > Integer.MAX_VALUE /10 || (reversedX == Integer.MAX_VALUE/10 && valueToshift > 7)){
                return 0;
            }
            if(reversedX < Integer.MIN_VALUE/10 ||( reversedX == Integer.MIN_VALUE/10 && valueToshift < -8)){
                return 0;
            }
            reversedX = reversedX *10 + valueToshift;  //<-- Shift Value to reversedX store
        }        
        
        return reversedX;
    }
}
