import java.util.Scanner;

/**
 * @author awhitepanda
 */

public class Solution {
    public static void main(String[] args) {
        new SolutionImpl();
    }

    public Solution() { }
}

class SolutionImpl {
    public SolutionImpl() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}


