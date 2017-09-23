package a1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * 随机生成的点，障碍物 10*10 类对象 随机生成的 Node 固定生成 2个 move（）----接受头的坐标 Head 头
 * move（vector《Node》） 需要检测节点碰撞，检测边界碰撞
 * 
 * @author John
 *
 */

public class Snack extends JFrame {    ////----snack类为整体游戏界面

	static final int width = 480;       ///游戏界面的长度，宽度
	static final int height = 640;

	MyPanel mp = new MyPanel();        ///通过实现runnable接口实现java多线程

	public Snack() {
		// TODO Auto-generated constructor stub
		this.setSize(width, height);              ////游戏界面设置
		this.setLocationRelativeTo(null);
		this.setTitle("贪吃蛇");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(mp);

		this.setVisible(true);

		Thread t = new Thread(mp);            ///通过调用thread(对象)创建一个线程，
		t.start();                ///调用线程的start方法

		this.addKeyListener(new KeyAdapter() {       ///键盘监听器，控制前进方向
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(mp.head.right)           ///当向右时，左方向键无用
						return;
					mp.head.reset();
					mp.head.left = true;
					break;
				case KeyEvent.VK_UP:
					if(mp.head.down)
						return;
					mp.head.reset();
					mp.head.up = true;
					break;
				case KeyEvent.VK_RIGHT:
					if(mp.head.left)
						return;
					mp.head.reset();
					mp.head.right = true;
					break;
				case KeyEvent.VK_DOWN:
					if(mp.head.up)
						return;
					mp.head.reset();
					mp.head.down = true;
					break;
				}
			}
		});

	}

	public static void main(String[] args) {
		Snack t = new Snack();
	}
}
