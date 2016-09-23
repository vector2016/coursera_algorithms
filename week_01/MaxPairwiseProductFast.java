import java.util.*;
import java.io.*;

public class MaxPairwiseProductFast {
    static long getMaxPairwiseProductFast(int[] numbers) {
        int n = numbers.length;
        int max_index1 = 0;

        for (int i = 0; i < n; i++)
            if ((max_index1 == 0) || (numbers[i] > numbers[max_index1]))
                max_index1 = i;

        //int max_index2 = 0;

        //for (int j = 0; j < n; j++)
        //    if ((numbers[j] != numbers[max_index1]) && ((max_index2 == 0) || (numbers[j] > numbers[max_index2])))
        //        max_index2 = j;
        //return ((long) (numbers[max_index1]) * (long) (numbers[max_index2]));
	return ((long) (numbers[max_index1]));
    }

    private static int[] buildIntArray(int[] integers) {
        int[] ints = new int[integers.length];
        int i = 0;
        for (Integer n : integers) {
            ints[i++] = n;
	    System.out.println("LOG" +n);
        }
        return ints;
    }

    private static int[] buildZeroArray(int count) {
        int[] ints = new int[count];
        for (int i = 0; i < count;i++) {
            ints[i] = 0;
        }
        return ints;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; ++i) {
            numbers[i] = scanner.nextInt();
        }


	//int[] numbers = buildZeroArray(100000);

	System.out.println(     (long)getMaxPairwiseProductFast( numbers)     );
	//for (int i = 0; i < numbers.length; ++i)
	//	System.out.println ("Array count:-" + i + " zero:-" + numbers[i]);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
