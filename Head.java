package a1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class Head {
	int x ;
	int y ; 
	int w = 10 ;
	int h = 10; 
	boolean left,up,right,down;
	public Head() {
		// TODO Auto-generated constructor stub
		x = Snack.width/2;                      ////开始时，蛇所在界面中间
		y = Snack.height/2;
		left = true;
	}
	public void paint(Graphics g) {              ////蛇头的颜色
        g.setColor(Color.green);
        g.fillRect(x, y, w, h);
        g.setColor(Color.white);
        g.fillRect(x+3, y+3, 4, 4);
	}

	public void move(Vector<Node> nodes,Vector<Food> foods) {
          if(left)
        	  x-=10;
          if(up )
        	  y-=10;
          if(right)
        	  x+=10;
          if(down)
        	  y+=10;
          //边界判断，节点判断
          if(x<0 || x>Snack.width-20 || y<0 || y>Snack.height-40){
        	  MyPanel.isRun = false;
          }
          //吃障碍物
          if(foods.size()>0){
        	  if(x == foods.get(0).x && y == foods.get(0).y){
        		  foods.remove(0);//移出障碍物
        		  if(MyPanel.time>20)
        			  MyPanel.time-=10;
        		  
        		  int nx = nodes.get(nodes.size()-1).x;     ///新生成的节点为蛇尾最后一个节点
        		  int ny = nodes.get(nodes.size()-1).y;
        		  Node node = new Node(nx,ny);
        		  nodes.add(node);
        		  //重新创建障碍物
        		  Food food = new Food(this,nodes);
        		  foods.add(food);
        	  }
          }
          //jiedian -----------判断是否有回路，造成自杀
          for (int i = 0; i < nodes.size(); i++) {
			if(x == nodes.get(i).x && y == nodes.get(i).y){
				MyPanel.isRun = false;
			}
		}
          
	}
	
	public void reset(){                    ///每次转变方向时，重置方向变量
		left = up = right = down = false;
	}
}
