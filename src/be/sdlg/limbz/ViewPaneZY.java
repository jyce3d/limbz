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

import javax.swing.JPanel;
import javax.vecmath.Point3f;

public class ViewPaneZY extends JPanel implements MouseListener {
	private LimbzApp m_parent = null;
	public Point m_pt = null;
	public void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		g2.setPaint(Color.BLUE);		
		g2.fill(new Rectangle(0,0,796,444));
		g2.setPaint(Color.YELLOW);
		g2.drawLine(398, 0, 398,444);
		g2.drawString("Y", 398+4, 8);
		g2.drawString("Z", 788, 222);
		g2.drawLine(0, 222, 796,222);
		if (m_pt !=null ) {
			g2.drawString("Pos (Z,Y)=(" + Double.toString(m_pt.getX()) +","+m_pt.getY()+")" , 8,16);
			displayLimbz(g);
		}
	}
	public ViewPaneZY(LimbzApp parent) {
		m_parent =  parent;
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		PointerInfo a=MouseInfo.getPointerInfo();
		m_pt = a.getLocation();
		
		// Create triFace
		Point3f cur=new Point3f();

		
		cur.z=(float) ((m_pt.getX()-(398+800)) * 11.25f/398f);
		cur.y=(float) (((m_pt.getY()-222)-24) * 11.25f/222f);
		if (m_parent.m_pt3d !=null )
				cur.x = m_parent.m_pt3d.x;
		else
			cur.x=0;
		m_parent.points.add(cur);
		m_parent.m_pt3d = cur;

		Point3f cur2=new Point3f();
		cur2.z=(float) ((m_pt.getX()-(398+800)) * 11.25f/398f);
		cur2.y=(float) ((m_pt.getY()-222)-16) * 11.25f/222f;
		cur2.x = m_parent.m_pt3d.x;

		m_parent.points.add(cur2);
		m_parent.m_pt3d = cur2;

		Point3f cur3=new Point3f();
		cur3.z=(float) ((m_pt.getX()-(390+800)) * 11.25f/398f);
		cur3.y=(float) ((m_pt.getY()-222)-24) * 11.25f/222f;
		cur3.x = m_parent.m_pt3d.x;

		m_parent.points.add(cur3);
		m_parent.m_pt3d = cur3;

		TriFace triFace = new TriFace(cur, cur2, cur3);
		m_parent.triFaces.add(triFace);
		m_parent.refreshAll();
			
	}
	public void displayLimbz(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		for(TriFace cur : m_parent.triFaces) {
			int x,y;
			for (int i=0; i<3; i++) {
				x=(int) ((cur.tf[i].z * 398f/11.25f)+398+800);
				y=(int) ((cur.tf[i].y *222f/11.25f)+222);
				g2.setPaint(Color.YELLOW);
				g2.drawOval(x-2, y-2, 4, 4);
			}
		}
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
	public void refresh() {
		this.repaint();
	}
	
}
