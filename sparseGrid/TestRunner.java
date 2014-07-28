//Copyright@2014 KenLee All Rights Reserved
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.actor.*;
/**
* This class runs a world with additional grid choices.
*/
public class TestRunner
{
  public static void main(String[] args)
  {
    ActorWorld world = new ActorWorld();
    world.addGridClass("SparseBoundedGridLLOC");
    world.addGridClass("SparseBoundedGridSGN");
    world.addGridClass("SparseBoundedGridHM");
    world.addGridClass("SparseBoundedGridTM");
    world.addGridClass("SparseUnboundedGridHM");
    world.add(new Location(9, 9),new Bug());
    world.show();
  }
}