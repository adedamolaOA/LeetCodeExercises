/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leet.code.excerises.lc9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ade
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121 
 * Output: true 
 * 
 * Example 2:
 *
 * Input: -121 
 * Output: false
 * 
 * Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 *
 * Input: 10
 * Output: false 
 * Explanation: Reads 01 from right to left. Therefore
 * it is not a palindrome. Follow up:
 *
 * Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    
    public static void main( String[] args ) {
        System.out.println( isPalindrome( 121) );
    }

    public static  boolean isPalindrome(int x) {         
        if(x < 0){
           return false; 
        }
        int y = x;
        int rev = 0;
        while(y!=0){                        
            rev = (rev*10)+(y%10);
            y/=10;
        }
        return rev == x;
    }
}
