//Minal
import java.awt.Color;
import java.awt.Graphics;

public class Falcon9 extends Rocket {
	
	private double deltaTime;
	private double time=162;
	private double altitude=51795;
	private double mass=96570;//kg
	private double deltaMass=92670;//the fuel consumption in kg
	private double burnTime=397; //how long rocket burns
	private double Fthrust=9340000; //thrust force
	private double Fnet;//net force in kg
	private double acceleration;
	private double velocity;
	private double Fg=(mass*9.81)-((1/2)*(0.33)*(3.7)*(0.25)*(velocity));//gravity force, tried to include air resistance calculations but wasn't able to do it
	//private double y; //y position of rocket
	
	/*//variables for stage 2
	private double altitude2=51795;
	private double mass2=96570;
	private double deltaMass2=92670;
	private double burnTime2=397;
	private double Fthrust2 = 934000;
	private double time2=162;*/
	
	
	//constructor
	public Falcon9(double aX, double aY) {
		super(aX, aY, 3.7, 47, Color.BLACK, Color.RED);
		
		//y=aY;

		
		
	
	}

	//getters
	public double getDeltaTime() {
		return deltaTime;
	}
	public double getTime() {
		return time;
	}
	
	public double getMass() {
		return mass;
	}
	public double getDeltaMass() {
		return deltaMass;
	}
	public double getBurnTime() {
		return burnTime;
	}
	public double getAcceleration() {
		return acceleration;
	}
	public double getVelocity() {
		return velocity;
	}
	
	public double getFthrust() {
		return Fthrust;
	}
	
	public double getFg() {
		return Fg;
	}
	
	public double getFnet() {
		return Fnet;
	}
	
	public double getAltitude() {
		return altitude;
	}
	
	/*//getters for stage 2
	public double getMass2() {
		return mass2;
	}
	public double getDeltaMass2() {
		return deltaMass2;
	}
	public double getBurnTime2() {
		return burnTime2;
	}
	public double getAltitude2() {
		return altitude2;
	}
	public double getFthrust2() {
		return Fthrust2;
	}
	public double getTime2() {
		return time2;
	}*/
	
	//setters

	public void setDeltaTime(double deltaTime) {
		this.deltaTime = deltaTime;
	}
	public void setTime(double time) {
		this.time = time;
	}
	
	public void setMass(double mass) {
		this.mass=mass;
	}
	public void setDeltaMass(double deltaMass) {
		this.deltaMass=deltaMass;
	}
	public void setBurnTime(double burnTime) {
		this.burnTime = burnTime;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
	public void setFthrust(double Fthrust) {
		this.Fthrust = Fthrust;
	}
	
	public void setFg(double Fg) {
		this.Fg = Fg;
	}
	
	public void setFnet(double Fnet) {
		this.Fnet = Fnet;
	}
	
	//move method
	public void move(int h) {
	
	//calculate mass
	setMass(getMass() - (getDeltaMass() / getBurnTime()) * getDeltaTime()); 
	//calculate net force
    setFnet(getFthrust() - getFg());
    //calculate acceleration
    setAcceleration(getFnet()/getMass());
    //calculate velocity
    setVelocity(getVelocity() + (getAcceleration() * getDeltaTime()));
    //calculate altitude
    setAltitude(getAltitude() + (getVelocity()*getDeltaTime())-((1/2)*(0.33)*(3.7)*(0.25)*(getVelocity())));
    //calculate time
    setTime(getTime()+getDeltaTime());
	
  /* if (getTime() > 162)  {
		
		//calculate mass
		setMass(getMass2() - (getDeltaMass2()/getBurnTime2()) * getDeltaTime()); 
		//calculate net force
	    setFnet(getFthrust2() - getFg());
	    //calculate acceleration
	    setAcceleration(getFnet()/getMass());
	    //calculate velocity
	    setVelocity(getVelocity() + (getAcceleration() * getDeltaTime()));
	    //calculate altitude
	    setAltitude(getAltitude() + (getVelocity()*getDeltaTime()));
	    //calculate time
	    setTime(getTime()+getDeltaTime());
		
	}*/
    //had to set y in move method
    setY(h*(1-getAltitude()/3117589));
	
    
    
		


	}
	
	
}
