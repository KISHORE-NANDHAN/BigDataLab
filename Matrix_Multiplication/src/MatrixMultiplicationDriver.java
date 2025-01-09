import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.conf.*; 
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat; 
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class MatrixMultiplicationDriver 

{

	public static void main(String[] args) throws Exception 

	{

		Configuration conf = new Configuration();

		// M is an m-by-n matrix; N is an n-by-p matrix. 

		conf.set("m", "2");

		conf.set("n", "2");

		conf.set("p", "2");

		Job job = Job.getInstance(conf, "MatrixMultiplication"); 

		job.setJarByClass(MatrixMultiplicationDriver.class); 

		job.setOutputKeyClass(Text.class); 

		job.setOutputValueClass(Text.class);

		job.setMapperClass(MatrixMultiplicationMapper.class); 

		job.setReducerClass(MatrixMultiplicationReducer.class);

		job.setInputFormatClass(TextInputFormat.class); 

		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));

		FileOutputFormat.setOutputPath(job, new Path(args[1])); 
		boolean success = job.waitForCompletion(true);

		System.exit(success?0:1);

}

}