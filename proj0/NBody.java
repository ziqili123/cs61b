public class NBody{


	public static double readRadius(String Filename){
		In fileread = new In(Filename);
		int numPlanets = fileread.readInt();
		double radius = fileread.readDouble();
		return radius;
			}
// read the radius of the universe

	public static Planet[] readPlanets(String Filename){
		In fileread = new In(Filename); //visualize
		int numPlanets = fileread.readInt();
		double radius = fileread. readDouble();
		Planet[] planetArray = new Planet[numPlanets];

		for(int i=0; i< numPlanets;i++){
			double xxPos = fileread.readDouble();
			// the first time I use NIntelliJ
			double yyPos = fileread.readDouble();
			double xxVel = fileread.readDouble();
			double yyVel = fileread.readDouble();
			double mass = fileread. readDouble();
			String imgFileName = fileread.readString();
			planetArray[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}

		return planetArray;
	}
	//read the data of the planets

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

		StdDraw.enableDoubleBuffering();
		double timeinterval = 0;
		while(timeinterval < T){
			double xForces[] = new double [allPlanets.length];
			double yForces[] = new double [allPlanets.length];
			for(int i=0;i<allPlanets.length; i++){
				double xForce = allPlanets[i].calcNetForceExertedByX(allPlanets);
				double yForce = allPlanets[i].calcNetForceExertedByY(allPlanets);
				xForces[i] = xForce;
				yForces[i] = yForce;
			}
			for(int i=0;i<allPlanets.length;i++){
				allPlanets[i].update(dt , xForces[i], yForces[i] );	
			}

			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (Planet p: allPlanets){

				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
			timeinterval +=dt;
		}
		StdOut.printf("%d\n", allPlanets.length);
		StdOut.printf("%.2e\n", univradius);
		for(int i = 0; i < allPlanets.length; i++){
		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
							allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName );
		}
	}
}