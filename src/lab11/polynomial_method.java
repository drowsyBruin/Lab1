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
		while(root2.next.flag != 2){	//root2没到最后一项
			root2 = root2.next;

			if(root2.flag == 1)
				if(root2.op != '*')		//当前符号为+，-符号，匹配结束
					break;
				else					//当前符号为'*'， 直接跳过
					continue;

			if(root2.var.equals(var)){	//有相同变量
=======
		while(root2.next.flag != 2){	//root2û�����һ��
			root2 = root2.next;

			if(root2.flag == 1)
				if(root2.op != '*')		//��ǰ����Ϊ+��-���ţ�ƥ�����
					break;
				else					//��ǰ����Ϊ'*'�� ֱ������
					continue;

			if(root2.var.equals(var)){	//����ͬ����
>>>>>>> origin/mynew
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
			if(tmp1.flag == 1 && tmp1.op != '*')	//为+，-符号时结束，只对单项式比较
=======
			if(tmp1.flag == 1 && tmp1.op != '*')	//Ϊ+��-����ʱ������ֻ�Ե���ʽ�Ƚ�
>>>>>>> origin/mynew
				break;
			length1++;
		}
		while(tmp2.next.flag != 2){
			tmp2 = tmp2.next;
<<<<<<< HEAD
			if(tmp2.flag == 1 && tmp2.op != '*')	//为+，-符号时结束，只对单项式比较
=======
			if(tmp2.flag == 1 && tmp2.op != '*')	//Ϊ+��-����ʱ������ֻ�Ե���ʽ�Ƚ�
>>>>>>> origin/mynew
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
					else				//+，-符号，表明单项式结束
=======
					else				//+��-���ţ���������ʽ����
>>>>>>> origin/mynew
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
						else				//+，-符号，表明单项式结束
=======
						else				//+��-���ţ���������ʽ����
>>>>>>> origin/mynew
							break;
					}
					var2 = tmp2.var;
					exponent2 = tmp2.exponent;
<<<<<<< HEAD
					if(var1.equals(var2) && exponent1 == exponent2){	//该变量找到同类项，进行下个变量查找
=======
					if(var1.equals(var2) && exponent1 == exponent2){	//�ñ����ҵ�ͬ��������¸���������
>>>>>>> origin/mynew
						flag = true;
						break;
					}
				}
<<<<<<< HEAD
				if(flag == false)	//该变量未匹配成功
					return false;
				else
					flag = false;	//重置flag标志，进行下个变量查找
			}
			return true;	//执行到这步说明是同类项
=======
				if(flag == false)	//�ñ���δƥ��ɹ�
					return false;
				else
					flag = false;	//����flag��־�������¸���������
			}
			return true;	//ִ�е��ⲽ˵����ͬ����
>>>>>>> origin/mynew
		}	
	}
	
 	public polynomial merge_var(polynomial root_old){
		polynomial root_new = new polynomial();
		polynomial_method method = new polynomial_method();
		polynomial root_tmp = root_new;
		polynomial copy_tmp = root_tmp;
		float coef;

<<<<<<< HEAD
		//第一项的第一个变量 直接复制
=======
		//��һ��ĵ�һ������ ֱ�Ӹ���
>>>>>>> origin/mynew
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
		copy_tmp.next = new polynomial();	//root_new 最后一项的终止符
		if(root_old.flag == 1)
			root_old = root_old.next;
			
		while(root_old.next.flag != 2){		//root_old还没到最后一项，循环继续
			
			//遍历到*符号不处理，对下个变量进行对比
			if(root_old.flag == 0){			//跳过刚复制的变量
				root_old = root_old.next;
				continue;
			}
			else if(root_old.flag == 1){	//遍历遇到+，-符号，直接复制，且连同符号后第一个变量一起复制
				
				if(root_old.op != '*'){
					method.copy(root_old, copy_tmp);	//复制+，-符号
=======
		copy_tmp.next = new polynomial();	//root_new ���һ�����ֹ��
		if(root_old.flag == 1)
			root_old = root_old.next;
			
		while(root_old.next.flag != 2){		//root_old��û�����һ�ѭ������
			
			//������*���Ų��������¸��������жԱ�
			if(root_old.flag == 0){			//�����ո��Ƶı���
				root_old = root_old.next;
				continue;
			}
			else if(root_old.flag == 1){	//��������+��-���ţ�ֱ�Ӹ��ƣ�����ͬ���ź��һ������һ����
				
				if(root_old.op != '*'){
					method.copy(root_old, copy_tmp);	//����+��-����
>>>>>>> origin/mynew
					copy_tmp = copy_tmp.next;
					root_old = root_old.next;

					coef = 1;
					root_tmp = copy_tmp;
<<<<<<< HEAD
					method.copy(root_old, copy_tmp);	//复制+，-符号后第一个变量
=======
					method.copy(root_old, copy_tmp);	//����+��-���ź��һ������
>>>>>>> origin/mynew
					copy_tmp = copy_tmp.next;
					coef *= copy_tmp.coef;
					copy_tmp.next = new polynomial();

					continue;
				}
				else{
<<<<<<< HEAD
					if(!method.like_var(root_old, root_tmp)){	//查看是否有同变量：若有，指数相加(函数内完成)；若无，直接连接
						method.copy(root_old, copy_tmp);	//连接*号
						copy_tmp = copy_tmp.next;
						root_old = root_old.next;
						method.copy(root_old, copy_tmp);	//连接变量
=======
					if(!method.like_var(root_old, root_tmp)){	//�鿴�Ƿ���ͬ���������У�ָ�����(���������)�����ޣ�ֱ������
						method.copy(root_old, copy_tmp);	//����*��
						copy_tmp = copy_tmp.next;
						root_old = root_old.next;
						method.copy(root_old, copy_tmp);	//���ӱ���
>>>>>>> origin/mynew
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
		boolean flag = false;				//false-无同类项; true-有同类项

		//第一项 直接复制
		while(root_old.next.flag != 2){		//未到结尾，继续复制
=======
		boolean flag = false;				//false-��ͬ����; true-��ͬ����

		//��һ�� ֱ�Ӹ���
		while(root_old.next.flag != 2){		//δ����β����������
>>>>>>> origin/mynew
			root_old = root_old.next;

			method.copy(root_old, root_tmp);

			root_tmp = root_tmp.next;
			
<<<<<<< HEAD
			if(root_old.next.flag == 1)			//遇到+，-符号，复制中断
				if(root_old.next.op != '*')
					break;
		}
		root_tmp.next = new polynomial();	//root_new 最后一项的终止符

		
		while(root_old.next.flag != 2){		//root_old还没到最后一项，循环继续

			root_tmp = root_new;			//每次从root_new第一个多项式开始比较

			//遍历到+，-符号或root节点（不处理），对下个单项式进行对比
=======
			if(root_old.next.flag == 1)			//����+��-���ţ������ж�
				if(root_old.next.op != '*')
					break;
		}
		root_tmp.next = new polynomial();	//root_new ���һ�����ֹ��

		
		while(root_old.next.flag != 2){		//root_old��û�����һ�ѭ������

			root_tmp = root_new;			//ÿ�δ�root_new��һ������ʽ��ʼ�Ƚ�

			//������+��-���Ż�root�ڵ㣨�����������¸�����ʽ���жԱ�
>>>>>>> origin/mynew
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
			//将root_old的第一项与root_new的每一项比对
			while(root_tmp.next.flag != 2){	//root_new还没到最后一项，循环继续
				//遍历到+，-符号或root节点（不处理），对下个单项式进行对比
=======
			//��root_old�ĵ�һ����root_new��ÿһ��ȶ�
			while(root_tmp.next.flag != 2){	//root_new��û�����һ�ѭ������
				//������+��-���Ż�root�ڵ㣨�����������¸�����ʽ���жԱ�
>>>>>>> origin/mynew
				if(root_tmp.flag == 0){	
					root_tmp = root_tmp.next;
					continue;
				}
				else if(root_tmp.op == '*'){
					root_tmp = root_tmp.next;
					continue;
				}

<<<<<<< HEAD
				if(method.like_term(root_old, root_tmp)){	//有同类项，系数相加

					if(root_old.flag == 2)	//root节点
=======
				if(method.like_term(root_old, root_tmp)){	//��ͬ���ϵ�����

					if(root_old.flag == 2)	//root�ڵ�
>>>>>>> origin/mynew
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
					root_old = root_old.next;	//跳过当前root或+，-节点
					break;
				}
				root_tmp = root_tmp.next;	//跳过当前root或+，-节点
			}
			
			//无同类项，直接连接单项式(root_tmp位于root_new末端)
			if(flag == false){

				// 处理好root/+，-符号 下面开始连接单项式（单项式复制结束标志：多项式结尾/遇到+，-符号）

				while(root_old.next.flag != 2){		//未到结尾，继续复制
=======
					root_old = root_old.next;	//������ǰroot��+��-�ڵ�
					break;
				}
				root_tmp = root_tmp.next;	//������ǰroot��+��-�ڵ�
			}
			
			//��ͬ���ֱ�����ӵ���ʽ(root_tmpλ��root_newĩ��)
			if(flag == false){

				// �����root/+��-���� ���濪ʼ���ӵ���ʽ������ʽ���ƽ�����־������ʽ��β/����+��-���ţ�

				while(root_old.next.flag != 2){		//δ����β����������
>>>>>>> origin/mynew

					method.copy(root_old, root_tmp);
					
					root_tmp = root_tmp.next;

<<<<<<< HEAD
					if(root_old.next.flag == 1)			//遇到+，-符号，复制中断
=======
					if(root_old.next.flag == 1)			//����+��-���ţ������ж�
>>>>>>> origin/mynew
						if(root_old.next.op != '*')
							break;
					root_old = root_old.next;
										
				}
				if(root_old.next.flag == 2){
<<<<<<< HEAD
					method.copy(root_old, root_tmp);	//格式化复制最后一项
					root_tmp = root_tmp.next;
				}
				root_tmp.next = new polynomial();	//root_new 最后一项的终止符
=======
					method.copy(root_old, root_tmp);	//��ʽ���������һ��
					root_tmp = root_tmp.next;
				}
				root_tmp.next = new polynomial();	//root_new ���һ�����ֹ��
>>>>>>> origin/mynew
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
 		while(root_old.next.flag != 2){	//没到最后一项
=======
 		while(root_old.next.flag != 2){	//û�����һ��
>>>>>>> origin/mynew
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
 				if(root_tmp == root_new){		//新的第一项，如为正符号位或根节点，跳过
 					if(root_old.flag == 1)		//'-'
 						if(root_old.op == '-'){
 		 					method.copy(root_old, root_tmp);	//复制符号位
=======
 				if(root_tmp == root_new){		//�µĵ�һ���Ϊ������λ����ڵ㣬����
 					if(root_old.flag == 1)		//'-'
 						if(root_old.op == '-'){
 		 					method.copy(root_old, root_tmp);	//���Ʒ���λ
>>>>>>> origin/mynew
 		 					root_tmp = root_tmp.next;
 		 					root_tmp.next = new polynomial();
 						}
 					root_old = root_old.next;
 				}
 				
 				else{
<<<<<<< HEAD
 					method.copy(root_old, root_tmp);	//复制符号位
=======
 					method.copy(root_old, root_tmp);	//���Ʒ���λ
>>>>>>> origin/mynew
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

<<<<<<< HEAD
//B2
=======
>>>>>>> origin/mynew
