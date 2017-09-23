package a1;

import java.awt.Color;
import java.awt.Graphics;

public class Node {
    int x ;
    int y ;
    int w ;
    int h ;
    public Node(int x,int y) {
		// TODO Auto-generated constructor stub
    	this.x = x;
    	this.y = y;
	}
    public void paint(Graphics g){
    	g.setColor(Color.green);
    	g.fillRect(x, y, 10, 10);
    	g.setColor(Color.white);
    	g.fillRect(x+4, y+4, 2, 2);           ////蛇身节点蓝色，
    }
    public void move(int x,int y ){
    	this.x = x;
    	this.y = y;
    	
    }
}
