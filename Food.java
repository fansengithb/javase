package a1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import java.util.Vector;

/**
 * 障碍物： 随机生成（避开蛇头以及节点） paint（）
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
		Vector<Point> pts = new Vector<Point>();                     ///生成点的数组
		pts.add(new Point(head.x,head.y));                    
		for (int i = 0; i < nodes.size(); i++) {                       ////把蛇头，蛇身都放在同一数组，进行食物节点生成位置判断
			pts.add(new Point(nodes.get(i).x,nodes.get(i).y));         ///蛇头，蛇神，放在一个数组中
		}
		do{
//			x = r.nextInt(Snack.width/10)*10;       ///保证食物在方框中间
//			y = r.nextInt(Snack.height/10)*10;
//			x = r.nextInt(Snack.width);
//			y = r.nextInt(Snack.height);
			x = r.nextInt(Snack.width/10-2)*10;       ///保证食物在方框中间--------------------------------------------
			y = r.nextInt(Snack.height/10-4)*10;
		}while(pts.indexOf(new Point(x,y))!=-1);     ///避开蛇头以及节点）
		
		
		
		
				
		
	}

	public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, w, h);
		
	}
       /////递归不建议使用。---------------------------------------------------------------
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
