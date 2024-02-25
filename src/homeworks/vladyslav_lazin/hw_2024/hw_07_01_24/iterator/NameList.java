package homeworks.vladyslav_lazin.hw_2024.hw_07_01_24.iterator;

public class NameList {
    private String names[] = {"Mike", "Emily", "Nick", "Patric", "Sarah"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter = 0;
        public Iterator() {
        }

        public boolean hasNext() {
            return counter < names.length;
        }
        public String next() {
            return names[counter++];
        }
    }
}
class Main {
    public static void main(String[] args) {
        NameList nameList = new NameList();
        NameList.Iterator iterator = nameList.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}