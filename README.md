# SimpleScript Language Compiler

A compiler that for now demonstrates a syntax highlighting ast visitor on a TypeScript inspired language.

```typescript
var x: int = 2;
var y: int = 3;
var result: bool;
function add(a: int, b: int): int => return a + b;
if(add(x, y) >= 2) => { result = true; } else => { result = false; }
```
<sup>--- `simple.sl`</sup>

There are 2 possible means of compilation of the compiler: with Maven or with the `javac` and `jar` commands.

------------------------------------------------

### **Requirements:**

- JDK **14 or above**
- Maven installation (_Optional_)
- JAVA_HOME set to JDK 14 or above installation directory
- Access to commands like `java`, `javac`, `jar` in your PATH

------------------------------------------------

### **Generation of JAR executable (with Maven):**
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

### **Generation of JAR executable (with `javac` & `jar`):**
1. Open a terminal and go to project base directory.
2. Run the following commands to compile the source files into `target/` directory.
```
$ sudo chmod a+x ./compile.sh
$ sudo ./compile.sh
```
> Note: the script automaticly downloads the needed version of ANTLR Tools and puts it in `/usr/local/lib/`. If the file required already exists it is not downloaded.
3. If there is no build error the JAR file is generated as `target/ssl-compiler.jar`

------------------------------------------------

### **User manual:**
The compiler takes 1 input file. It must be passed as an argument, otherwise the compiler will return an error code ! 

Example:
```
$ java -jar target/ssl-compiler.jar examples/simple.sl
```

> Note: multiple example files can be found in the `examples/` directory. Including `invalid.sl` which demonstrates the detection of syntaxe errors.