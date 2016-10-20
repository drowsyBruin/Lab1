<<<<<<< HEAD
package lab11;
import lab11.polynomial_method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;
public class polynomial {
	float coef;
	int exponent;
	int flag;	// 0 -> item; 1 -> op; 2-> end sign;
	char op;
	String var;
	polynomial next;
	
	public polynomial(){
		flag = 2;
	}
	
	public polynomial(char o){
		flag = 1;
		op = o;
	}
	
	public polynomial(float c, String v, int e){
		flag = 0;
		coef = c;
		exponent = e;
		var = v;
		next = new polynomial();			//å°†nextåˆå§‹åŒ–ä¸ºç»“æŸæ ‡å¿—
	}
		
	
	public void display(){
		DecimalFormat df=(DecimalFormat) DecimalFormat.getInstance();
		polynomial tmp = this;
		if(tmp.next == null)
			return;
		while(tmp.next.flag != 2){			//åªè¦æ²¡åˆ°ç»ˆç‚¹å°±æ‰§è¡Œçº¿æ€§è®¿é—®ï¼Œå¯¹ç³»æ•°å’ŒæŒ‡æ•°ä¸º1çš„æƒ…å†µè¾“å‡ºæ ¼å¼åŒ–
			tmp = tmp.next;
			if(tmp.flag == 1)				//å¤šä½™ç¬¦å·å¤„ç†
				if(tmp.next.var.equals(""))
					if(tmp.next.coef == 1)
						if(tmp.next.next.flag == 2)
							tmp.flag = 2;
						else{
							tmp.op = tmp.next.next.op;
							tmp.next = tmp.next.next.next;
						}
			if(tmp.flag == 0){
				if(tmp.var.equals("")){	//çº¯ç³»æ•°
					System.out.print(df.format(Math.pow(tmp.coef, tmp.exponent)));
				}
				else{
					if(tmp.exponent == 1)
						if(tmp.coef == 1)		//å¯èƒ½ä¸ºç©º
								System.out.print(tmp.var);
						else if(tmp.coef == -1)
							System.out.print("-"+tmp.var);
						else
							System.out.print(df.format(tmp.coef) + tmp.var);
					else
						if(tmp.coef == 1)
							System.out.print(tmp.var + "^" + tmp.exponent);
						else if(tmp.coef == -1)
							System.out.print("-" + tmp.var + "^" + tmp.exponent);
						else
							System.out.print(df.format(tmp.coef) + tmp.var + "^" + tmp.exponent);
				}
			}
			else if (tmp.flag == 1)
				System.out.print(tmp.op);
			else
				break;
		}
	}
	
