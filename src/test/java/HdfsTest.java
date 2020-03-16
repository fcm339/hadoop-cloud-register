import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.InputStream;
import java.net.URI;

/**
 * description
 *
 * @author hzl 2020/03/16 2:51 PM
 */
public class HdfsTest {

	@Test
	public void mkdir() {
		Configuration conf = new Configuration();
		InputStream inputStream = null;
		try {
			conf.set("dfs.replication", "1");
			conf.set("fs.defaultFS", "hdfs://localhost:9000");

			FileSystem fs = FileSystem.get(new URI("hdfs://localhost:9000"), conf, "root");
			Path srcPath = new Path("/txt");
			fs.mkdirs(srcPath);
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeStream(inputStream);
		}
	}

}
