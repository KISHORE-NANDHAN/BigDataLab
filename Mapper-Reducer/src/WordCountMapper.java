import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Convert the input value to a string
        String line = value.toString();
        String[] words = line.split("\\s+");

        // Emit a key-value pair for each word
        for (String w : words) {
            w = w.trim().toLowerCase();
            if (!w.isEmpty()) {
                word.set(w);
                context.write(word, one);
            }
        }
    }
}