	public polynomial expression(String str){
		polynomial tmp = this;
		polynomial root_new = this;
		String str_pd = "[\\+\\-]";					//å°†å¤šé¡¹å¼æ ¹æ®+ï¼Œ-ç¬¦å·åˆ†æˆå„å•é¡¹
		Pattern p_pd = Pattern.compile(str_pd);
		String []item = str.split(str_pd);
		Matcher m_pd = p_pd.matcher(str);
		
		String str_mul = "[\\*]";					//å°†å„å•é¡¹æ ¹æ®*ç¬¦å·åˆ†æˆå„å˜é‡
		Pattern p_mul = Pattern.compile(str_mul);
		
		String str_coef = "^[0-9\\.]+";				//å¯¹å„å˜é‡æ ¹æ®èµ·å§‹æ•°å­—ç¡®å®šç³»æ•°
		Pattern p_coef = Pattern.compile(str_coef);
		String str_var = "[a-zA-Z]+";				//å¯¹å„å˜é‡æ ¹æ®å­—æ¯ç¡®å®šå˜é‡
		Pattern p_var = Pattern.compile(str_var);
		String str_exponent = "[\\^]";			//å¯¹å„å˜é‡æ ¹æ®^åæ•°å­—ç¡®å®šæŒ‡æ•°
		Pattern p_exponent = Pattern.compile(str_exponent);
		float coef = 1;
		float c;
		int e;
		int num_mul;
		String v;
		
		polynomial tmp_coef = tmp;
		for(String elm_item : item){				//å¯¹æ¯ä¸€é¡¹
			num_mul = 0;
			String []var = elm_item.split(str_mul);
			Matcher m_mul = p_mul.matcher(elm_item);
			while(m_mul.find())				//æ±‚*ç¬¦å·æ•°
				num_mul++;
			for(String elm_var : var){
				Matcher m_var = p_var.matcher(elm_var);
				if(!m_var.find())
					num_mul--;
			}
			for(String elm_var : var){				//å¯¹æ¯ä¸€é¡¹ä¸­æ¯ä¸ªå˜é‡
				Matcher m_coef = p_coef.matcher(elm_var);
				Matcher m_exponent = p_exponent.matcher(elm_var);
				if(m_coef.find())					//æ±‚å’Œç³»æ•°ç»¼åˆåˆ°ç¬¬ä¸€é¡¹
					coef *= Float.parseFloat(m_coef.group(0));
				c = 1;
				Matcher m_var = p_var.matcher(elm_var);
				if(m_var.find())					//ç¡®å®šå˜é‡
					v = m_var.group(0);
				else{								//çº¯ç³»æ•°

					if(m_exponent.find()){			//è‹¥æœ‰æŒ‡æ•°
						String []item_exponent = elm_var.split(str_exponent);
						e = Integer.parseInt(item_exponent[1], 10);
					}
					else
						e = 1;
					coef = (float)Math.pow(coef, e);
					if(coef == 1)
						coef = 0;

					continue;
				}
				
				if(m_exponent.find()){				//ç¡®å®šæŒ‡æ•°
					String []item_exponent = elm_var.split(str_exponent);
					e = Integer.parseInt(item_exponent[1], 10);
				}
				else
					e = 1;
				tmp.next = new polynomial(c, v, e);
				tmp = tmp.next;
				
				if(num_mul > 0){					//*å·è¿æ¥
					tmp.next = new polynomial('*');	
					num_mul--;
					tmp = tmp.next;
				}
			}
			if(tmp == tmp_coef){			//å¸¸æ•°é¡¹
				tmp.next = new polynomial(1, "", 1);
				tmp = tmp.next;
			}			
			tmp_coef = tmp_coef.next;
			tmp_coef.coef *= coef;
			coef = 1;
			
			if(m_pd.find()){						//è¿æ¥+ï¼Œ-ç¬¦å·
				tmp.next = new polynomial(m_pd.group().charAt(0));	
				tmp = tmp.next;
			}
			tmp_coef = tmp;
		}
			polynomial_method  method = new polynomial_method();	
			return method.merge(root_new);
	}
	
