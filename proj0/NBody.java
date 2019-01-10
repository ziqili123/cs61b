public class NBody{


	public static double readRadius(String Filename){
		In fileread = new In(Filename);
		int numPlanets = fileread.readInt();
		double radius = fileread.readDouble();
		return radius;
			}

	public static Planet[] readPlanets(String Filename){
		In fileread = new In(Filename);
		int numPlanets = fileread.readInt();
		double radius = fileread. readDouble();
		Planet[] planetArray = new Planet[numPlanets];
		for(int i=0; i< numPlanets;i++){
			double xxPos = fileread.readDouble();
			double yyPos = fileread.readDouble();
			double xxVel = fileread.readDouble();
			double yyVel = fileread.readDouble();
			double mass = fileread. readDouble();
			String imgFileName = fileread.readString();
			planetArray[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planetArray;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double univradius = readRadius(filename);
		Planet[] allPlanets = readPlanets(filename);

		StdDraw.setScale(-univradius, univradius);
		StdDraw.picture(0, 0, "images/starfield.jpg");

		for(Planet p : allPlanets){
			p.draw();
		}
	}

}