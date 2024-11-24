import java.util.*;

public class CRC {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the binary dataWord: ");
		String dataWord = sc.nextLine();
		
		System.out.print("Enter the binary divisor: ");
		String divisor = sc.nextLine();
		
		String remainder = calculate(dataWord, divisor);
		
		System.out.println("CRC: "+remainder);	
		String NoError = "0".repeat(divisor.length()-1);

		if(remainder.equals(NoError)) 
			System.out.println("The dataWord has no error"+dataWord);
		else 
			System.out.println("The encoded dataWord is "+dataWord+remainder);
	}
	
	static String calculate(String dataWord, String divisor) {
		String dividend = dataWord+"0".repeat(divisor.length()-1);
		StringBuilder dividendBuilder = new StringBuilder(dividend);
		
		for(int i=0; i<=dividend.length()-divisor.length(); i++) {
			if(dividendBuilder.charAt(i) == '1') {
				for(int j=0; j<divisor.length(); j++) {
					dividendBuilder.setCharAt(i+j, (dividendBuilder.charAt(i+j) == (divisor.charAt(j))?'0':'1'));
				}
			}
		}
		return dividendBuilder.substring(dividendBuilder.length() - divisor.length() + 1);
	}
}
