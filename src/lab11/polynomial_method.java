package lab11;
import lab11.polynomial;

public class polynomial_method {
	
	public void copy(polynomial root_old, polynomial root_new){
		float c;
		int e;
		char op;
		String var;
		if(root_old.flag == 0){
			c = root_old.coef;
			e = root_old.exponent;
			var = root_old.var;
			root_new.next = new polynomial(c, var, e);
		}
		else if(root_old.flag == 1){
			op = root_old.op;
			root_new.next = new polynomial(op);
		}
		else
			root_new.next = new polynomial();
	}
	
	public boolean like_var(polynomial root1, polynomial root2){
		String var = root1.next.var;
<<<<<<< HEAD
		while(root2.next.flag != 2){	//root2æ²¡åˆ°æœ€åŽä¸€é¡¹
			root2 = root2.next;

			if(root2.flag == 1)
				if(root2.op != '*')		//å½“å‰ç¬¦å·ä¸º+ï¼Œ-ç¬¦å·ï¼ŒåŒ¹é…ç»“æŸ
					break;
				else					//å½“å‰ç¬¦å·ä¸º'*'ï¼Œ ç›´æŽ¥è·³è¿‡
					continue;

			if(root2.var.equals(var)){	//æœ‰ç›¸åŒå˜é‡
=======
		while(root2.next.flag != 2){	//root2Ã»µ½×îºóÒ»Ïî
			root2 = root2.next;

			if(root2.flag == 1)
				if(root2.op != '*')		//µ±Ç°·ûºÅÎª+£¬-·ûºÅ£¬Æ¥Åä½áÊø
					break;
				else					//µ±Ç°·ûºÅÎª'*'£¬ Ö±½ÓÌø¹ý
					continue;

			if(root2.var.equals(var)){	//ÓÐÏàÍ¬±äÁ¿
>>>>>>> origin_partner/master
				if(!var.equals(""))
					root2.exponent += root1.next.exponent;
				root2.coef *= root1.next.coef;
				return true;
			}		
		}
		return false;
	}
	
	public boolean like_term(polynomial root1, polynomial root2){
		int length1 = 0;
		int length2 = 0;
		polynomial tmp1 = root1;
		polynomial tmp2 = root2;
		while(tmp1.next.flag != 2){
			tmp1 = tmp1.next;
<<<<<<< HEAD
			if(tmp1.flag == 1 && tmp1.op != '*')	//ä¸º+ï¼Œ-ç¬¦å·æ—¶ç»“æŸï¼Œåªå¯¹å•é¡¹å¼æ¯”è¾ƒ
=======
			if(tmp1.flag == 1 && tmp1.op != '*')	//Îª+£¬-·ûºÅÊ±½áÊø£¬Ö»¶Ôµ¥ÏîÊ½±È½Ï
>>>>>>> origin_partner/master
				break;
			length1++;
		}
		while(tmp2.next.flag != 2){
			tmp2 = tmp2.next;
<<<<<<< HEAD
			if(tmp2.flag == 1 && tmp2.op != '*')	//ä¸º+ï¼Œ-ç¬¦å·æ—¶ç»“æŸï¼Œåªå¯¹å•é¡¹å¼æ¯”è¾ƒ
=======
			if(tmp2.flag == 1 && tmp2.op != '*')	//Îª+£¬-·ûºÅÊ±½áÊø£¬Ö»¶Ôµ¥ÏîÊ½±È½Ï
>>>>>>> origin_partner/master
				break;
			length2++;
		}
		if(length1 != length2)
			return false;
		else{
			tmp1 = root1;
			String var1, var2;
			int exponent1, exponent2;
			boolean flag = false;
			while(tmp1.next.flag != 2){
				tmp1 = tmp1.next;
				if(tmp1.flag == 1){
					if(tmp1.op == '*')
						continue;
<<<<<<< HEAD
					else				//+ï¼Œ-ç¬¦å·ï¼Œè¡¨æ˜Žå•é¡¹å¼ç»“æŸ
=======
					else				//+£¬-·ûºÅ£¬±íÃ÷µ¥ÏîÊ½½áÊø
>>>>>>> origin_partner/master
						break;
				}
					
				var1 = tmp1.var;
				exponent1 = tmp1.exponent;
				
				tmp2 = root2;
				while(tmp2.next.flag != 2){
					tmp2 = tmp2.next;
					if(tmp2.flag == 1){
						if(tmp2.op == '*')
							continue;
<<<<<<< HEAD
						else				//+ï¼Œ-ç¬¦å·ï¼Œè¡¨æ˜Žå•é¡¹å¼ç»“æŸ
=======
						else				//+£¬-·ûºÅ£¬±íÃ÷µ¥ÏîÊ½½áÊø
>>>>>>> origin_partner/master
							break;
					}
					var2 = tmp2.var;
					exponent2 = tmp2.exponent;
<<<<<<< HEAD
					if(var1.equals(var2) && exponent1 == exponent2){	//è¯¥å˜é‡æ‰¾åˆ°åŒç±»é¡¹ï¼Œè¿›è¡Œä¸‹ä¸ªå˜é‡æŸ¥æ‰¾
=======
					if(var1.equals(var2) && exponent1 == exponent2){	//¸Ã±äÁ¿ÕÒµ½Í¬ÀàÏî£¬½øÐÐÏÂ¸ö±äÁ¿²éÕÒ
>>>>>>> origin_partner/master
						flag = true;
						break;
					}
				}
<<<<<<< HEAD
				if(flag == false)	//è¯¥å˜é‡æœªåŒ¹é…æˆåŠŸ
					return false;
				else
					flag = false;	//é‡ç½®flagæ ‡å¿—ï¼Œè¿›è¡Œä¸‹ä¸ªå˜é‡æŸ¥æ‰¾
			}
			return true;	//æ‰§è¡Œåˆ°è¿™æ­¥è¯´æ˜Žæ˜¯åŒç±»é¡¹
=======
				if(flag == false)	//¸Ã±äÁ¿Î´Æ¥Åä³É¹¦
					return false;
				else
					flag = false;	//ÖØÖÃflag±êÖ¾£¬½øÐÐÏÂ¸ö±äÁ¿²éÕÒ
			}
			return true;	//Ö´ÐÐµ½Õâ²½ËµÃ÷ÊÇÍ¬ÀàÏî
>>>>>>> origin_partner/master
		}	
	}
	
 	public polynomial merge_var(polynomial root_old){
		polynomial root_new = new polynomial();
		polynomial_method method = new polynomial_method();
		polynomial root_tmp = root_new;
		polynomial copy_tmp = root_tmp;
		float coef;

<<<<<<< HEAD
		//ç¬¬ä¸€é¡¹çš„ç¬¬ä¸€ä¸ªå˜é‡ ç›´æŽ¥å¤åˆ¶
=======
		//µÚÒ»ÏîµÄµÚÒ»¸ö±äÁ¿ Ö±½Ó¸´ÖÆ
>>>>>>> origin_partner/master
		root_old = root_old.next;
		while(root_old.flag == 1){
			if(root_old.op == '+')
				root_old = root_old.next;
			else{
				if(root_old.next.flag == 0)
					if(root_old.next.coef < 0)
						root_old = root_old.next;
					else{
						method.copy(root_old, copy_tmp);
						copy_tmp = copy_tmp.next;
						root_old = root_old.next;
						break;
					}
				else
					root_old = root_old.next;
			}
		}
		
						
		method.copy(root_old, copy_tmp);
		
		copy_tmp = copy_tmp.next;
		coef = copy_tmp.coef;	
<<<<<<< HEAD
		copy_tmp.next = new polynomial();	//root_new æœ€åŽä¸€é¡¹çš„ç»ˆæ­¢ç¬¦
		if(root_old.flag == 1)
			root_old = root_old.next;
			
		while(root_old.next.flag != 2){		//root_oldè¿˜æ²¡åˆ°æœ€åŽä¸€é¡¹ï¼Œå¾ªçŽ¯ç»§ç»­
			
			//éåŽ†åˆ°*ç¬¦å·ä¸å¤„ç†ï¼Œå¯¹ä¸‹ä¸ªå˜é‡è¿›è¡Œå¯¹æ¯”
			if(root_old.flag == 0){			//è·³è¿‡åˆšå¤åˆ¶çš„å˜é‡
				root_old = root_old.next;
				continue;
			}
			else if(root_old.flag == 1){	//éåŽ†é‡åˆ°+ï¼Œ-ç¬¦å·ï¼Œç›´æŽ¥å¤åˆ¶ï¼Œä¸”è¿žåŒç¬¦å·åŽç¬¬ä¸€ä¸ªå˜é‡ä¸€èµ·å¤åˆ¶
				
				if(root_old.op != '*'){
					method.copy(root_old, copy_tmp);	//å¤åˆ¶+ï¼Œ-ç¬¦å·
=======
		copy_tmp.next = new polynomial();	//root_new ×îºóÒ»ÏîµÄÖÕÖ¹·û
		if(root_old.flag == 1)
			root_old = root_old.next;
			
		while(root_old.next.flag != 2){		//root_old»¹Ã»µ½×îºóÒ»Ïî£¬Ñ­»·¼ÌÐø
			
			//±éÀúµ½*·ûºÅ²»´¦Àí£¬¶ÔÏÂ¸ö±äÁ¿½øÐÐ¶Ô±È
			if(root_old.flag == 0){			//Ìø¹ý¸Õ¸´ÖÆµÄ±äÁ¿
				root_old = root_old.next;
				continue;
			}
			else if(root_old.flag == 1){	//±éÀúÓöµ½+£¬-·ûºÅ£¬Ö±½Ó¸´ÖÆ£¬ÇÒÁ¬Í¬·ûºÅºóµÚÒ»¸ö±äÁ¿Ò»Æð¸´ÖÆ
				
				if(root_old.op != '*'){
					method.copy(root_old, copy_tmp);	//¸´ÖÆ+£¬-·ûºÅ
>>>>>>> origin_partner/master
					copy_tmp = copy_tmp.next;
					root_old = root_old.next;

					coef = 1;
					root_tmp = copy_tmp;
<<<<<<< HEAD
					method.copy(root_old, copy_tmp);	//å¤åˆ¶+ï¼Œ-ç¬¦å·åŽç¬¬ä¸€ä¸ªå˜é‡
=======
					method.copy(root_old, copy_tmp);	//¸´ÖÆ+£¬-·ûºÅºóµÚÒ»¸ö±äÁ¿
>>>>>>> origin_partner/master
					copy_tmp = copy_tmp.next;
					coef *= copy_tmp.coef;
					copy_tmp.next = new polynomial();

					continue;
				}
				else{
<<<<<<< HEAD
					if(!method.like_var(root_old, root_tmp)){	//æŸ¥çœ‹æ˜¯å¦æœ‰åŒå˜é‡ï¼šè‹¥æœ‰ï¼ŒæŒ‡æ•°ç›¸åŠ (å‡½æ•°å†…å®Œæˆ)ï¼›è‹¥æ— ï¼Œç›´æŽ¥è¿žæŽ¥
						method.copy(root_old, copy_tmp);	//è¿žæŽ¥*å·
						copy_tmp = copy_tmp.next;
						root_old = root_old.next;
						method.copy(root_old, copy_tmp);	//è¿žæŽ¥å˜é‡
=======
					if(!method.like_var(root_old, root_tmp)){	//²é¿´ÊÇ·ñÓÐÍ¬±äÁ¿£ºÈôÓÐ£¬Ö¸ÊýÏà¼Ó(º¯ÊýÄÚÍê³É)£»ÈôÎÞ£¬Ö±½ÓÁ¬½Ó
						method.copy(root_old, copy_tmp);	//Á¬½Ó*ºÅ
						copy_tmp = copy_tmp.next;
						root_old = root_old.next;
						method.copy(root_old, copy_tmp);	//Á¬½Ó±äÁ¿
>>>>>>> origin_partner/master
						copy_tmp = copy_tmp.next;
						coef = copy_tmp.coef;

						root_tmp.next.coef *= coef;
						copy_tmp.coef = 1;
						copy_tmp.next = new polynomial();
					}
					if(root_old.next.flag != 2)
						root_old = root_old.next;	
				}
			}
		}


		return root_new;
	}	
 	
 	public polynomial merge_term(polynomial root_old){
		polynomial root_new = new polynomial();
		polynomial_method method = new polynomial_method();
		polynomial root_tmp = root_new;
<<<<<<< HEAD
		boolean flag = false;				//false-æ— åŒç±»é¡¹; true-æœ‰åŒç±»é¡¹

		//ç¬¬ä¸€é¡¹ ç›´æŽ¥å¤åˆ¶
		while(root_old.next.flag != 2){		//æœªåˆ°ç»“å°¾ï¼Œç»§ç»­å¤åˆ¶
=======
		boolean flag = false;				//false-ÎÞÍ¬ÀàÏî; true-ÓÐÍ¬ÀàÏî

		//µÚÒ»Ïî Ö±½Ó¸´ÖÆ
		while(root_old.next.flag != 2){		//Î´µ½½áÎ²£¬¼ÌÐø¸´ÖÆ
>>>>>>> origin_partner/master
			root_old = root_old.next;

			method.copy(root_old, root_tmp);

			root_tmp = root_tmp.next;
			
<<<<<<< HEAD
			if(root_old.next.flag == 1)			//é‡åˆ°+ï¼Œ-ç¬¦å·ï¼Œå¤åˆ¶ä¸­æ–­
				if(root_old.next.op != '*')
					break;
		}
		root_tmp.next = new polynomial();	//root_new æœ€åŽä¸€é¡¹çš„ç»ˆæ­¢ç¬¦

		
		while(root_old.next.flag != 2){		//root_oldè¿˜æ²¡åˆ°æœ€åŽä¸€é¡¹ï¼Œå¾ªçŽ¯ç»§ç»­

			root_tmp = root_new;			//æ¯æ¬¡ä»Žroot_newç¬¬ä¸€ä¸ªå¤šé¡¹å¼å¼€å§‹æ¯”è¾ƒ

			//éåŽ†åˆ°+ï¼Œ-ç¬¦å·æˆ–rootèŠ‚ç‚¹ï¼ˆä¸å¤„ç†ï¼‰ï¼Œå¯¹ä¸‹ä¸ªå•é¡¹å¼è¿›è¡Œå¯¹æ¯”
=======
			if(root_old.next.flag == 1)			//Óöµ½+£¬-·ûºÅ£¬¸´ÖÆÖÐ¶Ï
				if(root_old.next.op != '*')
					break;
		}
		root_tmp.next = new polynomial();	//root_new ×îºóÒ»ÏîµÄÖÕÖ¹·û

		
		while(root_old.next.flag != 2){		//root_old»¹Ã»µ½×îºóÒ»Ïî£¬Ñ­»·¼ÌÐø

			root_tmp = root_new;			//Ã¿´Î´Óroot_newµÚÒ»¸ö¶àÏîÊ½¿ªÊ¼±È½Ï

			//±éÀúµ½+£¬-·ûºÅ»òroot½Úµã£¨²»´¦Àí£©£¬¶ÔÏÂ¸öµ¥ÏîÊ½½øÐÐ¶Ô±È
>>>>>>> origin_partner/master
			if(root_old.flag == 0){	
				root_old = root_old.next;
				continue;
			}
			else if(root_old.flag == 1){
				if(root_old.op == '*'){
					root_old = root_old.next;
					continue;
				}
			}

			
			flag = false;
<<<<<<< HEAD
			//å°†root_oldçš„ç¬¬ä¸€é¡¹ä¸Žroot_newçš„æ¯ä¸€é¡¹æ¯”å¯¹
			while(root_tmp.next.flag != 2){	//root_newè¿˜æ²¡åˆ°æœ€åŽä¸€é¡¹ï¼Œå¾ªçŽ¯ç»§ç»­
				//éåŽ†åˆ°+ï¼Œ-ç¬¦å·æˆ–rootèŠ‚ç‚¹ï¼ˆä¸å¤„ç†ï¼‰ï¼Œå¯¹ä¸‹ä¸ªå•é¡¹å¼è¿›è¡Œå¯¹æ¯”
=======
			//½«root_oldµÄµÚÒ»ÏîÓëroot_newµÄÃ¿Ò»Ïî±È¶Ô
			while(root_tmp.next.flag != 2){	//root_new»¹Ã»µ½×îºóÒ»Ïî£¬Ñ­»·¼ÌÐø
				//±éÀúµ½+£¬-·ûºÅ»òroot½Úµã£¨²»´¦Àí£©£¬¶ÔÏÂ¸öµ¥ÏîÊ½½øÐÐ¶Ô±È
>>>>>>> origin_partner/master
				if(root_tmp.flag == 0){	
					root_tmp = root_tmp.next;
					continue;
				}
				else if(root_tmp.op == '*'){
					root_tmp = root_tmp.next;
					continue;
				}

<<<<<<< HEAD
				if(method.like_term(root_old, root_tmp)){	//æœ‰åŒç±»é¡¹ï¼Œç³»æ•°ç›¸åŠ 

					if(root_old.flag == 2)	//rootèŠ‚ç‚¹
=======
				if(method.like_term(root_old, root_tmp)){	//ÓÐÍ¬ÀàÏî£¬ÏµÊýÏà¼Ó

					if(root_old.flag == 2)	//root½Úµã
>>>>>>> origin_partner/master
						root_tmp.next.coef += root_old.next.coef;
					else if(root_old.flag == 1 && root_old.op == '+' && (root_tmp.op == '+' || root_tmp.flag == 2) || (root_old.op == '-' && root_tmp.op == '-') )
						root_tmp.next.coef += root_old.next.coef;
					else if(root_old.flag == 1 && root_old.op == '-' && (root_tmp.op == '+' || root_tmp.flag == 2) || (root_old.op == '+' && root_tmp.op == '-') )
						root_tmp.next.coef -= root_old.next.coef;					
					else
						System.out.println("error occurred!");
					if(root_tmp.next.coef < 0){
						if(root_tmp.flag != 2){
							root_tmp.next.coef = -root_tmp.next.coef;
							root_tmp.op = root_tmp.op == '+'  ? '-' : '+';
						}
					}
					
					flag = true;
<<<<<<< HEAD
					root_old = root_old.next;	//è·³è¿‡å½“å‰rootæˆ–+ï¼Œ-èŠ‚ç‚¹
					break;
				}
				root_tmp = root_tmp.next;	//è·³è¿‡å½“å‰rootæˆ–+ï¼Œ-èŠ‚ç‚¹
			}
			
			//æ— åŒç±»é¡¹ï¼Œç›´æŽ¥è¿žæŽ¥å•é¡¹å¼(root_tmpä½äºŽroot_newæœ«ç«¯)
			if(flag == false){

				// å¤„ç†å¥½root/+ï¼Œ-ç¬¦å· ä¸‹é¢å¼€å§‹è¿žæŽ¥å•é¡¹å¼ï¼ˆå•é¡¹å¼å¤åˆ¶ç»“æŸæ ‡å¿—ï¼šå¤šé¡¹å¼ç»“å°¾/é‡åˆ°+ï¼Œ-ç¬¦å·ï¼‰

				while(root_old.next.flag != 2){		//æœªåˆ°ç»“å°¾ï¼Œç»§ç»­å¤åˆ¶
=======
					root_old = root_old.next;	//Ìø¹ýµ±Ç°root»ò+£¬-½Úµã
					break;
				}
				root_tmp = root_tmp.next;	//Ìø¹ýµ±Ç°root»ò+£¬-½Úµã
			}
			
			//ÎÞÍ¬ÀàÏî£¬Ö±½ÓÁ¬½Óµ¥ÏîÊ½(root_tmpÎ»ÓÚroot_newÄ©¶Ë)
			if(flag == false){

				// ´¦ÀíºÃroot/+£¬-·ûºÅ ÏÂÃæ¿ªÊ¼Á¬½Óµ¥ÏîÊ½£¨µ¥ÏîÊ½¸´ÖÆ½áÊø±êÖ¾£º¶àÏîÊ½½áÎ²/Óöµ½+£¬-·ûºÅ£©

				while(root_old.next.flag != 2){		//Î´µ½½áÎ²£¬¼ÌÐø¸´ÖÆ
>>>>>>> origin_partner/master

					method.copy(root_old, root_tmp);
					
					root_tmp = root_tmp.next;

<<<<<<< HEAD
					if(root_old.next.flag == 1)			//é‡åˆ°+ï¼Œ-ç¬¦å·ï¼Œå¤åˆ¶ä¸­æ–­
=======
					if(root_old.next.flag == 1)			//Óöµ½+£¬-·ûºÅ£¬¸´ÖÆÖÐ¶Ï
>>>>>>> origin_partner/master
						if(root_old.next.op != '*')
							break;
					root_old = root_old.next;
										
				}
				if(root_old.next.flag == 2){
<<<<<<< HEAD
					method.copy(root_old, root_tmp);	//æ ¼å¼åŒ–å¤åˆ¶æœ€åŽä¸€é¡¹
					root_tmp = root_tmp.next;
				}
				root_tmp.next = new polynomial();	//root_new æœ€åŽä¸€é¡¹çš„ç»ˆæ­¢ç¬¦
=======
					method.copy(root_old, root_tmp);	//¸ñÊ½»¯¸´ÖÆ×îºóÒ»Ïî
					root_tmp = root_tmp.next;
				}
				root_tmp.next = new polynomial();	//root_new ×îºóÒ»ÏîµÄÖÕÖ¹·û
>>>>>>> origin_partner/master
			}
		}
		return root_new;
	}
 	
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
	 
	 public polynomial merge(polynomial root_old){
		 polynomial root_new;

		 root_new = merge_var(root_old);

		 root_new = merge_term(root_new);

		 root_new = clear(root_new);

		 return root_new;
	 }
	 
     public polynomial clear(polynomial root_old){
 		polynomial root_new = new polynomial();
 		polynomial root_tmp = root_new;
 		polynomial_method method = new polynomial_method();
<<<<<<< HEAD
 		while(root_old.next.flag != 2){	//æ²¡åˆ°æœ€åŽä¸€é¡¹
=======
 		while(root_old.next.flag != 2){	//Ã»µ½×îºóÒ»Ïî
>>>>>>> origin_partner/master
 			if(root_old.next.coef == 0){
 				root_old = root_old.next;
 				while(root_old.flag == 0 || root_old.flag == 1){
 					if(root_old.flag == 1)
 						if(root_old.op != '*')				
 							break;
 					root_old = root_old.next;
 				}
 				if(root_old.flag == 2)
 					break;
 				continue;
 			}
 			else{
<<<<<<< HEAD
 				if(root_tmp == root_new){		//æ–°çš„ç¬¬ä¸€é¡¹ï¼Œå¦‚ä¸ºæ­£ç¬¦å·ä½æˆ–æ ¹èŠ‚ç‚¹ï¼Œè·³è¿‡
 					if(root_old.flag == 1)		//'-'
 						if(root_old.op == '-'){
 		 					method.copy(root_old, root_tmp);	//å¤åˆ¶ç¬¦å·ä½
=======
 				if(root_tmp == root_new){		//ÐÂµÄµÚÒ»Ïî£¬ÈçÎªÕý·ûºÅÎ»»ò¸ù½Úµã£¬Ìø¹ý
 					if(root_old.flag == 1)		//'-'
 						if(root_old.op == '-'){
 		 					method.copy(root_old, root_tmp);	//¸´ÖÆ·ûºÅÎ»
>>>>>>> origin_partner/master
 		 					root_tmp = root_tmp.next;
 		 					root_tmp.next = new polynomial();
 						}
 					root_old = root_old.next;
 				}
 				
 				else{
<<<<<<< HEAD
 					method.copy(root_old, root_tmp);	//å¤åˆ¶ç¬¦å·ä½
=======
 					method.copy(root_old, root_tmp);	//¸´ÖÆ·ûºÅÎ»
>>>>>>> origin_partner/master
 					root_tmp = root_tmp.next;
 					root_tmp.next = new polynomial();
 					root_old = root_old.next;
 				}
 				while(root_old.flag == 0){
 					method.copy(root_old, root_tmp);
 					root_tmp = root_tmp.next;
 					root_tmp.next = new polynomial();
 					root_old = root_old.next;
 					if(root_old.flag == 2)
 						return root_new;
 				}
 			}
 		}
 		return root_new;
 	}
}

//Mod