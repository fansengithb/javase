package a1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable {
	static boolean isRun = true; 
	static int time =500;    ///�߳�˯��ʱ��
	Head head =  new Head();
	Vector<Node> nodes = new Vector<Node>();   
    //���ʳ��
	Vector<Food> foods = new Vector<Food>();          ///���ͱ��
	
	public MyPanel() {              ///���캯��
		// TODO Auto-generated constructor stub
		//��ʼ���ڵ�------�տ�ʼ��3���ڵ㣬��һ��ͷ��2��node�ڵ�
		Node n1 = new Node(head.x+10, head.y);
		nodes.add(n1);
		Node n2 = new Node(n1.x+10, n1.y);
		nodes.add(n2);
		//���һ���ϰ���
		
		Food food = new Food(head, nodes);      //���ƽڵ�����λ��---��ܲ�����������
		foods.add(food);
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillRect(0, 0, Snack.width,Snack.height);
		
		//��������
		g.setColor(Color.yellow);
		//��ֱ
		for (int i = 0; i < Snack.width	; i+=10) {
			g.drawLine(i, 0, i, Snack.height);    //�ڴ�ͼ�������ĵ�����ϵ�У�ʹ�õ�ǰ��ɫ�ڵ� (x1, y1) �� (x2, y2) ֮�仭һ���ߡ�
		}
		//ˮƽ
		for (int i = 0; i < Snack.height; i+=10) {
			g.drawLine(0, i, Snack.width, i);
		}
		//��ͷ
		head.paint(g);
		//��������ڵ�
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).paint(g);
		}
		//�����ϰ�����
		if(foods.size()>0){
			foods.get(0).paint(g);
		}

		if(!isRun){              ////��Ϸ����ʱ����ӡ��ʾ��
//    		g.setColor(Color.red);
//    		g.fillRect(100, 220, 120, 60);
//    		g.setColor(Color.black);
//    		g.fillRect(103, 223, 114, 54);
    		g.setColor(Color.black);
    		g.setFont(new Font("����",Font.BOLD,25));
    		g.drawString("��Ϸ����", Snack.width/2-50, Snack.height/2-50);
    	}
	}
	
	@Override       ///
	public void run() {                 ///�߳���ִ�еĴ���
		// TODO Auto-generated method stub
       while(isRun){
    	   try {
    		   Thread.sleep(time);//����     �߳���ͣ
    	   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
    		   e.printStackTrace();
    	   }
    	   int oldx = head.x;
    	   int oldy = head.y;
    	   
    	   //��ͷ�ƶ�
//    	   head.move(null);�Ե����ǰ��move move��nodes��
    	   head.move(nodes, foods);
    	   moveNode(oldx, oldy);
    	   //�ڵ��ƶ�
//    	   for (int i = 0; i < nodes.size(); i++) {
//			nodes.get(i).move(x, y);
//		}
   	      repaint();     ///�ػ滭��---С���ƶ�ʱ�����»��ƽ���---Jframe�еķ���
       }
     
	}  
	public void moveNode(int oldx,int oldy){           ///����ڵ���ƶ�
		for (int i = nodes.size()-1	; i > 0	; i--) {
			// Node n = nodes.get(i-1);
			nodes.get(i).move(nodes.get(i-1).x, nodes.get(i-1).y);       ///�����һ���ڵ㿪ʼ��������ǰ��
		}
    	nodes.get(0).move(oldx, oldy);     ///��1���ڵ㣬�ƶ���ԭ��ͷλ��
       }

}
