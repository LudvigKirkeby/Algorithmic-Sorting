package Sorting;

public class Merge {


    public void sort(Comparable[] a) {
        int n = a.length;
        if (n < 2) { return; }
        int mid = n / 2;
        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }

        sort(left);
        sort(right);
        merge(a, left, right);
    }

    private static void merge(Comparable[] a, Comparable[] left, Comparable[] right) {
        int i = 0; int j = 0; int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                a[k] = left[i++];
            } else {
                a[k] = right[j++];
            }
            k++;
        }
        while (i < left.length) {
            a[k++] = left[i++];
        } while(j < right.length) {
            a[k++] = right[j++];
        }
    }
}