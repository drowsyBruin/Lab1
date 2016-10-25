package lab11;

/**
* show 鏂规硶鐨勭畝杩�.
* <p>show 鏂规硶鐨勮缁嗚鏄庣涓�琛�<br>
* show 鏂规硶鐨勮缁嗚鏄庣浜岃

*/
public class Polynomialmethod { /*class*/

	public final void copy(final Polynomial rootold, final Polynomial rootnew) {
		float c;
		int e;
		char op;
		String var;
		if (rootold.flag == 0) {
			c = rootold.coef;
			e = rootold.exponent;
			var = rootold.var;
			rootnew.next = new Polynomial(c, var, e);
		} else if (rootold.flag == 1) {
			op = rootold.op;
			rootnew.next = new Polynomial(op);
		} else {
			rootnew.next = new Polynomial();
		}
		
		
			
	}
	
	public final boolean likevar(final Polynomial root1, Polynomial root2) {
		String var = root1.next.var;
		while (root2.next.flag != 2) {	//root2濞屸�冲煂閺堬拷閸氬簼绔存い锟�
			root2 = root2.next;

			if (root2.flag == 1) {
				if (root2.op != '*') {
					break;
				} else {
					continue; //瑜版挸澧犵粭锕�褰挎稉锟�'*'閿涳拷 閻╁瓨甯寸捄瀹犵箖
				}
					
			}

			if (root2.var.equals(var)) {	//閺堝娴夐崥灞藉綁闁诧拷
				if (!var.equals(""))
					root2.exponent += root1.next.exponent;
				root2.coef *= root1.next.coef;
				return true;
			}		
		}
		return false;
	}
	
	public final boolean liketerm(final Polynomial root1, final Polynomial root2) {
		int length1 = 0;
		int length2 = 0;
		Polynomial tmp1 = root1;
		Polynomial tmp2 = root2;
		while (tmp1.next.flag != 2) {
			tmp1 = tmp1.next;
			if (tmp1.flag == 1 && tmp1.op != '*') {
				break;
			}
				
			length1++;
		}
		while (tmp2.next.flag != 2) {
			tmp2 = tmp2.next;
			if (tmp2.flag == 1 && tmp2.op != '*') {
				break; //娑擄拷+閿涳拷-缁楋箑褰块弮鍓佺波閺夌噦绱濋崣顏勵嚠閸楁洟銆嶅蹇旂槷鏉堬拷
			}
				
			length2++;
		}
		if (length1 != length2) {
			return false;
		} else {
			tmp1 = root1;
			String var1, var2;
			int exponent1, exponent2;
			boolean flag = false;
			while (tmp1.next.flag != 2) {
				tmp1 = tmp1.next;
				if (tmp1.flag == 1) {
					if (tmp1.op == '*') {
						continue;
					} else {
						break; //+閿涳拷-缁楋箑褰块敍宀冦�冮弰搴″礋妞ょ懓绱＄紒鎾存将
					}
						
				}
					
				var1 = tmp1.var;
				exponent1 = tmp1.exponent;
				
				tmp2 = root2;
				while (tmp2.next.flag != 2) {
					tmp2 = tmp2.next;
					if (tmp2.flag == 1) {
						if (tmp2.op == '*') {
							continue;
						} else {
							break; //+閿涳拷-缁楋箑褰块敍宀冦�冮弰搴″礋妞ょ懓绱＄紒鎾存将
						}
							
					}
					var2 = tmp2.var;
					exponent2 = tmp2.exponent;
					if (var1.equals(var2) && exponent1 == exponent2) {	
						flag = true;
						break;
					}
				}
				if (flag) {
					return false;
				} else {
					flag = false;	//闁插秶鐤唂lag閺嶅洤绻旈敍宀冪箻鐞涘奔绗呮稉顏勫綁闁插繑鐓￠幍锟�
				}
			}
			return true;	//閹笛嗩攽閸掓媽绻栧銉嚛閺勫孩妲搁崥宀�琚い锟�
		}	
	}
	
