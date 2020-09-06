package compress;


import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;


public class Genome {
    // Do not instantiate.
    private Genome() {
    }

    /**
     * Reads a sequence of 8-bit extended ASCII characters over the alphabet
     * { A, C, T, G } from standard input; compresses them using two bits per
     * character; and writes the results to standard output.
     */
    public static void compress() {
        Alphabet DNA = Alphabet.DNA;
        String s = BinaryStdIn.readString();
        int n = s.length();
        BinaryStdOut.write(n);

        // Write two-bit code for char.
        for (int i = 0; i < n; i++) {
            int d = DNA.toIndex(s.charAt(i));
            BinaryStdOut.write(d, 2);
        }
        BinaryStdOut.close();
    }

    /**
     * Reads a binary sequence from standard input; converts each two bits
     * to an 8-bit extended ASCII character over the alphabet { A, C, T, G };
     * and writes the results to standard output.
     */
    public static void expand() {
        Alphabet DNA = Alphabet.DNA;
        int n = BinaryStdIn.readInt();
        // Read two bits; write char.
        for (int i = 0; i < n; i++) {
            char c = BinaryStdIn.readChar(2);
            BinaryStdOut.write(DNA.toChar(c), 8);
        }
        BinaryStdOut.close();
    }


    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "-" an {@code expand()} if it is "+".
     *
     * @param args the command-line arguments
     */

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1);
        new GenomeImpl("ABCD").compress("ABCABACDA");
    }
}

class GenomeImpl {
    /**
     * the characters in the alphabet, just a contain for string to char array.
     */
    private char[] alphabet;
    private int[] inverse;

    /**
     * the radix of the alphabet, just is the length of the alphabet string
     */
    private final int R;

    public GenomeImpl(String alpha) {
        // check that alphabet contains no duplicate chars
        boolean[] unicode = new boolean[Character.MAX_VALUE];

        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);
            if (unicode[c]) {
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
            }
            unicode[c] = true;
        }

        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];

        for (int i = 0; i < inverse.length; i++) {
            inverse[i] = -1;
        }

        // can't use char since R can be as big as 65,536
        for (int c = 0; c < R; c++) {
            inverse[alphabet[c]] = c;
        }
    }

    public int toIndex(char c) {
        if (c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }
        return inverse[c];
    }

    /**
     * @param s the string to be compressed
     */
    public void compress(String s) {
        for (int i = 0; i < s.length(); ++i) {
            System.out.print(toIndex(s.charAt(i)) + " ");
        }
    }

    @Override
    public String toString() {
        for (int c = 0; c < R; ++c) {
            System.out.println(inverse[alphabet[c]]);
        }
        return null;
    }
}
