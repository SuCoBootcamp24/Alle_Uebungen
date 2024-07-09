public class IntArrayList {
    // 1. task create a remove(int index) method

    private int[] list = new int[10];
    private int countElements = 0;

    public void add(int element) {
        list[countElements] = element;
        countElements++;
    }
    public int get(int index) {
        if(index >= countElements) throw new IndexOutOfBoundsException(); // Fehler werfen!
        return list[index];
    }


    // list = { -10, 20, 40 }
    // countElements = 3
    // remove(2)
    // list = { -10, 40 }
    // countElements = 2
    public boolean remove(int index) {
        if (index >= countElements || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < countElements - 1; i++) {
            list[i] = list[i + 1];
        }
        countElements--;
        return true;
    }

    


    public boolean isEmpty() {
        return countElements == 0;
    }

    public int size() {
        return countElements;
    }
}
