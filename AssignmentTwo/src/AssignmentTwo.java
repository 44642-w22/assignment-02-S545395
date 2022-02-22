import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AssignmentTwo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//Question 1
		
		System.out.print("For Question 1, please enter no of elements for array: ");
		int size = input.nextInt(); String [] inputArray =
		populateInputStringArray(new String[size], input); getFrequency(inputArray);

		// Question 2
		System.out.print("For Question 2, please enter no of elements for array: ");
		int size2 = input.nextInt();
		String[] inputArray2 = populateInputStringArray(new String[size2], input);
		System.out.println("{" + concatStartsWithFirstLetter(inputArray2).keySet().stream()
				.map(k -> "\"" + k + "\"" + ":" + "\"" + concatStartsWithFirstLetter(inputArray2).get(k) + "\"")
				.collect(Collectors.joining(", ")) + "}");

		// Question 3
		System.out.print("For Question 3, please enter no of elements for list: ");
		ArrayList<Integer> inputIntList = populateInputIntArrayList(new ArrayList<Integer>(), input);
		updateDuplicateVal(inputIntList); 
		
		//Question 4
		System.out.print("For Question 4, please enter no of elements for list: ");
		ArrayList<String> inputList = populateInputArrayList(new ArrayList<String>(), input);
		ArrayList<String> outputList =  removeDuplicateInVal(inputList);
		int counter = 0;
		System.out.print("[");
		for (String string : outputList) {
			counter++;
			if(counter==outputList.size())
				System.out.print("\""+string+"\"");
			else
				System.out.print("\""+string+"\""+", ");
		}
		System.out.println("]");
		
		//Question 5
		System.out.print("For Question 5, please enter no of elements for list: ");
		ArrayList<String> inputList2 = populateInputArrayList(new ArrayList<String>(), input);
		Map<String, String> outputMap1= mapBothExtremeChars(inputList2);
		System.out.println("{"+outputMap1.keySet().stream().map(k-> "\""+k+"\""+ ":"+"\"" + outputMap1.get(k)+"\"").collect(Collectors.joining(", "))+"}");
		
		//Question 6
		System.out.print("For Question 6, please enter no of elements for list: ");
		ArrayList<String> inputList3 = populateInputArrayList(new ArrayList<String>(), input);
		Map<String, Boolean> outputMap= checkRepeatation(inputList3);
		System.out.println("["+outputMap.keySet().stream().map(k-> "\""+k+"\""+ ":"+ outputMap.get(k)).collect(Collectors.joining(", "))+"]");
		
	}

		//Question 1
		private static void getFrequency(String[] inputArray) {
	
				Map<String, Integer> frequencyMap = new LinkedHashMap<String,Integer>();
					 
			    for(String val: inputArray) {
			       Integer i = frequencyMap.get(val);
			       if (i ==  null) {
			           i = 0;
			       }
			       frequencyMap.put(val, ++i);
			    } 
					
				System.out.println(frequencyMap.keySet().stream().map(k-> k+ "-" + frequencyMap.get(k)).collect(Collectors.joining(", ")));
			
			
		}
		
		//Question 2
		private static Map<String,String> concatStartsWithFirstLetter(String[] inputArray) {
			
			Map<String, String> outputMap = new LinkedHashMap<String,String>();
			String finalCharVal="";
			
			for(String val: inputArray) {
				String firstChar =val.charAt(0)+"";
				finalCharVal=outputMap.get(firstChar)==null?val:outputMap.get(firstChar);
				if(outputMap.containsKey(firstChar)) {
					finalCharVal+=val;
				}
				
				outputMap.put(firstChar, finalCharVal);
			} 
			return outputMap;
		}
		
		//Question 3
		public static void updateDuplicateVal(ArrayList<Integer> inputList) {
			
			Set<Integer> outputSet = new LinkedHashSet<Integer>();
		
			int counter = 0;
			for (Integer integer : inputList) {
				counter++;
				int val=-1;
				for(int i= 0;i<counter;i++) {
						
					if( inputList.get(i) == integer) {
						val++;
					}
				}
				
				outputSet.add(integer+val);
			}	
			
			System.out.println(outputSet);
		}
		
		
		//Question 4
		public static ArrayList<String> removeDuplicateInVal(ArrayList<String> inputList) {
			
			  ArrayList<String> outputList = new ArrayList<String>();
	          
	          for (int i=0;i<inputList.size();i++){
	         	 String text = "";
	         	 
	         	 for(char ch: inputList.get(i).toCharArray()){
	         		 if(text.contains(Character.toString(ch))==false)
	         			 text+=ch;
	         	 }
	         	 outputList.add(text.toString());
	          }
	
			
			return outputList;
		}
		
		//Question 5
		public static Map<String,String> mapBothExtremeChars(ArrayList<String> inputList){
	
			Map<String,String> outputList = new LinkedHashMap<String,String>();
			for (String str : inputList) {
				outputList.put(Character.toString(str.charAt(0)), Character.toString(str.charAt(str.length()-1)));
			}
			
			return outputList;
		}
		
		//Question 6
		public static Map <String,Boolean> checkRepeatation(ArrayList<String> inputList){
			Map<String,Boolean> outputMap = new LinkedHashMap<String,Boolean>();
			
			for (int i=0;i<inputList.size();i++) {
				if(outputMap.containsKey(inputList.get(i)))
					outputMap.put(inputList.get(i), true);
				else
					outputMap.put(inputList.get(i), false);
					
			}
			
			return outputMap;
		}
		
		//Fill String Array
		private static String[] populateInputStringArray(String[] inputArray,Scanner input) {
			for (int i = 0; i < inputArray.length; i++) {
				
				System.out.print("Enter the value at index "+ i +" is: ");
				inputArray[i] = input.next();
				
			}
			
			return inputArray;
		}
		
		//Fill Array List
			private static ArrayList<String> populateInputArrayList(ArrayList<String> inputList,Scanner input) {
	
				int size = input.nextInt(); 
	
				for (int i = 0; i < size; i++) {
					
					System.out.print("Enter the value at index "+ i +" is: ");
					inputList.add(input.next()); 
					
				}
				
				return inputList;
			}
	
			//Fill Array List
			private static ArrayList<Integer> populateInputIntArrayList(ArrayList<Integer> inputList, Scanner input) {
	
				int size = input.nextInt(); 
				
				for (int i = 0; i < size; i++) {
	
					System.out.print("Enter the value at index " + i + " is: ");
					inputList.add(input.nextInt());
	
				}
	
				return inputList;
			}

}
