import java.io.IOException;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Reducer;

public class CharCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

  /*

   * bigdata   <1>

   */

  @Override

  public void reduce(Text key, Iterable<IntWritable> values,Context con)

      throws IOException, InterruptedException {   

	  int sum = 0;

	  for(IntWritable i:values) {

		  sum = sum + i.get();

	  }

	  con.write(key, new IntWritable(sum));

      }

}
