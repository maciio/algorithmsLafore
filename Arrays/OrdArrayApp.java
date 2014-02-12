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
		
		//search with Alternative 99

		int indx = oArray.findV2(7);
		System.out.println("->>>>>: " + indx);

		//searching element 35
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
		oArray.delete(00);
		oArray.delete(44);
		oArray.delete(99);

		oArray.display();
	}			
}

class OrdArray {
	private long [] a;
	private int nElems;

	public OrdArray(int size) {
		a = new long[size];
		nElems = 0;
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
			// the maximum positive int value (231 - 1). 
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

	public int findV2(long searchValue) {
		int lowebound = 0;
		int upperbound = nElems-1;
		return binarySearch(lowebound, upperbound, searchValue);
	}

	private int binarySearch(int low, int high, long key) {
		int mid = low + ((high - low) / 2);
		if(a[mid] == key){
			return mid;
		} else if(low > high) {
			return low;
		} else  {
			if(a[mid] > key) {
				return binarySearch(low, mid - 1, key);
			} else {
				return binarySearch(mid + 1, high, key);
			}
		}

	}

	//ingresa en orden natural
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

	public void binaryInsertionSort(long value){

	}

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

	public void display() {
		for (int i = 0; i < nElems; i ++) {
			System.out.print(a[i]+ " ");
		}
		System.out.print("\n");
	}
}






