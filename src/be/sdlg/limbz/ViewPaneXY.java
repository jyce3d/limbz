package be.sdlg.limbz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewPaneXY extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LimbzApp m_parent = null;
	public ViewPaneXY(LimbzApp parent) {
		m_parent =  parent;
		addMouseListener(this);
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		g2.drawLine(398, 0, 398,444);
		g2.drawLine(0, 222, 796, 222);
		g2.drawString("Y", 400, 8);
		g2.drawString("X", 788, 222);
		g2.setPaint(Color.GRAY);
		g2.fill(new Rectangle(0,0,200,200));
		g2.setPaint(Color.WHITE);
		g2.drawString("Pos=" + Double.toString(m_parent.m_pt.getX()), 8,16);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		PointerInfo a=MouseInfo.getPointerInfo();
		m_parent.m_pt = a.getLocation();
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
