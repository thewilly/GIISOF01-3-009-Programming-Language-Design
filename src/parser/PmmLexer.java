// Generated from src/parser/Pmm.g4 by ANTLR 4.7
package parser;

  import ast.*;
  import java.util.*;
  import errorhandler.ErrorType;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, SKIP_=38, 
		INT_CONSTANT=39, REAL_CONSTANT=40, CHAR_CONSTANT=41, ID=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "SKIP_", "WHITE_SPACE", "ONE_LINE_COMMENT", 
		"MULTI_LINE_COMMENT", "DIGIT", "NON_ZERO_DIGIT", "EXPONENT", "FRACTION", 
		"INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "ID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'int'", "'double'", "'char'", "'['", "']'", "':'", "'struct'", 
		"'{'", "'}'", "','", "'def'", "'void'", "'main'", "'('", "')'", "'.'", 
		"'-'", "'!'", "'*'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", 
		"'=='", "'&&'", "'||'", "'print'", "'input'", "'='", "'if'", "'else'", 
		"'while'", "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "SKIP_", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", 
		"ID"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0155\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&"+
		"\3&\3&\3\'\3\'\3\'\5\'\u00e5\n\'\3\'\3\'\3(\6(\u00ea\n(\r(\16(\u00eb\3"+
		")\3)\7)\u00f0\n)\f)\16)\u00f3\13)\3*\3*\3*\3*\3*\7*\u00fa\n*\f*\16*\u00fd"+
		"\13*\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\5-\u0109\n-\3-\6-\u010c\n-\r-\16-\u010d"+
		"\3.\3.\6.\u0112\n.\r.\16.\u0113\3/\3/\3/\7/\u0119\n/\f/\16/\u011c\13/"+
		"\5/\u011e\n/\3\60\5\60\u0121\n\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\7\60\u012d\n\60\f\60\16\60\u0130\13\60\3\60\3\60\5\60\u0134"+
		"\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u014d\n\61\3\62"+
		"\3\62\7\62\u0151\n\62\f\62\16\62\u0154\13\62\3\u00fb\2\63\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O\2Q\2S\2U\2W\2Y\2[\2])_*a+c,\3\2\n\7\2\13\f\16\17\"\"GHQQ\4\2"+
		"\f\f\16\17\3\2\62;\3\2\63;\4\2GGgg\4\2--//\5\2C\\aac|\6\2\62;C\\aac|\2"+
		"\u0161\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5g\3\2\2\2\7k\3\2\2\2\tr\3\2\2\2\13w\3\2"+
		"\2\2\ry\3\2\2\2\17{\3\2\2\2\21}\3\2\2\2\23\u0084\3\2\2\2\25\u0086\3\2"+
		"\2\2\27\u0088\3\2\2\2\31\u008a\3\2\2\2\33\u008e\3\2\2\2\35\u0093\3\2\2"+
		"\2\37\u0098\3\2\2\2!\u009a\3\2\2\2#\u009c\3\2\2\2%\u009e\3\2\2\2\'\u00a0"+
		"\3\2\2\2)\u00a2\3\2\2\2+\u00a4\3\2\2\2-\u00a6\3\2\2\2/\u00a8\3\2\2\2\61"+
		"\u00aa\3\2\2\2\63\u00ad\3\2\2\2\65\u00af\3\2\2\2\67\u00b2\3\2\2\29\u00b5"+
		"\3\2\2\2;\u00b8\3\2\2\2=\u00bb\3\2\2\2?\u00be\3\2\2\2A\u00c4\3\2\2\2C"+
		"\u00ca\3\2\2\2E\u00cc\3\2\2\2G\u00cf\3\2\2\2I\u00d4\3\2\2\2K\u00da\3\2"+
		"\2\2M\u00e4\3\2\2\2O\u00e9\3\2\2\2Q\u00ed\3\2\2\2S\u00f4\3\2\2\2U\u0102"+
		"\3\2\2\2W\u0104\3\2\2\2Y\u0106\3\2\2\2[\u010f\3\2\2\2]\u011d\3\2\2\2_"+
		"\u0133\3\2\2\2a\u014c\3\2\2\2c\u014e\3\2\2\2ef\7=\2\2f\4\3\2\2\2gh\7k"+
		"\2\2hi\7p\2\2ij\7v\2\2j\6\3\2\2\2kl\7f\2\2lm\7q\2\2mn\7w\2\2no\7d\2\2"+
		"op\7n\2\2pq\7g\2\2q\b\3\2\2\2rs\7e\2\2st\7j\2\2tu\7c\2\2uv\7t\2\2v\n\3"+
		"\2\2\2wx\7]\2\2x\f\3\2\2\2yz\7_\2\2z\16\3\2\2\2{|\7<\2\2|\20\3\2\2\2}"+
		"~\7u\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080\u0081\7w\2\2\u0081\u0082\7"+
		"e\2\2\u0082\u0083\7v\2\2\u0083\22\3\2\2\2\u0084\u0085\7}\2\2\u0085\24"+
		"\3\2\2\2\u0086\u0087\7\177\2\2\u0087\26\3\2\2\2\u0088\u0089\7.\2\2\u0089"+
		"\30\3\2\2\2\u008a\u008b\7f\2\2\u008b\u008c\7g\2\2\u008c\u008d\7h\2\2\u008d"+
		"\32\3\2\2\2\u008e\u008f\7x\2\2\u008f\u0090\7q\2\2\u0090\u0091\7k\2\2\u0091"+
		"\u0092\7f\2\2\u0092\34\3\2\2\2\u0093\u0094\7o\2\2\u0094\u0095\7c\2\2\u0095"+
		"\u0096\7k\2\2\u0096\u0097\7p\2\2\u0097\36\3\2\2\2\u0098\u0099\7*\2\2\u0099"+
		" \3\2\2\2\u009a\u009b\7+\2\2\u009b\"\3\2\2\2\u009c\u009d\7\60\2\2\u009d"+
		"$\3\2\2\2\u009e\u009f\7/\2\2\u009f&\3\2\2\2\u00a0\u00a1\7#\2\2\u00a1("+
		"\3\2\2\2\u00a2\u00a3\7,\2\2\u00a3*\3\2\2\2\u00a4\u00a5\7\'\2\2\u00a5,"+
		"\3\2\2\2\u00a6\u00a7\7-\2\2\u00a7.\3\2\2\2\u00a8\u00a9\7@\2\2\u00a9\60"+
		"\3\2\2\2\u00aa\u00ab\7@\2\2\u00ab\u00ac\7?\2\2\u00ac\62\3\2\2\2\u00ad"+
		"\u00ae\7>\2\2\u00ae\64\3\2\2\2\u00af\u00b0\7>\2\2\u00b0\u00b1\7?\2\2\u00b1"+
		"\66\3\2\2\2\u00b2\u00b3\7#\2\2\u00b3\u00b4\7?\2\2\u00b48\3\2\2\2\u00b5"+
		"\u00b6\7?\2\2\u00b6\u00b7\7?\2\2\u00b7:\3\2\2\2\u00b8\u00b9\7(\2\2\u00b9"+
		"\u00ba\7(\2\2\u00ba<\3\2\2\2\u00bb\u00bc\7~\2\2\u00bc\u00bd\7~\2\2\u00bd"+
		">\3\2\2\2\u00be\u00bf\7r\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7k\2\2\u00c1"+
		"\u00c2\7p\2\2\u00c2\u00c3\7v\2\2\u00c3@\3\2\2\2\u00c4\u00c5\7k\2\2\u00c5"+
		"\u00c6\7p\2\2\u00c6\u00c7\7r\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9\7v\2\2"+
		"\u00c9B\3\2\2\2\u00ca\u00cb\7?\2\2\u00cbD\3\2\2\2\u00cc\u00cd\7k\2\2\u00cd"+
		"\u00ce\7h\2\2\u00ceF\3\2\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1\7n\2\2\u00d1"+
		"\u00d2\7u\2\2\u00d2\u00d3\7g\2\2\u00d3H\3\2\2\2\u00d4\u00d5\7y\2\2\u00d5"+
		"\u00d6\7j\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7g\2\2"+
		"\u00d9J\3\2\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7v\2"+
		"\2\u00dd\u00de\7w\2\2\u00de\u00df\7t\2\2\u00df\u00e0\7p\2\2\u00e0L\3\2"+
		"\2\2\u00e1\u00e5\5O(\2\u00e2\u00e5\5Q)\2\u00e3\u00e5\5S*\2\u00e4\u00e1"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e7\b\'\2\2\u00e7N\3\2\2\2\u00e8\u00ea\t\2\2\2\u00e9\u00e8\3\2\2\2"+
		"\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ecP\3"+
		"\2\2\2\u00ed\u00f1\7%\2\2\u00ee\u00f0\n\3\2\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2R\3\2\2\2"+
		"\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7$\2\2\u00f5\u00f6\7$\2\2\u00f6\u00f7"+
		"\7$\2\2\u00f7\u00fb\3\2\2\2\u00f8\u00fa\13\2\2\2\u00f9\u00f8\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fe\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\7$\2\2\u00ff\u0100\7$\2\2\u0100\u0101"+
		"\7$\2\2\u0101T\3\2\2\2\u0102\u0103\t\4\2\2\u0103V\3\2\2\2\u0104\u0105"+
		"\t\5\2\2\u0105X\3\2\2\2\u0106\u0108\t\6\2\2\u0107\u0109\t\7\2\2\u0108"+
		"\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u010c\5U"+
		"+\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010eZ\3\2\2\2\u010f\u0111\7\60\2\2\u0110\u0112\5U+\2\u0111"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2"+
		"\2\2\u0114\\\3\2\2\2\u0115\u011e\7\62\2\2\u0116\u011a\t\5\2\2\u0117\u0119"+
		"\5U+\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u0115\3\2"+
		"\2\2\u011d\u0116\3\2\2\2\u011e^\3\2\2\2\u011f\u0121\5]/\2\u0120\u011f"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0134\5[.\2\u0123"+
		"\u0124\5]/\2\u0124\u0125\7\60\2\2\u0125\u0134\3\2\2\2\u0126\u0127\5]/"+
		"\2\u0127\u0128\5Y-\2\u0128\u0134\3\2\2\2\u0129\u012a\5]/\2\u012a\u012e"+
		"\7\60\2\2\u012b\u012d\5U+\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2"+
		"\2\2\u0131\u0132\5Y-\2\u0132\u0134\3\2\2\2\u0133\u0120\3\2\2\2\u0133\u0123"+
		"\3\2\2\2\u0133\u0126\3\2\2\2\u0133\u0129\3\2\2\2\u0134`\3\2\2\2\u0135"+
		"\u0136\7)\2\2\u0136\u0137\13\2\2\2\u0137\u014d\7)\2\2\u0138\u0139\7)\2"+
		"\2\u0139\u013a\7^\2\2\u013a\u013b\5]/\2\u013b\u013c\5]/\2\u013c\u013d"+
		"\5]/\2\u013d\u013e\7)\2\2\u013e\u014d\3\2\2\2\u013f\u0140\7)\2\2\u0140"+
		"\u0141\7^\2\2\u0141\u0142\7p\2\2\u0142\u0143\3\2\2\2\u0143\u014d\7)\2"+
		"\2\u0144\u0145\7)\2\2\u0145\u0146\7^\2\2\u0146\u0147\7v\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u014d\7)\2\2\u0149\u014a\7)\2\2\u014a\u014b\7/\2\2\u014b"+
		"\u014d\7)\2\2\u014c\u0135\3\2\2\2\u014c\u0138\3\2\2\2\u014c\u013f\3\2"+
		"\2\2\u014c\u0144\3\2\2\2\u014c\u0149\3\2\2\2\u014db\3\2\2\2\u014e\u0152"+
		"\t\b\2\2\u014f\u0151\t\t\2\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152"+
		"\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153d\3\2\2\2\u0154\u0152\3\2\2\2"+
		"\21\2\u00e4\u00eb\u00f1\u00fb\u0108\u010d\u0113\u011a\u011d\u0120\u012e"+
		"\u0133\u014c\u0152\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}