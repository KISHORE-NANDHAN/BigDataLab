//MatrixMultiplyMapper.java
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;

public class MatrixMultiplicationMapper extends Mapper<LongWritable, Text, Text, Text> {

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] tokens = value.toString().split(",");
        int i = Integer.parseInt(tokens[0].trim());
        int j = Integer.parseInt(tokens[1].trim());
        int val = Integer.parseInt(tokens[2].trim());

        if (tokens.length == 3) {
            // Matrix A (i, j, value)
            context.write(new Text(i + ","), new Text("A," + j + "," + val));
        } else {
            // Matrix B (j, k, value)
            context.write(new Text(j + ","), new Text("B," + i + "," + val));
        }
    }
}
