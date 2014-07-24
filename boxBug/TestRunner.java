//Copyright @2014 KenLee All Rights Reserved
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import java.awt.Color;

public class TestRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Jumper a=new Jumper();
        BoxBug b=new BoxBug(2);
        world.add(new Location(1,2),b);
        world.add(new Location(5, 5),a);
        world.add(new Rock());
        world.show();
    }
}