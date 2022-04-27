import org.antlr.v4.runtime.*;
public class MyJavaListener extends JavaParserBaseListener{

    TokenStreamRewriter rewriter;
    int if_Counter = 0;
    int else_Counter = 0;

    public MyJavaListener(TokenStream tokens){
        rewriter = new TokenStreamRewriter(tokens);
    }

    @Override
    public void enterIfStatement(JavaParser.IfStatementContext ctx){
        String block = String.format("\"Block #%d\"", if_Counter);
        String alter = "\n\t\tSystem.out.println("+block+");";
        if(ctx.getChild(2).getText().charAt(0) =='{') {   //  ( ) {
            rewriter.insertAfter(ctx.ifS.getStart(), alter);
        }else{
            rewriter.insertAfter(ctx.pE.getStop(), '{');
            rewriter.insertAfter(ctx.ifS.getStop(), alter+"\n\t\t}");
        }
        if_Counter++;
        super.enterIfStatement(ctx);
    }

    @Override
    public void enterElseStatement(JavaParser.ElseStatementContext ctx) {
        String block = String.format("\"Block #%d\"", ++else_Counter);
        String alter = "\n\t\tSystem.out.println("+block+");";
        if(ctx.getChildCount()>0){
            if(!ctx.elseS.getStart().getText().equals("if")){
                if(ctx.getChild(1).getText().charAt(0) =='{') {
                    rewriter.insertAfter(ctx.elseS.getStart(), alter);
                }
                else{
                    rewriter.insertAfter(ctx.ELSE().getSymbol(), '{');
                    rewriter.insertAfter(ctx.elseS.getStop(), alter+"\n\t\t}");
                }
            }

        }
        super.enterElseStatement(ctx);
    }
}
