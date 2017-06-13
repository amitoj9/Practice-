package bigData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerFlightSchedule extends Reducer<Text,IntWritable,Text,DoubleWritable> {
    List<OnScheduleProbability> list = new ArrayList<>();
    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
      int totalCount = 0;
      int onSchedule = 0;
      for (IntWritable val : values) {
          totalCount += 1;
          if(val.get() == 1)
          {
            onSchedule += 1;
          }
      }
      double prob = (double)onSchedule/(double)totalCount;
      list.add(new OnScheduleProbability(prob,key.toString()));
   }

   //After reducer is done, write carriers on schedule prob. in reverse order
   protected void cleanupData(Context context) throws IOException, InterruptedException {
      Collections.sort(list, new ReverseSortOnSchdProbComp());
      for (OnScheduleProbability elem : list) {
          context.write(new Text(elem.carrier), new DoubleWritable(elem.probability ));
      }
  }
}