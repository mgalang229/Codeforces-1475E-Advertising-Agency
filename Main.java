import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	
	static long[] facts;
	static long[] invFacts;
	
	public static void main(String[] args) {
		prep();
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt(), k = fs.nextInt();
			int[] a = fs.readArray(n);
			shuffleSort(a);
			int max = a[n-1];
			int[] choose = new int[max+1];
			int[] freq = new int[max+1];
			Arrays.fill(choose, 0);
			Arrays.fill(freq, 0);
			for (int i = n - 1; i >= 0; i--) {
				if (i >= n - k) {
					choose[a[i]]++;
				}
				freq[a[i]]++;
			}
			long ans = 1;
			for (int i = 1; i <= max; i++) {
				if (choose[i] > 0) {
					ans = mul(ans, nCr(freq[i], choose[i]));
				}
			}
			System.out.println(ans);
		}
		out.close();
	}
	
	static void prep() {
		facts = new long[1001]; //can change
		invFacts = new long[1001]; //can change
		facts[0] = invFacts[0] = 1;
		for (int i = 1; i < facts.length; i++) {
			facts[i] = mul(i, facts[i-1]);
			invFacts[i] = fastPow(facts[i], mod - 2);
		}
	}
	
	static final long mod = 1_000_000_007;
	static long mul(long a, long b) {
		return a * b % mod;
	}
	
	static long fastPow(long base, long e) {
		if (e == 0) {
			return 1;
		}
		long half = fastPow(base, e / 2);
		if (e % 2 == 0) {
			return mul(half, half);
		}
		return mul(half, mul(half, base));
	}
	
	static long nCr(int n, int r) {
		return mul(facts[n], mul(invFacts[r], invFacts[n-r]));
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
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
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
