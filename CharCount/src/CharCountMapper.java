import java.io.IOException;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;

public class CharCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override

  public void map(LongWritable key, Text value, Context con)

      throws IOException, InterruptedException {

    String line = value.toString();

    char[] chars = line.toCharArray();

    for(char c:chars) {

    	con.write(new Text("Total Characters"), new IntWritable(1));

    }

  }

}


