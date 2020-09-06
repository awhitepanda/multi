package search;

public class Search {
    public static void main(String[] args) {
        new Search();
    }

    public Search() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        new SearchTwo(arr, 0);
    }
}

class SearchNum {
    public SearchNum(int[] arr, int target) {
        System.out.println(target + " in " + binarySearch(arr, target));
    }

    public int binarySearch(int[] arr, int target) {
        return -1;
    }
}

class SearchThree {
    public SearchThree(int[] arr, int target) {
        System.out.println(target + " in " + binarySearch(arr, target));
    }

    public int binarySearch(int[] arr, int target) {
        int l = 0, h = arr.length - 1;
        if (target < arr[0] || target > arr[h]) {
            return -1;
        }
        int m;
        while (l <= h) {
            m = l + ((h - 1) >> 1);
            if (target == arr[m]) {
                return m;
            } else if (target < arr[m]) {
                h = m - 1;
            } else if (target > arr[m]) {
                l = m + 1;
            }
        }
        return -1;
    }
}

class SearchTwo {
    public SearchTwo(int[] arr, int target) {
        System.out.println(target + " in " + binarySearch(arr, target));
    }

    public int binarySearch(int[] arr, int target) {
        int l = 0, h = arr.length - 1;
        if (target < arr[l] || target > arr[h]) {
            return -1;
        }
        int m;
        while (l <= h) {
            m = l + ((h - l) >> 1);

            if (target == arr[m]) {
                return m;
            } else if (target < arr[m]) {
                h = m - 1;
            } else if (target > arr[m]) {
                l = m + 1;
            }
        }
        return -1;
    }
}

class SearchOne {
    public SearchOne(int[] arr, int target) {
        System.out.println(binarySearch(arr, target));
    }

    public int binarySearch(int[] arr, int target) {
        int l = 0, h = arr.length - 1;
        if (target < arr[l] && target > arr[h]) {
            return -1;
        }

        int m = 0;
        while (l <= h) {
            m = l + ((h - l) >> 1);
            System.out.println("l,m,h: " + l + " " + m + " " + h);

            if (target == arr[m]) {
                return m;
            } else if (target < arr[m]) {
                h = m - 1;
            } else if (target > arr[m]) {
                l = m + 1;
            }
        }
        return -1;
    }
}