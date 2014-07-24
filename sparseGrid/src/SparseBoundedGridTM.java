//Copyright@2014 KenLee All Rights Reserved
import java.util.*;
import info.gridworld.grid.*;

@SuppressWarnings("unchecked")
public class SparseBoundedGridTM<E> extends AbstractGrid<E>{
	//hash map key is Location
	//hash map value is Object
	private TreeMap<Location,Object> occupantArray;
	private int maxCol;
	private int maxRow;
	//methods
	public SparseBoundedGridTM(int rows,int cols){
		if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");
        maxCol=cols;
        maxRow=rows;
        occupantArray=new TreeMap<Location,Object>();
        occupantArray.clear();
        System.out.println("SparseBoundedGridTM ["+maxRow+"]"+"["+maxCol+"] has been created!");
	}
	public int getNumRows(){
        return maxRow;
    }

    public int getNumCols(){
        return maxCol;
    }
    public boolean isValid(Location loc){
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
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