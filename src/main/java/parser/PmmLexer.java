// Generated from src/parser/Pmm.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SKIP_=1, INT_CONSTANT=2, REAL_CONSTANT=3, CHAR_CONSTANT=4, ID=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SKIP_", "WHITE_SPACE", "MULTI_LINE_COMMENT", "ONE_LINE_COMMENT", "DIGIT", 
		"EXPONENT", "FRACTION", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", 
		"ID"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SKIP_", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "ID"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7\u008b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\5\2\35\n\2\3\2\3\2\3\3\6\3\"\n\3\r\3\16\3#\3"+
		"\4\3\4\3\4\3\4\3\4\7\4+\n\4\f\4\16\4.\13\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5"+
		"\66\n\5\f\5\16\59\13\5\3\6\3\6\3\7\3\7\5\7?\n\7\3\7\6\7B\n\7\r\7\16\7"+
		"C\3\b\3\b\6\bH\n\b\r\b\16\bI\3\t\3\t\3\t\7\tO\n\t\f\t\16\tR\13\t\5\tT"+
		"\n\t\3\n\5\nW\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nc\n\n\f\n"+
		"\16\nf\13\n\3\n\3\n\5\nj\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0083\n\13\3\f\3\f\7\f\u0087\n\f\f\f\16\f\u008a\13\f\3,\2\r\3"+
		"\3\5\2\7\2\t\2\13\2\r\2\17\2\21\4\23\5\25\6\27\7\3\2\n\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\16\17\3\2\62;\4\2GGgg\4\2--//\3\2\63;\5\2C\\aac|\6\2\62;"+
		"C\\aac|\2\u0098\2\3\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\3\34\3\2\2\2\5!\3\2\2\2\7%\3\2\2\2\t\63\3\2\2\2\13:\3\2\2\2\r"+
		"<\3\2\2\2\17E\3\2\2\2\21S\3\2\2\2\23i\3\2\2\2\25\u0082\3\2\2\2\27\u0084"+
		"\3\2\2\2\31\35\5\5\3\2\32\35\5\t\5\2\33\35\5\7\4\2\34\31\3\2\2\2\34\32"+
		"\3\2\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36\37\b\2\2\2\37\4\3\2\2\2 \"\t\2"+
		"\2\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\6\3\2\2\2%&\7$\2\2&\'\7"+
		"$\2\2\'(\7$\2\2(,\3\2\2\2)+\13\2\2\2*)\3\2\2\2+.\3\2\2\2,-\3\2\2\2,*\3"+
		"\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\7$\2\2\60\61\7$\2\2\61\62\7$\2\2\62\b\3"+
		"\2\2\2\63\67\7%\2\2\64\66\n\3\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2"+
		"\2\2\678\3\2\2\28\n\3\2\2\29\67\3\2\2\2:;\t\4\2\2;\f\3\2\2\2<>\t\5\2\2"+
		"=?\t\6\2\2>=\3\2\2\2>?\3\2\2\2?A\3\2\2\2@B\5\13\6\2A@\3\2\2\2BC\3\2\2"+
		"\2CA\3\2\2\2CD\3\2\2\2D\16\3\2\2\2EG\7\60\2\2FH\5\13\6\2GF\3\2\2\2HI\3"+
		"\2\2\2IG\3\2\2\2IJ\3\2\2\2J\20\3\2\2\2KT\7\62\2\2LP\t\7\2\2MO\5\13\6\2"+
		"NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QT\3\2\2\2RP\3\2\2\2SK\3\2\2\2"+
		"SL\3\2\2\2T\22\3\2\2\2UW\5\21\t\2VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2Xj\5\17"+
		"\b\2YZ\5\21\t\2Z[\7\60\2\2[j\3\2\2\2\\]\5\21\t\2]^\5\r\7\2^j\3\2\2\2_"+
		"`\5\21\t\2`d\7\60\2\2ac\5\13\6\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2"+
		"\2eg\3\2\2\2fd\3\2\2\2gh\5\r\7\2hj\3\2\2\2iV\3\2\2\2iY\3\2\2\2i\\\3\2"+
		"\2\2i_\3\2\2\2j\24\3\2\2\2kl\7)\2\2lm\13\2\2\2m\u0083\7)\2\2no\7)\2\2"+
		"op\7^\2\2pq\5\21\t\2qr\5\21\t\2rs\5\21\t\2st\7)\2\2t\u0083\3\2\2\2uv\7"+
		")\2\2vw\7^\2\2wx\7p\2\2xy\3\2\2\2y\u0083\7)\2\2z{\7)\2\2{|\7^\2\2|}\7"+
		"v\2\2}~\3\2\2\2~\u0083\7)\2\2\177\u0080\7)\2\2\u0080\u0081\7/\2\2\u0081"+
		"\u0083\7)\2\2\u0082k\3\2\2\2\u0082n\3\2\2\2\u0082u\3\2\2\2\u0082z\3\2"+
		"\2\2\u0082\177\3\2\2\2\u0083\26\3\2\2\2\u0084\u0088\t\b\2\2\u0085\u0087"+
		"\t\t\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\30\3\2\2\2\u008a\u0088\3\2\2\2\21\2\34#,\67>CIPS"+
		"Vdi\u0082\u0088\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}