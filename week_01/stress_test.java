import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class stress_test {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (  ((long) numbers[i]) * numbers[j] > result   ) {
                    result = ((long)numbers[i]) * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(int[] numbers) {
        int n = numbers.length;
        int max_index1 = -1;

        for (int i = 0; i < n; ++i)
            if ((max_index1 == -1) || (numbers[i] > numbers[max_index1]))
                max_index1 = i;
	
        int max_index2 = -1;

        for (int j = 0; j < n; ++j)
             if (( j != max_index1) && ((max_index2 == -1) || (numbers[j] > numbers[max_index2])))
                max_index2 = j;

	//System.out.println("first for loop: "+max_index1+" second for loop: "+max_index2);

        return ((long) (numbers[max_index1])) * numbers[max_index2];
    }

    private static int[] toIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }

    private static int[] buildZeroArray(int count) {
        int[] ints = new int[count];
        for (int i = 0; i < count;i++) {
            ints[i] = 0;
        }
        return ints;
    }

    public static void main(String[] args) {
	/* Random r = new Random();
        while (true) {
            //int n = r.next(Integer.SIZE - 1) % 10 + 2;
	    int n = (int) ((Math.random() * 1000) % 100) + 2;
            System.out.println(n);
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) {
                a.add((int) (Math.random() * 100000));
            }


            for (int i = 0; i < n; ++i) {
                System.out.print(toIntArray(a)[i]+ " ");
            }

            System.out.println();
           
            long res1 = getMaxPairwiseProduct(toIntArray(a));
            long res2 = getMaxPairwiseProductFast(toIntArray(a));
	     
            if (res1 != res2) {
                System.out.println("Wrong answer: "+res1+" "+res2);
                break;
            }
            else {
                System.out.println("OK");
            }
        }*/

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