//Copyright@2014 KenLee All Rights Reserved
import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
//this Critter will walk around and turn other critter into zombie
public class ZombieCritter extends Critter{
	private ActorWorld world=null;
	public ZombieCritter(ActorWorld w){
		world=w;
		this.setColor(Color.GREEN);
	}
	public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (a instanceof Critter && !(a instanceof ZombieCritter)){
            	Location temploc = a.getLocation();
            	a.removeSelfFromGrid();
            	System.out.println("ouch!");
            	if(world!=null){
            		world.add(temploc,new ZombieCritter(world));
            	}
            }
                
        }
    }
	public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT,Location.AHEAD,Location.HALF_CIRCLE};
        for (Location loc : getLocationsInDirections(dirs))
            if (getGrid().get(loc) == null)
                locs.add(loc);

        return locs;
    }
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
    }
}