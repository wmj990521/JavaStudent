package cn.syhg.student;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入古诗中要统计出现次数的某个字或词：");
		String key=scanner.nextLine();
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
		Student stu=new Student(name,clas,number,sex,age,nation);
		File sourceFile=new File("B.txt");
		File targetFile=new File("A.txt");
		String line = System.getProperty("line.separator");//换行
		Pattern pattern =  Pattern.compile("([\u4e00-\u9fa5]{1})");//统计总字数
		try{
			Reader in=new FileReader(sourceFile);
			Writer out=new FileWriter(targetFile);
			FileReader inOne=new FileReader(sourceFile);
			BufferedReader reader=new BufferedReader(inOne);
			out.write(stu.toString());//输出输入的学生信息
			out.write(line);//换行
			//实现每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
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
			//统计古诗的总字数
			String tempstr = null;
			int c=0;
			while((tempstr = reader.readLine()) != null && tempstr != ""){
				 Matcher matcher = pattern.matcher(tempstr);
		            while(matcher.find()) c++;
		         n++;
			}	
			System.out.println("这首诗的字数为："+c);
			in.close();
			out.close();
			reader.close();
			//实现：允许提供输入参数，统计古诗中某个字或词出现的次数
			FileReader inOne2=new FileReader(sourceFile);
			BufferedReader reader2=new BufferedReader(inOne2);
			String source = reader2.readLine();			
			int num = GetTime(source, key);				
			System.out.println(key + " 在本诗中出现了 " + num +" 次");
			reader2.close();				
		}
		catch(IOException e){
			System.out.println("Error"+e);
		}
	}
	//统计古诗中某个字或词出现的次数的方法
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
}
