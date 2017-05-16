from pyspark import SparkContext
sc = SparkContext(appName="1gb")
file=sc.textFile("hdfs://172.31.14.182:9000/input")
wrd = file.flatMap(lambda line: line.split('/n')) \
             .map(lambda word: (word+' ',''))\
	     .sortByKey()
wrd.keys().saveAsTextFile("hdfs://172.31.14.182:9000/output")



