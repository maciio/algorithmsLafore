import java.util.Random;
//Demostrate low-level interface
public class LowArrayApp {
	public static void main(String[] args) {
		LowArray array = new LowArray(100);
		int nElem = 10;
		array.setElem(0, 77);
		array.setElem(1, 99);
		array.setElem(2, 44);
		array.setElem(3, 55);
		array.setElem(4, 22);
		array.setElem(5, 88);
		array.setElem(6, 11);
		array.setElem(7, 00);
		array.setElem(8, 66); 
		array.setElem(9, 33);

		for(int j=0; j< nElem; j++) {
			System.out.print(array.getElem(j) + " ");
		}
		System.out.print("\n");

		//Search for element, it's supposed no repetion allowed
		int searchKey = new Random().nextInt(100);
		int indexFounded = -1;
		System.out.println("Elem to Search: " + searchKey);
		for(int j=0; j< nElem; j++) {
			if(array.getElem(j) == searchKey) {
				indexFounded = j;
				break;
			}
		}
		if(indexFounded < 0){
			System.out.println("Element not found");
		} else {
			System.out.println("Element founded at index: " + indexFounded);
		}

		//Deletion item i.e. 55
		for (int j=0; j<nElem; j++ ) {
			if(array.getElem(j) == 55){
				System.out.println("55 founded at index: " + j);
				for(int k = j; k < nElem; k++) {
					array.setElem(k, array.getElem(k+1));
				}		
			}				
		}
		nElem--;
		//Display array after deletion
		for(int j=0; j< nElem; j++) {
			System.out.print( array.getElem(j) + " ");
		}
	}
}

// array as class
class LowArray {	

	private long[] a;

	public LowArray(int size) {
		a = new long[size];
	}

	public void setElem(int index, long value) {
		a[index] = value;
	}

	public long getElem(int index) {
		return a[index];
	}
}