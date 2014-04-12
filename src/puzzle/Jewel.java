package puzzle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Jewel {
   public static final int RED=0,YELLOW=1,BLUE=2,GREEN=3,PURPLE=4,PINK=5;
   
   public static final int SIZE = 80;
   
    private int type;
    
    private boolean selected;
    
    private int offset;
    
    public Jewel() {
        type = (int) (Math.random() * 6);
        selected = false;
    }
    
    public int getType(){
    	return type;
    }
    
    public int setType(int type){
    	this.type = type;
    	return type;
    }
    
    public void paint(int x, int y, Graphics2D g, Component c) {
        switch(type) {
            case RED:
            /*	BufferedImage img1 = null;
                try {
                	img1 = ImageIO.read(new File("images/fire.jpg"));
                }catch(IOException e){
                	e.printStackTrace();
                }
                g.drawImage(img1, x, y, null);*/
            	ImageIcon icon1 = new ImageIcon(this.getClass()
                        .getResource("/images/fire.jpg"));
            	icon1.paintIcon(c,g,x,y);
                break;
            case YELLOW:
            	/*BufferedImage img2 = null;
                try {
                	img2 = ImageIO.read(new File("images/yellow.jpg"));
                }catch(IOException e){
                	e.printStackTrace();
                }
                g.drawImage(img2, x, y, null);*/
            	ImageIcon icon2 = new ImageIcon(this.getClass()
                        .getResource("/images/yellow.jpg"));
            	icon2.paintIcon(c,g,x,y);
                break;
            case BLUE:
            	/*BufferedImage img3 = null;
                try {
                	img3 = ImageIO.read(new File("images/blue.jpg"));
                }catch(IOException e){
                	e.printStackTrace();
                }
                g.drawImage(img3, x, y, null);*/
            	ImageIcon icon3 = new ImageIcon(this.getClass()
                        .getResource("/images/blue.jpg"));
            	icon3.paintIcon(c,g,x,y);
                break;
            case GREEN:
            	/*BufferedImage img4 = null;
                try {
                	img4 = ImageIO.read(new File("images/green.jpg"));
                }catch(IOException e){
                	e.printStackTrace();
                }
            	g.drawImage(img4, x, y, null);*/
            	ImageIcon icon4 = new ImageIcon(this.getClass()
                        .getResource("/images/green.jpg"));
            	icon4.paintIcon(c,g,x,y);
                break;
            case PURPLE:
            	/*BufferedImage img5 = null;
                try {
                	img5 = ImageIO.read(new File("images/purple.jpg"));
                }catch(IOException e){
                	e.printStackTrace();
                }
            	g.drawImage(img5, x, y, null);*/
            	ImageIcon icon5 = new ImageIcon(c.getClass()
                        .getResource("/images/purple.jpg"));
            	icon5.paintIcon(c,g,x,y);
                break;
            case PINK:
            	/*BufferedImage img6 = null;
                try {
                	img6 = ImageIO.read(new File("images/heart.png"));
                }catch(IOException e){
                	e.printStackTrace();
                }
            	g.drawImage(img6, x, y, null);*/
            	ImageIcon icon6 = new ImageIcon(this.getClass().getResource("images/heart.png"));
            	icon6.paintIcon(c,g,x,y);
                break;
            
        }
        
        if(selected) {
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(3));
            g.drawRect(x, y, SIZE, SIZE);
        }
    }
    
    public void setSelected(boolean x) {
        selected = x;
    }
    
    public void setOffset(int x) {
    	offset = x;
    }
}
