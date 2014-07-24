//Copyright @2014 KenLee All Rights Reserved
import info.gridworld.actor.Bug;
public class DancingBug extends Bug
{
	private int[] turnArray;
	private int arrayPos;
	
	public DancingBug(int[] array){
		turnArray=array;
		arrayPos=0;
	}
	public void turn(int times){
		for(int i=0;i<times;i++){
			super.turn();
		}
	}
	public void act(){
		if(arrayPos==turnArray.length){
			arrayPos=0;
		}
		this.turn(turnArray[arrayPos]);
		arrayPos++;
		super.act();
	}
};