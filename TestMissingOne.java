
public class TestMissingOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,3,5,6,4,8,9};
		TestMissingOne.missingOne(numbers);

	}
	public static int missingOne(int[] numbers){
		int counter = 0;
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]); 
		}		
		return 0;
	}

}
