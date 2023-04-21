# SimpleScript Language Compiler

A compiler that takes a TypeScript inspired language to transcript it to MIPS32.
```typescript
var a: int = 2;
var b: int = 2;
var result: bool = false;
if(a == b) => result = true;
else => result = false;
print(result);
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
> ⚠️ Note: This language does not take a `main` function as entry. the whole script is the entry point. Creating a function named `main` will juste create a function with that name !

Example:
```
$ java -jar target/ssl-compiler.jar <flags>
```
#### Flags:

| **Flag**             | **Description**                                       |
|----------------------|-------------------------------------------------------|
| `-i <filepath>`      | SimpleScript file path that will be read.             |
| `-input <filepath>`  | SimpleScript file path that will be read.             |
| `-o <filepath>`      | MIPS32 Output file generated.                         |
| `-output <filepath>` | MIPS32 Output file generated.                         |
| `-f[hHv]` | Enable features of the compiler. see *features* below |

#### Features:

| **Feature** | **Description**                                      |
|-------------|------------------------------------------------------|
| `h`         | Display the syntax highlighter before optimizations. |
| `H`         | Display the syntax highlighter after optimizations.  |
| `v`         | Display the detailed steps of the compiler.          |
> Note: multiple example files can be found in the `examples/` directory. Including `invalid.sl` which demonstrates the detection of syntaxe errors.