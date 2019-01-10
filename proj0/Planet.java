public class Planet{
	public double xxPos ;
	public double yyPos ;
	public double xxVel ;
	public double yyVel ;
	public double mass ;
	public String imgFileName ;
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
	public double calcNetForceExertedByX(Planet[] ps){
		double netForceX = 0;
		for (Planet p : ps){
			if (!this.equals(p)){
				netForceX += this.calcForceExertedByX(p);
			}

		}
		return netForceX;
	}
	public double calcNetForceExertedByY(Planet[] ps){
		double netForceY = 0;
		for(Planet p : ps){
			if(!this.equals(p)){
				netForceY +=this.calcForceExertedByY(p);

			}
		}
		return netForceY;
	}
	public void update(double dt, double fX, double fY){
		double accelerationX = fX /this.mass;
		double accelerationY = fY /this.mass;
		this. xxVel = this. xxVel+ accelerationX*dt;
		this. yyVel = this. yyVel + accelerationY*dt;
		this.xxPos = this.xxVel*dt + this.xxPos;
		this.yyPos = this.yyVel*dt + this.yyPos;


	}
	//1.7really restart it agian
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}
}