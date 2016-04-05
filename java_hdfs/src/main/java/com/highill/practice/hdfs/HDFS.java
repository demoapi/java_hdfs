package com.highill.practice.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Hello world!
 *
 */
public class HDFS {
	static final String hdfsPath = "hdfs://hadoop1:9000/test/java_program/hdfs";

	public static void main(String[] args)
	{
		System.out.println("Hello World!");

		byte[] textContent = "This is a java program, use HDFS api test!".getBytes();
		try
		{
			Configuration config = new Configuration();
			FileSystem fileSystem = FileSystem.get(config);

			Path path1 = new Path(hdfsPath);
			if (!fileSystem.exists(path1))
			{
				fileSystem.mkdirs(path1);
				System.out.println("----- ----- Create HDFS path:" + hdfsPath + " success! ");
			} else
			{
				FileStatus[] fileStatusArray = fileSystem.listStatus(path1);
				if (fileStatusArray != null && fileStatusArray.length > 0)
				{
					for (FileStatus fileStatus : fileStatusArray)
					{
						Path tempPath = fileStatus.getPath();
						fileSystem.delete(tempPath, true);
						System.out.println("----- ----- Delete HDFS file:" + tempPath);
					}
				}
			}

			Path filePath = new Path(hdfsPath + "/java_file.txt");
			FSDataOutputStream fsDataOutput = fileSystem.create(filePath);
			fsDataOutput.write(textContent, 0, textContent.length);

			Path renamePath = new Path(hdfsPath + "/rename_java_file.txt");
			fileSystem.rename(filePath, renamePath);

			fileSystem.close();

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
