package lab11;
import lab11.polynomial;
import lab11.commandAnalyse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	//ex.2xy^2*abc +	34p^1*d*q*u^2 - 24	d^7*i^7*o
	public static void main(String []args) throws IOException{ 	
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		commandAnalyse Analyse = new commandAnalyse();
		String str = "";
		
		polynomial root = new polynomial();
		do{	
			System.out.print("> ");
			str = br.readLine();

			if(Analyse.Type(str) == 1){
				if(str.equals("!simplify")){
					System.out.println(root.display());	
				}
				else {
					root = root.simplify(str,root);
					System.out.println(root.display());	
				}
			}
			else if(Analyse.Type(str) == 2){
				if(str.equals("!d/d")){	
					System.out.println("Error input!");
				}
				else{
					root = root.diff(str,root);
					System.out.println(root.display());
				}
			}
			else if (Analyse.Type(str) == 0){
				str = Analyse.Format(str);
				root = root.expression(str);
				System.out.println(root.display());
			}
			else{
				System.out.println("Command Type Invaild!!!");
			}
		}while(!str.equals("quit"));
			
		return;
	}
}
