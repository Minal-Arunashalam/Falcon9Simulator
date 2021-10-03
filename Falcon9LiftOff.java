//Minal

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Falcon9LiftOff extends JPanel{

private static final int w = 800;
private static final int h = 1000 ;

private BufferedImage image;
private Graphics g;
private Timer timer;
private Falcon9 falcon9;


public Falcon9LiftOff() {
	
	image = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
	g = image.getGraphics();

	falcon9 = new Falcon9(450,1000);
	falcon9.setY(h*(1-falcon9.getAltitude()/3117589));
	falcon9.draw(g);

	falcon9.setDeltaTime(0.5);

	timer = new Timer(5,new TimerListener());
	timer.start();

}
private class TimerListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		
	if (falcon9.getTime()<=falcon9.getBurnTime()) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,w,h);
	
	
	falcon9.move(h);
	falcon9.draw(g);

	g.setFont(new Font("Times New Roman", Font.BOLD,20));
	g.setColor(Color.BLACK);
	g.drawString("Falcon9 Info: ",10, 20);
	g.drawString(("Time: " + (falcon9.getTime())), 30, 45);
	g.drawString(("Mass: " + (falcon9.getMass())), 30, 65);
    g.drawString(("NetForce: " + (falcon9.getFnet())), 30, 95);
    g.drawString(("Acceleration: " + (falcon9.getAcceleration())), 30, 125);
    g.drawString(("Velocity: " + (falcon9.getVelocity())), 30, 155);
    g.drawString(("Altitude: " + (falcon9.getAltitude())), 30, 185);
           
    repaint();
	}
	
	
	
}
}




public void paintComponent(Graphics g) {
	g.drawImage(image, 0, 0, getWidth(), getHeight(),null);

}

public static void main(String[] args) {
// TODO Auto-generated method stub
JFrame frame = new JFrame("Falcon9 Launch");
frame.setSize(w,h);
frame.setLocation(0,0);;
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setContentPane(new Falcon9LiftOff());
frame.setVisible(true);
}

}
