package king.com;

	public class RecursiveCalculate {
		
	/********* head recursion start call ***********
	public static void main(String arg[]) {
		RecursiveCalculate rec = new RecursiveCalculate();
		try {
		rec.startRoutine(new int[4]);
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Fine sabutin");
		}
	}
	************************************************/
		
	/********* tail recursion start call **************/
	public static void main(String arg[]) {
		RecursiveCalculate rec = new RecursiveCalculate();
		for (int i=3; i >=0; i--)
			rec.startRoutine(new int[4], i, i);
	}
	/**************************************************/
	
	/***************** tail recursion *******************/
	public void startRoutine(int[] arr, int i, int j) {
		if (i >= j) {
			i = setpivot(arr, i);
			startRoutine(arr, i, j);
		}
	}
	public int setpivot(int arr[], int i) {
		arr[i] = 1;
		stampa(arr);
		i = setvalue(arr);
		return i;
	}
	public int setvalue(int arr[]) {
		int i = arr.length - 1;
		if (arr[i] == 1) {
			i = reset(arr, i);
		}
		return i;
	}
	public int reset(int[] arr, int i) {
		if (i >= 0 && arr[i] == 1) {
			arr[i] = 0;
			return reset(arr,--i);
		} else return i;
	}
	/**********************************************/
	
	/***************** head recursion *******************
	public void startRoutine(int[] arr) {
		int i = arr.length - 1;
		stampa(arr);
		setpivot(arr,i);
	}
	public void setpivot(int arr[], int i) {
		arr[i] = 1;
		stampa(arr);
		setvalue(arr,i);
	}
	public void setvalue(int arr[], int i) {
		if (i < (arr.length - 1)) setvalue(arr,++i);
		else if (arr[i] == 1) {
			reset(arr,i);
		} else {
			setpivot(arr,i);
		}
	}
	public void reset(int[] arr, int i) throws ArrayIndexOutOfBoundsException {
		if (arr[i] == 1) {
			arr[i] = 0;
			reset(arr,--i);
		} else {
			setpivot(arr,i);
		}
	}
	**********************************************/
	
	
	
	public void stampa(int[] arr) {
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		} System.out.println();
	}




}
