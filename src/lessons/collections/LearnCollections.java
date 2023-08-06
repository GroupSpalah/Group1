package lessons.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LearnCollections {
    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();//Object[]

        aList.add(5);
        aList.add(8);
        aList.add(9);
        aList.add(6);

        aList.remove(2);

//        System.out.println(aList);

       List<Integer> lList = new LinkedList<>();

        for (int i = 0; i < aList.size(); i++) {
            Integer value = aList.get(i);

            aList.set(i, value + 8);
        }

        int i = 0;

        while (i < aList.size()) {

            Integer value = aList.get(i);

//            aList.set(i, value + 8);

            ++i;
        }

        for (Integer value : aList) {
            /*if (value == 9) {
            }*/
//            aList.remove(2);
        }

        Iterator<Integer> iterator = aList.iterator();

        while (iterator.hasNext()) {
            Integer value = iterator.next();

            if (value == 9) {
                iterator.remove();
            }

//            System.out.println(value);
        }

        System.out.println(aList);

    }
}
