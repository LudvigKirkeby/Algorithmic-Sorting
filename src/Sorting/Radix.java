package Sorting;

public class Radix {

    public void sort(Comparable[] a) {
        int n = a.length; // Amount of elements
        Comparable largest = a[0];

        for (Comparable element : a) {
            if (element.compareTo(largest) > 0) {
                largest = element;
            }
        }
        int d = (largest.toString()).length(); // Longest single element


    }
}
