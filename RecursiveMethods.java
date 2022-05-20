/**
 *  Program 6
 *  Creates an object with recursive methods that each have different functions
 *  CS108-3
 *  4/17/22
 *  @author  Logan Wolff
  */

public class RecursiveMethods {
	   public static void main(String[] args) {
		      RecursiveMethods p6 = new RecursiveMethods();
		      System.out.println(p6.byLeapsAndBounds(5));
		      System.out.println(p6.subCount("treetreetreebeartree", "tree"));
		   }
	   
			public static String getIdentificationString() {
	 		//returns the number and author of the program
	 		String author = "Logan Wolff";
	 		String programNum = "6";
			return "Program " + programNum + ", " + author;
			}	
			
			/*
			 * This function takes only one parameter n. Suppose that an object on a grid 
			must move forward n spaces. Each move forward can be either 1 space (a leap) or 
			2 spaces (a bound). The function shall return the total distinct ways in which 
			the object can advance the required n spaces. This function assumes n is a positive
			integer > 0.
			*/
		   public int byLeapsAndBounds(int n) {
			     //base case return values
			     if(n == 0 || n == 1) {
			         return 1;
			     }
			     
			     //initializes a count variable to keep track of possibilities 
			     int count = byLeapsAndBounds(n - 1) + byLeapsAndBounds(n - 2);
			     // returns count after collecting possibilities
			     return count;
		   }
		   
		   /*
		    * A recursive function int subCount (String str, String subStr).
		    *  This function takes two Strings as parameters - str and subStr. This
		    *   function shall return the number of times subStr occurs within str.
		    *    If subStr is not present within str, return 0.
		    */
		   public int subCount(String str, String subStr) {
				   //the substring would not occur if it is greater than the string length
				  if(subStr.length() > str.length()){
				       return 0;
				   }
				    
				  //check the start of the string
				   boolean found = true;
				   for(int i = 0; i < subStr.length(); i++){
				      if(str.charAt(i) != subStr.charAt(i)){
				          found = false;
				          break;
				      }
				   }
				     //if the substring is found, call the method again after the found substring
				     if(found == true){
				         return 1 + subCount(str.substring(1), subStr);
				     }else{
				         return subCount(str.substring(1), subStr);
				     }
		   }
		   
		   /*
		    * A recursive function int binarySearch(int[]array, int target, int left, int right).
		    * The function takes four parameters: a sorted int array (with no duplicates), a target
		    * number, left index, and right index. The sorted int array contains either no elements
		    * (empty), or only positive integers, with each integer appear only once.
		    * Binary search is used to locate the index of target. The left index and right index
		    * are  for convenience when using recursion. Returns -1 if target is not found.
		    * It is assumed that the first input of int left and int right will
		    * always be 0 and array.length-1, respectively.
		   */
		   
		   public int binarySearch(int[]array, int target, int left, int right) {
		       //if the left index is greater than the right, the search can not occur
		       if(left > right){
		           return -1;
		       }
		       
		       //finds the middle of array with given indexes
		       int mid = (left + right) / 2;
		      
		       if(array[mid] == target){
		           return mid;
		       }
		       
		       //if the target is greater than the current index, the target might be to the right in the array
		       else if(array[mid] < target){
		           return binarySearch(array, target, mid + 1, right);
		       }
		       // if current element is greater than target, then target may be to the left in the array
		       else{
		           return binarySearch(array, target, left, mid - 1);
		       }
		   }
		   
}
