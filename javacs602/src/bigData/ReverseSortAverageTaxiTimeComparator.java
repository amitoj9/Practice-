package bigData;

import java.util.Comparator;

public class ReverseSortAverageTaxiTimeComparator implements Comparator<AverageTaxiTime> {
    @Override
    public int compare(AverageTaxiTime o1, AverageTaxiTime o2) {
      if( o1.avg > o2.avg )
        return -1;
      else if( o1.avg < o2.avg )
        return 1;
      else
        return 0;
    }
}