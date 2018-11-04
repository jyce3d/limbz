package be.sdlg.limbz;

import javax.vecmath.Point3f;

public class TriFace {
	Point3f[] tf = new Point3f[3];
	
	TriFace(Point3f p1, Point3f p2, Point3f p3) {
		tf[0] = p1;
		tf[1] = p2;
		tf[2] = p3;
	}
}