	public polynomial simplify(String input, polynomial root){
		 polynomial temp = root;
		 polynomial_method method = new polynomial_method();
		 String[] count = input.split(" ");//æŒ‰ç©ºæ ¼åˆ†å¼€
		 int num = count.length;
		 String[] s_var= new String[num-1];
		 float []value= new float[100];
		 for (int i = 1; i < num; i++)
		 {
			 s_var[i-1] = method.GetVarStr(count[i],0);			 
			 int len = count[i].length();
			 String n = count[i].substring(s_var[i-1].length()+1, len);
			 float v =  Float.parseFloat(n);
			 value[i-1] = v;
		 }
		 boolean havevar = false;
		 while(temp.next.flag != 2)//è¡¨è¾¾å¼æ²¡ç»“æŸ
		 {
			 temp=temp.next;
			 if(temp.flag==0)
			 {
				 for(int k=0; k < num-1; k++)
				 {
					 if(temp.var.equals(s_var[k]))
					 {
						 havevar = true;
						 if(temp.exponent == 1)
						 {
							 temp.coef = temp.coef * value[k];
							 temp.var ="";
							 break;
						 }
						 else
						 {
							 temp.coef = temp.coef * (float)Math.pow(value[k],temp.exponent);
							 temp.var ="";
							 temp.exponent=1;
							 break;
						 }	
					 }
				 }
			}
		}
		 if(havevar == false)
		 {
			 System.out.println("Error, no variable!"); 
		 }

		return method.merge(root);
	}
	
	
	public polynomial diff(String input, polynomial root){
	 	
		 polynomial temp = root;
		 polynomial_method method = new polynomial_method();
		 polynomial tra = root;
		 String[] count = input.split(" ");//æŒ‰ ç©ºæ ¼ åˆ†å¼€
		 int len = count.length;
		 boolean havevar = false;
		 boolean havev = false;
		 if(len == 2)
		 {
			 if(count[0].equals("!d/d"))
			 {
				 String d_var = count[1] ;//å˜é‡	

				 while(temp.next.flag != 2)//è¡¨è¾¾å¼æ²¡ç»“æŸ
				 {			 
					 havevar = false;
					 temp=temp.next;

					 while(temp.flag != 2)
					 {
						 if(temp.flag == 1)
							 if(temp.op == '+' || temp.op == '-')
								 break;
						if(temp.flag == 0)
						{
							if(temp.var != "")//havevar
							 { 
								 if(temp.var.equals(d_var))
								 { 

									 havevar = true;
									 havev = true;
									 if(temp.exponent == 1)
									 { 
										 temp.var ="";
										 
									 }
									 else
									 {
										 temp.coef = temp.coef *temp.exponent;
										 temp.exponent = temp.exponent -1;
									 }
								 }
							 }
						}
						temp=temp.next;
					 }
					 if(havevar == true){
						 tra = temp;
						 if(temp.flag == 2){
							 tra.flag = 2;
							 break;
						 }
					 }
					 else
					 {
						 if(temp.flag == 2)
						 {
							 tra.flag =2;
							 if(havev == false)
								 tra.next.flag = 2;
							 break;
						 }
						 else
						 {
							 tra.op = temp.op;
							 tra.next = temp.next;
						 }
					 }

				 }		 	 
					
				 if(havev == false)
					 System.out.println("Error, no variable!"); 		 
			 }
			 else
				 System.out.println("Error input!"); 
		 }
		 else
			 System.out.println("Error input!");

		 return method.merge(root);
	}
}


//B2
=======
package lab11;
import lab11.polynomial_method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;
public class polynomial {
	float coef;
	int exponent;
	int flag;	// 0 -> item; 1 -> op; 2-> end sign;
	char op;
	String var;
	polynomial next;

	public polynomial(){
		flag = 2;
	}

	public polynomial(char o){
		flag = 1;
		op = o;
	}

	public polynomial(float c, String v, int e){
		flag = 0;
		coef = c;
		exponent = e;
		var = v;
		next = new polynomial();			//½«next³õÊ¼»¯Îª½áÊø±êÖ¾
	}


	public void display(){
		DecimalFormat df=(DecimalFormat) DecimalFormat.getInstance();
		polynomial tmp = this;
		if(tmp.next == null)
			return;
		while(tmp.next.flag != 2){			//Ö»ÒªÃ»µ½ÖÕµã¾ÍÖ´ĞĞÏßĞÔ·ÃÎÊ£¬¶ÔÏµÊıºÍÖ¸ÊıÎª1µÄÇé¿öÊä³ö¸ñÊ½»¯
			tmp = tmp.next;
			if(tmp.flag == 1)				//¶àÓà·ûºÅ´¦Àí
				if(tmp.next.var.equals(""))
					if(tmp.next.coef == 1)
						if(tmp.next.next.flag == 2)
							tmp.flag = 2;
						else{
							tmp.op = tmp.next.next.op;
							tmp.next = tmp.next.next.next;
						}
			if(tmp.flag == 0){
				if(tmp.var.equals("")){	//´¿ÏµÊı
					System.out.print(df.format(Math.pow(tmp.coef, tmp.exponent)));
				}
				else{
					if(tmp.exponent == 1)
						if(tmp.coef == 1)		//¿ÉÄÜÎª¿Õ
								System.out.print(tmp.var);
						else if(tmp.coef == -1)
							System.out.print("-"+tmp.var);
						else
							System.out.print(df.format(tmp.coef) + tmp.var);
					else
						if(tmp.coef == 1)
							System.out.print(tmp.var + "^" + tmp.exponent);
						else if(tmp.coef == -1)
							System.out.print("-" + tmp.var + "^" + tmp.exponent);
						else
							System.out.print(df.format(tmp.coef) + tmp.var + "^" + tmp.exponent);
				}
			}
			else if (tmp.flag == 1)
				System.out.print(tmp.op);
			else
				break;
		}
	}

