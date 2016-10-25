package lab11;
import lab11.Polynomial;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test { //

	//ex.2xy^2*abc +	34p^1*d*q*u^2 - 24	d^7*i^7*o
    public static void main(final String  []args) throws IOException { //main
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    String strsimplify = "!simplify";
    String strdiff = "!d/d";
    Pattern psimplify = Pattern.compile(strsimplify);
    Pattern pdiff = Pattern.compile(strdiff);
    Polynomial root = new Polynomial();
    do {	
			System.out.print("> ");
			str = br.readLine();
			if (str == null) {
				return;
			}
			Matcher msimplify = psimplify.matcher(str);
			Matcher mdiff = pdiff.matcher(str);
			if (msimplify.find()) {
				if (str.equals("!simplify")) {
					root.display();	
					System.out.println("");
				} else {
					root = root.simplify(str, root);
					root.display();	
					//System.out.println("");
				}

			} else if (mdiff.find()) {
				if (str.equals("!d/d")) {	
					System.out.println("Error input!");
				} else {
					root = root.diff(str, root);
					root.display();
					//System.out.println("");
				}
			} else {
				str = str.replaceAll("[\\s]", "");
				root = root.expression(str);
				root.display();
				//System.out.println("");
			}
		} while(!str.equals("quit"));
			
    return;
	}
}
//Mod Test