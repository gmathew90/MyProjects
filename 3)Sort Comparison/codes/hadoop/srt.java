import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class srt {

  public static class mppr
       extends Mapper<Object, Text, Text, NullWritable>{

    NullWritable n=NullWritable.get();
    Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {

        word.set(value.toString()+" ");
        context.write(word, n);
      }
    }


  public static class rdcr
       extends Reducer<Text,NullWritable,Text,NullWritable> {


        NullWritable s=NullWritable.get();
public void reduce(Text key, Iterable<NullWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {

      for (NullWritable val : values) {
        s= val;
      }

      context.write(key,s);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(srt.class);
    job.setMapperClass(mppr.class);
    job.setCombinerClass(rdcr.class);
    job.setReducerClass(rdcr.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(NullWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}

            
