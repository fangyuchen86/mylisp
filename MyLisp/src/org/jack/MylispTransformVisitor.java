package org.jack;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MylispTransformVisitor extends MylispBaseVisitor<AbstractNode> {
	
	@Override public AbstractNode visitForm(@NotNull MylispParser.FormContext ctx){
		
		
		
		return visitChildren(ctx); 
	}
	
	@Override public AbstractNode visitLiteral(@NotNull MylispParser.LiteralContext ctx) {
		TerminalNode node = (TerminalNode)ctx.getChild(0);
		int type = node.getSymbol().getType();
		if(type == MylispLexer.SYMBOL){
			return new LiteralNode(MylispLexer.SYMBOL, node.getText());
		}
		
		return null;
	}
	
	@Override
	protected AbstractNode aggregateResult(AbstractNode aggregate, AbstractNode nextResult) {
		return nextResult;
	}
}
