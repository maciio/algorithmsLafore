class HighArray {
	private long[] a; // ref to array a
	private int nElems; // number of data items //-----------------------------------------------------------
	
	public HighArray(int max) {
		a = new long[max]; nElems = 0;
	}

	public boolean find(long searchKey) {		
		for(int j=0; j<nElems; j++) {
			if(a[j] == searchKey) {
				return true;
			}
		}
	}
		
	public void insert(long value) {
		a[nElems] = value; 
		nElems++;
	}
	public boolean delete(long value) {
		for(int j=0; j<nElems; j++){
			if( value == a[j] ){
				
			}
		}
			
		if(j==nElems) return false;
		else {
		for(int k=j; k<nElems; k++) a[k] = a[k+1];
		nElems--; return true; }
		// look for it
		// can’t find it
		// found it
		// move higher ones down // decrement size
		} // end delete() //----------------------------------------------------------- public void display() // displays array contents
		{
		for(int j=0; j<nElems; j++) // for each element,
		System.out.print(a[j] + “ “); // display it System.out.println(“”);
		}
		//-----------------------------------------------------------
		} // end class HighArray