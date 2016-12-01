package lab11;

public class stringMethod {
	
	 public boolean Isletter(char a)
	 {
		 if ((a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z')) 
			 return true;
		 else 
			 return false;
	 }

	 public String GetVarStr(String input, int i)
	 {
		 int j = i + 1;
		 for (;j < input.length() && Isletter(input.charAt(j)); j++);
		 return input.substring(i,j);
	 }
}
