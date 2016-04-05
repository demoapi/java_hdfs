# README.md

Run hadoop jar result  

```  
$ sudo /usr/local/hadoop-2.7.2/bin/hadoop jar /soft/java_hdfs-0.0.0.1.jar com.highill.practice.hdfs.HDFS
Hello World!
----- ----- Create HDFS path:hdfs://hadoop1:9000/test/java_program/hdfs success!

$ sudo /usr/local/hadoop-2.7.2/bin/hadoop jar /soft/java_hdfs-0.0.0.1.jar com.highill.practice.hdfs.HDFS
Hello World!
----- ----- Delete HDFS file:hdfs://hadoop1:9000/test/java_program/hdfs/rename_java_file.txt

```  




Clear test folder  

```  
$ sudo /usr/local/hadoop-2.7.2/bin/hadoop fs -rm -r /test

```  

