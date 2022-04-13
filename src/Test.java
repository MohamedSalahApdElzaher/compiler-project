/*
 * import antlr
 */
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.* ;
import java.io.IOException;

/*
 * main method
 */
public class Test {
    public static void main(String[] args) throws IOException {

        /* Some basic work

         * 1- take input
         * 2- pass it to lexer
         * 3- pass lexer to tokens
         * 4- pass tokens to parser
         * 5- define ParseTree with start rule

         */

        ANTLRInputStream input = new ANTLRInputStream(System.in);

     // OurClassLexer lexer = new OurClassLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

     // OurClassParser parser = new OurClassParser(tokens);

        ParseTree tree = parser . // {OurStart_rule};

    //  OurClassVisitor vistor = new OurClassVisitor();

    //  vistor.visit(tree);

       System.out.println("Done Successfully !!");

    }
}
