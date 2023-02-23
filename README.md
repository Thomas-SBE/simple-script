# SimpleScript Language Compiler

A compiler that for now demonstrates a syntax highlighting ast visitor on a TypeScript inspired language.

------------------------------------------------

### **Requirements:**

- JDK **14 or above**
- Maven installation
- JAVA_HOME set to JDK 14 or above installation directory

------------------------------------------------

### **Generation of JAR executable:**
1. Open a terminal and go to project base directory.
2. Check if Maven's JDK is set to 14 or above by typing:
```
$ mvn -version
Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: --> 14.0.2 <--, vendor: Oracle Corporation, runtime: /usr/lib/jvm/jdk-14.0.2
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.15.79.1-microsoft-standard-wsl2", arch: "amd64", family: "unix"
```
3. Type `mvn clean package` in the terminal.
4. If there is no build error the JAR file is generated as `target/ssl-compiler.jar`

------------------------------------------------

### **User manual:**
The compiler takes 1 input file. It must be passed as an argument, otherwise the compiler will return an error code ! 

Example:
```
$ java -jar target/ssl-compiler.jar example/simple.sl
```

> Note: multiple example files can be found in the `examples/` directory. Including `invalid.sl` which demonstrates the detection of syntaxe errors.