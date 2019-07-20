package Model;

import java.util.ArrayList;

public class WaterHill {
	
	private int[] waterhill = new int[10];
	private ArrayList<Point> water = new ArrayList<Point>();
	
	public WaterHill() {
		refresh();
	}
	
	private void fillWater() {
		water.clear();
		
		for(int i = 0; i < waterhill.length - 1; i++) {
			if(waterhill[i] > waterhill[i + 1]) {
				int max = i + 1;
				for(int j = i + 2; j < waterhill.length; j++) {
					if(waterhill[j] >= waterhill[i]) {
						writeWater(waterhill[j] > waterhill[i] ? waterhill[i] : waterhill[j], i + 1, j);
						i = j - 1;
						break;
					} else if(waterhill[j] > waterhill[max]) {
						max = j;
					}
					
					if(j + 1 == waterhill.length && waterhill[max] > waterhill[i + 1]) {
						writeWater(waterhill[max] > waterhill[i] ? waterhill[i] : waterhill[max], i + 1, max);
						i = max - 1;
					}
				}
			}
		}
	}
	
	public void refresh() {
		generateRandomWaterhill();
		//generateStaticWaterhill();
		printHill();
		fillWater();
	}
	
	private void generateRandomWaterhill() {
		for(int i = 0; i < waterhill.length; i++)
			waterhill[i] = ((int) (Math.random() * 9)) + 1;
	}
	
	private void generateStaticWaterhill() {
		waterhill = new int[] {6,7,3,3,3,8,8,1,4,2};
	}
	
	private void printHill() {
		for(int i = 0; i < waterhill.length; i++) {
			System.out.print(waterhill[i] + ",");
		}
		System.out.println();
	}
	
	private void writeWater(int dif, int start, int end) {
		for(; start < end; start++) 
			water.add(new Point(start, dif - waterhill[start]));
	}
	
	public int[] getWaterhill() {
		return waterhill;
	}

	public void setWaterhill(int[] waterhill) {
		this.waterhill = waterhill;
	}
	
	public ArrayList<Point> getWater() {
		return water;
	}

	public void setWater(ArrayList<Point> water) {
		this.water = water;
	}

}
