//MatrixMultiplyReducer.java

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;
import java.util.*;

public class MatrixMultiplicationReducer extends Reducer<Text, Text, Text, IntWritable> {

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Map<Integer, Integer> a = new HashMap<>();
        Map<Integer, Integer> b = new HashMap<>();

        for (Text val : values) {
            String[] tokens = val.toString().split(",");
            if (tokens[0].equals("A")) {
                a.put(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            } else {
                b.put(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }
        }

        // Calculate dot product of the row and column
        for (Integer k : a.keySet()) {
            if (b.containsKey(k)) {
                int sum = a.get(k) * b.get(k);
                context.write(key, new IntWritable(sum));
            }
        }
    }
}
