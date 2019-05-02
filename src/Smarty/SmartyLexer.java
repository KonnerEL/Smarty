package Smarty;

// Generated from Smarty.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmartyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, Logic_Operator=24, 
		Arithmetic_Operator=25, Boolean=26, Integer=27, Decimal=28, Type=29, StringLiteral=30, 
		UnterminatedStringLiteral=31, Identifier=32, ID=33, Write=34, WS=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "Logic_Operator", 
			"Arithmetic_Operator", "Boolean", "Integer", "Decimal", "Type", "StringLiteral", 
			"UnterminatedStringLiteral", "Identifier", "ID", "Write", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':{'", "'}'", "':'", "','", "'@event'", "'@args'", "'['", "']'", 
			"'@subjects'", "'=>'", "'@create_'", "'@get_info:'", "'@invariant'", 
			"'@warning'", "'@pre'", "'@action'", "'@post'", "'@reverts'", "'@fails'", 
			"':='", "'@after.'", "'.'", "'@before.'", null, null, null, null, null, 
			null, null, null, null, null, "'Write'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"Logic_Operator", "Arithmetic_Operator", "Boolean", "Integer", "Decimal", 
			"Type", "StringLiteral", "UnterminatedStringLiteral", "Identifier", "ID", 
			"Write", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public SmartyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Smarty.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u014b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u00db\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u00eb\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\5\33\u00f6\n\33\3\34\6\34\u00f9\n\34\r\34\16\34\u00fa\3\35\6\35\u00fe"+
		"\n\35\r\35\16\35\u00ff\3\35\3\35\6\35\u0104\n\35\r\35\16\35\u0105\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0120\n\36\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \5 \u012a\n \7 \u012c\n \f \16 \u012f\13 \3!\3!\7"+
		"!\u0133\n!\f!\16!\u0136\13!\3\"\3\"\7\"\u013a\n\"\f\"\16\"\u013d\13\""+
		"\3#\3#\3#\3#\3#\3#\3$\6$\u0146\n$\r$\16$\u0147\3$\3$\2\2%\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%\3\2\t\5\2,-//\61\61\4\2\'\'``\3\2\62;\6\2\f\f\17\17$$^^\6\2&&C\\aac"+
		"|\7\2&&\62;C\\aac|\5\2\13\f\17\17\"\"\2\u0163\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5L\3\2\2\2"+
		"\7N\3\2\2\2\tP\3\2\2\2\13R\3\2\2\2\rY\3\2\2\2\17_\3\2\2\2\21a\3\2\2\2"+
		"\23c\3\2\2\2\25m\3\2\2\2\27p\3\2\2\2\31y\3\2\2\2\33\u0084\3\2\2\2\35\u008f"+
		"\3\2\2\2\37\u0098\3\2\2\2!\u009d\3\2\2\2#\u00a5\3\2\2\2%\u00ab\3\2\2\2"+
		"\'\u00b4\3\2\2\2)\u00bb\3\2\2\2+\u00be\3\2\2\2-\u00c6\3\2\2\2/\u00c8\3"+
		"\2\2\2\61\u00da\3\2\2\2\63\u00ea\3\2\2\2\65\u00f5\3\2\2\2\67\u00f8\3\2"+
		"\2\29\u00fd\3\2\2\2;\u011f\3\2\2\2=\u0121\3\2\2\2?\u0124\3\2\2\2A\u0130"+
		"\3\2\2\2C\u0137\3\2\2\2E\u013e\3\2\2\2G\u0145\3\2\2\2IJ\7<\2\2JK\7}\2"+
		"\2K\4\3\2\2\2LM\7\177\2\2M\6\3\2\2\2NO\7<\2\2O\b\3\2\2\2PQ\7.\2\2Q\n\3"+
		"\2\2\2RS\7B\2\2ST\7g\2\2TU\7x\2\2UV\7g\2\2VW\7p\2\2WX\7v\2\2X\f\3\2\2"+
		"\2YZ\7B\2\2Z[\7c\2\2[\\\7t\2\2\\]\7i\2\2]^\7u\2\2^\16\3\2\2\2_`\7]\2\2"+
		"`\20\3\2\2\2ab\7_\2\2b\22\3\2\2\2cd\7B\2\2de\7u\2\2ef\7w\2\2fg\7d\2\2"+
		"gh\7l\2\2hi\7g\2\2ij\7e\2\2jk\7v\2\2kl\7u\2\2l\24\3\2\2\2mn\7?\2\2no\7"+
		"@\2\2o\26\3\2\2\2pq\7B\2\2qr\7e\2\2rs\7t\2\2st\7g\2\2tu\7c\2\2uv\7v\2"+
		"\2vw\7g\2\2wx\7a\2\2x\30\3\2\2\2yz\7B\2\2z{\7i\2\2{|\7g\2\2|}\7v\2\2}"+
		"~\7a\2\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\u0081\7h\2\2\u0081\u0082\7"+
		"q\2\2\u0082\u0083\7<\2\2\u0083\32\3\2\2\2\u0084\u0085\7B\2\2\u0085\u0086"+
		"\7k\2\2\u0086\u0087\7p\2\2\u0087\u0088\7x\2\2\u0088\u0089\7c\2\2\u0089"+
		"\u008a\7t\2\2\u008a\u008b\7k\2\2\u008b\u008c\7c\2\2\u008c\u008d\7p\2\2"+
		"\u008d\u008e\7v\2\2\u008e\34\3\2\2\2\u008f\u0090\7B\2\2\u0090\u0091\7"+
		"y\2\2\u0091\u0092\7c\2\2\u0092\u0093\7t\2\2\u0093\u0094\7p\2\2\u0094\u0095"+
		"\7k\2\2\u0095\u0096\7p\2\2\u0096\u0097\7i\2\2\u0097\36\3\2\2\2\u0098\u0099"+
		"\7B\2\2\u0099\u009a\7r\2\2\u009a\u009b\7t\2\2\u009b\u009c\7g\2\2\u009c"+
		" \3\2\2\2\u009d\u009e\7B\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7e\2\2\u00a0"+
		"\u00a1\7v\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7p\2\2"+
		"\u00a4\"\3\2\2\2\u00a5\u00a6\7B\2\2\u00a6\u00a7\7r\2\2\u00a7\u00a8\7q"+
		"\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7v\2\2\u00aa$\3\2\2\2\u00ab\u00ac"+
		"\7B\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7x\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7u\2\2"+
		"\u00b3&\3\2\2\2\u00b4\u00b5\7B\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7c\2"+
		"\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7u\2\2\u00ba(\3\2"+
		"\2\2\u00bb\u00bc\7<\2\2\u00bc\u00bd\7?\2\2\u00bd*\3\2\2\2\u00be\u00bf"+
		"\7B\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7h\2\2\u00c1\u00c2\7v\2\2\u00c2"+
		"\u00c3\7g\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7\60\2\2\u00c5,\3\2\2\2\u00c6"+
		"\u00c7\7\60\2\2\u00c7.\3\2\2\2\u00c8\u00c9\7B\2\2\u00c9\u00ca\7d\2\2\u00ca"+
		"\u00cb\7g\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7t\2\2"+
		"\u00ce\u00cf\7g\2\2\u00cf\u00d0\7\60\2\2\u00d0\60\3\2\2\2\u00d1\u00db"+
		"\7@\2\2\u00d2\u00d3\7@\2\2\u00d3\u00db\7?\2\2\u00d4\u00db\7?\2\2\u00d5"+
		"\u00d6\7#\2\2\u00d6\u00db\7?\2\2\u00d7\u00db\7>\2\2\u00d8\u00d9\7>\2\2"+
		"\u00d9\u00db\7?\2\2\u00da\u00d1\3\2\2\2\u00da\u00d2\3\2\2\2\u00da\u00d4"+
		"\3\2\2\2\u00da\u00d5\3\2\2\2\u00da\u00d7\3\2\2\2\u00da\u00d8\3\2\2\2\u00db"+
		"\62\3\2\2\2\u00dc\u00eb\t\2\2\2\u00dd\u00de\7-\2\2\u00de\u00eb\7?\2\2"+
		"\u00df\u00e0\7/\2\2\u00e0\u00eb\7?\2\2\u00e1\u00e2\7,\2\2\u00e2\u00eb"+
		"\7?\2\2\u00e3\u00e4\7\61\2\2\u00e4\u00eb\7?\2\2\u00e5\u00eb\t\3\2\2\u00e6"+
		"\u00e7\7-\2\2\u00e7\u00eb\7-\2\2\u00e8\u00e9\7/\2\2\u00e9\u00eb\7/\2\2"+
		"\u00ea\u00dc\3\2\2\2\u00ea\u00dd\3\2\2\2\u00ea\u00df\3\2\2\2\u00ea\u00e1"+
		"\3\2\2\2\u00ea\u00e3\3\2\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00e6\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00eb\64\3\2\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7t\2\2"+
		"\u00ee\u00ef\7w\2\2\u00ef\u00f6\7g\2\2\u00f0\u00f1\7h\2\2\u00f1\u00f2"+
		"\7c\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7u\2\2\u00f4\u00f6\7g\2\2\u00f5"+
		"\u00ec\3\2\2\2\u00f5\u00f0\3\2\2\2\u00f6\66\3\2\2\2\u00f7\u00f9\t\4\2"+
		"\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb8\3\2\2\2\u00fc\u00fe\t\4\2\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u0103\7\60\2\2\u0102\u0104\t\4\2\2\u0103\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106:\3\2\2\2"+
		"\u0107\u0108\7d\2\2\u0108\u0109\7q\2\2\u0109\u010a\7q\2\2\u010a\u0120"+
		"\7n\2\2\u010b\u010c\7k\2\2\u010c\u010d\7p\2\2\u010d\u010e\7v\2\2\u010e"+
		"\u010f\7g\2\2\u010f\u0110\7i\2\2\u0110\u0111\7g\2\2\u0111\u0120\7t\2\2"+
		"\u0112\u0113\7f\2\2\u0113\u0114\7g\2\2\u0114\u0115\7e\2\2\u0115\u0116"+
		"\7k\2\2\u0116\u0117\7o\2\2\u0117\u0118\7c\2\2\u0118\u0120\7n\2\2\u0119"+
		"\u011a\7u\2\2\u011a\u011b\7v\2\2\u011b\u011c\7t\2\2\u011c\u011d\7k\2\2"+
		"\u011d\u011e\7p\2\2\u011e\u0120\7i\2\2\u011f\u0107\3\2\2\2\u011f\u010b"+
		"\3\2\2\2\u011f\u0112\3\2\2\2\u011f\u0119\3\2\2\2\u0120<\3\2\2\2\u0121"+
		"\u0122\5? \2\u0122\u0123\7$\2\2\u0123>\3\2\2\2\u0124\u012d\7$\2\2\u0125"+
		"\u012c\n\5\2\2\u0126\u0129\7^\2\2\u0127\u012a\13\2\2\2\u0128\u012a\7\2"+
		"\2\3\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a\u012c\3\2\2\2\u012b"+
		"\u0125\3\2\2\2\u012b\u0126\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2"+
		"\2\2\u012d\u012e\3\2\2\2\u012e@\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0134"+
		"\t\6\2\2\u0131\u0133\t\7\2\2\u0132\u0131\3\2\2\2\u0133\u0136\3\2\2\2\u0134"+
		"\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135B\3\2\2\2\u0136\u0134\3\2\2\2"+
		"\u0137\u013b\t\6\2\2\u0138\u013a\t\7\2\2\u0139\u0138\3\2\2\2\u013a\u013d"+
		"\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013cD\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013e\u013f\7Y\2\2\u013f\u0140\7t\2\2\u0140\u0141\7k\2"+
		"\2\u0141\u0142\7v\2\2\u0142\u0143\7g\2\2\u0143F\3\2\2\2\u0144\u0146\t"+
		"\b\2\2\u0145\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\b$\2\2\u014aH\3\2\2\2\20"+
		"\2\u00da\u00ea\u00f5\u00fa\u00ff\u0105\u011f\u0129\u012b\u012d\u0134\u013b"+
		"\u0147\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}