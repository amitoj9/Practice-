package bigData;

import java.util.Comparator;

public class ReverseSortOnSchdProbComp  implements Comparator<OnScheduleProbability> {
    @Override
    public int compare(OnScheduleProbability o1, OnScheduleProbability o2) {
      if( o1.probability > o2.probability )
        return -1;
      else if( o1.probability < o2.probability )
        return 1;
      else 
        return 0;
    }
}