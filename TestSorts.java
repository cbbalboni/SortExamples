import java.util.Random;



public class TestSorts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] numbers = {713,131,312,124,245,457,572,724,243,437};
		//int[] insertReturn = TestSorts.insertionSort(numbers);
		//int[] selectReturn = TestSorts.selectSort(numbers);
		//int[] mergeSortReturn = TestSorts.mergeSort(numbers,0,8);
		
		/*
		for(int j = 0; j < insertReturn.length; ++j) {
	        System.out.println(insertReturn[j]);
	    }
		for(int a = 0; a < insertReturn.length; ++a) {
	        System.out.println(selectReturn[a]);
	    }
		for(int a = 0; a < insertReturn.length; ++a) {
	        System.out.println(selectReturn[a]);
	    }
	    
		for(int a = 0; a < mergeSortReturn.length; ++a) {
	        System.out.println(selectReturn[a]);
	    }*/
		//TestSorts.quickSort(numbers,0,numbers.length-1);
		TestSorts.Radixsort(numbers);
		for(int a = 0; a < numbers.length; ++a) {
	        //System.out.println(numbers[a]);
		}
		
		


	}
	//Oh = O(n)
	public static int[] insertionSort(int[] list){
		int j,key,temp;
		for (int i = 1; i < list.length; i++) {
			key=list[i]; //sempre começa com 1 porque a validação é da direita para esq.
			j=i-1; //numero do elemento logo a esquerda 
				while(j>-1 && key<list[j]){ //essa é a magica o mais a esquerda ser menor que o elemento
					temp = list[j]; //variavel logo a esquerda
					list[j]=list[j+1];
					list[j+1]=temp; 
					j--; //garante o anterior a esquerda 
				}
			
		}
		return list;
	}
	//Oh = O(n^2)
	public static int[] selectSort(int[] list){
		int minValue,minIndex,temp = 0;
		
		for (int i = 0; i < list.length; i++) {
			minValue = list[i];
			minIndex = i;
			for (int k = 0; k < list.length; k++) {
				if(list[k]>minValue){ //> descending, < ascending 
					minValue = list[k];
					minIndex=k;
				}
				if(minValue>list[i]){ //> descending, < ascending 
					//swap
					temp=list[i];
					list[i]=list[minIndex];
					list[minIndex]=temp;
				}
			}			
		}		
		return list;
	}
	//Oh = O(nlogn)
	public static int[] mergeSort(int[] list, int lowIndex, int highIndex){
		if(lowIndex!=highIndex) {
			int midIndex = (lowIndex+highIndex)/2;
			mergeSort(list,lowIndex,midIndex);
			mergeSort(list,midIndex+1,highIndex);
			return merge(list,lowIndex,midIndex+1,highIndex);
			
		}
		return null;
	}
	public static int[] merge(int[] list, int lowIndex, int midIndex, int highIndex) {
		int[] L = new int[midIndex - lowIndex + 2];
		
		for (int i = lowIndex; i <= midIndex; i++) {
			L[i - lowIndex] = list[i];
		}
		L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
		int[] R = new int[highIndex - midIndex + 1];
		
		for (int i = midIndex + 1; i <= highIndex; i++) {
			R[i - midIndex - 1] = list[i];
		}
		R[highIndex - midIndex] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		
		for (int k = lowIndex; k <= highIndex; k++) {
			if (L[i] <= R[j]) {
				list[k] = L[i];
				i++;
			}
			else {
				list[k] = R[j];
				j++;
			}
		} 
		return list;
	}
	//Oh = O(nlogn)
	public static void quickSort(int[] list, int lowIndex, int highIndex){
		if(lowIndex<highIndex+1) {
			int p = partition(list,lowIndex,highIndex);
			quickSort(list,lowIndex,p-1);
			quickSort(list,p+1,highIndex);			
			
		}
	}
	public static int partition(int[] list, int lowIndex, int highIndex){
		swap(list,lowIndex,getPivot(lowIndex,highIndex));
		int border = lowIndex+1;
		for (int i=border; i <= highIndex; i++) {
			if(list[i]<list[lowIndex]){
				swap(list,i,border++);
				
			}			
		}
		swap(list,lowIndex,border-1);
		return border-1;
		
	}
	public static int getPivot( int lowIndex, int highIndex){
		Random rand = new Random();
		return rand.nextInt(((highIndex-lowIndex)+1))+lowIndex;
	}
	public static void swap(int[] list, int lowIndex, int highIndex){
		int temp = list[lowIndex];
		list[lowIndex]=list[highIndex];
		list[highIndex]=temp;		
	}
	/** Radix Sort function **/
    public static void Radixsort( int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[n];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        
        //System.out.println(m);
      
        while (m / exp > 0)
        {
        	//System.out.println(exp);
        	
        	int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++){
            	a[i] = b[i];
            	System.out.println(a[i]);
            }
            System.out.println("=============");    
            exp *= 10;        
        }
    }    
	
}
