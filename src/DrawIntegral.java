import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

import javax.swing.JOptionPane;

/*
  Here, we are essentially graphing the integral of y = 2x. We draw tiny lines with slope 2x for every x, incrementing
  by a miniscule dx. As you can see from the drawing, the result is the graph y = x^2. You can also see from the output
  that the graph is y=x^2, as every x increment of 1 gets us to a new square.
 */

public class DrawIntegral extends Applet{
	
	static int maxX = 500;
	static int maxY = 500;
	
	static int num_sides;
	static int length;
	
	public void init(){
		setSize(maxX, maxY);
	}
	
	public void start(){
		repaint();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		double dx = 0.000001;
		double y = maxY/2;
		
		int count = 0;
		for(double x = maxX/2; x < maxX; x+=dx){
			Shape l = new Line2D.Double(x, y, x + dx, y + (2*(dx+(x-250))*dx));
			g2.draw(l);
			y -= (2*(dx+(x-250))*dx);
			if(y < 0) break;
			
			if(count % 1000000 == 0){
				System.out.println(x + " " + (250-y));
			}
			count++;
			//if(((int) x-250) % 1 == 0) System.out.println(x + " " + y);
		}
		
		y = maxY/2;
		for(double x = maxX/2; x < maxX; x-=dx){
			Shape l = new Line2D.Double(x, y, x - dx, y + (2*((250-x)+dx)*dx));
			g2.draw(l);
			y -= (2*((250-x)+dx)*dx);
			if(y < 0) break;
			//if(((int) x-250) % 1 == 0) System.out.println(x + " " + y);
		}
	}
}
