package org.jack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MylispTransformVisitor extends MylispBaseVisitor<AbstractNode> {
	
	@Override public AbstractNode visitForm(@NotNull MylispParser.FormContext ctx){
		
		AbstractNode node = null;
		
		
		
		AbstractNode headChild =  visitChildren(ctx); 
		List<AbstractNode> children = createChildrenList(headChild);
		
		if(children.size() > 0 && children.get(0) instanceof LiteralNode){
			LiteralNode literalNode = (LiteralNode) children.get(0);
			if(literalNode.getType() == MylispLexer.SYMBOL && literalNode.getValue().equals("declare")){
				node = new DeclareNode();
				List<AbstractNode> newChildren = children.subList(1, children.size());
				node.setChildren(newChildren);
				setParent(node, newChildren);
			} else if(literalNode.getType() == MylispLexer.SYMBOL && literalNode.getValue().equals("fun")){
				node = new FunNode();
				List<AbstractNode> newChildren = children.subList(1, children.size());
				node.setChildren(newChildren);
				setParent(node, newChildren);
			}
			else{
				node = new CallNode();
				node.setChildren(children);
				setParent(node, children);
			}
		}else{
			node = new CallNode();
			node.setChildren(children);
			setParent(node, children);
		}
		
		return node; 
	}
	
	@Override public AbstractNode visitFile(@NotNull MylispParser.FileContext ctx) { 
		FileNode file = new FileNode();
		
		AbstractNode headChild =  visitChildren(ctx); 
		List<AbstractNode> children = createChildrenList(file, headChild);
		file.setChildren(children); 
		return file;
	}
	
	private void setParent(AbstractNode parent, List<AbstractNode> list){
		for(AbstractNode n : list){
			n.setParent(parent);
		}
	}
	
	private List<AbstractNode> createChildrenList(AbstractNode parent, AbstractNode headChild){
		List<AbstractNode> children = new ArrayList<AbstractNode>();
		while(headChild != null){
			headChild.setParent(parent);
			children.add(headChild);
			headChild = headChild.getNext();
		}
		Collections.reverse(children);
		return children;
	}
	
	private List<AbstractNode> createChildrenList(AbstractNode headChild){
		List<AbstractNode> children = new ArrayList<AbstractNode>();
		while(headChild != null){
			children.add(headChild);
			headChild = headChild.getNext();
		}
		Collections.reverse(children);
		return children;
	}
	
	@Override public AbstractNode visitLiteral(@NotNull MylispParser.LiteralContext ctx) {
		TerminalNode node = (TerminalNode)ctx.getChild(0);
		int type = node.getSymbol().getType();
		if(type == MylispLexer.SYMBOL || type == MylispLexer.STRING){
			return new LiteralNode(type, node.getText());
		}else if(type == MylispLexer.NUMBER){
			return new LiteralNode(type, new Double(node.getText()));
		}else if(type == MylispLexer.NIL){
			return new LiteralNode(type, Nil.getNil());
		}else if(type == MylispLexer.BOOLEAN){
			return new LiteralNode(type, Boolean.parseBoolean(node.getText()));
		}
		return null;
	}
	
	@Override
	protected AbstractNode aggregateResult(AbstractNode aggregate, AbstractNode nextResult) {
		if(nextResult != null){
			nextResult.setNext(aggregate);
			return nextResult;
		}else{
			return aggregate;
		}
	}
	
	@Override
	protected boolean shouldVisitNextChild(@NotNull RuleNode node, AbstractNode currentResult) {
		return true;
	}
}
