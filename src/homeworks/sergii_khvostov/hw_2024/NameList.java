package homeworks.sergii_khvostov.hw_2024;

/*Suppose we have the next class:

public class NameList {
    private String [] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

Create public inner class named Iterator inside NameList class that correspond the next class diagram:
    - counter: int = 0;
    - Iterator();
    + hasNext(): boolean; - Return true if the next element exist in the list, otherwise returns false.
    + next(): String; - Returns current element and add 1 to counter.
* */

public class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    class Iterator {
        private int counter = 0;

        private Iterator() {
        }

        public boolean hasNext() {
            return counter < names.length;
        }

        public String next() {
            if (hasNext()) {
                return names[counter++];
            } else return null;
        }
    }

    public static void main(String[] args) {
        NameList nameList = new NameList();
        Iterator iterator = nameList.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
