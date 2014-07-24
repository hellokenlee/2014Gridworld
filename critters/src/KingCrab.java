//Copyright@2014 KenLee All Rights Reserved

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter{
    //all actor means including flowers and rocks
	public void processActors(ArrayList<Actor> actors){
        for (Actor a : actors){
            boolean flag=false;
            Grid<Actor> actorGrid = this.getGrid();
            Location aLoc = a.getLocation();
            int movDir = this.getLocation().getDirectionToward(aLoc);
            //it can move to 3 optional grid away from king.
            for(int d = movDir - 45;d <= movDir + 45;d += 45){
                Location movLoc= aLoc.getAdjacentLocation(d);
                //can move
                if(actorGrid.isValid(movLoc) && actorGrid.get(movLoc)==null){
                    a.moveTo(movLoc);
                    flag=true;
                    break;
                }        
            }
            if(flag==false){
                a.removeSelfFromGrid();
            }
        }
    }
}