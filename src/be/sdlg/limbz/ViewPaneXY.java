package be.sdlg.limbz;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ViewPaneXY extends JPanel {
	public void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		g2.drawLine(398, 0, 398,444);
		g2.drawLine(0, 222, 796, 222);
		g2.drawString("Y", 400, 8);
		g2.drawString("X", 788, 222);
	}
}
