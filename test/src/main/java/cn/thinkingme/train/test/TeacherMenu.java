package cn.thinkingme.train.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class TeacherMenu extends JFrame {
	
		JPanel panelXiaLaKuang;
		JLabel kemu;
		JComboBox<String> xiaLa;
		JComboBox<String> nianji;
		JLabel user;
		JLabel pass;
		
		JTextField text_user;
		JTextField text_pass;
		
		JButton btSubmit;//确定
		
		//JPanel panelXiaLaKuang2;
		
		public TeacherMenu()
		{
			panelXiaLaKuang = new JPanel();
			panelXiaLaKuang.setLayout(new GridLayout(6,2));
			panelXiaLaKuang.setPreferredSize(new Dimension(500,500));
			this.setTitle("科目");
			this.setLocationRelativeTo(null);;
			//this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			
			this.add(panelXiaLaKuang);
			
			
			kemu = new JLabel("请选择科目及年级");
			panelXiaLaKuang.add(kemu);
			
			xiaLa = new JComboBox<String>();
			xiaLa.addItem("语文");
			xiaLa.addItem("数学");
			xiaLa.addItem("英语");
			xiaLa.addItem("物理");
			xiaLa.addItem("化学");
			xiaLa.addItem("政治");
			xiaLa.addItem("生物");
			xiaLa.addItem("历史");
			xiaLa.addItem("地理");
			panelXiaLaKuang.add(xiaLa);
			
			user =new JLabel("用户名");
			panelXiaLaKuang.add(user);
			
			text_user = new JTextField();
			panelXiaLaKuang.add(text_user);
			
			pass =new JLabel("密码");
			panelXiaLaKuang.add(pass);
			
			text_pass = new JTextField();
			panelXiaLaKuang.add(text_pass);
			
			btSubmit = new JButton("确定");
			panelXiaLaKuang.add(btSubmit);
			
			//年级
			nianji = new JComboBox<String>();
			nianji .addItem("七年级");
			nianji .addItem("八年级");
			nianji .addItem("九年级");
			panelXiaLaKuang.add(nianji);

			//user=new JLabel("请输入用户名");
			
			this.pack();
			//监听确认按钮
			btSubmit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(xiaLa.getSelectedIndex() == 0)//语文
					{
						
					}
					else if(xiaLa.getSelectedIndex() == 1)
					{
						     
					}
					else if(xiaLa.getSelectedIndex() == 2)
					{
						
					}
					else if(xiaLa.getSelectedIndex() == 3)
					{
						
					}
					
				}
			});
		}
		public static void main(String[] args)
		{
			new TeacherMenu();
		}
	}