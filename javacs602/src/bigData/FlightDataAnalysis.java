package bigData;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlightDataAnalysis {

    public static class MapperFlightSchedule extends Mapper<Object, Text, Text, IntWritable>{

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            final int thres = 10;
            String line = value.toString();
            String[] tokens = line.split(","); 
            String year = tokens[0];
            String carriers = tokens[8];
            String arrivalDelay = tokens[14];
            String departureDelay = tokens[15];
      	    if(!year.equals("NA") && !year.equals("Year") &&
                      !carriers.equals("NA") && !carriers.equals("Uniquecarriers") &&
                      !arrivalDelay.equals("NA") && !arrivalDelay.equals("arrivalDelay") &&
                      !departureDelay.equals("NA") && !departureDelay.equals("departureDelay") )
            {
                if ( (Integer.parseInt(arrivalDelay) + Integer.parseInt(departureDelay) ) <= thres)
                    context.write(new Text(carriers), new IntWritable(1));
                else
                    context.write(new Text(carriers), new IntWritable(0));
            }
      }
    }

}
