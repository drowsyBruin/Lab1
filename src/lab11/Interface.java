package lab11;
import lab11.Polynomial;

import java.io.IOException;

import lab11.Command;



public class Interface {

	//ex.2xy^2*abc +	34p^1*d*q*u^2 - 24	d^7*i^7*o
	public static void main(String []args) throws IOException{ 	
		
		Command command = new Command();
		
		Polynomial root = new Polynomial();
		do{	
			System.out.print("> ");
			command.getCommand();

			if(command.type == 1){
				if(command.str.equals("!simplify"))
					System.out.println(root.display());	
				else {
					root = root.simplify(command.str,root);
					System.out.println(root.display());	
				}
			}
			else if(command.type == 2){
				if(command.str.equals("!d/d"))
					System.out.println("Error input!");
				else{
					root = root.diff(command.str,root);
					System.out.println(root.display());
				}
			}
			else if (command.type == 0){
				command.Format();
				root = root.expression(command.str);
				System.out.println(root.display());
			}
			else
				System.out.println("Command Type Invaild!!!");
		}while(!command.str.equals("quit"));
			
		return;
	}
}