 	public final Polynomial mergevar(Polynomial rootold) {
		Polynomial rootnew = new Polynomial();
		Polynomialmethod method = new Polynomialmethod();
		Polynomial roottmp = rootnew;
		Polynomial copytmp = roottmp;
		float coef;

		//缁楊兛绔存い鍦畱缁楊兛绔存稉顏勫綁闁诧拷 閻╁瓨甯存径宥呭煑
		rootold = rootold.next;
		while (rootold.flag == 1) {
			if (rootold.op == '+') {
				rootold = rootold.next;
			} else {
				if (rootold.next.flag == 0) {
					if (rootold.next.coef < 0) {
						rootold = rootold.next;
					} else {
						method.copy(rootold, copytmp);
						copytmp = copytmp.next;
						rootold = rootold.next;
						break;
					}
				} else {
					rootold = rootold.next;
				}
			}
		}
		
						
		method.copy(rootold, copytmp);
		
		copytmp = copytmp.next;
		coef = copytmp.coef;	
		copytmp.next = new Polynomial();	//rootnew 閺堬拷閸氬簼绔存い鍦畱缂佸牊顒涚粭锟�
		if (rootold.flag == 1) {
			rootold = rootold.next;
		}
			
		while (rootold.next.flag != 2) {		
			
			//闁秴宸婚崚锟�*缁楋箑褰挎稉宥咁槱閻炲棴绱濈�甸�涚瑓娑擃亜褰夐柌蹇氱箻鐞涘苯顕В锟�
			if (rootold.flag == 0) {			//鐠哄疇绻冮崚姘槻閸掑墎娈戦崣姗�鍣�
				rootold = rootold.next;
				continue;
			} else if (rootold.flag == 1) {	
				
				if (rootold.op != '*') {
					method.copy(rootold, copytmp);	//婢跺秴鍩�+閿涳拷-缁楋箑褰�
					copytmp = copytmp.next;
					rootold = rootold.next;

					coef = 1;
					roottmp = copytmp;
					method.copy(rootold, copytmp);	
					copytmp = copytmp.next;
					coef *= copytmp.coef;
					copytmp.next = new Polynomial();

					continue;
				} else {
					if (!method.likevar(rootold, roottmp)) {	
						method.copy(rootold, copytmp);	//鏉╃偞甯�*閸欙拷
						copytmp = copytmp.next;
						rootold = rootold.next;
						method.copy(rootold, copytmp);	//鏉╃偞甯撮崣姗�鍣�
						copytmp = copytmp.next;
						coef = copytmp.coef;

						roottmp.next.coef *= coef;
						copytmp.coef = 1;
						copytmp.next = new Polynomial();
					}
					if (rootold.next.flag != 2) {
						rootold = rootold.next;
					}	
				}
			}
		}


		return rootnew;
	}	
 	
 	public final Polynomial mergeterm(Polynomial rootold) {
		Polynomial rootnew = new Polynomial();
		Polynomialmethod method = new Polynomialmethod();
		Polynomial roottmp = rootnew;
		boolean flag = false;				//false-閺冪姴鎮撶猾濠氥��; true-閺堝鎮撶猾濠氥��

		//缁楊兛绔存い锟� 閻╁瓨甯存径宥呭煑
		while (rootold.next.flag != 2) {		//閺堫亜鍩岀紒鎾崇啲閿涘瞼鎴风紒顓烆槻閸掞拷
			rootold = rootold.next;

			method.copy(rootold, roottmp);

			roottmp = roottmp.next;
			
			if (rootold.next.flag == 1) {
				if (rootold.next.op != '*') {
					break;
				}
			}
		}
		roottmp.next = new Polynomial();	//rootnew 閺堬拷閸氬簼绔存い鍦畱缂佸牊顒涚粭锟�

		
		while (rootold.next.flag != 2) {		//rootold鏉╂ɑ鐥呴崚鐗堟付閸氬簼绔存い鐧哥礉瀵邦亞骞嗙紒褏鐢�

			roottmp = rootnew;			//濮ｅ繑顐兼禒宸杘otnew缁楊兛绔存稉顏勵樋妞ょ懓绱″锟芥慨瀣槷鏉堬拷

			//闁秴宸婚崚锟�+閿涳拷-缁楋箑褰块幋鏉沷ot閼哄倻鍋ｉ敍鍫滅瑝婢跺嫮鎮婇敍澶涚礉鐎甸�涚瑓娑擃亜宕熸い鐟扮础鏉╂稖顢戠�佃鐦�
			if (rootold.flag == 0) {	
				rootold = rootold.next;
				continue;
			} else if (rootold.flag == 1) {
				if (rootold.op == '*') {
					rootold = rootold.next;
					continue;
				}
			}

			
			flag = false;
			//鐏忓敃ootold閻ㄥ嫮顑囨稉锟芥い閫涚瑢rootnew閻ㄥ嫭鐦℃稉锟芥い瑙勭槷鐎碉拷
			while (roottmp.next.flag != 2) {	//rootnew鏉╂ɑ鐥呴崚鐗堟付閸氬簼绔存い鐧哥礉瀵邦亞骞嗙紒褏鐢�
				
				if (roottmp.flag == 0) {	
					roottmp = roottmp.next;
					continue;
				} else if (roottmp.op == '*') {
					roottmp = roottmp.next;
					continue;
				}

				if (method.liketerm(rootold, roottmp)) {	//閺堝鎮撶猾濠氥�嶉敍宀�閮撮弫鎵祲閸旓拷

					if (rootold.flag == 2) {
						roottmp.next.coef += rootold.next.coef;
					} else if (rootold.flag == 1 && rootold.op == '+' && (roottmp.op == '+' || roottmp.flag == 2) || (rootold.op == '-' && roottmp.op == '-')) {
						roottmp.next.coef += rootold.next.coef;
					} else if (rootold.flag == 1 && rootold.op == '-' && (roottmp.op == '+' || roottmp.flag == 2) || (rootold.op == '+' && roottmp.op == '-')) {
						roottmp.next.coef -= rootold.next.coef;
					} else {
						System.out.println("error occurred!");
					}
					if (roottmp.next.coef < 0) {
						if (roottmp.flag != 2) {
							roottmp.next.coef = -roottmp.next.coef;
							roottmp.op = roottmp.op == '+'  ? '-' : '+';
						}
					}
					
					flag = true;
					rootold = rootold.next;	//鐠哄疇绻冭ぐ鎾冲root閹达拷+閿涳拷-閼哄倻鍋�
					break;
				}
				roottmp = roottmp.next;	//鐠哄疇绻冭ぐ鎾冲root閹达拷+閿涳拷-閼哄倻鍋�
			}
			
			//閺冪姴鎮撶猾濠氥�嶉敍宀�娲块幒銉ㄧ箾閹恒儱宕熸い鐟扮础(roottmp娴ｅ秳绨瑀ootnew閺堫偆顏�)
			if (flag == false) {

				// 婢跺嫮鎮婃總绲﹐ot/+閿涳拷-缁楋箑褰� 娑撳娼板锟芥慨瀣箾閹恒儱宕熸い鐟扮础閿涘牆宕熸い鐟扮础婢跺秴鍩楃紒鎾存将閺嶅洤绻旈敍姘樋妞ょ懓绱＄紒鎾崇啲/闁洤鍩�+閿涳拷-缁楋箑褰块敍锟�

				while (rootold.next.flag != 2) {		//閺堫亜鍩岀紒鎾崇啲閿涘瞼鎴风紒顓烆槻閸掞拷

					method.copy(rootold, roottmp);
					
					roottmp = roottmp.next;

					if (rootold.next.flag == 1) {
						if (rootold.next.op != '*') {
							break;
						}
					}
					rootold = rootold.next;
										
				}
				if (rootold.next.flag == 2) {
					method.copy(rootold, roottmp);	//閺嶇厧绱￠崠鏍ь槻閸掕埖娓堕崥搴濈妞わ拷
					roottmp = roottmp.next;
				}
				roottmp.next = new Polynomial();	//rootnew 閺堬拷閸氬簼绔存い鍦畱缂佸牊顒涚粭锟�
			}
		}
		return rootnew;
	}
 	
