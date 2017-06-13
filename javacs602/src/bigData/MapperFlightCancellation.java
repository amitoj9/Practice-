package bigData;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperFlightCancellation extends Mapper<Object, Text, Text, IntWritable>{
    IntWritable one = new IntWritable(1);
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] tokens = line.split(",");
        String cancel = tokens[21];
        String code = tokens[22];
        //Emit Cancellation Code if the flight is cancelled 
        if(!cancel.equals("NA") && !cancel.equals("Cancelled") && cancel.equals("1") &&
                  !code.equals("NA") && !code.equals("CancellationCode") && !code.isEmpty())
        {
            context.write(new Text(code), one);
        }
  }
}