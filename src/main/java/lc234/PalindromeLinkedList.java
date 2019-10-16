/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lc234;

/**
 *
 * @author Ade 
 * 
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2 Output: false Example 2:
 *
 * Input: 1->2->2->1 Output: true Follow up: Could you do it in O(n) time and
 * O(1) space?
 */
public class PalindromeLinkedList {

    public static void main( String[] argv ) {
        int[] testArray = new int[]
        {-31900,22571,-31634,19735,13748,16612,-28299,-16628,9614,-14444,-14444,9614,-16628,-31900,16612,13748,19735,-31634,22571,-28299};//{-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557};
        for (Integer testData : testArray)
        {
            NodeList.add( testData );
        }
        
        System.out.println( isPalindrome( NodeList.listNode ) );
    }

    public static boolean isPalindrome( ListNode head ) {

        return isPalindrome( head, head.val, 0, 0, 0, 0 );

    }

     private static boolean isPalindrome( ListNode head, int start, int prev, int construct, int count, int temp ) {
        if (head == null && (count <= 1 || (count == 3 && ( start == prev ))))
        {
            return true;
        } else if (head == null){
           
            return (construct == temp && start == prev);

        } else if (head.next != null && count < 2 && construct == 0)
        {
            boolean s = (head.next.next == null);
            if (s && ( head.val == head.next.val ))
            {
                return true;
            } else if (s)
            {
                return false;
            }

        }

        ListNode nextNode = head.next;

        int value = head.val < 0 ? ( head.val * -1 ) : head.val;
        if (nextNode != null && head.val == nextNode.val)
        {
            if (prev != head.val)
            {
                construct += value;
                temp = construct;
                if (prev != nextNode.val && head.val == nextNode.val)
                {
                    if (head.next.next != null && (head.next.next.val == prev || (head.next.next.val == head.val)))
                    {
                         temp = temp + value;
                    }
                }
            }

            construct = value;
        } else if (nextNode != null && prev == nextNode.val)
        {
            temp = construct + head.val;
            construct = head.val;
        } else
        {
            construct += value;
        }
        count++;
        return isPalindrome( nextNode, start, head.val, construct, count, temp );
    }

    public static class ListNode {

        ListNode next;
        int val;

        public ListNode( int x ) {
            val = x;
        }
    }

    public static class NodeList {

        private static ListNode listNode;

        public static void add( int value ) {
            ListNode node = new ListNode( value );
            node.next =  listNode ;
            listNode = node;
        }

    }
}
