package bigData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerAirportTaxiTime extends Reducer<Text,IntWritable,Text,DoubleWritable> {
    List<AverageTaxiTime> list = new ArrayList<>();
    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
      int totalCount = 0;
      int taxiTime = 0;
      for (IntWritable val : values) {
          totalCount += 1;
          taxiTime += val.get();
      }
      double avg = (double)taxiTime/(double)totalCount;
      list.add(new AverageTaxiTime(avg,key.toString()));
   }

 

   // Comparator class for reverse sorting the average taxi time of airports 
 

   //After reducer is done, write airport's average taxi times in reverse order
   protected void cleanupData(Context context) throws IOException, InterruptedException {
      Collections.sort(list, new ReverseSortAverageTaxiTimeComparator());
      for (AverageTaxiTime elem : list) {
          context.write(new Text(elem.airport), new DoubleWritable(elem.avg ));
      }
  }
}