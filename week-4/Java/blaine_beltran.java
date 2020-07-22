
/**
 * PROMPT 1: Given two numbers represented by two linked lists, write a function
 * that returns sum list. The sum list is linked list representation of addition
 * of two input numbers.
 * 
 * PROMPT 2: Given a Linked List which represents a sentence S such that each
 * node represents a letter, the task is to reverse the sentence without
 * reversing individual words.
 */

import java.util.LinkedList;

public class blaine_beltran {

    class node {
        int num;
        node next;

        public node(int num) {
            this.num = num;
        }
    }

    void printResult(node head) {
        while (head != null) {
            System.out.print(head.num + " ");
            head = head.next;
        }
    } // END printResult method

    node head1;
    node head2;
    node result;
    int move;

    void carry(int num, int list) {
        node newnode = new node(num);
        if (list == 1) {
            newnode.next = head1;
            head1 = newnode;
        } else if (list == 2) {
            newnode.next = head2;
            head2 = newnode;
        } else {
            newnode.next = result;
            result = newnode;
        }
    }// END carry method

    void add(node i, node j) {
        if (i == null) {
            return;
        }

        add(i.next, j.next);

        int sum = i.num + j.num + move;
        move = sum / 10;
        sum = sum % 10;

        carry(sum, 3);
    }// END add method

    node current;

    void prop(node head1) {
        if (head1 != current) {
            prop(head1.next);
            int sum = move + head1.num;
            move = sum / 10;
            sum %= 10;

            carry(sum, 3);
        }
    }// END PROP method

    int size(node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }// END size method

    void addEverything() {
        if (head1 == null) {
            result = head2;
            return;
        }
        if (head2 == null) {
            result = head1;
            return;
        }

        int length1 = size(head1);
        int length2 = size(head2);

        if (length1 == length2) {
            add(head1, head2);
        } else {
            if (length1 < length2) {
                node temp = head1;
                head1 = head2;
                head2 = temp;
            }
            int differnce = Math.abs(length1 - length2);

            node temp = head1;
            while (differnce-- >= 0) {
                current = temp;
                temp = temp.next;
            }

            add(current, head2);
            prop(head1);
        }
        if (move > 0) {
            carry(move, 3);
        }
    }// END addEverything method

    public static void main(String[] args) {
        linkedlistAddNumbers list = new LinkedListAddNumbers();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.move = 0;
        int l1[] = { 5, 6, 3 };
        int l2[] = { 8, 4, 2 };

        for (int i = l1.length - 1; i >= 0; --i) {
            list.carry(l1[i], 1);
        }
        for (int i = l2.length - 1; i >= 0; --i) {
            list.carry(l2[i], 2);
        }

        list.addEverything();
        list.printResult(list.result);
    }
}// END Application CLASS