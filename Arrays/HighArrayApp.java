class HighArrayApp {
	public static void main(String[] args) {
		HighArray highArray = new HighArray(100);
		highArray.insert(77);
		highArray.insert(66);
		highArray.insert(55);
		highArray.insert(44);
		highArray.insert(33);
		highArray.insert(22);
		highArray.insert(11);
		highArray.insert(0);
		highArray.insert(9);
		highArray.insert(88);
		highArray.insert(67);
		highArray.insert(4);
		highArray.insert(45);
		highArray.insert(21);

		highArray.display();

		//searching element
		long serchVal = 33;
		if(highArray.isElemContained(serchVal)){
			System.out.println("Found it: " + serchVal);
		} else {
			System.out.println("Not Found it");
		}
		System.out.println("Max element: " + highArray.getMax());
		System.out.println("Poll Max element: " + highArray.pollMax());
		highArray.display();
		
		System.out.println("Elements to delete: {0,55,77}");
		highArray.delete(0);
		highArray.delete(55);	
		highArray.delete(77);

		highArray.display();
	}
}

class HighArray {
	
	private long[] a; // ref to array a
	private int nElems; // number of data items 
	
	public HighArray(int max) {
		a = new long[max]; 
		nElems = 0;
	}

	//Linear search
	public boolean isElemContained(long searchKey) {		
		for(int j=0; j<nElems; j++) {
			if(a[j] == searchKey) {
				return true;
			}
		}
		return false;
	}
		
	public void insert(long value) {
		a[nElems] = value; 
		nElems++;
	}
	public boolean delete(long elem) {		
		for(int j = 0; j < nElems; j++){
			if( elem == a[j] ) {
				for (int k = j; k < nElems; k++) {
					a[k] = a[k+1];	
				}		
				nElems--; 
				return true;
			}
		}
		return false;
	}
		
	public void display() {
		for(int j = 0; j < nElems; j++){
			System.out.print(a[j] + " ");
		} 
			System.out.print("\n");			
	}	

	public long getMax() {
		if(a.length == 0) {
			return -1;
		}
		long max = a[0];
		for(int i = 0; i <nElems; i++) {
			if(max < a[i + 1]) {
				max = a[i + 1];
			} 
		}
		return max;
	}		

	public long pollMax() {		
		long max = getMax();
		for(int i = 0 ; i < nElems; i++) {
			if(a[i] == max){
				a[i] = a[i + 1];
			}
		}
		nElems--;
		return max;
	}		
} 



