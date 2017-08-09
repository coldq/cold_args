/**
 * Created by cold on 2017/5/17.
 */
import cold.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;
        while(l1 != null){
            n1 = n1*10 + l1.val;
            l1 = l1.next;
        }
        while(l2 != null){
            n2 = n2*10 + l2.val;
            l2 = l2.next;
        }
        int n3 = n1+n2;
        int cu = n3%10;
        n3 = n3/10;
        ListNode res = new ListNode(cu),pre = null;

        while(n3 != 0){
            cu = n3 % 10;
            pre = res;
            res = new ListNode(cu);
            res.next = pre;
            n3 = n3/10;
        }
        return res;
    }
    public static void main(String[] args){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;n3.next = n4; n4.next = n5;
        n5.next = n6;n6.next = n7;n7.next = n8;
        n8.next = n9;n9.next = n10;

        ListNode m1 = new ListNode(7);
        ListNode res = addTwoNumbers(n1,m1);
        while (res != null){
            StdOut.println(res.val);
            res = res.next;
        }
    }




}
