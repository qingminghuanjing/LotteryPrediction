package cn.qingming.com;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lottery extends JFrame implements ActionListener{

	
	JButton jb;
	//Lottery lottery;
	JPanel jp1;
	
	JPanel jp2;
	JLabel jb1;
	JLabel jb2;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
	public Lottery(){
		jb = new JButton("选号");
		
		this.setLayout(null);
		this.setBounds(100, 100, 400, 400);
		
		jp1 = new JPanel();//面板 1放红球 
		jp2 = new JPanel();//面板 2放蓝球
		jb1=new JLabel("红球");
		jb2=new JLabel("蓝球");
		jb1.setBounds(5, 30, 30, 30);
		jb2.setBounds(5, 70, 30, 30);
		//jp2.setLayout(null);//注意此处的null
		jp1.setBounds(50, 30, 300, 50);
		jp2.setBounds(50, 70, 300, 50);
		jp1.setLayout(null);
		jp2.setLayout(null);
		//ceshishiyan
		
		jt1=new JTextField(2);
		
		jt2=new JTextField(2);
		jt3=new JTextField(2);
		jt4=new JTextField(2);
		jt5=new JTextField(2);
		jt6=new JTextField(2);
		jt7=new JTextField(2);
		jb.addActionListener(this);
		jb.setBounds(130, 120, 80, 30);
		
		jt1.setBounds(0, 0, 30, 30);
		jt2.setBounds(40, 0, 30, 30);
		jt3.setBounds(80, 0, 30, 30);
		jt4.setBounds(120, 0, 30, 30);
		jt5.setBounds(160, 0, 30, 30);
		jt6.setBounds(200, 0, 30, 30);
		jt7.setBounds(0, 0, 30, 30);
		
		jp1.add(jt1);
		jp1.add(jt2);
		jp1.add(jt3);
		jp1.add(jt4);
		jp1.add(jt5);
		jp1.add(jt6);
		jp2.add(jt7);
		
		this.add(jb1);
		this.add(jb2);
		this.add(jp1);
		this.add(jp2);
		this.add(jb);
		

		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Lottery l = new Lottery();
		l.showNumber();
	}
	public static int[] createNumber(){
		Random random = new Random();
		int[] arr = new int[7];
		arr[0]=random.nextInt(33)+1;
		for(int i=1;i<6;i++){
			int temp = random.nextInt(33)+1;
			for(int j=0;j<i;j++){
				if(arr[j]==temp){
					i=i-1;
					break;
				}else if(j==i-1){
					arr[i]=temp;
				}
			}
		}
		arr[6]=34;
		Arrays.sort(arr);
		arr[6]=random.nextInt(16)+1;
		
		return arr;
	}
	
	public  void showNumber(){
		int[] arr = createNumber();
		jt1.setText(arr[0]+"");
		jt2.setText(arr[1]+"");
		jt3.setText(arr[2]+"");
		jt4.setText(arr[3]+"");
		jt5.setText(arr[4]+"");
		jt6.setText(arr[5]+"");
		jt7.setText(arr[6]+"");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			showNumber();
		}
		
	}

}
