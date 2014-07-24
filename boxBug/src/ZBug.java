//Copyright @2014 KenLee All Rights Reserved

import info.gridworld.actor.Bug;

/**
 * A <code>ZBug</code> traces out a square "Z" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int zCounter;

    /**
     * Constructs a Z bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        zCounter=1;
        turn();
        turn();
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act(){
        if( canMove() && zCounter < 4){
                if (steps < sideLength){
                    move();
                    steps++;
                }
                else {
                    if(zCounter==1){
                        turn();
                        turn();
                        turn();
                    }
                    else if(zCounter == 2){
                        turn();
                        turn();
                        turn();
                        turn();
                        turn();
                    }
                    steps = 0;
                    zCounter++;
                }
        }
    }
};
