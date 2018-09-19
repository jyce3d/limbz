package be.sdlg.limbz;

import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Point3f;
public class LimbzApp extends JFrame implements MouseListener {
	/**
	 * 
	 */
	ArrayList<Point3f> points = new ArrayList<Point3f>() ;

	float module = 22.5f/3.5f;
	public int getPane(Point pt) {
		String status;
		if ((pt.getX() <=444) && (pt.getY()<=398)) {
			paneStatus.mouse3DCoords.y=(float)pt.getY() * 22.5f/398f;
			paneStatus.mouse3DCoords.x = (float) pt.getX() * 16.07f/444f;
			paneStatus.invalidate();
			paneStatus.repaint();
			
			return PANEXY;
		} else if ((pt.getX() <=444) && (pt.getY()>=398)) {
			return PANEXZ;
		} else if ((pt.getX() >444) && (pt.getY()<=398) ) {
			return PANEYZ;
		}
		else return 0;
		
	}
	public static final int PANEXY =1;
	public static final int PANEYZ =2;
	public static final int PANEXZ =3;
	
	JPanel pane = new JPanel();
	StatusPane paneStatus = new StatusPane();
	ViewPaneXY paneYX = new ViewPaneXY();
	ViewPaneZY paneZY = new ViewPaneZY();
	ViewPaneXZ paneXZ = new ViewPaneXZ();

	private static final long serialVersionUID = 1L;
	@Override
	public void mouseClicked(MouseEvent arg0) {
		PointerInfo a=MouseInfo.getPointerInfo();
		Point pt = a.getLocation();
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public LimbzApp() {
		super("Limbz");
		setSize(1600,960);

		GridLayout family =new GridLayout(2,2);
		pane.setLayout(family);
		pane.add(paneYX);
		pane.add(paneZY);
		pane.add(paneXZ);
		pane.add(paneStatus);
		setContentPane(pane);	
		// ymax =444
		// xmax = 796
		// 0 = 222, 398
	}
	public static void main(String arv[]) {
		LimbzApp appFrame = new LimbzApp();
		appFrame.show();
		appFrame.setResizable(false);
	}
}
