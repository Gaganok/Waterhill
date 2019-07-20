package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WaterHillFrame extends JFrame{
	
	private final int width, height;
	private WaterHillCanvas canvas;
	private WaterHillRenderer renderer;
	
	JPanel panel;
	
	public WaterHillFrame(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.width = width;
		this.height = height;
		
		canvas = new WaterHillCanvas(width, height);	
		canvas.setBackground(Color.BLUE);
		canvas.requestFocus();
		canvas.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				renderer.refresh();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		add(canvas);
		pack();
		
		setVisible(true);
	}
	
	
	public void start() {
		canvas.init();
		renderer = new WaterHillRenderer(canvas.getBufferStrategy(), width, height);
		new Thread(renderer).start();
	}
	
}
