//10.22 As well as implementing the MyString1 class, 
//provide a test main method in the main class MyStringTest 
//that demonstrates the use of your class and its methods.

public class MyStringTest {
	public static void main(String[] args){
		char[] chars = {'A','E','l','L','o'};
		
		MyString1 myString1 = new MyString1(chars);
		MyString1 myString2 = new MyString1(chars);
		// character at index
		System.out.println("char at index 0 = " + myString1.charAt(0));
		// length of string
		System.out.println("length of myString1 = "+ myString1.length());
		// substring
		System.out.println("substring(0,2) " +  myString1.substring(0, 2));
		//toLowerCase
		System.out.println("To lower case " + myString1.toLowerCase());
		// equals method
		System.out.println("equals methos : " + myString1.equals(myString2));
		// value of an integer
		System.out.println("value of an integer to String : "+ MyString1.valueOf(1234));
	}
	
}
class MyString1{
	private char[] chars;
	public MyString1(char[] chars) {
		 this.chars = new char[chars.length];
	        for (int i = 0; i < chars.length; i++)
	            this.chars[i] = chars[i];
	}
	public char charAt(int index){
		return this.chars[index];
		
	}
	public int length(){
		return this.chars.length;
		
	}
	public MyString1 substring(int begin, int end){
		char[] subString = new char[end - begin];
		for(int i = begin; i < end; i++){
			subString[i-begin] = chars[i];
		}
		return (new MyString1(subString));
		
	}
	public MyString1 toLowerCase(){
		// a = 97, A = 65
		char[] lowerChars = new char[this.length()];
		for(int i = 0; i < length();i++){
			if(chars[i] < 97){
				lowerChars[i] = (char) (chars[i] + (97-65));
			}else{
				lowerChars[i] = chars[i];
			}
		}
		return new MyString1(lowerChars);
		
	}
	public boolean equals(MyString1 s){
		boolean equal = true;
		for(int i = 0; i < this.length(); i++){
			if(this.chars[i] != s.charAt(i)){
				equal = false;
			}
		}		
		return equal;		
	}
	public static MyString1 valueOf(int i){
		//checking length of number i
		int count = 0, j = i;
		while(j > 0){
			j = j/10;
			count++;	
			//System.out.println("count " +  count+". j = " + j );
		}
		// initiating char value
		char[] value = new char[count];
		
		for(int k = count - 1; k >= 0; k--){
			value[k] = (char)('0' + (i%10));
			i/=10;
			//System.out.println("value " +  value[k]+". i = " + i );
		}
		return new MyString1(value);
	}
	public String toString(){
		return new String(chars);
	}
}
