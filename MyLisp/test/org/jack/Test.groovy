package org.jack;

import static org.junit.Assert.*

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

class Test {

	@org.junit.Test
	public void test() {
		def input = 
		'''
			(("god" "thank") "like")
			(declare ("hello" (fun "test")))
		'''

//			def input =
//		   '''
//			(god world test)
//		   '''
		   
		ANTLRInputStream inputSteam = new ANTLRInputStream(input)
		
		MylispLexer lexer = new MylispLexer(inputSteam);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		MylispParser parser = new MylispParser(tokens);
		
		ParseTree tree = parser.file();
		
		MylispTransformVisitor visitor = new MylispTransformVisitor();
		AbstractNode node = visitor.visit(tree);
		
		println(node)
		
		println(tree.toStringTree(parser))
		
	}

}
