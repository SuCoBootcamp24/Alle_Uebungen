public class Tower {
    public static void main(String[] args) {
        int n = 4;
        hanoiTower(n, 'A', 'B', 'C');
    }

    public static void hanoiTower(int n, char start, char mid, char end) {
        if (n == 1) {
            System.out.println("Verschiebe Scheibe " + n + " von " + start + " nach " + end);
        } else {
            hanoiTower(n-1, start, end, mid);
            System.out.println("Verschiebe Scheibe " + n + " von " + start + " nach " + end);
            hanoiTower(n-1, mid, start, end);
        }
    }
    
}
