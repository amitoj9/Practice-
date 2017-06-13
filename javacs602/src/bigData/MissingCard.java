package bigData;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;




public class MissingCard {
    
public static class Mappers extends Mapper<LongWritable, Text, Text, IntWritable>{
  
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
    {    
        String line = value.toString();
        String[] lineSplit = line.split(" ");
        context.write(new Text(lineSplit[0]), new IntWritable(Integer.parseInt(lineSplit[1])));
    }
}

public static class Reducers extends Reducer<Text, IntWritable, Text, IntWritable>{   
    public void reduce(Text key, Iterable<IntWritable> value, Context context)
    throws IOException, InterruptedException {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int sum=0;
        int tempVal=0;
        for (IntWritable val : value) {
            sum+= val.get();
            tempVal=val.get();
            nums.add(tempVal);
        }
   
        if(sum<91){
            for (int i=1;i<=13;i++){
                if(nums.contains(i))
                     context.write(key, new IntWritable(i));
            }
    }
   
    }  
  
}

public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = new Job(conf, "Find missing Cards");
    job.setJarByClass(MissingCard.class);
    job.setMapperClass(Mappers.class);
    job.setReducerClass(Reducers.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
}
}