	 public final boolean isletter(final char a) {
		 if (a >= 'A' && a <= 'Z' || a >= 'a' && a <= 'z') {
			return true;
		} else {
			return false;
		}
	 }

	 public final String getVarStr(final String input, final int i) {
		 int j = i + 1;
		 for (;j < input.length() && isletter(input.charAt(j)); j++) {
		}
		 return input.substring(i, j);
	 }
	 
	 public Polynomial merge(final Polynomial rootold) {
		 Polynomial rootnew;

		 rootnew = mergevar(rootold);

		 rootnew = mergeterm(rootnew);

		 rootnew = clear(rootnew);

		 return rootnew;
	 }
	 
     public final Polynomial clear(Polynomial rootold) {
 		Polynomial rootnew = new Polynomial();
 		Polynomial roottmp = rootnew;
 		Polynomialmethod method = new Polynomialmethod();
 		while (rootold.next.flag != 2) {	//濞屸�冲煂閺堬拷閸氬簼绔存い锟�
 			if (rootold.next.coef == 0) {
 				rootold = rootold.next;
 				while (rootold.flag == 0 || rootold.flag == 1) {
 					if (rootold.flag == 1) {
						if (rootold.op != '*') {
							break;
						}
					}
 					rootold = rootold.next;
 				}
 				if (rootold.flag == 2) {
 					break;
 				}
 				continue;
 			} else {
 				if (roottmp == rootnew) {		
 					if (rootold.flag == 1)	{
 						continue; 
 					}	//'-'
 						if (rootold.op == '-') {
 		 					method.copy(rootold, roottmp);	//婢跺秴鍩楃粭锕�褰挎担锟�
 		 					roottmp = roottmp.next;
 		 					roottmp.next = new Polynomial();
 						}
 					rootold = rootold.next; 
 					} else {
 					method.copy(rootold, roottmp);	//婢跺秴鍩楃粭锕�褰挎担锟�
 					roottmp = roottmp.next;
 					roottmp.next = new Polynomial();
 					rootold = rootold.next;
 				}
 				while (rootold.flag == 0) {
 					method.copy(rootold, roottmp);
 					roottmp = roottmp.next;
 					roottmp.next = new Polynomial();
 					rootold = rootold.next;
 					if (rootold.flag == 2) {
 						return rootnew;
 					}
 						
 				}
 			}
 		}
 		return rootnew;
 	}
}

