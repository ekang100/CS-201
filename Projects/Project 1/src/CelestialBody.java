

/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * @author ola
 *
 * If you add code here, add yourself as @author below
 *
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		this.myXPos = xp;
		this.myYPos = yp;
		this.myXVel = xv;
		this.myYVel = yv;
		this.myMass = mass;
		this.myFileName = filename;

	}

	/**
	 *
	 * @return
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}

	/**
	 * Accessor for the x-velocity
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}

	/**
	 *
	 * @return
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		double xDifference = b.getX() - myXPos;
		double yDifference = b.getY() - myYPos;
		double distSquared = (xDifference * xDifference) + (yDifference * yDifference);
		double distance = Math.sqrt(distSquared);
		return distance;
	}

	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		double massOne = myMass;
		double massTwo = b.getMass();
		double gravity = 6.67e-11;
		double distance = calcDistance(b);
		double force = gravity * ((massOne * massTwo) / (distance * distance));
		return force;
	}

	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		double differenceX = b.getX() - this.getX();
		double radius = calcDistance(b);
		double force = calcForceExertedBy(b);
		double forceX = force *  differenceX / radius;
		return forceX;
	}
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		double differenceY = b.getY() - this.getY();
		double radius = calcDistance(b);
		double force = calcForceExertedBy(b);
		double forceY = force * differenceY / radius;
		return forceY;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double sum = 0.0;
		for(CelestialBody b : bodies) {
			if (!b.equals(this)) {
				sum = sum + calcForceExertedByX(b);
			}
		}
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for(CelestialBody b : bodies) {
			if(!b.equals(this)) {
				sum = sum + calcForceExertedByY(b);
			}
		}
		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		double ax = xforce / this.getMass();
		double ay = yforce / this.getMass();
		double nvx = myXVel + deltaT * ax;
		double nvy = myYVel + deltaT * ay;
		double nx = myXPos + deltaT * nvx;
		double ny = myYPos + deltaT * nvy;
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
