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
				//int type = 0;
				//type = jewels[r][c].getType();
				for (int i=1; i<Puzzle.ROWS-r;i++){
					int n = 1;
					if (jewels[r][c].getType() == jewels[r+i][c].getType()){
						n++;
						System.out.println("asdf1");
					}
					if (n>=3){
						System.out.println("asdf");
						for (int k=0;k<n;k++){
							toKill.add(new Point(r+k,c));
						}
					
						
					}
				
				}
				
				/*if (jewels[r][c].getType() == jewels[r+1][c].getType()){
				//if (jewels[r+1][c].getType() == type){
						if(jewels[r+2][c].getType()==jewels[r][c].getType()){
							System.out.println("Match 3"+r+", "+c);
							toKill.add(new Point(r,c));
							toKill.add(new Point(r+1,c));
							toKill.add(new Point(r+2,c));
						}
					//}
				}*/
				

			}
		//}
		
		for(Point p : toKill) {
			//jewels[p.x][p.y].setSelected(true);
			select(p);
		}
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
