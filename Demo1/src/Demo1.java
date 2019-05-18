//bbbb
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

//Hello World
public class Demo1 {

	@Test
	public void testMkDir() throws Exception {

		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.40.128:9000");

		FileSystem client = FileSystem.get(conf);

		client.mkdirs(new Path("/temp"));

		client.close();
	}

	@Test
	public void testUpload() throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.40.128:9000");

		FileSystem client = FileSystem.get(conf);

		InputStream in = new FileInputStream("C:\\software\\Eclipse\\data.txt");

		OutputStream out = client.create(new Path("/temp/data.txt"));

		IOUtils.copyBytes(in, out, 1024);

		client.close();
	}

}
