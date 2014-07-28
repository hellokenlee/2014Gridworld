//Copyright@2014 KenLee All Rights Reserved
import java.util.*;
import info.gridworld.grid.*;

@SuppressWarnings("unchecked")
public class SparseUnboundedGridHM<E> extends AbstractGrid<E>{
	//hash map key is Location
	//hash map value is Object
	private HashMap<Location,Object> occupantArray;
	private int maxCol;
	private int maxRow;
	//methods
	public SparseUnboundedGridHM(){

        maxCol=16;
        maxRow=16;
        occupantArray=new HashMap<Location,Object>();
        occupantArray.clear();
        System.out.println("SparseUnboundedGridHM ["+maxRow+"]"+"["+maxCol+"] has been created!");
	}
    private void resize(){
        maxRow=maxRow*2;
        maxCol=maxCol*2;
        System.out.println("resize to ["+maxRow+"]"+"  ["+maxCol+"]");
    }
	public int getNumRows(){
        return -1;
    }

    public int getNumCols(){
        return -1;
    }
    public boolean isEnough(Location loc){
        return loc.getRow()<maxRow &&loc.getCol()< maxCol;
    }
    public boolean isValid(Location loc){
        return 0 <= loc.getRow() && 0 <= loc.getCol();
    }
    public ArrayList<Location> getOccupiedLocations(){
        Set<Location> locSet=occupantArray.keySet();
        ArrayList<Location> theLocations = new ArrayList<Location>(locSet);
        return theLocations;
    }
    public E get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        return (E)occupantArray.get(loc);
    }
    public E put(Location loc, E obj)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");
        while(!isEnough(loc)){
            resize();
        }
        // Add the object to the grid.
        E oldOccupant = get(loc);
        occupantArray.put(loc,obj);
        return oldOccupant;
    }
    public E remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        // Remove the object from the grid.
        E r = get(loc);
        occupantArray.remove(loc);
        return r;
    }
};