// Generated from Mylisp.g4 by ANTLR 4.2.2
package org.jack;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MylispParser}.
 *
 * @param <AbstractNode> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MylispVisitor<AbstractNode> extends ParseTreeVisitor<AbstractNode> {
	/**
	 * Visit a parse tree produced by {@link MylispParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	AbstractNode visitForm(@NotNull MylispParser.FormContext ctx);

	/**
	 * Visit a parse tree produced by {@link MylispParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	AbstractNode visitFile(@NotNull MylispParser.FileContext ctx);

	/**
	 * Visit a parse tree produced by {@link MylispParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	AbstractNode visitLiteral(@NotNull MylispParser.LiteralContext ctx);
}