
public class TesteExcercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = {3,9,9};
		int[] newNumbers = TesteExcercise.sumInArray(numbers);
		
		for (int i = 0; i < newNumbers.length; i++) {
			System.out.println(newNumbers[i]);
			
		}

	}
	public static int[] sumInArray(int[] numbers){
		int lastIndex = numbers.length-1;	
		int arraySize = numbers.length;
		int tempNumber = 0;
		
		if(numbers[lastIndex]!=9){
			tempNumber=numbers[lastIndex]+1;
			numbers[lastIndex] = tempNumber;
			
		} else {			
			if(arraySize>1){
				numbers[lastIndex-1]=numbers[lastIndex-1]+1;
				numbers[lastIndex] = tempNumber;
			} else {
				int[] newOrder = new int[arraySize+1];
				newOrder[0] = 1;
				int newOrderIndex=1;
				for (int i = 0; i < numbers.length; i++) {
					newOrder[newOrderIndex]=numbers[i];
					newOrderIndex++;
				}
				return newOrder;
			}
		}
		
		return numbers;
		
	}
                             
}
