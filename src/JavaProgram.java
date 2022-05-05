import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.io.File;  // Import the File class
import java.util.ArrayList;
import java.util.List;

public class JavaProgram{
    static int x = -1, count =1;

    static List<Integer> list_color = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        for(int i =1;i<4; i++) {
        CharStream input = CharStreams.fromFileName("test/test"+i+".java");

        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        MyJavaListener myListner = new MyJavaListener(tokens);
        walker.walk(myListner, tree); // initiate walk of tree with listener


            File fileObjOutput = new File("output/output" + i + ".java");

            FileWriter FW = new FileWriter("output/output" + i + ".java");
            FW.write(myListner.rewriter.getText().replace("test", "output"));
            FW.close();

            //compile direct
            // Compile source file.
            Process theProcess = null;
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(null, null, null, fileObjOutput.getPath());
            try {
                theProcess = Runtime.getRuntime().exec("java output/" + fileObjOutput.getName());
            } catch (IOException e) {
                System.err.println("Error on exec() method");
                e.printStackTrace();
            }

            /*
             *  write java code to generate html | css files
             */

            CharStream in = CharStreams.fromFileName("Text/output"+i+".txt");
            String ss = in.toString().replace(" ", "");
            String[] chars = ss.split(","); // 4
            for(int j=0;j<chars.length;j++){
                String _s = chars[j];
                for(int c=0;c<_s.length();c++){
                    if(Character.isDigit(_s.charAt(c))){
                        // blocks number
                        list_color.add(Integer.valueOf(_s.charAt(c)+""));
                    }
                }
            }

            genHtml(myListner.rewriter.getText(), i);

            System.out.println(x);
            System.out.println(list_color.toString());

            File cssFile = new File("html/style"+i+".css");
            String s = "";
            for (int v: list_color) {
                 s += "#b" + v + " {background-color:LimeGreen;}\n";
            }

            while (x-- > 0){
                if(!list_color.contains(x)){
                    if (x == 0){
                        s += "#b" + x + " {background-color: LimeGreen;}\n";
                    }else{
                        s += "#b" + x + " {background-color: red;   padding-left:10px; margin-left:-10px; margin-right:-10px;}\n";
                    }
                }
            }

            FileUtils.writeStringToFile(cssFile, s);

            x =-1;
            list_color.clear();


        }

    }

    /*
     *  generate html | css file
     */

    static void genHtml(String s, int i) throws IOException {
        StringBuilder builder = new StringBuilder("");
        for (char c : s.toCharArray()) {
            builder.append(c);
            if (c == '{') builder.append("<p id=\"b" + x++ + "\"" + ">");
            if (c == '}') builder.append("</p>");
            if (c == ';') builder.append("<br>");
        }
        File htmlTemplateFile = new File("html/template.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile);
        htmlString = htmlString.replace("$body", builder.toString());
        htmlString = htmlString.replace("$li", "href=\"style"+i+".css\"");
        File newHtmlFile = new File("html/output"+ count++ +".html");
        FileUtils.writeStringToFile(newHtmlFile, htmlString);
    }

}
