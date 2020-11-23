# JavaStudent
# Java实验五——模拟学生作业处理
# 计G201 武美娟 2020322065

## 一、实验目的
1. 掌握字符串String及其方法的使用； 
2. 掌握文件的读取/写入方法；
3. 掌握异常处理结构。
## 二、实验要求
1. 实验要求：
   设计学生类；  
   * 采用交互式方式实例化某学生；
   * 设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。
2. 业务要求：
   * 在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。
   * 文件A包括两部分内容：
       一是学生的基本信息；
       二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：  
          1). 每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”；  
          2). 允许提供输入参数，统计古诗中某个字或词出现的次数；  
          3). 输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A；  
          4). 考虑操作中可能出现的异常，在程序中设计异常处理程序。 

## 三、实验过程
1. 创建学生类Student  
   学生有属性：姓名，班级，学号，性别，年龄，民族;     
   要求setName(String name)方法将参数name的值赋值给name，要求getName()返回name的值；  
   要求setClas(String clas)方法将参数clas的值赋值给clas，要求getClas()返回clas的值；  
   要求setNumber(int number)方法将参数number的值赋值给number，要求getNumber()返回number的值；    
   要求setSex(String sex)方法将参数sex的值赋值给sex，要求getSex()返回sex的值；   
   要求setAge(int age)方法将参数age的值赋值给age，要求getAge()返回age的值；    
   要求setNation(double nation)方法将参数nation的值赋值给nation，要求getNation()返回nation的值；     
   创建Student类的构造方法，实例化对象;      
   创建toString()方法，返回学生的信息;    
2. 创建主类Test类
  * 使用Scanner类实现运行时交互式输入，输入姓名，班级，学号，性别，年龄，民族；
  * 创建Student类对象，将输入的学生信息返回到学生类对象中；
  * 使用File类创建文本文件A和文本文件B，文本文件A用来存放原始数据，文本文件B用来存放结果；
  * 使用read（），write（）方法，将文本文件B中的内容写入到文本文件A中；
  * 使用while循环实现每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”；
  * 使用BufferedReader类实现：允许提供输入参数，统计古诗中某个字或词出现的次数；
  * 使用try-catch，考虑操作中可能出现的异常，在程序中设计异常处理程序
## 四、核心方法
1. 方法1:利用Scanner类实现交互式输入
```
Scanner scanner=new Scanner(System.in);
System.out.println("请输入你的姓名：");
String name=scanner.next();
System.out.println("请输入你的班级：");
String clas=scanner.next();
System.out.println("请输入你的学号：");
int number=scanner.nextInt();
System.out.println("请输入你的性别：");
String sex=scanner.next();
System.out.println("请输入你的年龄：");
int age=scanner.nextInt();
System.out.println("请输入你的民族：");
String nation=scanner.next();
System.out.println("输入结束");
```
2. 方法2:创建文本文件，向文本文件写入内容
```
File sourceFile=new File("B.txt");
File targetFile=new File("A.txt");
Reader in=new FileReader(sourceFile);
Writer out=new FileWriter(targetFile);
out.write(stu.toString());
out.write(line);
```
3. 方法3:实现每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
```
int n=-1;
while((n=in.read())!=-1){ 			
	out.write(n);
	for(int i=2;i<=240;i++){				
		out.write(in.read());
		if(i%7 == 0 && i%14 !=0){
			out.write(" ， ");				
		}else if(i%14==0){
			out.write("  。 ");
			out.write(line);
		}
	}
}
 ```
4. 方法4:统计古诗的总字数
```
String tempstr = null;
int c=0;
while((tempstr = reader.readLine()) != null && tempstr != ""){
	 Matcher matcher = pattern.matcher(tempstr);
	 while(matcher.find()) c++;
	 n++;
}	
System.out.println("这首诗的字数为："+c);
 ```
5. 方法5:实现：允许提供输入参数，统计古诗中某个字或词出现的次数
```
Scanner scanner=new Scanner(System.in);
System.out.println("请输入古诗中要统计出现次数的某个字或词：");
String key=scanner.nextLine();
FileReader inOne2=new FileReader(sourceFile);
BufferedReader reader2=new BufferedReader(inOne2);
String source = reader2.readLine();			
int num = GetTime(source, key);				
System.out.println(key + " 在本诗中出现了 " + num +" 次");
public static int GetTime(String source,String key){
	int i, j, count = 0;
	int poem = source.length(); 
	int word = key.length(); 
	for(i=0; i<poem-word; i++){
		for(j=0; j<word; j++){ 
			if(key.charAt(j) != source.charAt(j + i)){
				break;
			}
		}
		if(j>=key.length()){
			count++;
		}
	}
	return count;
}
```
## 五、实验结果
  运行成功，输出结果：    
  ![img](https://p.qlogo.cn/qqmail_head/PiajxSqBRaEKWNg0BcGz3pTg6yE2DqrvMSicB3Xa7tCDfK9fAZ15XHdjgHpcCgxNiczxqdygw9H6kM/0)  
  
  文本文件B：
  ![img](https://p.qlogo.cn/qqmail_head/TUEqibv7an4p8NMmO6ASG2Dcj3dWKSqibCA48gfKBGKHSbM9gvxxGFwolJTyQRicjK9/0)  
  文本文件A：
  ![img](https://p.qlogo.cn/qqmail_head/TUEqibv7an4p8NMmO6ASG2Dcj3dWKSqibCA48gfKBGKHQqSTCehUMOKmG54yZ3g8Gm/0)
## 六、实验感想
  掌握了字符串String及其length（）、toString（）等方法的使用以及字符串数组的定义及使用，掌握了scanner类的使用，学习了正则表达式的使用，掌握文件的读取/写入方法，例如File类，文件字节输入输出流，文件字符输入输出流，缓冲流等，掌握了异常的使用。
