// Generated from Mylisp.g4 by ANTLR 4.2.2
package org.jack;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MylispParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, STRING=3, NUMBER=4, NIL=5, BOOLEAN=6, SYMBOL=7, WS=8, 
		COMMENT=9;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'('", "STRING", "NUMBER", "'nil'", "BOOLEAN", "SYMBOL", 
		"WS", "COMMENT"
	};
	public static final int
		RULE_file = 0, RULE_form = 1, RULE_literal = 2;
	public static final String[] ruleNames = {
		"file", "form", "literal"
	};

	@Override
	public String getGrammarFileName() { return "Mylisp.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MylispParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public List<FormContext> form() {
			return getRuleContexts(FormContext.class);
		}
		public FormContext form(int i) {
			return getRuleContext(FormContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MylispVisitor ) return ((MylispVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << STRING) | (1L << NUMBER) | (1L << NIL) | (1L << BOOLEAN) | (1L << SYMBOL))) != 0)) {
				{
				{
				setState(6); form();
				}
				}
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormContext extends ParserRuleContext {
		public List<FormContext> form() {
			return getRuleContexts(FormContext.class);
		}
		public FormContext form(int i) {
			return getRuleContext(FormContext.class,i);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MylispVisitor ) return ((MylispVisitor<? extends T>)visitor).visitForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_form);
		int _la;
		try {
			setState(21);
			switch (_input.LA(1)) {
			case STRING:
			case NUMBER:
			case NIL:
			case BOOLEAN:
			case SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(12); literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(13); match(2);
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << STRING) | (1L << NUMBER) | (1L << NIL) | (1L << BOOLEAN) | (1L << SYMBOL))) != 0)) {
					{
					{
					setState(14); form();
					}
					}
					setState(19);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(20); match(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(MylispParser.SYMBOL, 0); }
		public TerminalNode BOOLEAN() { return getToken(MylispParser.BOOLEAN, 0); }
		public TerminalNode NIL() { return getToken(MylispParser.NIL, 0); }
		public TerminalNode NUMBER() { return getToken(MylispParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(MylispParser.STRING, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MylispVisitor ) return ((MylispVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << NUMBER) | (1L << NIL) | (1L << BOOLEAN) | (1L << SYMBOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\34\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\3\3\3\3\3\7\3\22\n\3\f\3"+
		"\16\3\25\13\3\3\3\5\3\30\n\3\3\4\3\4\3\4\2\2\5\2\4\6\2\3\3\2\5\t\33\2"+
		"\13\3\2\2\2\4\27\3\2\2\2\6\31\3\2\2\2\b\n\5\4\3\2\t\b\3\2\2\2\n\r\3\2"+
		"\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\3\3\2\2\2\r\13\3\2\2\2\16\30\5\6\4\2"+
		"\17\23\7\4\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2"+
		"\23\24\3\2\2\2\24\26\3\2\2\2\25\23\3\2\2\2\26\30\7\3\2\2\27\16\3\2\2\2"+
		"\27\17\3\2\2\2\30\5\3\2\2\2\31\32\t\2\2\2\32\7\3\2\2\2\5\13\23\27";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}