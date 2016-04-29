import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author Peter Thorsen
 * @Date   Apr 26, 2016
 * Problem URL: https://open.kattis.com/problems/classy
 * 
 * Problem solved using mergeSort algorithm
 */
public class ClassyProblem {

	private HashMap<String, String[]> allCases;

	public static void main(String[] args) throws NumberFormatException, IOException{
		new ClassyProblem();
	}

	public ClassyProblem() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = new Integer(reader.readLine());

		for(int currentCase = 0; currentCase < testCases; currentCase++) {
			HashMap<String, String[]> allCases = readInput(reader);

			divideAndConquer(allCases);
			System.out.println("==============================");
		}
	}


	private HashMap<String, String[]> readInput(BufferedReader reader) throws NumberFormatException, IOException {
		int noOfCases = new Integer(reader.readLine());

		allCases = new HashMap<String, String[]>();

		for(int i=0; i<noOfCases; i++) {
			String input = reader.readLine();
			String key = input.split(": ")[0];
			String temp = input.split(": ")[1];
			String value = temp.split(" ")[0];

			String[] valueArray = value.split("-");
			allCases.put(key, valueArray);
		}
		return allCases;		
	}

	private void divideAndConquer(HashMap<String, String[]> allCases) {
		String[] array = new String[allCases.size()];

		int i = 0;
		for(String key : allCases.keySet()) {
			array[i] = key;
			i++;
		}
		array = mergeSort(array, 0, array.length-1); 
		for(String s : array) {
			System.out.println(s);
		}


	}

	private String[] mergeSort(String[] array, int p, int r) {
		if(p < r) {
			int q = (p + r)/2;
			array = mergeSort(array, p, q);
			array = mergeSort(array, q+1, r);
			array = merge(array, p, q, r);
		}
		return array;
	}

	private String[] merge(String[] array, int p, int q, int r) {
		int n1 = q-p+1;
		int n2 = r-q;
		String[] L = new String[n1+1]; // n1+1 because of below L[n1]
		String[] R = new String[n2+1]; // n2+1 because of below R[n2]

		for(int i = 0; i<n1; i++) {
			L[i] = array[p+i]; 
		}
		for(int i = 0; i<n2; i++) {
			R[i] = array[q+i+1];
		}
		L[n1] = "lastElementUnique";
		R[n2] = "lastElementUnique";

		int i = 0;
		int j = 0;

		for(int k=p; k<r+1; k++) {
			if(compare(L[i], R[j])) {
				array[k] = L[i];
				i++;
			}
			else {
				array[k] = R[j];
				j++;
			}
		}
		return array;
	}

	private boolean compare(String left, String right) {
		String[] leftArray;
		String[] rightArray;
		if(left.equals("lastElementUnique")) { 
			return false;
		}
		if(right.equals("lastElementUnique")) {
			return true;
		}
		leftArray = allCases.get(left);
		rightArray = allCases.get(right);

		int sizeLeft = leftArray.length-1;
		int sizeRight = rightArray.length-1;

		while(true) {
			if(sizeLeft < 0 && sizeRight < 0) {
				return sortAlphabetical(left, right); // equal in everything inclusive size
			}

			String leftWord;
			String rightWord;

			if(sizeLeft < 0) {
				rightWord = rightArray[sizeRight];

				if(rightWord.equals("upper")) {
					return false;
				}
				if(rightWord.equals("lower")) {
					return true;
				}
				sizeRight--;
				continue;
			}
			if(sizeRight < 0) {
				leftWord = leftArray[sizeLeft];
				if(leftWord.equals("upper")) {
					return true;
				}
				if(leftWord.equals("lower")) {
					return false;
				}
				sizeLeft--;
				continue;
			}
			rightWord = rightArray[sizeRight];
			leftWord = leftArray[sizeLeft];

			if(rightWord.equals("upper") && !leftWord.equals("upper")) {
				return false;
			}
			if(rightWord.equals("middle") && leftWord.equals("upper")) {
				return true;
			}
			if(rightWord.equals("middle") && leftWord.equals("lower")) {
				return false;
			}
			if(rightWord.equals("lower") && !leftWord.equals("lower")) {
				return true;
			}
			sizeLeft--;
			sizeRight--;

		}
	}

	// Return true if left is before right alphabetically
	private boolean sortAlphabetical(String left, String right) {
		int res = left.compareToIgnoreCase(right);
		if(res < 1) {
			return true;
		}
		return false;
	}
}
