echo "Compiling"
javac *.java
copy /Y *.class C:\apache-tomcat-7.0.34\webapps\csj\WEB-INF\classes\
C:\apache-tomcat-7.0.34\bin\shutdown

C:\apache-tomcat-7.0.34\bin\startup
