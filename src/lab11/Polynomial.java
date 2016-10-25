package lab11;
import lab11.Polynomialmethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;
public class Polynomial {
	float coef; /* */
	int exponent;
	int flag;	// 0 -> item; 1 -> op; 2-> end sign;
	char op;
	String var;
	Polynomial next;
	
	/**
	* set default mock parameter.（方法说明）.
	*  additionalParameters parameter additional(参数名称)
	*  data manager(返回值说明)
	* @throws Exception if has error(异常说明)
	*/
	public Polynomial() {
		flag = 2;
	}
	
	/**
	* set default mock parameter.（方法说明）.
	*  additionalParameters parameter additional(参数名称)
	*  data manager(返回值说明)
	* @throws Exception if has error(异常说明)
	* @param o 
	*/
	public Polynomial(final char o) {
		flag = 1;
		op = o;
	}
	
	/**
	* set default mock parameter.（方法说明）.
	*  additionalParameters parameter additional(参数名称)
	*  data manager(返回值说明)
	* @throws Exception if has error(异常说明)
	* @param c 
	* @param v 
	* @param e 
	*/
	public Polynomial(final float c, final String v, final int e) {
		flag = 0;
		coef = c;
		exponent = e;
		var = v;
		next = new Polynomial();			//灏唍ext鍒濆鍖栦负缁撴潫鏍囧織
	}
		
	/**
	* set default mock parameter.（方法说明）.
	*  additionalParameters parameter additional(参数名称)
	*  data manager(返回值说明)
	* @throws Exception if has error(异常说明)
	*/
	public final void display() {
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
		Polynomial tmp = this;
		if (tmp.next == null) {
			return;
		}
		while (tmp.next.flag != 2) {			
			//鍙娌″埌缁堢偣灏辨墽琛岀嚎鎬ц闂紝瀵圭郴鏁板拰鎸囨暟涓�1鐨勬儏鍐佃緭鍑烘牸寮忓寲
			tmp = tmp.next;
			if (tmp.flag == 1) {			//澶氫綑绗﹀彿澶勭悊
				if (tmp.next.var.equals("")) {
					if (tmp.next.coef == 1) {
						if (tmp.next.next.flag == 2) {
							tmp.flag = 2;
						} else {
							tmp.op = tmp.next.next.op;
							tmp.next = tmp.next.next.next;
						}
					}
				}
			}
			if (tmp.flag == 0) {
				if (tmp.var.equals("")) {	//绾郴鏁�
					System.out.print(df.format(Math.pow(tmp.coef, 
							tmp.exponent)));
				} else {
					if (tmp.exponent == 1) {
						if (tmp.coef == 1) {		//鍙兘涓虹┖
								System.out.print(tmp.var);
						} else if (tmp.coef == -1) {
							System.out.print("-" + tmp.var);
						} else {
							System.out.print(df.format(tmp.coef) + tmp.var);
						}
						} else {
							if (tmp.coef == 1) {
								System.out.print(tmp.var + "^" + tmp.exponent);
							} else if (tmp.coef == -1) {
								System.out.print("-" + tmp.var + "^" 
							+ tmp.exponent);
							} else {
								System.out.print(df.format(tmp.coef) + tmp.var 
										+ "^" + tmp.exponent);
							}
						}
					}
			} else if (tmp.flag == 1) {
				System.out.print(tmp.op);
			}	else {
				break;
			}
		}
	}
	
	/**
	* set default mock parameter.（方法说明）.
	*  additionalParameters parameter additional(参数名称)
	*  @return data manager(返回值说明)
	* @throws Exception if has error(异常说明)
	* @param str 
	*/
	public final Polynomial expression(final String str) {
		Polynomial tmp = this;
		Polynomial rootnew = this;
		String strpd = "[\\+\\-]"; //灏嗗椤瑰紡鏍规嵁+锛�-绗﹀彿鍒嗘垚鍚勫崟椤�
		Pattern ppd = Pattern.compile(strpd);
		String []item = str.split(strpd);
		Matcher mpd = ppd.matcher(str);
		
		String strmul = "[\\*]";	//灏嗗悇鍗曢」鏍规嵁*绗﹀彿鍒嗘垚鍚勫彉閲�
		Pattern pmul = Pattern.compile(strmul);
		
		String strcoef = "^[0-9\\.]+";	//瀵瑰悇鍙橀噺鏍规嵁璧峰鏁板瓧纭畾绯绘暟
		Pattern pcoef = Pattern.compile(strcoef);
		String strvar = "[a-zA-Z]+";	//瀵瑰悇鍙橀噺鏍规嵁瀛楁瘝纭畾鍙橀噺
		Pattern pvar = Pattern.compile(strvar);
		String strexponent = "[\\^]"; //瀵瑰悇鍙橀噺鏍规嵁^鍚庢暟瀛楃‘瀹氭寚鏁�
		Pattern pexponent = Pattern.compile(strexponent);
		float coef = 1;
		float c;
		int e;
		int nummul;
		String v;
		
		Polynomial tmpcoef = tmp;
		for (String elmitem : item) {				//瀵规瘡涓�椤�
			nummul = 0;
			String []var = elmitem.split(strmul);
			Matcher mmul = pmul.matcher(elmitem);
			while (mmul.find())	{			//姹�*绗﹀彿鏁�
				nummul++;
			}
			for (String elmvar : var) {
				Matcher mvar = pvar.matcher(elmvar);
				if (!mvar.find()) {
					nummul--;
				}
			}
			for (String elmvar : var) {				//瀵规瘡涓�椤逛腑姣忎釜鍙橀噺
				Matcher mcoef = pcoef.matcher(elmvar);
				Matcher mexponent = pexponent.matcher(elmvar);
				if (mcoef.find()) {					//姹傚拰绯绘暟缁煎悎鍒扮涓�椤�
					coef *= Float.parseFloat(mcoef.group(0));
				}
				c = 1;
				Matcher mvar = pvar.matcher(elmvar);
				if (mvar.find()) {					//纭畾鍙橀噺
					v = mvar.group(0);
				} else {								//绾郴鏁�

					if (mexponent.find()) {			//鑻ユ湁鎸囨暟
						String []itemexponent = elmvar.split(strexponent);
						e = Integer.parseInt(itemexponent[1], 10);
					} else {
						e = 1;
					}
					coef = (float) Math.pow(coef, e);
					if (coef == 1) {
						coef = 0;
					}
					continue;
				}
				
				if (mexponent.find()) {				//纭畾鎸囨暟
					String []itemexponent = elmvar.split(strexponent);
					e = Integer.parseInt(itemexponent[1], 10);
				} else {
					e = 1;
				}
				tmp.next = new Polynomial(c, v, e);
				tmp = tmp.next;
				
				if (nummul > 0) {					//*鍙疯繛鎺�
					tmp.next = new Polynomial('*');	
					nummul--;
					tmp = tmp.next;
				}
			}
			if (tmp == tmpcoef) {			//甯告暟椤�
				tmp.next = new Polynomial(1, "", 1);
				tmp = tmp.next;
			}			
			tmpcoef = tmpcoef.next;
			tmpcoef.coef *= coef;
			coef = 1;
			
			if (mpd.find()) {						//杩炴帴+锛�-绗﹀彿
				tmp.next = new Polynomial(mpd.group().charAt(0));	
				tmp = tmp.next;
			}
			tmpcoef = tmp;
		}
			Polynomialmethod  method = new Polynomialmethod();	
			return method.merge(rootnew);
	}
	
