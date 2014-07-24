//Copyright@2014 KenLee All Rights Reserved
import info.gridworld.actor.*;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
public class BlusterCritter extends Critter{
	public int courage=0;
	private static final double COLOR_FACTOR = 0.05;
	//if x<0 darker; x>0 brighter.
	private void changeColor(int x){
		double ratio=0;
		if(x<=0){
			ratio=1 - COLOR_FACTOR;
		}
		if(x>0){
			ratio=1 + COLOR_FACTOR;
		}
		Color c = getColor();
        int red =(int) (c.getRed() * (ratio));
        int green = (int) (c.getGreen() * (ratio));
        int blue = (int) (c.getBlue() * (ratio));
        if(red>255){
        	red=255;
        }
        if(green>255){
        	green=255;
        }
        if(blue>255){
        	blue=255;
        }
        this.setColor(new Color(red, green, blue));
	}
	public BlusterCritter(int c){
		courage=c;
	}
	public ArrayList<Actor> getActors()
    {
        //inorder not to add repeated elements use HashSet
        //to init a Array
        HashSet<Actor> actorSet=new HashSet<Actor>();
       	for (Actor near : this.getGrid().getNeighbors(this.getLocation())) {
       		actorSet.add(near);
       		for(Actor far : near.getGrid().getNeighbors(near.getLocation())){
       			actorSet.add(far);
       		}
       	}
       	actorSet.remove(this);
       	ArrayList<Actor> actorArray=new ArrayList<Actor>(actorSet);
        return actorArray;
    }
    public void processActors(ArrayList<Actor> actors)
    {
        //System.out.println(actors.size());
        this.changeColor(courage-actors.size());     	
    }
    //stay still for debug use
    // public void makeMove(Location loc){

    // }
};