import java.util.Arrays;
public class Languages {
    public static void main(String[] args) {
        String[] alphabet = {"a", "b"};
        int n = alphabet.length;

        // L1: set of all strings of length 2
        int L1_cardinality = n * n; // there are n choices for each character
        String[] L1 = new String[L1_cardinality];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                L1[k] = alphabet[i] + alphabet[j];
                k++;
            }
        }
        System.out.println("L1: " + Arrays.toString(L1) + ", cardinality: " + L1_cardinality + ", language: Σ^2, infinite: false");

        // L2: set of all strings of length 3
        int L2_cardinality = n * n * n; // there are n choices for each character
        String[] L2 = new String[L2_cardinality];
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    L2[k] = alphabet[i] + alphabet[j] + alphabet[l];
                    k++;
                }
            }
        }
        System.out.println("L2: " + Arrays.toString(L2) + ", cardinality: " + L2_cardinality + ", language: Σ^3, infinite: false");

        // L3: set of all strings that begin with A
        int L3_cardinality = n * (n - 1) + 1; // there are n choices for the first character, except b
        String[] L3 = new String[L3_cardinality];
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (alphabet[i].equals("a")) {
                    L3[k] = "a" + alphabet[j];
                    k++;
                }
            }
        }
        System.out.println("L3: " + Arrays.toString(L3) + ", cardinality: " + L3_cardinality + ", language: ΣaΣ, infinite: true");
    }
}