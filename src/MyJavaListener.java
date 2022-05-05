import org.antlr.v4.runtime.*;


public class MyJavaListener extends JavaParserBaseListener{


    TokenStreamRewriter rewriter;
    int counter = 0;
    static int x = 1;
    public MyJavaListener(TokenStream tokens){

        rewriter = new TokenStreamRewriter(tokens);
    }
    //if statement
    @Override
    public void enterIfStatement(JavaParser.IfStatementContext ctx){
        String block = String.format("\"Block #%d\"", counter);
        if(ctx.getChild(2).getText().charAt(0) =='{') {   //  ( ) {

        }else{
            rewriter.insertAfter(ctx.pE().getStop(), '{');
            counter++;
            String alter = "\n\t\t intArray ["+counter+"] =1;";
            rewriter.insertAfter(ctx.pE().getStop(), alter);
            rewriter.insertAfter(ctx.ifS().getStop(), "\n\t\t}");
        }
        super.enterIfStatement(ctx);
    }

    // else satement
    /*
    @Override
    public void enterElseStatement(JavaParser.ElseStatementContext ctx) {
        String block = String.format("\"Block #%d\"", counter);
        if(ctx.getChildCount()>0){
            if(!ctx.elseS.getStart().getText().equals("if")){
                if(ctx.getChild(1).getText().charAt(0) =='{') {

                }
                else{
                    rewriter.insertAfter(ctx.ELSE().getSymbol(), '{');
                    String alter = "\n\t\t intArray ["+counter+"] =1;";
                    rewriter.insertAfter(ctx.elseS.getStop(), alter+"\n\t\t}");
                }
            }

        }
        super.enterElseStatement(ctx);
    }*/

    // while statement
    @Override
     public void enterWhileStatement(JavaParser.WhileStatementContext ctx) {
        String block = String.format("\"Block #%d\"", counter);
        if(ctx.getChild(2).getText().charAt(0) =='{') {

        }else{
            rewriter.insertAfter(ctx.pE().getStop(), '{');
            counter++;
            String alter = "\n\t\t intArray ["+counter+"] =1;";
            rewriter.insertAfter(ctx.pE().getStop(), alter);
            rewriter.insertAfter(ctx.whileS().getStop(), "\n\t\t}");

        }


        super.enterWhileStatement(ctx);

    }


// do while statement
    @Override
    public void enterDowhileStatement(JavaParser.DowhileStatementContext ctx) {

        String block = String.format("\"Block #%d\"", counter);
        if(ctx.getChild(1).getText().charAt(0) =='{') {

        }else{
            rewriter.insertAfter(ctx.pE().getStop(), '{');
            counter++;
            String alter = "\n\t\t intArray ["+counter+"] =1;";
            rewriter.insertAfter(ctx.pE().getStop(), alter);
            rewriter.insertAfter(ctx.whileS().getStop(), alter+"\n\t\t}");

        }
        super.enterDowhileStatement(ctx);

    }

/*
// for
    @Override
     public void enterForStatement(JavaParser.ForStatementContext ctx) {
        String block = String.format("\"Block #%d\"", counter);
        String alter = "\n\t\tSystem.out.println("+block+");";
        if(ctx.getChild(2).getText().charAt(0) =='{') {
            //rewriter.insertAfter(ctx.forS().getStart(),alter);
        }else{
            int end = ctx.forC().getStop().getTokenIndex();
            rewriter.insertAfter(end +1, "\n\t\t{ "+alter);
            //rewriter.insertAfter(ctx.getStop().getTokenIndex()-1, "\n\t\t break;");
            counter++;
            //int i = ctx.getStart().getTokenIndex();
            String alter1 = "\n\t\t intArray ["+counter+"] =1;";
            rewriter.insertAfter(ctx.forS().getStop().getTokenIndex(), alter1 + "}");
            //rewriter.insertAfter(ctx.getStop(), "\n\t\t}");

        }
        super.enterForStatement(ctx);
    }
*/
    @Override public void enterBlock(JavaParser.BlockContext ctx) {
        if (counter==0){
            int start = ctx.getStart().getTokenIndex();
            rewriter.insertAfter(start,"\n int[] intArray = new int[20]; \n");

            int end = ctx.getStop().getTokenIndex();
            rewriter.insertAfter(end-2,"\n PrintWriter out = new PrintWriter(\"Text/output"+ x++ +".txt\");\n" +
                    " for(int i=0 ; i< 20; i++){\n" +
                    "     if (intArray[i] == 1)\n" +
                    "        out.println(\"block#\"+i);\n" +
                    "\n" +
                    "     \n" +
                    " }\n" +
                    "        out.close();");

        }
        counter++;

        int i = ctx.getStart().getTokenIndex();
        String alter = "\n\t\t intArray ["+counter+"] =1;";
        rewriter.insertAfter(i, alter);

    }
}
