import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLi {

    public static int findCross(LinkedList L1, LinkedList L2){
        ListIterator l1 = L1.listIterator(0);
        ListIterator l2 = L2.listIterator(0);

        int counter = 0;

        Object pointer1=l1.next();
        Object pointer2=l2.next();


        if (pointer1==pointer2){
            return (int)pointer1;
        }

        while(pointer1 != pointer2){
            pointer1 = l1.next();
            pointer2 = l2.next();
            counter++;
            System.out.println("iteration "+counter+": pointer1 = "+pointer1);
            System.out.println("iteration "+counter+": pointer2 = "+pointer2);
            if (pointer1==pointer2){
                return (int)pointer1;
            }
            if(l1.next()==null){
                l1 = L2.listIterator(0);
            }
            if(l2.next() == null){
                l2 = L1.listIterator(0);
            }
        }
        System.out.println("Iterations = "+counter);
        return (int)pointer2;
    }

    public static void main(String[] args){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.add(3);
        list1.add(7);
        list1.add(8);
        list1.add(10);

        list2.add(99);
        list2.add(1);
        list2.add(8);
        list2.add(10);

        System.out.println(findCross(list1,list2));
    }
}