	public polynomial expression(String str){
		polynomial tmp = this;
		polynomial root_new = this;
		String str_pd = "[\\+\\-]";					//½«¶àÏîÊ½¸ù¾İ+£¬-·ûºÅ·Ö³É¸÷µ¥Ïî
		Pattern p_pd = Pattern.compile(str_pd);
		String []item = str.split(str_pd);
		Matcher m_pd = p_pd.matcher(str);

		String str_mul = "[\\*]";					//½«¸÷µ¥Ïî¸ù¾İ*·ûºÅ·Ö³É¸÷±äÁ¿
		Pattern p_mul = Pattern.compile(str_mul);

		String str_coef = "^[0-9\\.]+";				//¶Ô¸÷±äÁ¿¸ù¾İÆğÊ¼Êı×ÖÈ·¶¨ÏµÊı
		Pattern p_coef = Pattern.compile(str_coef);
		String str_var = "[a-zA-Z]+";				//¶Ô¸÷±äÁ¿¸ù¾İ×ÖÄ¸È·¶¨±äÁ¿
		Pattern p_var = Pattern.compile(str_var);
		String str_exponent = "[\\^]";			//¶Ô¸÷±äÁ¿¸ù¾İ^ºóÊı×ÖÈ·¶¨Ö¸Êı
		Pattern p_exponent = Pattern.compile(str_exponent);
		float coef = 1;
		float c;
		int e;
		int num_mul;
		String v;

		polynomial tmp_coef = tmp;
		for(String elm_item : item){				//¶ÔÃ¿Ò»Ïî
			num_mul = 0;
			String []var = elm_item.split(str_mul);
			Matcher m_mul = p_mul.matcher(elm_item);
			while(m_mul.find())				//Çó*·ûºÅÊı
				num_mul++;
			for(String elm_var : var){
				Matcher m_var = p_var.matcher(elm_var);
				if(!m_var.find())
					num_mul--;
			}
			for(String elm_var : var){				//¶ÔÃ¿Ò»ÏîÖĞÃ¿¸ö±äÁ¿
				Matcher m_coef = p_coef.matcher(elm_var);
				Matcher m_exponent = p_exponent.matcher(elm_var);
				if(m_coef.find())					//ÇóºÍÏµÊı×ÛºÏµ½µÚÒ»Ïî
					coef *= Float.parseFloat(m_coef.group(0));
				c = 1;
				Matcher m_var = p_var.matcher(elm_var);
				if(m_var.find())					//È·¶¨±äÁ¿
					v = m_var.group(0);
				else{								//´¿ÏµÊı

					if(m_exponent.find()){			//ÈôÓĞÖ¸Êı
						String []item_exponent = elm_var.split(str_exponent);
						e = Integer.parseInt(item_exponent[1], 10);
					}
					else
						e = 1;
					coef = (float)Math.pow(coef, e);
					if(coef == 1)
						coef = 0;

					continue;
				}

				if(m_exponent.find()){				//È·¶¨Ö¸Êı
					String []item_exponent = elm_var.split(str_exponent);
					e = Integer.parseInt(item_exponent[1], 10);
				}
				else
					e = 1;
				tmp.next = new polynomial(c, v, e);
				tmp = tmp.next;

				if(num_mul > 0){					//*ºÅÁ¬½Ó
					tmp.next = new polynomial('*');
					num_mul--;
					tmp = tmp.next;
				}
			}
			if(tmp == tmp_coef){			//³£ÊıÏî
				tmp.next = new polynomial(1, "", 1);
				tmp = tmp.next;
			}
			tmp_coef = tmp_coef.next;
			tmp_coef.coef *= coef;
			coef = 1;

			if(m_pd.find()){						//Á¬½Ó+£¬-·ûºÅ
				tmp.next = new polynomial(m_pd.group().charAt(0));
				tmp = tmp.next;
			}
			tmp_coef = tmp;
		}
			polynomial_method  method = new polynomial_method();
			return method.merge(root_new);
	}

