// Generated from Mylisp.g4 by ANTLR 4.2.2
package org.jack;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MylispLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, STRING=3, NUMBER=4, NIL=5, BOOLEAN=6, SYMBOL=7, WS=8, 
		COMMENT=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'('", "STRING", "NUMBER", "'nil'", "BOOLEAN", "SYMBOL", "WS", 
		"COMMENT"
	};
	public static final String[] ruleNames = {
		"T__1", "T__0", "STRING", "NUMBER", "NIL", "BOOLEAN", "SYMBOL", "NAME", 
		"SYMBOL_HEAD", "SYMBOL_REST", "WS", "COMMENT"
	};


	public MylispLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mylisp.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13\u0081\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\7\4$\n\4\f\4"+
		"\16\4\'\13\4\3\4\3\4\3\5\5\5,\n\5\3\5\6\5/\n\5\r\5\16\5\60\3\5\3\5\6\5"+
		"\65\n\5\r\5\16\5\66\5\59\n\5\3\5\3\5\5\5=\n\5\3\5\6\5@\n\5\r\5\16\5A\5"+
		"\5D\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7S\n\7\3"+
		"\b\3\b\3\b\3\b\5\bY\n\b\5\b[\n\b\3\t\3\t\7\t_\n\t\f\t\16\tb\13\t\3\t\3"+
		"\t\6\tf\n\t\r\t\16\tg\7\tj\n\t\f\t\16\tm\13\t\3\n\3\n\3\13\3\13\5\13s"+
		"\n\13\3\f\3\f\3\f\3\f\3\r\3\r\7\r{\n\r\f\r\16\r~\13\r\3\r\3\r\2\2\16\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\2\27\n\31\13\3\2\t\3\2$$\3\2"+
		"\62;\4\2GGgg\n\2##&&,-//>AC\\aac|\5\2((\60\60\62;\7\2\13\f\17\17\"\"."+
		".^^\4\2\f\f\17\17\u008e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33"+
		"\3\2\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t+\3\2\2\2\13E\3\2\2\2\rR\3\2\2\2\17"+
		"Z\3\2\2\2\21\\\3\2\2\2\23n\3\2\2\2\25r\3\2\2\2\27t\3\2\2\2\31x\3\2\2\2"+
		"\33\34\7+\2\2\34\4\3\2\2\2\35\36\7*\2\2\36\6\3\2\2\2\37%\7$\2\2 $\n\2"+
		"\2\2!\"\7^\2\2\"$\7$\2\2# \3\2\2\2#!\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3"+
		"\2\2\2&(\3\2\2\2\'%\3\2\2\2()\7$\2\2)\b\3\2\2\2*,\7/\2\2+*\3\2\2\2+,\3"+
		"\2\2\2,.\3\2\2\2-/\t\3\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2"+
		"\2\2\618\3\2\2\2\62\64\7\60\2\2\63\65\t\3\2\2\64\63\3\2\2\2\65\66\3\2"+
		"\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\62\3\2\2\289\3\2\2\29C\3"+
		"\2\2\2:<\t\4\2\2;=\7/\2\2<;\3\2\2\2<=\3\2\2\2=?\3\2\2\2>@\t\3\2\2?>\3"+
		"\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2C:\3\2\2\2CD\3\2\2\2D\n"+
		"\3\2\2\2EF\7p\2\2FG\7k\2\2GH\7n\2\2H\f\3\2\2\2IJ\7v\2\2JK\7t\2\2KL\7w"+
		"\2\2LS\7g\2\2MN\7h\2\2NO\7c\2\2OP\7n\2\2PQ\7u\2\2QS\7g\2\2RI\3\2\2\2R"+
		"M\3\2\2\2S\16\3\2\2\2T[\4\60\61\2UX\5\21\t\2VW\7\61\2\2WY\5\21\t\2XV\3"+
		"\2\2\2XY\3\2\2\2Y[\3\2\2\2ZT\3\2\2\2ZU\3\2\2\2[\20\3\2\2\2\\`\5\23\n\2"+
		"]_\5\25\13\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ak\3\2\2\2b`\3\2\2"+
		"\2ce\7<\2\2df\5\25\13\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2"+
		"\2\2ic\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\22\3\2\2\2mk\3\2\2\2no\t"+
		"\5\2\2o\24\3\2\2\2ps\5\23\n\2qs\t\6\2\2rp\3\2\2\2rq\3\2\2\2s\26\3\2\2"+
		"\2tu\t\7\2\2uv\3\2\2\2vw\b\f\2\2w\30\3\2\2\2x|\7=\2\2y{\n\b\2\2zy\3\2"+
		"\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\b"+
		"\r\2\2\u0080\32\3\2\2\2\24\2#%+\60\668<ACRXZ`gkr|\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}