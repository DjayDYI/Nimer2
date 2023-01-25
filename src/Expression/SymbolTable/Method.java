package Expression.SymbolTable;

import Antlr.TParser;
import Expression.Value;

import java.util.ArrayList;
import java.util.List;

public class Method {

    ArrayList<String> params;
    TParser.Stat_blockContext context;
    TParser.ReturnContext return_;

    public Method(ArrayList<String> params, TParser.Stat_blockContext ctx) {
        this.params = params;
        this.context = ctx;
    }

    public Value call(List<TParser.ExprContext> ctx, AbstractSyntaxTree caller) {
        for (int i=0;i<params.size();i++) {
            caller.table.addVariable(params.get(i), new Value(Double.valueOf(ctx.get(i).getText())));
        }
        return caller.visit(this.context);
    }
}

