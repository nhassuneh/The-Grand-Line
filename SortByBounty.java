package tgl;

import java.util.Comparator;

public class SortByBounty implements Comparator<Boat>{
    
    public int compare(Boat a, Boat b)
    {
 
        return b.bounty - a.bounty;
    }
}
