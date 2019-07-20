package WaterHill;

import javax.swing.JFrame;

import Model.WaterHillGraphicData;
import View.WaterHillFrame;

public class Main extends JFrame {

	public static void main(String[] args) {
		WaterHillFrame frame = new WaterHillFrame(WaterHillGraphicData.width, WaterHillGraphicData.height);
		frame.start();
	}
}
