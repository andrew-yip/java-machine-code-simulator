package cs340hw3;

import java.util.Arrays;
import java.util.Scanner;

public class simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Write a simulator program to simulate the 8 digit word machine with a 1000
		 * memory locations. That program should accept any machine language program of
		 * that machine and produce the required output.
		 * 
		 * Run the three machine language programs (written by you for the previous
		 * assignment or modified code) as input to this program and submit the inputs
		 * and outputs.
		 * 
		 * You may assume that the program gets loaded in memory location 0 onwards, and
		 * data may be stored anywhere from location 101 onwards.
		 */
		
		// DECLARATION OF VARIABLES

		// MEMORY LOCATIONS
		int [] memory_locations = new int [1000];
		
		// ADDRESS LOCATIONS
		int [] address = new int [1000];
		Arrays.fill(address, -1);
		int address_count = 100; // STARTING THE INDEX AT 100
		
		Scanner in = new Scanner(System.in);

		// INSTRUCTIONS & FORMULAS
		
		// OPCODES:
			// 10 = ADDITION
			// 11 = SUBTRACTION
			// 12 = MULTIPLICATION
			// 13 = DIVISION
			// 14 = INPUT
			// 15 =	COPY
			// 16 = OUTPUT
			// 17 = END
		
		// x^2 + 2y + 5, x = 2, y = 3, 2 is in 102, 5 is in 103
		// int [] operations = {14100000, 14101000, 14102000, 14103000, 12100100, 12102101, 10100102, 10100103, 16100000, 17000000}; 
		
		// (2x^2 + 7 - 1)^3, x = 1, 2 (coefficient), 7, 1, output = 512
		
		// int [] operations = {14200000, 14205000, 14210000, 14215000, 15200300, 12200205, 12200300, 10200210,11200215,15200400, 12200200, 12200400, 16200000, 17000000};
		
		// (x+y+z)^2, x = 1, y = 2, z = 3, output = 36
		 int [] operations = {14100000, 14200000, 14300000, 10100200, 10100300, 13100100, 16100000, 17000000};
		
		
		// populate the memory locations array
		for (int i = 0; i<operations.length; i++) {
			
			// the current 8 digit value that we're at in the array
			int current_value = operations[i];
			
			// the opcode value
			int opcode = current_value/1000000; // gets you the opcode
			//System.out.println("opcode: " + opcode);
			
			// the first operand
			int operand1 = (current_value% 1000000)/1000; 
			
			// the second operand
			int operand2 = current_value % 1000; // last three digits
			
			// fill address
			address[address_count++] = current_value;
			
			// fill memory location array
			switch (opcode) {
			case 10:
				// addition operation
				memory_locations[operand1] = memory_locations[operand1]+memory_locations[operand2];
				break;
			case 11:
				// subtraction operation
				memory_locations[operand1] = memory_locations[operand1]-memory_locations[operand2];
				break;
			case 12:
				// multiplication operation
				memory_locations[operand1] = memory_locations[operand1]*memory_locations[operand2];
				break;
			case 13:
				// division operation
				memory_locations[operand1] = memory_locations[operand1]*memory_locations[operand2];
				break;
			case 14:
				// input operation
				System.out.println("The opcode value is 14 which is input. Please input your value into memory location " + operand1 + "?");
				memory_locations[operand1] = in.nextInt();
				System.out.println("You just placed " + memory_locations[operand1] + " in memory location " + operand1);
				break;
			case 15:
				// copy operation
				System.out.println("copy");
				memory_locations[operand2] = memory_locations[operand1];
				break;
			case 16:
				// output operation
				System.out.println("Output: " + memory_locations[operand1]);
				break;
			case 17:
				// end program
				System.out.println("END PROGRAM");
				break;
			}
			
			if (opcode == 17) break;
			
		}
		
		
	}

}
