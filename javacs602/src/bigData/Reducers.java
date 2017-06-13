package bigData;
	import java.io.IOException;
	import java.util.TreeSet;

	import org.apache.hadoop.io.DoubleWritable;
	import org.apache.hadoop.io.LongWritable;
	import org.apache.hadoop.io.Text;
	import org.apache.hadoop.mapreduce.Reducer;

	public class Reducers extends Reducer<Text, LongWritable,Text, Text>{
		
		DoubleWritable count = new DoubleWritable();
		DoubleWritable relCount = new DoubleWritable();
		Text word = new Text("");
		TreeSet<Results> temp_Output = new TreeSet<>();
		TreeSet<Results> sortedOutput = new TreeSet<>();
		
		public TreeSet<Results> getSortedOutput() {
			return sortedOutput;
		}

		public void setSortedOutput(TreeSet<Results> sortedOutput) {
			this.sortedOutput = sortedOutput;
		}
		
		@Override
		protected void reduce(Text key, Iterable<LongWritable> value,
				Reducer<Text, LongWritable, Text, Text>.Context con) throws IOException, InterruptedException {
			String[] keys = key.toString().split(" ");
			if(keys[1].equals("*")){
				if(keys[0].equals(word.toString())){
					count.set(count.get() + getCount(value));
				}
				else{
					word.set(keys[0]);
					count.set(0);
					count.set(getCount(value));
				}
			}
			
			else{
				double cnt = getCount(value);
				relCount.set((double)cnt / count.get());
				Double rel = relCount.get();
				temp_Output.add(new Results(rel, key.toString(), word.toString()));
				if (temp_Output.size() > 100) {
					temp_Output.pollLast();
				}
	        }
	    }
		
		private double getCount(Iterable<LongWritable> values) {
			double count = 0;
			for (LongWritable value : values) {
				count += value.get();
			}
			return count;
		}
		
		protected void cleanup(Context context)
	            throws IOException,
	            InterruptedException {
			while(!temp_Output.isEmpty()){
				Results p1= temp_Output.pollFirst();
				context.write(new Text(p1.key+" / "+p1.key.split(" ")[0] + " ="), new Text(Double.toString(p1.relFreq)));
			}
		}
		
		
		    
	}
