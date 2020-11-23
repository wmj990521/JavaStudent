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
          3).输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A；  
          4).考虑操作中可能出现的异常，在程序中设计异常处理程序。 

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
  * 创建；
  *   
  * doctoralfirst调用calculateTuitionSum（）方法，调用时实参是输入的tuition；doctoralfirst调用calculateSalarySum（）方法，调用时实参是输入的salary；
  * doctoralfirst调用calculateIncome（）方法，计算一年的总收入；doctoralfirst调用calculateTax（）方法，计算税收；
  * 自定义异常，如果输入的学费或工资为负数，抛出异常。
## 四、核心方法
1. 方法1:定义接口
```
interface StudentManagement {
   void payTuition(double pt);//缴纳学费
   void inquireTuition(double it);//查学费
}
 ```
2. 方法2:实现接口并重写接口中的全部方法
```
public class DoctoralCandidate implements StudentManagement,TeacherManagement,Tax{
   public void paySalary(double ps) {
      // TODO Auto-generated method stub
      salary=ps;
   }
   public void inquireSalary(double is) {
      // TODO Auto-generated method stub
   }
   public void payTuition(double pt) {
      // TODO Auto-generated method stub
      tuition=pt;
   }
   public void inquireTuition(double it) {
      // TODO Auto-generated method stub
   }
}
 ```
3. 方法3:计算税收
```
public double calculateTax(double tuitionSum, double salarySum) {
   double sum = salarySum - tuitionSum;
   if (sum<=standard0*12) {
      tax = 0;
   } else if (sum >= standard0*12 && sum <= standard1*12) {
      tax = sum * rate1;
   } else if (sum >= standard1*12 && sum <= standard2*12) {
      tax = sum * rate2;
   }
   return tax;
}
 ```
4. 方法4:计算一年的总学费和一年的总工资和一年总收入
```
public double calculateTuitionSum(double tuition){
	tuitionSum=tuition*2;
	return tuitionSum;
}
public double calculateSalarySum(double salary){
	salarySum=salary*12;
	return salarySum;
}
public double calculateIncome(double tuitionSum,double salarySum){
	income=salarySum - tuitionSum;
	return income;
}
 ```
5. 方法5:自定义异常
```
class MyException extends Exception {
	String message;
	public MyException(int m) {
		message = "输入的学费或工资" + m + "为负数，不符合规定";
	}
	public String warnness() {
		return message;
	}
}
public static void checkTuition(double tuition) throws MyException {
	if (tuition <= 0) {
		throw new MyException((int) tuition);
	}
}	
public static void checkSalary(double salary) throws MyException {
	if (salary <= 0) {
	throw new MyException((int) salary);
	}
}
 ```
6. 方法6:scanner类
```
Scanner scanner=new Scanner(System.in);
double tuition=scanner.nextDouble();
 ```
7. 方法7：try-catch块
``` 
try{
	double tuition=scanner.nextDouble();
	double salary=scanner.nextDouble();		
}
catch(MyException e){
	System.out.println(e.warnness());
}
```
## 五、实验结果
  运行成功，输出结果：    
  ![img](https://p.qlogo.cn/qqmail_head/gWicbXPiajJn9xvkjMtjhZX8Z8MlIPx6oOUBn0uxIOn7vQ2bcQtria5rFqJnsVTJJAl5owcWZdtExs/0)
  异常：  
  ![img](https://p.qlogo.cn/qqmail_head/gWicbXPiajJn9xvkjMtjhZX8Z8MlIPx6oOUBn0uxIOn7tvx0ib3NKTR6YicCl2dwqtV6xTia3wVEpA0c/0)
## 六、实验感想
  学习了Java中抽象类和抽象方法的定义及实现，掌握了Java中接口的定义及接口的实现方法，学会了自定义异常的使用方法，学习使用了scanner类。
