package lab11;
import lab11.polynomial;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	//ex.2xy^2*abc +	34p^1*d*q*u^2 - 24	d^7*i^7*o
<<<<<<< HEAD
	public static void main(String []args) throws IOException{ 	
=======
	public static void main(String []args) throws IOException{
>>>>>>> origin/mynew
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String str = "";
		String str_simplify = "!simplify";
		String str_diff = "!d/d";
		Pattern p_simplify = Pattern.compile(str_simplify);
		Pattern p_diff = Pattern.compile(str_diff);
		polynomial root = new polynomial();
<<<<<<< HEAD
		do{	
=======
		do{
>>>>>>> origin/mynew
			System.out.print("> ");
			str = br.readLine();
			Matcher m_simplify = p_simplify.matcher(str);
			Matcher m_diff = p_diff.matcher(str);
			if(m_simplify.find()){
				if(str.equals("!simplify")){
<<<<<<< HEAD
					root.display();	
=======
					root.display();
>>>>>>> origin/mynew
					System.out.println("");
				}
				else {
					root = root.simplify(str,root);
<<<<<<< HEAD
					root.display();	
=======
					root.display();
>>>>>>> origin/mynew
					System.out.println("");
				}

			}
			else if(m_diff.find()){
<<<<<<< HEAD
				if(str.equals("!d/d")){	
					System.out.println("Error input!");
=======
				if(str.equals("!d/d")){
                    System.out.println("22222222222");
					System.out.println("Error input!!!!!!!!!");
>>>>>>> origin/mynew
				}
				else
				{
					root = root.diff(str,root);
					root.display();
					System.out.println("");
				}
			}
			else{
				str = str.replaceAll("[\\s]", "");
				root = root.expression(str);
				root.display();
				System.out.println("");
			}
		}while(!str.equals("quit"));
<<<<<<< HEAD
			
		return;
	}
}

//C4

=======
		return;
	}
}
>>>>>>> origin/mynew
