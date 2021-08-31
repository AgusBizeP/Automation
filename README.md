# Automation Project 1Center

Maven installation and Set up

Maven is JAVA based tool, the first requirement is to have JDK installed on your machine
System Requirement
 Java 1.5 or above

Step 1 : Verify Java Installation on your machine
 java -version

If it does not recognize command, please download and install java from https://www.oracle.com/java/technologies/javase-jdk16-downloads.html

 Step2: Set JAVA enviroment (GO to system properties and modify variables path)
 
 Windows: 
 JAVA_HOME=C:\Program Files\Java\jdk1.8.0_60
 PATH=%JAVA_HOME%\bin
-------------------------
 MAC:

Open terminal and execute this command:

 echo $JAVA_HOME 
If returns a location, you dont need to do anything else.
If you need to set up enviroment :
1 . Please type this command

nano ~/.bash_profile

2 . Please type this command

export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME/bin:/auto/share/bin:$PATH

3 . Press CTRL+O. 
4 . Press CTRL+X.
5 . Validate path typing, after typing it will return path:
echo $echo $JAVA_HOME

-------------------------
 Step 3 Download Maven archive
 Download Maven 2.2.1 from http://maven.apache.org/download.html
 Windows: Zip file
 Mac: tar.gz

 Step 4: Extract the maven archive
 Recommended Location: 
 Windows: C:\Program Files\Apache\apache-maven-3.3.3
 MAC: /usr/local/apache-maven

 Step 5: Set the enviroment variables using system properties
Windows:
 M2_HOME=C:\Program Files\Apache\apache-maven-3.3.3
 M2=%M2_HOME%\bin
 MAVEN_OPTS=-Xms256m -Xmx512m

MAC:
Open command terminal ans set enviroment variables
Type

vi ~/.bash_profile

export M2_HOME=/usr/local/apache-maven/apache-maven-3.8.2
export M2=%M2_HOME%/bin
export MAVEN_OPTS=-Xms256m -Xmx512m

Step 6: Add Maven bin directory location to system path
Windows: Append the string ;%M2% to the end of the system variable.
MAC: export PATH=$M2:$PATH

Step 7 : Verify Maven installation

mvn -version