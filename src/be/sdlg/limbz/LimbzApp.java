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
public class LimbzApp extends JFrame  {
	/**
	 * 
	 */
	ArrayList<Point3f> points = new ArrayList<Point3f>() ;
	
	
	public Point3f m_pt3d;
	float module = 22.5f/3.5f;
	
	public float step = 8; // pixel

	/*public int getPane(Point pt) {
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
		
	}*/
	ArrayList<TriFace> triFaces = new ArrayList<TriFace>();
	
	public static final int PANEXY =1;
	public static final int PANEYZ =2;
	public static final int PANEXZ =3;
	
	public static final int STATUS_SELECTED = 0;
	public static final int STATUS_TRI = 2;
	public static final int STATUS_QUAD = 4;

	public Point m_pt = null;
	// Selection
	public int m_status =0;
	public TriFace m_selTriFace = null;

	JPanel pane = new JPanel();
	StatusPane paneStatus = new StatusPane();
	ViewPaneXY paneXY = new ViewPaneXY(this);
	
	ViewPaneZY paneZY = new ViewPaneZY(this);
	ViewPaneXZ paneXZ = new ViewPaneXZ(this);

	private static final long serialVersionUID = 1L;
	public void refreshAll(){
		paneXY.refresh();
		paneZY.refresh();
		paneXZ.refresh();
	}
	public LimbzApp() {
		super("Limbz");
		setSize(1600,960);

		GridLayout family =new GridLayout(2,2);
		pane.setLayout(family);
		pane.add(paneXY);
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
