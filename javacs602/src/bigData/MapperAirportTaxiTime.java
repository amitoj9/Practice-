package bigData;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperAirportTaxiTime extends Mapper<Object, Text, Text, IntWritable>{

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] tokens = line.split(",");
        String origin = tokens[16];
        String dest = tokens[17];
        String taxiIn = tokens[19];
        String taxiOut = tokens[20];
        //Emit (origin + TaxiOut) & (dest + TaxiIn) for each flight
        if(!origin.equals("NA") && !origin.equals("Origin") &&
                  !dest.equals("NA") && !dest.equals("Dest") &&
                  !taxiIn.equals("NA") && !taxiIn.equals("TaxiIn") &&
                  !taxiOut.equals("NA") && !taxiOut.equals("TaxiOut") )
        {
            int in = Integer.parseInt(taxiIn);
            int out = Integer.parseInt(taxiOut);
            context.write(new Text(origin), new IntWritable(out));
            context.write(new Text(dest), new IntWritable(in));
        }
  }
}