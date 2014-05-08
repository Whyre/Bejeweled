package puzzle;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Grid {
	private Jewel[][] jewels;
        private Set<Point> toKill;

	public Grid() {
		jewels = new Jewel[Puzzle.ROWS][Puzzle.COLS];
                toKill = new HashSet<>();
                
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
                for (Point p : toKill){
                    jewels[p.x][p.y].fade();
                    for (int c=p.y-1;c>=0;c--){
                        jewels[p.x][c].incOffset();
                    }
                }
	}


	public void testThree() {
		for(int r = 0; r < Puzzle.ROWS; r++) {
                    int n = 1;
			for(int c = 0; c < Puzzle.COLS; c++) {
                            if(c-1 < 0 ) continue;
                            if (jewels[r][c].getType() == jewels[r][c-1].getType()){
				n++;
                            }
                            else {
                                n = 1;
                            }
                            if (n>=3){
                                System.out.println("asdf");
				for (int k=0;k<n;k++){
                                    toKill.add(new Point(r,c-k));
                                }
                            }
                    }
		}
                
                for(int c = 0; c < Puzzle.COLS; c++) {
                    int n = 1;
			for(int r = 0; r < Puzzle.ROWS; r++) {
                            if(r-1 < 0 ) continue;
                            if (jewels[r][c].getType() == jewels[r-1][c].getType()){
				n++;
                            }
                            else {
                                n = 1;
                            }
                            if (n>=3){
                                System.out.println("asdf1");
				for (int k=0;k<n;k++){
                                    toKill.add(new Point(r-k,c));
                                }
                            }
                    }
		}
                
//                for(int r = 1; r < Puzzle.ROWS; r++) {
//                    int n = 1;
//			for(int c = 0; c < Puzzle.COLS; c++) {
//                            if (jewels[r][c].getType() == jewels[r-1][c].getType()){
//				n++;
//                            }
//                            else {
//                                n = 1;
//                            }
//                            if (n>=3){
//                                System.out.println("asdf");
//				for (int k=0;k<n;k++){
//                                    toKill.add(new Point(r-k,c));
//                                }
//                            }
//                    }
//		}

                for(Point p : toKill) {
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
