package lab11;

import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

import java.io.IOException;


public class Command {
	public String str;
	public int type;
	
	public void getCommand() throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		str = br.readLine();
		Type();
	}
	
	public void Format(){
		str = str.replaceAll("[\\s]", "");
	}
	
	//	识别命令类型，根据返回值确定
	public void Type(){
		String strSimplify = "!simplify";
		String strDiff = "!d/d";
		
		Pattern pSimplify = Pattern.compile(strSimplify);
		Pattern pDiff = Pattern.compile(strDiff);
		
		Matcher mSimplify = pSimplify.matcher(str);
		Matcher mDiff = pDiff.matcher(str);
		
	 	//0 - expression
	 	//1 - simplify
	 	//2 - diff
		if (mSimplify.find())
			type = 1;
		else if (mDiff.find())
			type = 2;
		else
			type = 0;
	}
}
