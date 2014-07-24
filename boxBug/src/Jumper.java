//Copyright @2014 KenLee All Rights Reserved
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;

//Behavior Descirption:(think it like a Cricket)
//	- it behave like a bug unless it comes to a rock or a flower
//	- if there is a flower or a rock in fornt of it, it will attempt to jump
//	- if where it's jump falls is not valid (e.g. there is an actor or out of bound...) it will stay and do nothing

public class Jumper extends Bug
{
	//a jumper is always black
	public Jumper(){
		this.setColor(Color.BLACK);
	}
	public boolean canJump(){
		// if the jumper is not in a grid 
		Grid<Actor> selfGrid = this.getGrid();
		if(selfGrid==null)
			return false;
		Location selfLoc = this.getLocation();
		if(selfLoc==null)
			return false;
		Location neighbourLoc = selfLoc.getAdjacentLocation(this.getDirection());
		if(!selfGrid.isValid(neighbourLoc))
			return false;
		Actor neighbor = selfGrid.get(neighbourLoc);
		if((neighbor instanceof Flower)||(neighbor instanceof Rock)){
			Location jumpLoc = neighbourLoc.getAdjacentLocation(this.getDirection());
			if(!selfGrid.isValid(jumpLoc))
				return false;
			if(selfGrid.get(jumpLoc)==null)
				return true;
		}
		return false;
	}
	// the jump method MUST be call after canJump()!
	public void jump(){
		Grid<Actor> selfGrid = this.getGrid();
		if(selfGrid==null)
			return ;
		Location selfLoc = this.getLocation();
		Location jumpLoc=selfLoc.getAdjacentLocation(this.getDirection()).getAdjacentLocation(this.getDirection());
		moveTo(jumpLoc);
	}
	public void act(){
		//if there is a flower or a rock in front of a Jumer ,
		if(canJump()){
			jump();
		}
		//else act like a bug
		else{
			super.act();
		}
	}
};