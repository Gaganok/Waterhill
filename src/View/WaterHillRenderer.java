package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.List;

import Model.Point;
import Model.WaterHill;
import Model.WaterHillGraphicData;

public class WaterHillRenderer implements Runnable {
	
	private final int width, height;
	private BufferStrategy bs;
	private WaterHill waterhill;
	
	int width_unit = WaterHillGraphicData.width_unit;
	int height_unit = WaterHillGraphicData.height_unit;
	int[] hill;
	
	public WaterHillRenderer(BufferStrategy bs, int width, int height) {
		this.bs = bs;

		this.width = width;
		this.height = height;
		
		waterhill = new WaterHill();
		
		hill = waterhill.getWaterhill();
	}

	private void render() {
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		drawHill(g);
		drawWater(g);
		
		g.dispose();
		bs.show();
	}
	
	
	private void drawHill(Graphics g) {
		
		
		int x = 0, y = hill[0];
		
		g.setColor(Color.white);
		
		for(int i = 1; i < hill.length; i++) {
			int xu = x + width_unit;
			int yu = height - (y * height_unit);
			g.drawLine(x, yu, xu, yu);
			
			int temp = -(y - hill[i]);
			
			g.drawLine(xu, yu, xu, height - ((y + temp) * height_unit));
			
			x = xu;
			y += temp;
		}
		
		g.drawLine(x, height - (y * height_unit), x + width_unit, height - (y * height_unit));
		g.drawLine(x + width_unit, height - (y * height_unit), x + width_unit, height);
		
	}
	
	private void drawWater(Graphics g) {
		g.setColor(Color.BLUE);
		List<Point> water = waterhill.getWater();
		
		
		
		for(Point p : water) {
			int x = p.coord , y = hill[x];
			g.fillRect(x * width_unit, height - (y * height_unit), width_unit, -(height_unit * p.waterVal));
			
		}
		
	}
	
	public void refresh() {
		waterhill.refresh();
	}
	
	@Deprecated
	private void drawHillAnimated() {}
	
	
	@Override
	public void run() {
		while(true) {
			render();
			try {
				Thread.sleep(WaterHillGraphicData.renderer_sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
