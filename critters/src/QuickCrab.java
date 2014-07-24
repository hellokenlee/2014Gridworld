//Copyright@2014 KenLee All Rights Reserved

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter{
	public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        for (Location nextloc : getLocationsInDirections(dirs,this.getLocation())){
        	if (getGrid().get(nextloc) == null){
        		boolean flag=false;
        		for (Location next2loc : getLocationsInDirections(dirs,nextloc)){
        			if(getGrid().get(next2loc)==null){
        				locs.add(next2loc);
        				flag=true;
        			}
        		}
        		if(!flag){
        			locs.add(nextloc);
        		}
            }
        }
        return locs;
    }
    public ArrayList<Location> getLocationsInDirections(int[] directions,Location selfLoc)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = selfLoc;
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
    }
}