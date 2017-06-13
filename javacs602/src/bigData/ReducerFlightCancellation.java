package bigData;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerFlightCancellation extends Reducer<Text,IntWritable,Text,IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
      int totalCount = 0;
      for (IntWritable val : values) {
          totalCount += val.get();
      }
      context.write(new Text(key), new IntWritable(totalCount));
   }
}