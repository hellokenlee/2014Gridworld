//Copyright@2014 KenLee All Rights Reserved
//the whole dataStructs looks like this
//occupantArray[10]= [0] [1] [2] ... 
//                    |   |   |
//                    X   X   null
//                    |   |    
//                    X   null
//                    |
//                    null
import java.util.*;
import info.gridworld.grid.*;
@SuppressWarnings("unchecked")
public class SparseBoundedGrid<E> extends AbstractGrid<E>{
	//node for SparseArray              
	//Copyright@2014 KenLee All Rights Reserved
    static public class OccupantInCol{
        public OccupantInCol(Object obj,int c){
            occupant=obj;
            col=c;
        }
        public Object occupant;
        public int col;
    }
	private LinkedList[] occupantArray;
	private int maxCol=0;
	//gouzao function:)
	public SparseBoundedGrid(int rows,int cols){
		if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");
        maxCol=cols;
        occupantArray=new LinkedList[rows];
        for(int i=0;i<rows;i++){
        	occupantArray[i]=new LinkedList<OccupantInCol>();
        }
        System.out.println("S.B.G ["+occupantArray.length+"]"+"["+maxCol+"] has been created!");
	}
	public int getNumRows(){
        return occupantArray.length;
    }

    public int getNumCols(){
        return maxCol;
    }
    public boolean isValid(Location loc){
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();
        // if we can find it in our list , it must be occupied,
        // so no need to call get() method
        for (int r=0;r<this.getNumRows();r++ ) {
        	Iterator it = occupantArray[r].iterator() ;
        	while(it.hasNext()){
                OccupantInCol temp=(OccupantInCol)it.next();
        		theLocations.add(new Location(r,temp.col));
        	}
        }
        return theLocations;
    }
    public E get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        Iterator it = occupantArray[loc.getRow()].iterator();
        while(it.hasNext()){
        	OccupantInCol a=(OccupantInCol)it.next();
        	if(a.col==loc.getCol()){
        		return (E) a.occupant;
        	}
        }
        return null;
    }
    public E put(Location loc, E obj)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");

        //if there exist old occupant, remove it!
        E oldOccupant = get(loc);
        if(oldOccupant!=null){
        	//! there may be some error here.
        	this.remove(loc);
        }
        // Add the object to the grid.
        occupantArray[loc.getRow()].add(new OccupantInCol(obj,loc.getCol()));
        return oldOccupant;
    }
    public E remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        // Remove the object from the grid.
        E r = get(loc);
        Iterator it = occupantArray[loc.getRow()].iterator();
        while(it.hasNext()){
            OccupantInCol a=(OccupantInCol)it.next();
            if(a.col==loc.getCol()){
                it.remove();
                break;
            }
        }
        return r;
    }
}