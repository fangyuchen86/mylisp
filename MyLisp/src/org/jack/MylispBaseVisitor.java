// Generated from Mylisp.g4 by ANTLR 4.2.2
package org.jack;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link MylispVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <AbstractNode> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class MylispBaseVisitor<AbstractNode> extends AbstractParseTreeVisitor<AbstractNode> implements MylispVisitor<AbstractNode> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public AbstractNode visitForm(@NotNull MylispParser.FormContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public AbstractNode visitFile(@NotNull MylispParser.FileContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public AbstractNode visitLiteral(@NotNull MylispParser.LiteralContext ctx) { return visitChildren(ctx); }
}