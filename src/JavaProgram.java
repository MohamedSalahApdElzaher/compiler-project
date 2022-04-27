import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileInputStream;
import java.util.*;

public class JavaProgram{
    public static void main(String[] args) throws Exception {

        CharStream input = CharStreams.fromFileName("test/test.java");

        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);


        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        MyJavaListener myListner = new MyJavaListener(tokens);
        walker.walk(myListner, tree); // initiate walk of tree with listener

        File fileObjOutput = new File("output/output.java");

        FileWriter FW = new FileWriter("output/output.java");
        FW.write(myListner.rewriter.getText().replace("test" , "output"));
        FW.close();

    }
}