	/**
	* set default mock parameter.（方法说明）.
	*  additionalParameters parameter additional(参数名称)
	*  @return data manager(返回值说明)
	* @throws Exception if has error(异常说明)
	* @param input input
	* @param root 
	*/
	public final Polynomial simplify(final String input, 
			final Polynomial root) {
		 Polynomial temp = root;
		 Polynomialmethod method = new Polynomialmethod();
		 String[] count = input.split(" "); //鎸夌┖鏍煎垎寮�
		 int num = count.length;
		 String[] svar = new String[num - 1];
		 float []value = new float[100];
		 for (int i = 1; i < num; i++) {
			 svar[i - 1] = method.getVarStr(count[i], 0);			 
			 int len = count[i].length();
			 String n = count[i].substring(svar[i - 1].length() + 1, len);
			 float v =  Float.parseFloat(n);
			 value[i - 1] = v;
		 }
		 boolean havevar = false;
		 while (temp.next.flag != 2) { //琛ㄨ揪寮忔病缁撴潫
		 
			 temp = temp.next;
			 if (temp.flag ==  0) {
				 for (int k = 0; k < num - 1; k++) {
					 if (temp.var.equals(svar[k])) {
						 havevar = true;
						 if (temp.exponent == 1) {
							 temp.coef = temp.coef * value[k];
							 temp.var = "";
							 break;
						 } else {
							 temp.coef = temp.coef * (float) Math.pow(value[k], 
									 temp.exponent);
							 temp.var = "";
							 temp.exponent = 1;
							 break;
						 }	
					 }
				 }
			}
		}
		 if (!havevar) {
			 System.out.println("Error, no variable!"); 
		 }

		return method.merge(root);
	}
	
	/**
	* set default mock parameter.（方法说明）.
	*  additionalParameters parameter additional(参数名称)
	*  @return data manager(返回值说明)
	* @throws Exception if has error(异常说明)
	* @param input input
	* @param root 
	
	*/
	public final Polynomial diff(final String input, final Polynomial root) {
	 	
		 Polynomial temp = root;
		 Polynomialmethod method = new Polynomialmethod();
		 Polynomial tra = root;
		 String[] count = input.split(" "); //鎸� 绌烘牸 鍒嗗紑
		 int len = count.length;
		 boolean havevar = false;
		 boolean havev = false;
		 if (len == 2) {
			 if (count[0].equals("!d/d")) {
				 String dvar = count[1]; //鍙橀噺	

				 while (temp.next.flag != 2) { //琛ㄨ揪寮忔病缁撴潫			 
					 havevar = false;
					 temp = temp.next;

					 while (temp.flag != 2) {
						 if (temp.flag == 1) {
							 if (temp.op == '+' || temp.op == '-') {
								 break;
							 }
						 }	 
						if (temp.flag == 0) {
							if (temp.var != "") {
								 if (temp.var.equals(dvar)) { 

									 havevar = true;
									 havev = true;
									 if (temp.exponent == 1) { 
										 temp.var = "";
										 
									 } else {
										 temp.coef = temp.coef * temp.exponent;
										 temp.exponent = temp.exponent - 1;
									 }
								 }
							 }
						}
						temp = temp.next;
					 }
					 if (havevar) {
						 tra = temp;
						 if (temp.flag == 2) {
							 tra.flag = 2;
							 break;
						 }
					 } else {
						 if (temp.flag == 2) {
							 tra.flag = 2;
							 if (!havev) {
								 tra.next.flag = 2;
							 }
							 break;
						 } else {
							 tra.op = temp.op;
							 tra.next = temp.next;
						 }
					 }

				 }		 	 
					
				 if (!havev) {
					 System.out.println("Error, no variable!"); 
				 }
			 } else {
				 System.out.println("Error input!");
			 		}
		 } else {
			 System.out.println("Error input!");
		 }

		 return method.merge(root);
	}
}


	
