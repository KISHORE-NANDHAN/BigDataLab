import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class CharCountDriver {

  public static void main(String[] args) throws Exception {

    if (args.length != 2) {

      System.err.println("Usage: WordCount <input path> <output path>");

      System.exit(-1);

    }

    @SuppressWarnings("deprecation")

	Job job = new Job();

    job.setJobName("Char Count");

    job.setJarByClass(CharCountDriver.class);

    FileInputFormat.addInputPath(job, new Path(args[0]));

    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    job.setMapperClass(CharCountMapper.class);

    job.setReducerClass(CharCountReducer.class);

    job.setOutputKeyClass(Text.class);

    job.setOutputValueClass(IntWritable.class);

    System.exit(job.waitForCompletion(true) ? 0 : 1);

   }

}
