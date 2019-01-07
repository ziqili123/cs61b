public class Planet{
	public double xxPos = 1.0;
	public double yyPos = 2.0;
	public double xxVel = 3.0;
	public double yyVel = 4.0;
	public double mass = 5.0;
	public String imgFileName = "jupiter.gif";
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p){
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		double dissq = dx * dx + dy * dy;
		return Math.sqrt(dissq);
	}	
	public double calcForceExertedBy(Planet p){
		double G = 6.67* Math.pow(10,-11);
		double r = calcDistance(p);
		double force = (G*this.mass*p.mass)/(r*r);
		return force;
	}
	public double calcForceExertedByX(Planet p){
		double r = calcDistance(p);
		double force = calcForceExertedBy(p);
		double dx = this.xxPos - p.xxPos;
		double forcex = -(force*dx)/r;

		return forcex;
	}
	public double calcForceExertedByY(Planet p){
		double r = calcDistance(p);
		double force = calcForceExertedBy(p);
		double dy = this.yyPos - p.yyPos;
		double forcey = -(force*dy)/r;
		return forcey;
	}
	//1.7really restart it agian
}