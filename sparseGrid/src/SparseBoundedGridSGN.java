//Copyright@2014 KenLee All Rights Reserved
import java.util.*;
import info.gridworld.grid.*;

@SuppressWarnings("unchecked")

public class SparseBoundedGridSGN<E> extends AbstractGrid<E>{
	//inner class
	static public class SparseGridNode{
		public SparseGridNode(Object obj,int c,SparseGridNode n){
			occupant=obj;
			col=c;
			next=n;
		}
	    public Object occupant=null;
	    public int col=-1;
	    public SparseGridNode next=null;
	}
	//array 
	private SparseGridNode[] occupantArray;
	private int maxCol=0;
	//methods
	public SparseBoundedGridSGN(int rows,int cols){
		if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");
        maxCol=cols;
        occupantArray=new SparseGridNode[rows];
        for(int i=0;i<rows;i++){
        	occupantArray[i]=null;
        }
        System.out.println("sparseBoundedGridSGN ["+occupantArray.length+"]"+"["+maxCol+"] has been created!");
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
    public ArrayList<Location> getOccupiedLocations(){
        ArrayList<Location> theLocations = new ArrayList<Location>();
        // if we can find it in our list , it must be occupied,
        // so no need to call get() method
        for (int r=0;r<this.getNumRows();r++ ) {
        	SparseGridNode it=occupantArray[r];
        	while(it!=null){
        		theLocations.add(new Location(r,it.col));
        		it=it.next;
        	}
        }
        return theLocations;
    }
    public E get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        SparseGridNode it=occupantArray[loc.getRow()];
        while(it!=null){
        	if(it.col==loc.getCol()){
        		return (E) it.occupant;
        	}
        	it=it.next;
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
        SparseGridNode it=occupantArray[loc.getRow()];
        //if it's first element
        if(it==null){
        	occupantArray[loc.getRow()]=new SparseGridNode(obj,loc.getCol(),null);
        	return oldOccupant;
        }
        //if there is already has some element
        while(it.next!=null){
        	it=it.next;
        }
        occupantArray[loc.getRow()]=new SparseGridNode(obj,loc.getCol(),null);
        return oldOccupant;
    }
    public E remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        // Remove the object from the grid.
        E r = get(loc);
        SparseGridNode it=occupantArray[loc.getRow()];
        //remove the head
        if(it.col==loc.getCol()){
        	occupantArray[loc.getRow()]=it.next;
        	return r;
        }
        //remove the middle
        SparseGridNode front=null;
        while(it.next!=null){
        	front=it;
        	it=it.next;
        	if(it.col==loc.getCol()){
        		front.next=it.next;
        		it.next=null;
        		return r;
        	}
        }
        //remove the tail
        if(it.col==loc.getCol()&&front!=null){
        	front.next=null;
        }
        return r;
    }
}