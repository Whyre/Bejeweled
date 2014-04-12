package puzzle;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Grid {
	private Jewel[][] jewels;
	
	public Grid() {
		jewels = new Jewel[Puzzle.ROWS][Puzzle.COLS];

		for(int r=0; r<Puzzle.ROWS; r++) {
			for(int c=0;c<Puzzle.COLS;c++) {
				jewels[r][c] = new Jewel();
			}
		}
	}
	
	public Jewel get(int r, int c) {
		return jewels[r][c];
	}
	
	public void swap(Point firstSelected, Point secondSelected) {
		Jewel temp = get(firstSelected.x, firstSelected.y);
		jewels[firstSelected.x][firstSelected.y] = jewels[secondSelected.x][secondSelected.y];
		jewels[secondSelected.x][secondSelected.y] = temp;
		temp.setSelected(false);
	}
	
	public void select(Point p) {
		jewels[p.x][p.y].setSelected(true);
	}
	
	public void update() {
		testThree();
	}
	
	public void testThree() {
		ArrayList<Point> toKill = new ArrayList<Point>();
		for(int r = 0; r < Puzzle.ROWS; r++) {
			//int prevType = -1;
			//int n = 1;
			for(int c = 0; c < Puzzle.COLS; c++) {
				int type = jewels[r][c].getType();

				for(int i=1;i<Puzzle.COLS-c;i++){
					int n = 1;
					if(jewels[r][c+i].getType()==type){
						//System.out.println("stuff1");
						i++;
						n++;
					}else{
						if (n>=3){
							for(int k=0;k<n;k++){
								toKill.add(new Point(r,c+k));
							}
						}
					}
				}
				
				
				
				/*if(jewels[r][c+1].getType()== type) {
					if (jewels[r][c+2].getType() == type){
						toKill.add(new Point(r, c));
					}*/
					//n++;
				//}
				//else {
					//if(n>=3) {
						//for(int i = 0; i < n; i++) {
							//toKill.add(new Point(r, c-i));
						}
					//}
					//System.out.println(n);
					//n=1;
				//}
			
				//prevType = type;
			}
		//}
		
		for(Point p : toKill) {
			jewels[p.x][p.y].setSelected(true);
			//select(p);
		}
	}
	
	public void paint(Graphics2D g, Component f) {
		for(int r=0; r<Puzzle.ROWS; r++) {
			for(int c=0;c<Puzzle.COLS;c++) {
				//jewels[r][c].paint(r*Jewel.SIZE, c*Jewel.SIZE, g);
				jewels[r][c].paint(r*Jewel.SIZE, c*Jewel.SIZE,g,f);
			}
		}
	}
}
