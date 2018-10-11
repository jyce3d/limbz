package be.sdlg.limbz;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.vecmath.Point3f;

public class StatusPane extends JPanel  {
	public 	Point3f mouse3DCoords = new Point3f();
	public void paintComponent(Graphics g) {
		String status;
		Graphics2D g2 =(Graphics2D) g;
		status = "x=" + mouse3DCoords.x+"; y="+mouse3DCoords.y+" ;z="+mouse3DCoords.z;
		g2.drawString(status, 8, 8);
	}
}
