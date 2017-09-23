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
		x = Snack.width/2;                      ////��ʼʱ�������ڽ����м�
		y = Snack.height/2;
		left = true;
	}
	public void paint(Graphics g) {              ////��ͷ����ɫ
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
          //�߽��жϣ��ڵ��ж�
          if(x<0 || x>Snack.width-20 || y<0 || y>Snack.height-40){
        	  MyPanel.isRun = false;
          }
          //���ϰ���
          if(foods.size()>0){
        	  if(x == foods.get(0).x && y == foods.get(0).y){
        		  foods.remove(0);//�Ƴ��ϰ���
        		  if(MyPanel.time>20)
        			  MyPanel.time-=10;
        		  
        		  int nx = nodes.get(nodes.size()-1).x;     ///�����ɵĽڵ�Ϊ��β���һ���ڵ�
        		  int ny = nodes.get(nodes.size()-1).y;
        		  Node node = new Node(nx,ny);
        		  nodes.add(node);
        		  //���´����ϰ���
        		  Food food = new Food(this,nodes);
        		  foods.add(food);
        	  }
          }
          //jiedian -----------�ж��Ƿ��л�·�������ɱ
          for (int i = 0; i < nodes.size(); i++) {
			if(x == nodes.get(i).x && y == nodes.get(i).y){
				MyPanel.isRun = false;
			}
		}
          
	}
	
	public void reset(){                    ///ÿ��ת�䷽��ʱ�����÷������
		left = up = right = down = false;
	}
}
