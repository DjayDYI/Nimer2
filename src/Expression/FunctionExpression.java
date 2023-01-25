package Expression;

import Antlr.TParser;
import Expression.SymbolTable.AbstractSyntaxTree;
import Expression.SymbolTable.Method;

import java.util.ArrayList;

public class FunctionExpression extends Expression{


    public FunctionExpression(TParser.MethodContext ctx, AbstractSyntaxTree abstractSyntaxTree) {
        // function name
        String id = ctx.ID().getText();

        // Parameters
        ArrayList<String> param = new ArrayList<>();
        for(var v:ctx.arguments().expr())
            param.add(v.getText());

        // Block statement
        abstractSyntaxTree.visit(ctx.stat_block());

        abstractSyntaxTree.table.addFunc(id,new Method(param, ctx.stat_block()));
    }

    @Override
    public Value create() {
        return Value.VOID;
    }
}
