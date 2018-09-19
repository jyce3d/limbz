package be.sdlg.limbz;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ViewPaneZY extends JPanel {
	public void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		g2.drawLine(398, 0, 398,444);
		g2.drawString("Y", 398+4, 8);
		g2.drawString("Z", 788, 222);
		g2.drawLine(0, 222, 796,222);
		//g2.drawLine(0, 284, 400, 284);
	}
}
