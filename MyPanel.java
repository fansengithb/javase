package a1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable {
	static boolean isRun = true; 
	static int time =500;    ///线程睡眠时间
	Head head =  new Head();
	Vector<Node> nodes = new Vector<Node>();   
    //添加食物
	Vector<Food> foods = new Vector<Food>();          ///泛型编程
	
	public MyPanel() {              ///构造函数
		// TODO Auto-generated constructor stub
		//初始化节点------刚开始有3个节点，，一个头，2个node节点
		Node n1 = new Node(head.x+10, head.y);
		nodes.add(n1);
		Node n2 = new Node(n1.x+10, n1.y);
		nodes.add(n2);
		//添加一个障碍物
		
		Food food = new Food(head, nodes);      //控制节点生成位置---躲避产生在蛇身上
		foods.add(food);
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillRect(0, 0, Snack.width,Snack.height);
		
		//划网格线
		g.setColor(Color.yellow);
		//垂直
		for (int i = 0; i < Snack.width	; i+=10) {
			g.drawLine(i, 0, i, Snack.height);    //在此图形上下文的坐标系中，使用当前颜色在点 (x1, y1) 和 (x2, y2) 之间画一条线。
		}
		//水平
		for (int i = 0; i < Snack.height; i+=10) {
			g.drawLine(0, i, Snack.width, i);
		}
		//蛇头
		head.paint(g);
		//绘制蛇身节点
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).paint(g);
		}
		//绘制障碍物物
		if(foods.size()>0){
			foods.get(0).paint(g);
		}

		if(!isRun){              ////游戏结束时，打印提示语
//    		g.setColor(Color.red);
//    		g.fillRect(100, 220, 120, 60);
//    		g.setColor(Color.black);
//    		g.fillRect(103, 223, 114, 54);
    		g.setColor(Color.black);
    		g.setFont(new Font("楷体",Font.BOLD,25));
    		g.drawString("游戏结束", Snack.width/2-50, Snack.height/2-50);
    	}
	}
	
	@Override       ///
	public void run() {                 ///线程中执行的代码
		// TODO Auto-generated method stub
       while(isRun){
    	   try {
    		   Thread.sleep(time);//变量     线程暂停
    	   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
    		   e.printStackTrace();
    	   }
    	   int oldx = head.x;
    	   int oldy = head.y;
    	   
    	   //蛇头移动
//    	   head.move(null);吃点的以前的move move（nodes）
    	   head.move(nodes, foods);
    	   moveNode(oldx, oldy);
    	   //节点移动
//    	   for (int i = 0; i < nodes.size(); i++) {
//			nodes.get(i).move(x, y);
//		}
   	      repaint();     ///重绘画布---小蛇移动时，重新绘制界面---Jframe中的方法
       }
     
	}  
	public void moveNode(int oldx,int oldy){           ///蛇身节点的移动
		for (int i = nodes.size()-1	; i > 0	; i--) {
			// Node n = nodes.get(i-1);
			nodes.get(i).move(nodes.get(i-1).x, nodes.get(i-1).y);       ///从最后一个节点开始，依次向前串
		}
    	nodes.get(0).move(oldx, oldy);     ///第1个节点，移动到原蛇头位置
       }

}
