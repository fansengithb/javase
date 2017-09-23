package a1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import java.util.Vector;

/**
 * �ϰ�� ������ɣ��ܿ���ͷ�Լ��ڵ㣩 paint����
 * 
 * 
 *
 */
public class Food {
    int x ; 
    int y ; 
    int w ; 
    int h ;
    Random r = new Random();
	
	public Food(Head head, Vector<Node> nodes) {
		w = h = 10;
		Vector<Point> pts = new Vector<Point>();                     ///���ɵ������
		pts.add(new Point(head.x,head.y));                    
		for (int i = 0; i < nodes.size(); i++) {                       ////����ͷ����������ͬһ���飬����ʳ��ڵ�����λ���ж�
			pts.add(new Point(nodes.get(i).x,nodes.get(i).y));         ///��ͷ�����񣬷���һ��������
		}
		do{
//			x = r.nextInt(Snack.width/10)*10;       ///��֤ʳ���ڷ����м�
//			y = r.nextInt(Snack.height/10)*10;
//			x = r.nextInt(Snack.width);
//			y = r.nextInt(Snack.height);
			x = r.nextInt(Snack.width/10-2)*10;       ///��֤ʳ���ڷ����м�--------------------------------------------
			y = r.nextInt(Snack.height/10-4)*10;
		}while(pts.indexOf(new Point(x,y))!=-1);     ///�ܿ���ͷ�Լ��ڵ㣩
		
		
		
		
				
		
	}

	public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, w, h);
		
	}
       /////�ݹ鲻����ʹ�á�---------------------------------------------------------------
	public void creatPoint(Head head, Vector<Node> nodes){
		w = h = 10;
		x = r.nextInt(Snack.width/10)*10;
		y = r.nextInt(Snack.height/10)*10;
		boolean flag = false;
		boolean flag1 = false;
		while(x == head.x && y == head.y){
			flag = true;
		}
		
		for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).x == x && nodes.get(i).y == y){
				flag1 = true;
			}
		}
		
		if(flag || flag1){
			creatPoint(head,nodes);
		}
		return;
	}
}
