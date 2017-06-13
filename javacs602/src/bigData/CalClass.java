package bigData;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CalClass {	
	public static void main(String[] args)throws Exception{
		Configuration conf = new Configuration();
        	Job job = new Job(conf, "Word Count");
        	job.setJarByClass(CalClass.class);
        	job.setMapperClass(Mappers.class);
        	job.setReducerClass(Reducers.class);
        	job.setMapOutputKeyClass(Text.class);
        	job.setMapOutputValueClass(LongWritable.class);
        	job.setOutputKeyClass(Text.class);
        	job.setOutputValueClass(Text.class);
        	FileInputFormat.setInputPaths(job, new Path(args[0]));
        	FileOutputFormat.setOutputPath(job, new Path(args[1]));
       	 	job.waitForCompletion(true);
    	}
}
