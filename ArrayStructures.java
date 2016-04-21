package googletest;

public class ArrayStructures {
	
	private int[] myArray = new int[50];
	
	private int asize = 10;
	// want array table, print index and values
	public void generateRandomArray(){
		for(int i=0; i<asize; i++){
			myArray[i]=(int)(Math.random()*10)+10;
			
		}
		
	}
	public void printArray(){
			
			for(int i=0; i<asize;i++){
			System.out.println(i+"\t"+myArray[i]);
		}
	}
	
	//how to access or get an array value
	
	public int getValueAtIndex(int index){
		System.out.println("in get value");
		if(index<asize){
			return myArray[index];
		}
		return 0;
		
	}
	
	//check if array has a value
	public boolean containValue(int val)
	{
		for(int i=0; i<asize; i++){
			if(myArray[i]==val){
				return true;
			}
		}
		return false;
	}	
	//deleting an index and then moving all the values up
	public void deleteIndex(int index){
		if (index<asize)
		{
			//asize-1 coz 1 element will be will be deleted now
			for(int i=index; i<(asize-1); i++)
			{
				//move the values up
				myArray[i]=myArray[i+1];
			}
			asize--;
		}
	}
	
	//insert value at the end of an array
	public void insertValue(int value)
	{
		if(asize<50)
		{
			myArray[asize]=value;
			asize++;
		}
	}
	
	//linear search - look at every indexed value in the entire array , it is better when u have to find all matches 
	//Eg: 11, 18, 11 all matches of 11 are index 0 and 2 , For 1 match binary search is best
	
	public String linearSearch(int search)
	{
		boolean valueInArray=false;
		
		String foundAtIndex ="";
		for(int i=0;i<asize;i++)
		{
			if(myArray[i]==search)
			{
				valueInArray=true;
				System.out.println("Value found at"+ i+"");
				foundAtIndex+=i+"";
			}
					
		}
		if(!valueInArray){
			foundAtIndex="Not found";
		}
		return foundAtIndex;
	}
	//Binary search is quicker than linear search 
	
	//Bubble sort -sorts in asc or desc , start by comparing consequitive element, if 1st is largest then 2nd swap it continue until largest ele bubbles up at the end(repeat)
	//slower method comparisons =(n-1)+(n-2)...+1 = n(n-1)/2 does 0(n^2)
	public void bubblesort(){
		//asize-1 coz index starts with 0
		//i loop is for the largest element at the end of the array
		for(int i = asize-1; i>1; i--){
			//comparison
			for(int j=0; j<i; j++){
				//if desc change > to <
				if(myArray[j]>myArray[j+1])
				{
					swapValues(j,j+1);
				}
			}
		}
	}
	public void swapValues(int a, int b)
	{
		int t= myArray[a];
		myArray[a]=myArray[b];
		myArray[b]=t;
	}
	public static void main(String[] args){
		
		ArrayStructures as = new ArrayStructures();
		
		as.generateRandomArray();
		
		as.printArray();
		
		System.out.println(as.getValueAtIndex(3));
		
		System.out.println(as.containValue(10));
		
		as.deleteIndex(2);
		
		as.printArray();
		
		as.insertValue(300);
		
		as.printArray();
		
		System.out.println(as.linearSearch(11));
		System.out.println(as.linearSearch(500));
		
		as.bubblesort();
		
		as.printArray();
		
	}

}
