package info.gridworld.maze;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
	public Location next;
	public Location last;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug() {
		setColor(Color.GREEN);
		last = new Location(0, 0);
		crossLocation.push(new ArrayList<Location>());
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		boolean willMove = canMove();
		if (isEnd == true) {
		//to show step count when reach the goal		
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		}
		//move forward
		else if (willMove) {
			ArrayList<Location> a=new ArrayList<Location>();
			a.add(this.getLocation());
			crossLocation.push(a);
			last=this.getLocation();
			if(this.getGrid().get(next) instanceof Rock){
				isEnd=true;
			}
			move();
			//increase step count when move 
			stepCount++;
		}
		//step back
		else{
			Location temp=this.getLocation();
			next=last;
			move();
			crossLocation.pop();
			if(crossLocation.peek().size()!=0){
				last=crossLocation.peek().get(0);
			}
			crossLocation.peek().add(temp);
		}
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return null;
		ArrayList<Location> valid = new ArrayList<Location>();
		for(int dir=0;dir<360;dir+=90){
			Location around=loc.getAdjacentLocation(dir);
			// the loc is not out of bound
			if(gr.isValid(around)){
				// the loc's grid is nothing or flower
				Actor aroundActor=gr.get(around);
				if(aroundActor==null || aroundActor instanceof Flower 
					|| (aroundActor instanceof Rock && aroundActor.getColor().getRGB()==Color.RED.getRGB())){
					//the loc has not been visited!
					if(!crossLocation.peek().contains(around)){
						valid.add(around);
					}
				}
			}
		}
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		ArrayList<Location> nextArray=this.getValid(this.getLocation());
		if(nextArray.size()==0)
			return false;
		else{
			Random r=new Random();
			int p=r.nextInt(nextArray.size());
			this.next=nextArray.get(p);
			return true;
		}
	}
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		if (gr.isValid(next)) {
			setDirection(getLocation().getDirectionToward(next));
			moveTo(next);
		} else
			removeSelfFromGrid();
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}
}
