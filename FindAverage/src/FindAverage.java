import java.util.ArrayList;
import java.util.Scanner;

public class FindAverage {


	Scanner input = new Scanner(System.in);
	ArrayList<Integer> numberList = new ArrayList<>();
	private int firstNumber, secondNumber, thirdNumber;
	private double average;


	//CONSTRUCTOR
	public FindAverage() {
		numberList = new ArrayList<>();
	}

	//GETTING INPUT FROM THE USER

	public void getInput() {

		System.out.println("Enter first number: ");

		int firstNumber = input.nextInt();
		numberList.add(firstNumber);

		System.out.println("Enter the second number: ");

		int secondNumber = input.nextInt();
		numberList.add(secondNumber);

		System.out.println("Enter the third number: ");

		int thirdNumber = input.nextInt();
		numberList.add(thirdNumber);


		int sum = firstNumber + secondNumber + thirdNumber;

		System.out.println("The sum of all numbers you introduced is: " + sum);

		System.out.println("---------------------------------------------");

		System.out.println("Introduce a number to divide the sum with it: ");

		double divider = input.nextInt();

		getAverage(divider, sum);

		input.close();

	}

	//GETTING THE ELEMENTS IN THE LIST

	public void getAllListOfIntegers () {
		System.out.println("The numbers you chose: " + numberList);
	}

	public void getAverage(double divider, int sum) {

		average = sum / divider;
		System.out.println("The average of the numbers is: "+  average);

	}

	//PROPERTY GETTERS; 

	public int getFirstNumber() {
		return firstNumber;
	}


	public int getSecondNumber() {
		return secondNumber;
	}


	public int getThirdNumber() {
		return thirdNumber;
	}


}