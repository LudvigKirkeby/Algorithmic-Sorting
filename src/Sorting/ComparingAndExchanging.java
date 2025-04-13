package Sorting;

public class ComparingAndExchanging {

    boolean less(Comparable v, Comparable w) {
        if (v.compareTo(w) < 0) { return true;}
        return false;
    }

    void exchange(Comparable[] a, int i, int j) {
        Comparable b = a[i];
        a[i] = a[j];
        a[j] = b;
    }
}