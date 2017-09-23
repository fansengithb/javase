package a1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * ������ɵĵ㣬�ϰ��� 10*10 ����� ������ɵ� Node �̶����� 2�� move����----����ͷ������ Head ͷ
 * move��vector��Node���� ��Ҫ���ڵ���ײ�����߽���ײ
 * 
 * @author John
 *
 */

public class Snack extends JFrame {    ////----snack��Ϊ������Ϸ����

	static final int width = 480;       ///��Ϸ����ĳ��ȣ����
	static final int height = 640;

	MyPanel mp = new MyPanel();        ///ͨ��ʵ��runnable�ӿ�ʵ��java���߳�

	public Snack() {
		// TODO Auto-generated constructor stub
		this.setSize(width, height);              ////��Ϸ��������
		this.setLocationRelativeTo(null);
		this.setTitle("̰����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(mp);

		this.setVisible(true);

		Thread t = new Thread(mp);            ///ͨ������thread(����)����һ���̣߳�
		t.start();                ///�����̵߳�start����

		this.addKeyListener(new KeyAdapter() {       ///���̼�����������ǰ������
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(mp.head.right)           ///������ʱ�����������
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
