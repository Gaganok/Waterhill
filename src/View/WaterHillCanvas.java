package View;

import java.awt.Canvas;
import java.awt.Dimension;

public class WaterHillCanvas extends Canvas{

	public WaterHillCanvas(int width, int height) {
		setPreferredSize(new Dimension(width, height));
	}
	
	public void init() {
		createBufferStrategy(3);
	}
	
}
