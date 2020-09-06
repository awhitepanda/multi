package unionfind;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


/**
 * @author
 */
public class UF {
    /**
     * id[i] = i
     * count: number of components
     */
    private int[] id;
    private int count;

    /**
     * initialize int[] id by itself, and count by N
     *
     * @param N the number of rows to enter data
     */
    public UF(final int N) {
        if (N < 0) { throw new IllegalArgumentException(); }
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) { id[i] = i; }
    }

    public boolean connected(int p, int q) { return find(p) == find(q); }

    public void getId() {
        for (int i = 0; i < id.length; ++i) { System.out.print(i + ":" + id[i] + ", "); }
        System.out.println("\b\b ");
    }

    public int count() {
        return count;
    }

    public int find(int p) { return 0; }

    public void union(int p, int q) { }

    public static void main(String[] args) throws IOException {
        // redirect the standard input stream
        String inPath =
//                "D:/Download/algs4-data/tinyUF.txt";
                "D:\\ProgramData\\Git\\my.project.test\\IdeaProjects\\multi\\unJava\\src\\read.txt";
        InputStream is = new FileInputStream(inPath);
        System.setIn(is);

        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();

        UF uf = new UF(N);
        uf.getId();

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            // if is connected, continue
            if (uf.find(p) == uf.find(q)) { continue; }

            // if is not connected, union
            uf.union(p, q);
            System.out.println(p + " " + q);
        }

        System.out.println(uf.count() + " components");
        uf.getId();
    }
}