	public polynomial simplify(String input, polynomial root){
		 polynomial temp = root;
		 polynomial_method method = new polynomial_method();
		 String[] count = input.split(" ");//°´¿Õ¸ñ·Ö¿ª
		 int num = count.length;
		 String[] s_var= new String[num-1];
		 float []value= new float[100];
		 for (int i = 1; i < num; i++)
		 {
			 s_var[i-1] = method.GetVarStr(count[i],0);
			 int len = count[i].length();
			 String n = count[i].substring(s_var[i-1].length()+1, len);
			 float v =  Float.parseFloat(n);
			 value[i-1] = v;
		 }
		 boolean havevar = false;
		 while(temp.next.flag != 2)//±í´ïÊ½Ã»½áÊø
		 {
			 temp=temp.next;
			 if(temp.flag==0)
			 {
				 for(int k=0; k < num-1; k++)
				 {
					 if(temp.var.equals(s_var[k]))
					 {
						 havevar = true;
						 if(temp.exponent == 1)
						 {
							 temp.coef = temp.coef * value[k];
							 temp.var ="";
							 break;
						 }
						 else
						 {
							 temp.coef = temp.coef * (float)Math.pow(value[k],temp.exponent);
							 temp.var ="";
							 temp.exponent=1;
							 break;
						 }
					 }
				 }
			}
		}
		 if(havevar == false)
		 {
			 System.out.println("Error, no variable!");
		 }

		return method.merge(root);
	}


	public polynomial diff(String input, polynomial root){

		 polynomial temp = root;
		 polynomial_method method = new polynomial_method();
		 polynomial tra = root;
		 String[] count = input.split(" ");//°´ ¿Õ¸ñ ·Ö¿ª
		 int len = count.length;
		 boolean havevar = false;
		 boolean havev = false;
		 if(len == 2)
		 {
			 if(count[0].equals("!d/d"))
			 {
				 String d_var = count[1] ;//±äÁ¿

				 while(temp.next.flag != 2)//±í´ïÊ½Ã»½áÊø
				 {
					 havevar = false;
					 temp=temp.next;

					 while(temp.flag != 2)
					 {
						 if(temp.flag == 1)
							 if(temp.op == '+' || temp.op == '-')
								 break;
						if(temp.flag == 0)
						{
							if(temp.var != "")//havevar
							 {
								 if(temp.var.equals(d_var))
								 {

									 havevar = true;
									 havev = true;
									 if(temp.exponent == 1)
									 {
										 temp.var ="";

									 }
									 else
									 {
										 temp.coef = temp.coef *temp.exponent;
										 temp.exponent = temp.exponent -1;
									 }
								 }
							 }
						}
						temp=temp.next;
						System.out.println("222222222");
					 }
					 if(havevar == true){
						 tra = temp;
						 if(temp.flag == 2){
							 tra.flag = 2;
							 break;
						 }
					 }
					 else
					 {
						 if(temp.flag == 2)
						 {
							 tra.flag =2;
							 if(havev == false)
								 tra.next.flag = 2;
							 break;
						 }
						 else
						 {
							 tra.op = temp.op;
							 tra.next = temp.next;
						 }
					 }

				 }

				 if(havev == false)
					 System.out.println("Error, no variable!");
			 }
			 else
				 System.out.println("Error input!");
		 }
		 else
			 System.out.println("Error input!");

		 return method.merge(root);

	}
}



>>>>>>> origin/mynew
