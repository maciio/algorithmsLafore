import java.util.Arrays;

/**
*	Use the binary and linear methods of class OrdArray
*
*/
class OrdArrayApp {
	public static void main(String[] args) {
		OrdArray oArray = new OrdArray(100);
		oArray.insert(11);
		oArray.insert(13);
		oArray.insert(66);
		oArray.insert(77);
		oArray.insert(88);
		oArray.insert(44);
		oArray.insert(33);
		oArray.insert(99);
		oArray.insert(100);
		oArray.insert(44);
		
		oArray.display();
		
		//search with binarySearch
		int elem2BeFound = 12;
		int indx = oArray.findByBinarySearch(elem2BeFound, false);
		System.out.println("->'"+ elem2BeFound +"' findByBinarySearch: at index[" + indx + ']');

		//searching element 35 (Linear)
		int[] elems = {35, 66};
		int indexFound = 0;
		for(int i : elems) {
			indexFound = oArray.find(i);
			if(indexFound != oArray.size()) {
				System.out.println("Element '" + i + "' found at index: [" + indexFound + ']');
			} else {
				System.out.println("Element '" + i + "' not found");
			}
		}
		oArray.display();
		System.out.println("For deletion: {00,44,100}");
		oArray.delete(00);
		oArray.delete(44);
		oArray.delete(100);

		oArray.display();

		//----------Misc part problems
		long [] uOrdArray = new long[] {2,0,4,5,66,8,99,1,6,10};		
		OrdArray oArray2 = new OrdArray(uOrdArray, uOrdArray.length);
		System.out.println("-->Before binarySearch init");
		oArray2.display();
		oArray2.binaryInsertionSort();
		System.out.println("<--After binarySearch sort");
		oArray2.display();
		
		int inRs = oArray2.findByBinarySearch(67, false);
		System.out.println("->'"+ 67 +"' findByBinarySearch: at index[" + inRs + ']');
		oArray2.binaryDeletionSort(19);		
		oArray2.display();
		
	}			
}

class OrdArray {
	private long [] a;
	private int nElems;

	public OrdArray(int size) {
		a = new long[size];
		nElems = 0;
	}

	public OrdArray(long [] a) {
		this.a = a;
	}

	public OrdArray(long [] a, int size) {
		this.a = a;
		nElems = size;
	}

	public int size() {
		return nElems;
	}

	/**
	* Binary Serch 
	* returns the index of element if it's found it, else return the array size
	*/
	public int find(long searchValue) {
		int lowebound = 0;
		int upperbound = nElems-1;
		int currIndex; //currentIndex
		while(true) {
			// it fails if the sum of low and high is greater than 
			// the maximum positive int value (2^31 - 1). 
			// The sum overflows to a negative value
			// and the value stays negative when divided by two
			// it throws ArrayIndexOutOfBoundsException.
			currIndex = (lowebound + upperbound ) / 2;

			if(a[currIndex] == searchValue) {
				return currIndex;
			} else if(lowebound > upperbound){
				return nElems; //element not found
			} else {
				if(a[currIndex] > searchValue) {
					upperbound = currIndex - 1; //its in lower half
				} else {
					lowebound = currIndex + 1; //its in upper half
				}
			}

		}
	}


	public int findByBinarySearch(long searchValue, boolean isInsert) {
		int lowebound = 0;
		int upperbound = nElems-1;
		if(isInsert) {
			return	binarySearch(lowebound, upperbound, searchValue);
		}
		return binarySearchNotInsert(lowebound, upperbound, searchValue);
	}

	/**
	* returns index position
	*/
	private int binarySearch(int low, int high, long key) {
		// System.out.println("low: " + low);
		// System.out.println("high: " + high);
		 // System.out.println("key: "+ key);
		int mid = low + ((high - low) / 2);		
		if(low > high) {			
			return low;
		} else if(a[mid] == key){			
			return mid;
		} else  {
			if(a[mid] > key) {
				return binarySearch(low, mid - 1, key);
			} else {
				return binarySearch(mid + 1, high, key);
			}
		}

	}
	/**
	* returns index position, posible with integration flag 
	*/
	private int binarySearchNotInsert(int low, int high, long key) {
		int mid = low + ((high - low) / 2);		
		if(low > high) {	
			System.out.println("No esta, not insert")		;
			return -1;
		} else if(a[mid] == key){			
			return mid;
		} else  {
			if(a[mid] > key) {
				return binarySearchNotInsert(low, mid - 1, key);
			} else {
				return binarySearchNotInsert(mid + 1, high, key);
			}
		}

	}

	//Linear insertion
	public void insert(long value) {
		int j;
		for(j=0; j<nElems; j ++) {
			if(a[j] > value) {
				break;
			}
		}
		for(int k = nElems; k > j; k--){
			a[k] = a[k-1];
		}
		a[j] = value;
		nElems++;
	}
	/**
	*	Binary insertion
	*/
	public void binaryInsertionSort(){
		// nElems = a.length;
		int ins, i, j;
		long tmp;
		
		for(i = 0; i < nElems; i++) {
			ins = binarySearch(0, i, a[i]);
			//System.out.println("Binary index: " + ins);
			if( ins < i) {
				tmp = a[i];
				for(j= i -1; j>=ins; j--) {
					a[j+1] = a[j];
				}
				a[ins] = tmp;
			}
		}		
	}
	/**
	*	Linear deletion
	*/
	public boolean delete(long value) {
		int j = find(value);
		if(j == nElems) {
			return false;
		} else {
			for(int k = j; k < nElems; k++) {
				a[k] = a[k+1];
			}
			nElems--;	
			return true;
		}
	}

	public boolean binaryDeletionSort(long value) {
		int index = findByBinarySearch(value, false);
		System.out.println(value + " index: " + index);
		if(index != -1 ) {
			for(int k = index; k < nElems-1; k ++) {
				a[k] = a[k + 1];
			}
			nElems--;
		return true;
		}
		System.out.println("Element not found");
		return false;
	}

	public void display() {
		for (int i = 0; i < nElems; i ++) {
			System.out.print(a[i]+ " ");
		}
		System.out.print("\n");
	}

	public static void displayAnArray(long[] a) {
		for (int i = 0; i < a.length; i ++) {
			System.out.print(a[i]+ " ");
		}
		System.out.print("\n");
	}
}






