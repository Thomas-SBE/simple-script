ANTLR_FILE=/usr/local/lib/antlr-4.11.1-complete.jar

if [ -f "$ANTLR_FILE" ]; then
    echo "Found ANTLR Tools 4.11.1"
else
    echo "Downloading missing ANTLR Tools 4.11.1"
    curl -o /usr/local/lib/antlr-4.11.1-complete.jar https://www.antlr.org/download/antlr-4.11.1-complete.jar
fi

export CLASSPATH=".:/usr/local/lib/antlr-4.11.1-complete.jar:$CLASSPATH"

find ./src -type f -name "*.java" > _srcs
javac -d ./target @_srcs
rm _srcs

cd target
echo "Manifest-Version: 1.0\nMain-Class: net.tsbe.App\nClass-Path: /usr/local/lib/antlr-4.11.1-complete.jar" > MANIFEST.MF
find . -type f -name "*.class" > _classes
jar cvfm ssl-compiler.jar MANIFEST.MF @_classes
rm MANIFEST.MF _classes