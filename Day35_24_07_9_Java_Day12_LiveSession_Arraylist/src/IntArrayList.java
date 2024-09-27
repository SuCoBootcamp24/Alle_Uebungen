public class IntArrayList {
    private int[] list = new int[10];
    private int countElements = 0;

    // add(100)
    // ...
    // add(100) X IndexOutOfBoundsException
    public void add(int element) {
        if(countElements >= list.length) {
            // countElement == list.length
            int[] nextList = new int[list.length + 10];
            for (int i = 0; i < list.length; i++) {
                nextList[i] = list[i];
            }
            list = nextList;
        }
        list[countElements] = element;
        countElements++;
    }
    public int get(int index) {
        if(index >= countElements) throw new IndexOutOfBoundsException(); // Fehler werfen!
        return list[index];
    }
    // list = { -10, 20, 40, 60, 40, 50 }
    // countElements = 6
    // remove(1)
    // list = { -10, 40, 60, 40, 50 }, 50
    // countElements = 5
    public void remove(int index) {
        if (index < 0 || index >= countElements) throw new IndexOutOfBoundsException();
        for (int i = index; i < countElements - 1; i++) {
            list[index] = list[index + 1];
        }
        countElements--;
    }

    // -1 wenn nicht exisitert
    // index vom element
    public int indexOf(int element) {
        for (int i = 0; i < countElements; i++) {
            if (list[i] == element) return i;
        }
        return -1;
    }

    public boolean contains(int element) {
        return indexOf(element) >= 0;
    }


    //           0   1  2   3
    // list => 18, 14, 12, 11 --- countElements = 4
    // slice(0) // 18, 14, 12, 11 
    // slice(1) // 14, 12, 11
    // slice(2) // 12, 11
    // slice(3) // 11
    // slice(4) // empty
    // slice(0, 2) // 18, 14
    // slice(0, 1) // 18
    // slice(0, -1) // 18, 14, 12
    // slice(0, -2) // 18, 14
    // slice(2, -2) // empty
    // slice(0, 100) // 18, 14, 12, 11
    // slice(-1) // 11
    // slice(-2) // 12, 11
    // slice(-3) // 14, 12, 11
    // slice(-4) // 18, 14, 12, 11 
    // slice(-5) // 18, 14, 12, 11 
    // slice(-100) // 18, 14, 12, 11 
    // slice(-5000, 10) // throw new IllegalArgumentException()
    public IntArrayList slice(int startIndex, int endIndex) {
        if (startIndex < 0) throw new IllegalArgumentException();
        int start = startIndex;
        int end = normalizeIndex(endIndex, countElements);
        return sliceInternal(start, end);
    }
    // System.out.println("startIndex=" +startIndex + ", endIndex=" +endIndex +", start=" +start + ", end=" +end + " | countElements=" + countElements );
    // System.out.println("startIndex=" +startIndex +", start=" +start + ", end=" +end + " | countElements=" + countElements );
    public IntArrayList slice(int startIndex) {
        int start = normalizeIndex(startIndex, countElements); // 10000 7, -2 5, 0 0
        int end = countElements; // 7
        return sliceInternal(start, end);
    }
    // start <= end
    // start > 0
    // end <= countElements
    private IntArrayList sliceInternal(int start, int end) {
        IntArrayList sliced = new IntArrayList();
        for (int i = start; i < end; i++) {
            sliced.add(list[i]);
        }
        return sliced;
    }

    public int normalizeIndex(int index, int length) {
        if (index < 0) return Math.max(0, length + index); // -2 --> length - 2, - bigger than length --> 0
        else if(index > length) return length;
        else return index;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return countElements;
    }


    // Option 1 - reverse verändert die liste selbst (mutieren)
    // liste.print() // 1, 2, 3
    // liste.reverse() 
    // liste.print() // 3, 2, 1

    // Option 2 - reverse erzeugt eine neue liste
    // liste.print() // 1, 2, 3
    // reversedList = liste.reverse();
    // liste.print() // 1, 2, 3
    // reversedList.print() // 3, 2, 1
    public IntArrayList reverse() {
        IntArrayList reversedList = new IntArrayList();
        for (int i = countElements - 1; i >= 0; i--) {
            reversedList.add(list[i]);
        }
        return reversedList;
    }

    @Override
    public String toString() {
        if(countElements == 0) return "";
        String output = "";
        for (int i = 0; i < countElements - 1; i++) {
            output += (list[i] + ", ");
        }
        output += list[countElements - 1];
        return output;
    }

    public void print() {
        System.out.println(this.toString());
    }
}

// IntArrayList liste = new IntArrayList();

// liste.add(element);
// liste.add(index, element);
// liste.set(index, element); // überschreibt
// liste.get(index);
// liste.remove(index);
// liste.size(); // length
// liste.reverse();
// liste.indexOf(element);
// liste.sum();