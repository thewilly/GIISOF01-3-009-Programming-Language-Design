// Generated from src/parser/Pmm.g4 by ANTLR 4.7
package parser;

  import ast.*;
  import ast.types.*;
  import ast.literals.*;
  import ast.definitions.*;
  import ast.expressions.*;
  import ast.statements.*;
  import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, SKIP_=48, INT_CONSTANT=49, REAL_CONSTANT=50, STRUCT=51, 
		CHAR_CONSTANT=52, ID=53;
	public static final int
		RULE_program = 0, RULE_build_in_type = 1, RULE_var_def = 2, RULE_single_var_def = 3, 
		RULE_multi_var_def = 4, RULE_fields = 5, RULE_func_def = 6, RULE_main_def = 7, 
		RULE_parameters = 8, RULE_func_body = 9, RULE_expression = 10, RULE_statement = 11, 
		RULE_ternary = 12, RULE_write_st = 13, RULE_read_st = 14, RULE_assigment = 15, 
		RULE_condition = 16, RULE_if_st = 17, RULE_else_st = 18, RULE_elif_simple_body = 19, 
		RULE_elif_body = 20, RULE_while_st = 21, RULE_while_body = 22, RULE_dowhile_st = 23, 
		RULE_return_st = 24, RULE_cast = 25, RULE_func_invocation = 26, RULE_argument = 27, 
		RULE_proc_invocation = 28, RULE_var_invocation = 29;
	public static final String[] ruleNames = {
		"program", "build_in_type", "var_def", "single_var_def", "multi_var_def", 
		"fields", "func_def", "main_def", "parameters", "func_body", "expression", 
		"statement", "ternary", "write_st", "read_st", "assigment", "condition", 
		"if_st", "else_st", "elif_simple_body", "elif_body", "while_st", "while_body", 
		"dowhile_st", "return_st", "cast", "func_invocation", "argument", "proc_invocation", 
		"var_invocation"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'int'", "'double'", "'char'", "'{'", "'}'", "'['", "']'", 
		"':'", "'ref'", "','", "'def'", "'void'", "'main'", "'('", "')'", "'.'", 
		"'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", 
		"'!='", "'=='", "'&&'", "'||'", "'^'", "'++'", "'--'", "'?'", "'print'", 
		"'input'", "'='", "'+='", "'-='", "'*='", "'/='", "'if'", "'else'", "'while'", 
		"'do'", "'return'", null, null, null, "'struct'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"SKIP_", "INT_CONSTANT", "REAL_CONSTANT", "STRUCT", "CHAR_CONSTANT", "ID"
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

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public Var_defContext var_def;
		public Func_defContext func_def;
		public Main_defContext main_def;
		public Main_defContext main_def() {
			return getRuleContext(Main_defContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<Func_defContext> func_def() {
			return getRuleContexts(Func_defContext.class);
		}
		public Func_defContext func_def(int i) {
			return getRuleContext(Func_defContext.class,i);
		}
		public List<Var_defContext> var_def() {
			return getRuleContexts(Var_defContext.class);
		}
		public Var_defContext var_def(int i) {
			return getRuleContext(Var_defContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			List<Definition> defs = new ArrayList<Definition>();
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(69);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__9:
					case ID:
						{
						{
						setState(61);
						((ProgramContext)_localctx).var_def = var_def();
						setState(62);
						match(T__0);
						}
						defs.addAll(((ProgramContext)_localctx).var_def.ast);
						}
						break;
					case T__11:
						{
						setState(66);
						((ProgramContext)_localctx).func_def = func_def();
						defs.add(((ProgramContext)_localctx).func_def.ast);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(74);
			((ProgramContext)_localctx).main_def = main_def();
			setState(75);
			match(EOF);
			defs.add(((ProgramContext)_localctx).main_def.ast);((ProgramContext)_localctx).ast =  new Program(0,0,defs);
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

	public static class Build_in_typeContext extends ParserRuleContext {
		public Type ast;
		public Token STRUCT;
		public FieldsContext fields;
		public Token size;
		public Build_in_typeContext arr_type;
		public TerminalNode STRUCT() { return getToken(PmmParser.STRUCT, 0); }
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public Build_in_typeContext build_in_type() {
			return getRuleContext(Build_in_typeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public Build_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_build_in_type; }
	}

	public final Build_in_typeContext build_in_type() throws RecognitionException {
		Build_in_typeContext _localctx = new Build_in_typeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_build_in_type);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(T__1);
				((Build_in_typeContext)_localctx).ast =  IntType.getInstance();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(T__2);
				((Build_in_typeContext)_localctx).ast =  RealType.getInstance();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				match(T__3);
				((Build_in_typeContext)_localctx).ast =  CharType.getInstance();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 4);
				{
				List<RecordField> fields = new ArrayList<RecordField>();
				setState(85);
				((Build_in_typeContext)_localctx).STRUCT = match(STRUCT);
				setState(86);
				match(T__4);
				{
				setState(87);
				((Build_in_typeContext)_localctx).fields = fields();
				fields.addAll(((Build_in_typeContext)_localctx).fields.ast);
				}
				setState(90);
				match(T__5);
				((Build_in_typeContext)_localctx).ast =  new RecordType((((Build_in_typeContext)_localctx).STRUCT!=null?((Build_in_typeContext)_localctx).STRUCT.getLine():0), (((Build_in_typeContext)_localctx).STRUCT!=null?((Build_in_typeContext)_localctx).STRUCT.getCharPositionInLine():0)+1, fields);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(93);
				match(T__6);
				setState(94);
				((Build_in_typeContext)_localctx).size = match(INT_CONSTANT);
				setState(95);
				match(T__7);
				}
				setState(97);
				((Build_in_typeContext)_localctx).arr_type = build_in_type();
				((Build_in_typeContext)_localctx).ast =  new ArrayType(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((Build_in_typeContext)_localctx).size!=null?((Build_in_typeContext)_localctx).size.getText():null)), ((Build_in_typeContext)_localctx).arr_type.ast);
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

	public static class Var_defContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Single_var_defContext single_var_def;
		public Multi_var_defContext multi_var_def;
		public Token ID;
		public FieldsContext fields;
		public Single_var_defContext single_var_def() {
			return getRuleContext(Single_var_defContext.class,0);
		}
		public Multi_var_defContext multi_var_def() {
			return getRuleContext(Multi_var_defContext.class,0);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public Var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_def; }
	}

	public final Var_defContext var_def() throws RecognitionException {
		Var_defContext _localctx = new Var_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_def);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((Var_defContext)_localctx).single_var_def = single_var_def();
				_localctx.ast.add(((Var_defContext)_localctx).single_var_def.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				((Var_defContext)_localctx).multi_var_def = multi_var_def();
				_localctx.ast.addAll(((Var_defContext)_localctx).multi_var_def.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				List<RecordField> fields = new ArrayList<RecordField>();
				setState(109);
				((Var_defContext)_localctx).ID = match(ID);
				setState(110);
				match(T__8);
				setState(111);
				match(STRUCT);
				setState(112);
				match(T__4);
				{
				setState(113);
				((Var_defContext)_localctx).fields = fields();
				fields.addAll(((Var_defContext)_localctx).fields.ast);
				}
				setState(116);
				match(T__5);
				_localctx.ast.add(new VarDefinition((((Var_defContext)_localctx).ID!=null?((Var_defContext)_localctx).ID.getLine():0), (((Var_defContext)_localctx).ID!=null?((Var_defContext)_localctx).ID.getCharPositionInLine():0)+1, (((Var_defContext)_localctx).ID!=null?((Var_defContext)_localctx).ID.getText():null), new RecordType((((Var_defContext)_localctx).ID!=null?((Var_defContext)_localctx).ID.getLine():0), (((Var_defContext)_localctx).ID!=null?((Var_defContext)_localctx).ID.getCharPositionInLine():0)+1, fields)));
				}
				break;
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

	public static class Single_var_defContext extends ParserRuleContext {
		public VarDefinition ast;
		public Token ID;
		public Build_in_typeContext build_in_type;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public Build_in_typeContext build_in_type() {
			return getRuleContext(Build_in_typeContext.class,0);
		}
		public Single_var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_var_def; }
	}

	public final Single_var_defContext single_var_def() throws RecognitionException {
		Single_var_defContext _localctx = new Single_var_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_single_var_def);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				((Single_var_defContext)_localctx).ID = match(ID);
				((Single_var_defContext)_localctx).ast =  new VarDefinition((((Single_var_defContext)_localctx).ID!=null?((Single_var_defContext)_localctx).ID.getLine():0), (((Single_var_defContext)_localctx).ID!=null?((Single_var_defContext)_localctx).ID.getCharPositionInLine():0)+1, (((Single_var_defContext)_localctx).ID!=null?((Single_var_defContext)_localctx).ID.getText():null), null);
				setState(123);
				match(T__8);
				setState(124);
				((Single_var_defContext)_localctx).build_in_type = build_in_type();
				_localctx.ast.setType(((Single_var_defContext)_localctx).build_in_type.ast);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(T__9);
				setState(128);
				((Single_var_defContext)_localctx).ID = match(ID);
				((Single_var_defContext)_localctx).ast =  new VarDefinition((((Single_var_defContext)_localctx).ID!=null?((Single_var_defContext)_localctx).ID.getLine():0), (((Single_var_defContext)_localctx).ID!=null?((Single_var_defContext)_localctx).ID.getCharPositionInLine():0)+1, (((Single_var_defContext)_localctx).ID!=null?((Single_var_defContext)_localctx).ID.getText():null), null);
				setState(130);
				match(T__8);
				setState(131);
				((Single_var_defContext)_localctx).build_in_type = build_in_type();
				_localctx.ast.setType(new ReferenceType((((Single_var_defContext)_localctx).ID!=null?((Single_var_defContext)_localctx).ID.getLine():0), (((Single_var_defContext)_localctx).ID!=null?((Single_var_defContext)_localctx).ID.getCharPositionInLine():0)+1, ((Single_var_defContext)_localctx).build_in_type.ast));
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

	public static class Multi_var_defContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public Token id1;
		public Token id2;
		public Build_in_typeContext build_in_type;
		public Build_in_typeContext build_in_type() {
			return getRuleContext(Build_in_typeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public Multi_var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_var_def; }
	}

	public final Multi_var_defContext multi_var_def() throws RecognitionException {
		Multi_var_defContext _localctx = new Multi_var_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_multi_var_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			((Multi_var_defContext)_localctx).id1 = match(ID);
			_localctx.ast.add(new VarDefinition((((Multi_var_defContext)_localctx).id1!=null?((Multi_var_defContext)_localctx).id1.getLine():0), (((Multi_var_defContext)_localctx).id1!=null?((Multi_var_defContext)_localctx).id1.getCharPositionInLine():0)+1, (((Multi_var_defContext)_localctx).id1!=null?((Multi_var_defContext)_localctx).id1.getText():null), null));
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(138);
				match(T__10);
				setState(139);
				((Multi_var_defContext)_localctx).id2 = match(ID);
				if(_localctx.ast.contains(new VarDefinition((((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getLine():0), (((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getCharPositionInLine():0)+1, (((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getText():null), null))){new ErrorType((((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getLine():0), (((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getCharPositionInLine():0)+1, "Duplicate variable definition error: " + (((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getText():null));}else{_localctx.ast.add(new VarDefinition((((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getLine():0), (((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getCharPositionInLine():0)+1, (((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getText():null), null));}
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 );
			setState(145);
			match(T__8);
			setState(146);
			((Multi_var_defContext)_localctx).build_in_type = build_in_type();
			for(Definition def : _localctx.ast) {def.setType(((Multi_var_defContext)_localctx).build_in_type.ast);}
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

	public static class FieldsContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<RecordField>();
		public Var_defContext var_def;
		public List<Var_defContext> var_def() {
			return getRuleContexts(Var_defContext.class);
		}
		public Var_defContext var_def(int i) {
			return getRuleContext(Var_defContext.class,i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(149);
				((FieldsContext)_localctx).var_def = var_def();
				for(Definition def : ((FieldsContext)_localctx).var_def.ast) {if(_localctx.ast.contains(new RecordField(def.getLine(), def.getColumn(), def.getName(), def.getType(), 0))) {new ErrorType(def.getLine(), def.getColumn(), "Duplicate field error: " + def.getName());} else {_localctx.ast.add(new RecordField(def.getLine(), def.getColumn(), def.getName(), def.getType(), 0));}}
				setState(151);
				match(T__0);
				}
				}
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 || _la==ID );
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

	public static class Func_defContext extends ParserRuleContext {
		public FuncDefinition ast;
		public Token ID;
		public ParametersContext parameters;
		public Build_in_typeContext build_in_type;
		public Func_bodyContext func_body;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public Build_in_typeContext build_in_type() {
			return getRuleContext(Build_in_typeContext.class,0);
		}
		public Func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def; }
	}

	public final Func_defContext func_def() throws RecognitionException {
		Func_defContext _localctx = new Func_defContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_func_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__11);
			setState(158);
			((Func_defContext)_localctx).ID = match(ID);
			setState(159);
			((Func_defContext)_localctx).parameters = parameters();
			((Func_defContext)_localctx).ast =  new FuncDefinition((((Func_defContext)_localctx).ID!=null?((Func_defContext)_localctx).ID.getLine():0), (((Func_defContext)_localctx).ID!=null?((Func_defContext)_localctx).ID.getCharPositionInLine():0)+1, (((Func_defContext)_localctx).ID!=null?((Func_defContext)_localctx).ID.getText():null), new FunctionType((((Func_defContext)_localctx).ID!=null?((Func_defContext)_localctx).ID.getLine():0), (((Func_defContext)_localctx).ID!=null?((Func_defContext)_localctx).ID.getCharPositionInLine():0)+1, null, ((Func_defContext)_localctx).parameters.ast), null);
			setState(161);
			match(T__8);
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
			case T__3:
			case T__6:
			case STRUCT:
				{
				setState(162);
				((Func_defContext)_localctx).build_in_type = build_in_type();
				((FunctionType)_localctx.ast.getType()).setReturnType(((Func_defContext)_localctx).build_in_type.ast);
				}
				break;
			case T__12:
				{
				setState(165);
				match(T__12);
				((FunctionType)_localctx.ast.getType()).setReturnType(VoidType.getInstance());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(169);
			match(T__4);
			setState(170);
			((Func_defContext)_localctx).func_body = func_body();
			setState(171);
			match(T__5);
			_localctx.ast.setStatements(((Func_defContext)_localctx).func_body.ast);
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

	public static class Main_defContext extends ParserRuleContext {
		public Definition ast;
		public Func_bodyContext func_body;
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public Main_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_def; }
	}

	public final Main_defContext main_def() throws RecognitionException {
		Main_defContext _localctx = new Main_defContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_main_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			List<VarDefinition> null_list = new ArrayList<VarDefinition>();
			setState(175);
			match(T__11);
			setState(176);
			match(T__13);
			setState(177);
			match(T__14);
			setState(178);
			match(T__15);
			setState(179);
			match(T__8);
			setState(180);
			match(T__12);
			setState(181);
			match(T__4);
			setState(182);
			((Main_defContext)_localctx).func_body = func_body();
			setState(183);
			match(T__5);
			 ((Main_defContext)_localctx).ast =  new FuncDefinition(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, "main", new FunctionType(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, VoidType.getInstance(), null_list), ((Main_defContext)_localctx).func_body.ast); 
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

	public static class ParametersContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public Single_var_defContext s1;
		public Single_var_defContext s2;
		public List<Single_var_defContext> single_var_def() {
			return getRuleContexts(Single_var_defContext.class);
		}
		public Single_var_defContext single_var_def(int i) {
			return getRuleContext(Single_var_defContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameters);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(T__14);
				setState(187);
				match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(T__14);
				setState(189);
				((ParametersContext)_localctx).s1 = single_var_def();
				_localctx.ast.add(((ParametersContext)_localctx).s1.ast);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(191);
					match(T__10);
					setState(192);
					((ParametersContext)_localctx).s2 = single_var_def();
					_localctx.ast.add(((ParametersContext)_localctx).s2.ast);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(T__15);
				}
				break;
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

	public static class Func_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public Var_defContext var_def;
		public StatementContext statement;
		public List<Var_defContext> var_def() {
			return getRuleContexts(Var_defContext.class);
		}
		public Var_defContext var_def(int i) {
			return getRuleContext(Var_defContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Func_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_body; }
	}

	public final Func_bodyContext func_body() throws RecognitionException {
		Func_bodyContext _localctx = new Func_bodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_func_body);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(204);
					((Func_bodyContext)_localctx).var_def = var_def();
					_localctx.ast.addAll(((Func_bodyContext)_localctx).var_def.ast);
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__0) {
						{
						setState(206);
						match(T__0);
						}
					}

					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__35) | (1L << T__36) | (1L << T__42) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0)) {
				{
				{
				setState(214);
				((Func_bodyContext)_localctx).statement = statement();
				_localctx.ast.addAll(((Func_bodyContext)_localctx).statement.ast);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(216);
					match(T__0);
					}
				}

				}
				}
				setState(223);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext ex1;
		public ExpressionContext exp;
		public ExpressionContext expression;
		public CastContext cast;
		public Var_invocationContext var_invocation;
		public Func_invocationContext func_invocation;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token op;
		public ExpressionContext ex2;
		public Token ID;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public Var_invocationContext var_invocation() {
			return getRuleContext(Var_invocationContext.class,0);
		}
		public Func_invocationContext func_invocation() {
			return getRuleContext(Func_invocationContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(225);
				match(T__14);
				setState(226);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(227);
				match(T__15);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast;
				}
				break;
			case 2:
				{
				setState(230);
				((ExpressionContext)_localctx).cast = cast();
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).cast.ast;
				}
				break;
			case 3:
				{
				setState(233);
				match(T__17);
				setState(234);
				((ExpressionContext)_localctx).expression = expression(13);
				((ExpressionContext)_localctx).ast =  new UnaryMinus(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 4:
				{
				setState(237);
				match(T__18);
				setState(238);
				((ExpressionContext)_localctx).expression = expression(12);
				((ExpressionContext)_localctx).ast =  new UnaryNot(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 5:
				{
				setState(241);
				((ExpressionContext)_localctx).var_invocation = var_invocation();
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).var_invocation.ast;
				}
				break;
			case 6:
				{
				setState(244);
				((ExpressionContext)_localctx).func_invocation = func_invocation();
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).func_invocation.ast;
				}
				break;
			case 7:
				{
				setState(247);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast =  new IntLiteral(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)));
				}
				break;
			case 8:
				{
				setState(249);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new RealLiteral(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)));
				}
				break;
			case 9:
				{
				setState(251);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharLiteral(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(295);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(293);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(255);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(256);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(257);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(12);
						((ExpressionContext)_localctx).ast =  new Arithmetic(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ex1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).ex2.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(260);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(261);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__22) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(262);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(11);
						((ExpressionContext)_localctx).ast =  new Arithmetic(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ex1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).ex2.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(265);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(266);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(267);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(10);
						((ExpressionContext)_localctx).ast =  new Comparison(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ex1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).ex2.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(270);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(271);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(272);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(9);
						((ExpressionContext)_localctx).ast =  new Logical(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ex1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).ex2.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(275);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(276);
						match(T__31);
						setState(277);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(8);
						((ExpressionContext)_localctx).ast =  new Logical(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), new Logical(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), new UnaryNot(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(),((ExpressionContext)_localctx).ex1.ast), "&&", ((ExpressionContext)_localctx).ex2.ast), "||", new Logical(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), ((ExpressionContext)_localctx).ex1.ast, "&&", new UnaryNot(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(),((ExpressionContext)_localctx).ex2.ast)));
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(280);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(281);
						match(T__6);
						setState(282);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(283);
						match(T__7);
						((ExpressionContext)_localctx).ast = new Indexing(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ex1.ast, ((ExpressionContext)_localctx).ex2.ast);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp = _prevctx;
						_localctx.exp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(286);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(287);
						match(T__16);
						setState(288);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new FieldAccess((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getLine():0), (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getCharPositionInLine():0), ((ExpressionContext)_localctx).exp.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(290);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(291);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__33) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						((ExpressionContext)_localctx).ast =  new Arithmetic(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ExpressionContext)_localctx).expression.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), new IntLiteral(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), 1));
						}
						break;
					}
					} 
				}
				setState(297);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public If_stContext if_st;
		public TernaryContext ternary;
		public While_stContext while_st;
		public Dowhile_stContext dowhile_st;
		public Write_stContext write_st;
		public Read_stContext read_st;
		public Func_invocationContext func_invocation;
		public AssigmentContext assigment;
		public Return_stContext return_st;
		public If_stContext if_st() {
			return getRuleContext(If_stContext.class,0);
		}
		public TernaryContext ternary() {
			return getRuleContext(TernaryContext.class,0);
		}
		public While_stContext while_st() {
			return getRuleContext(While_stContext.class,0);
		}
		public Dowhile_stContext dowhile_st() {
			return getRuleContext(Dowhile_stContext.class,0);
		}
		public Write_stContext write_st() {
			return getRuleContext(Write_stContext.class,0);
		}
		public Read_stContext read_st() {
			return getRuleContext(Read_stContext.class,0);
		}
		public Func_invocationContext func_invocation() {
			return getRuleContext(Func_invocationContext.class,0);
		}
		public AssigmentContext assigment() {
			return getRuleContext(AssigmentContext.class,0);
		}
		public Return_stContext return_st() {
			return getRuleContext(Return_stContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				((StatementContext)_localctx).if_st = if_st();
				_localctx.ast.add(((StatementContext)_localctx).if_st.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				((StatementContext)_localctx).ternary = ternary();
				_localctx.ast.add(((StatementContext)_localctx).ternary.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				((StatementContext)_localctx).while_st = while_st();
				_localctx.ast.add(((StatementContext)_localctx).while_st.ast);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(307);
				((StatementContext)_localctx).dowhile_st = dowhile_st();
				_localctx.ast.add(((StatementContext)_localctx).dowhile_st.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(310);
				((StatementContext)_localctx).write_st = write_st();
				_localctx.ast.addAll(((StatementContext)_localctx).write_st.ast);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(313);
				((StatementContext)_localctx).read_st = read_st();
				_localctx.ast.addAll(((StatementContext)_localctx).read_st.ast);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(316);
				((StatementContext)_localctx).func_invocation = func_invocation();
				_localctx.ast.add((Statement)((StatementContext)_localctx).func_invocation.ast);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(319);
				((StatementContext)_localctx).assigment = assigment();
				_localctx.ast.add(((StatementContext)_localctx).assigment.ast);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(322);
				((StatementContext)_localctx).return_st = return_st();
				_localctx.ast.add(((StatementContext)_localctx).return_st.ast);
				}
				break;
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

	public static class TernaryContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext expression;
		public Elif_simple_bodyContext s1;
		public Elif_simple_bodyContext s2;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<Elif_simple_bodyContext> elif_simple_body() {
			return getRuleContexts(Elif_simple_bodyContext.class);
		}
		public Elif_simple_bodyContext elif_simple_body(int i) {
			return getRuleContext(Elif_simple_bodyContext.class,i);
		}
		public TernaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary; }
	}

	public final TernaryContext ternary() throws RecognitionException {
		TernaryContext _localctx = new TernaryContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(T__14);
			setState(328);
			((TernaryContext)_localctx).expression = expression(0);
			setState(329);
			match(T__15);
			setState(330);
			match(T__34);
			setState(331);
			((TernaryContext)_localctx).s1 = elif_simple_body();
			setState(332);
			match(T__8);
			setState(333);
			((TernaryContext)_localctx).s2 = elif_simple_body();
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(334);
				match(T__0);
				}
				break;
			}
			((TernaryContext)_localctx).ast =  new IfStatement(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), ((TernaryContext)_localctx).s1.ast, ((TernaryContext)_localctx).s2.ast, ((TernaryContext)_localctx).expression.ast);
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

	public static class Write_stContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public ExpressionContext ex1;
		public ExpressionContext ex2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Write_stContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_st; }
	}

	public final Write_stContext write_st() throws RecognitionException {
		Write_stContext _localctx = new Write_stContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_write_st);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(T__35);
			setState(340);
			((Write_stContext)_localctx).ex1 = expression(0);
			_localctx.ast.add(new Write(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((Write_stContext)_localctx).ex1.ast));
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(342);
				match(T__10);
				setState(343);
				((Write_stContext)_localctx).ex2 = expression(0);
				_localctx.ast.add(new Write(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((Write_stContext)_localctx).ex2.ast));
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(351);
				match(T__0);
				}
				break;
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

	public static class Read_stContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public ExpressionContext ex1;
		public ExpressionContext ex2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Read_stContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_st; }
	}

	public final Read_stContext read_st() throws RecognitionException {
		Read_stContext _localctx = new Read_stContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_read_st);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(T__36);
			setState(355);
			((Read_stContext)_localctx).ex1 = expression(0);
			_localctx.ast.add(new Read(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((Read_stContext)_localctx).ex1.ast));
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(357);
				match(T__10);
				setState(358);
				((Read_stContext)_localctx).ex2 = expression(0);
				_localctx.ast.add(new Read(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((Read_stContext)_localctx).ex2.ast));
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(366);
				match(T__0);
				}
				break;
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

	public static class AssigmentContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext ex1;
		public ExpressionContext ex2;
		public ExpressionContext ex;
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assigment; }
	}

	public final AssigmentContext assigment() throws RecognitionException {
		AssigmentContext _localctx = new AssigmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assigment);
		int _la;
		try {
			setState(386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				((AssigmentContext)_localctx).ex1 = expression(0);
				setState(370);
				match(T__37);
				setState(371);
				((AssigmentContext)_localctx).ex2 = expression(0);
				setState(373);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(372);
					match(T__0);
					}
					break;
				}
				((AssigmentContext)_localctx).ast =  new Assignment(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((AssigmentContext)_localctx).ex1.ast, ((AssigmentContext)_localctx).ex2.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				((AssigmentContext)_localctx).ex = expression(0);
				setState(378);
				((AssigmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__32 || _la==T__33) ) {
					((AssigmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((AssigmentContext)_localctx).ast =  new Assignment(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((AssigmentContext)_localctx).ex.ast, new Arithmetic(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((AssigmentContext)_localctx).ex.ast, (((AssigmentContext)_localctx).op!=null?((AssigmentContext)_localctx).op.getText():null), new IntLiteral(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), 1)));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(381);
				((AssigmentContext)_localctx).ex1 = expression(0);
				setState(382);
				((AssigmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0)) ) {
					((AssigmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(383);
				((AssigmentContext)_localctx).ex2 = expression(0);
				((AssigmentContext)_localctx).ast =  new Assignment(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((AssigmentContext)_localctx).ex1.ast, new Arithmetic(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((AssigmentContext)_localctx).ex1.ast, (((AssigmentContext)_localctx).op!=null?((AssigmentContext)_localctx).op.getText():null), ((AssigmentContext)_localctx).ex2.ast));
				}
				break;
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

	public static class ConditionContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext ex1;
		public Token op;
		public ExpressionContext ex2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condition);
		int _la;
		try {
			setState(398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				((ConditionContext)_localctx).ex1 = expression(0);
				setState(389);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(390);
				((ConditionContext)_localctx).ex2 = expression(0);
				((ConditionContext)_localctx).ast =  new Comparison(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ConditionContext)_localctx).ex1.ast, (((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null), ((ConditionContext)_localctx).ex2.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				((ConditionContext)_localctx).ex1 = expression(0);
				setState(394);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(395);
				((ConditionContext)_localctx).ex2 = expression(0);
				((ConditionContext)_localctx).ast =  new Logical(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((ConditionContext)_localctx).ex1.ast, (((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null), ((ConditionContext)_localctx).ex2.ast);
				}
				break;
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

	public static class If_stContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext expression;
		public Elif_simple_bodyContext elif_simple_body;
		public Elif_bodyContext elif_body;
		public Else_stContext else_st;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Elif_simple_bodyContext elif_simple_body() {
			return getRuleContext(Elif_simple_bodyContext.class,0);
		}
		public Elif_bodyContext elif_body() {
			return getRuleContext(Elif_bodyContext.class,0);
		}
		public Else_stContext else_st() {
			return getRuleContext(Else_stContext.class,0);
		}
		public If_stContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_st; }
	}

	public final If_stContext if_st() throws RecognitionException {
		If_stContext _localctx = new If_stContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_if_st);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(T__42);
			setState(401);
			((If_stContext)_localctx).expression = expression(0);
			((If_stContext)_localctx).ast =  new IfStatement(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, null, null, (Expression)((If_stContext)_localctx).expression.ast);
			setState(403);
			match(T__8);
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__17:
			case T__18:
			case T__35:
			case T__36:
			case T__42:
			case T__44:
			case T__45:
			case T__46:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				{
				setState(404);
				((If_stContext)_localctx).elif_simple_body = elif_simple_body();
				((IfStatement)_localctx.ast).setIfBody(((If_stContext)_localctx).elif_simple_body.ast);
				}
				break;
			case T__4:
				{
				setState(407);
				((If_stContext)_localctx).elif_body = elif_body();
				((IfStatement)_localctx.ast).setIfBody(((If_stContext)_localctx).elif_body.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(412);
				((If_stContext)_localctx).else_st = else_st();
				((IfStatement)_localctx.ast).setElseBody(((If_stContext)_localctx).else_st.ast);
				}
				break;
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

	public static class Else_stContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public Elif_simple_bodyContext elif_simple_body;
		public Elif_bodyContext elif_body;
		public Elif_simple_bodyContext elif_simple_body() {
			return getRuleContext(Elif_simple_bodyContext.class,0);
		}
		public Elif_bodyContext elif_body() {
			return getRuleContext(Elif_bodyContext.class,0);
		}
		public Else_stContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_st; }
	}

	public final Else_stContext else_st() throws RecognitionException {
		Else_stContext _localctx = new Else_stContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_else_st);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(T__43);
			setState(424);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__17:
			case T__18:
			case T__35:
			case T__36:
			case T__42:
			case T__44:
			case T__45:
			case T__46:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				{
				setState(418);
				((Else_stContext)_localctx).elif_simple_body = elif_simple_body();
				_localctx.ast.addAll(((Else_stContext)_localctx).elif_simple_body.ast);
				}
				break;
			case T__4:
				{
				setState(421);
				((Else_stContext)_localctx).elif_body = elif_body();
				_localctx.ast.addAll(((Else_stContext)_localctx).elif_body.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Elif_simple_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext statement;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Elif_simple_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_simple_body; }
	}

	public final Elif_simple_bodyContext elif_simple_body() throws RecognitionException {
		Elif_simple_bodyContext _localctx = new Elif_simple_bodyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elif_simple_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			((Elif_simple_bodyContext)_localctx).statement = statement();
			setState(428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(427);
				match(T__0);
				}
				break;
			}
			_localctx.ast.addAll(((Elif_simple_bodyContext)_localctx).statement.ast);
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

	public static class Elif_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Elif_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_body; }
	}

	public final Elif_bodyContext elif_body() throws RecognitionException {
		Elif_bodyContext _localctx = new Elif_bodyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elif_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(T__4);
			setState(438); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(433);
				((Elif_bodyContext)_localctx).statement = statement();
				_localctx.ast.addAll(((Elif_bodyContext)_localctx).statement.ast);
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(435);
					match(T__0);
					}
				}

				}
				}
				setState(440); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__35) | (1L << T__36) | (1L << T__42) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0) );
			setState(442);
			match(T__5);
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

	public static class While_stContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext expression;
		public While_bodyContext while_body;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public While_bodyContext while_body() {
			return getRuleContext(While_bodyContext.class,0);
		}
		public While_stContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_st; }
	}

	public final While_stContext while_st() throws RecognitionException {
		While_stContext _localctx = new While_stContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_while_st);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(T__44);
			setState(445);
			((While_stContext)_localctx).expression = expression(0);
			setState(446);
			match(T__8);
			setState(447);
			((While_stContext)_localctx).while_body = while_body();
			((While_stContext)_localctx).ast =  new WhileStatement(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((While_stContext)_localctx).while_body.ast, (Expression)((While_stContext)_localctx).expression.ast);
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

	public static class While_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public While_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_body; }
	}

	public final While_bodyContext while_body() throws RecognitionException {
		While_bodyContext _localctx = new While_bodyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_while_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			match(T__4);
			setState(456); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(451);
				((While_bodyContext)_localctx).statement = statement();
				_localctx.ast.addAll(((While_bodyContext)_localctx).statement.ast);
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(453);
					match(T__0);
					}
				}

				}
				}
				setState(458); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__35) | (1L << T__36) | (1L << T__42) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0) );
			setState(460);
			match(T__5);
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

	public static class Dowhile_stContext extends ParserRuleContext {
		public Statement ast;
		public While_bodyContext while_body;
		public ExpressionContext expression;
		public While_bodyContext while_body() {
			return getRuleContext(While_bodyContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Dowhile_stContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dowhile_st; }
	}

	public final Dowhile_stContext dowhile_st() throws RecognitionException {
		Dowhile_stContext _localctx = new Dowhile_stContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_dowhile_st);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(T__45);
			setState(463);
			match(T__8);
			setState(464);
			((Dowhile_stContext)_localctx).while_body = while_body();
			setState(465);
			match(T__44);
			setState(466);
			((Dowhile_stContext)_localctx).expression = expression(0);
			setState(468);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(467);
				match(T__0);
				}
				break;
			}
			((Dowhile_stContext)_localctx).ast =  new DoWhileStatement(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), ((Dowhile_stContext)_localctx).while_body.ast, (Expression)((Dowhile_stContext)_localctx).expression.ast);
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

	public static class Return_stContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Return_stContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_st; }
	}

	public final Return_stContext return_st() throws RecognitionException {
		Return_stContext _localctx = new Return_stContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_return_st);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(T__46);
			setState(473);
			((Return_stContext)_localctx).expression = expression(0);
			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(474);
				match(T__0);
				}
				break;
			}
			((Return_stContext)_localctx).ast =  new Return(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((Return_stContext)_localctx).expression.ast);
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

	public static class CastContext extends ParserRuleContext {
		public Expression ast;
		public Build_in_typeContext build_in_type;
		public ExpressionContext expression;
		public Build_in_typeContext build_in_type() {
			return getRuleContext(Build_in_typeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast; }
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(T__14);
			setState(480);
			((CastContext)_localctx).build_in_type = build_in_type();
			setState(481);
			match(T__15);
			setState(482);
			((CastContext)_localctx).expression = expression(0);
			setState(484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(483);
				match(T__0);
				}
				break;
			}
			((CastContext)_localctx).ast =  new Cast(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, ((CastContext)_localctx).expression.ast, ((CastContext)_localctx).build_in_type.ast);
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

	public static class Func_invocationContext extends ParserRuleContext {
		public Expression ast;
		public Token ID;
		public ArgumentContext argument;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public Func_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_invocation; }
	}

	public final Func_invocationContext func_invocation() throws RecognitionException {
		Func_invocationContext _localctx = new Func_invocationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_func_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			((Func_invocationContext)_localctx).ID = match(ID);
			setState(489);
			((Func_invocationContext)_localctx).argument = argument();
			setState(491);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(490);
				match(T__0);
				}
				break;
			}
			((Func_invocationContext)_localctx).ast =  new Invocation(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, new Variable((((Func_invocationContext)_localctx).ID!=null?((Func_invocationContext)_localctx).ID.getLine():0), (((Func_invocationContext)_localctx).ID!=null?((Func_invocationContext)_localctx).ID.getCharPositionInLine():0), (((Func_invocationContext)_localctx).ID!=null?((Func_invocationContext)_localctx).ID.getText():null)), ((Func_invocationContext)_localctx).argument.ast);
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

	public static class ArgumentContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext ex1;
		public ExpressionContext ex2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_argument);
		int _la;
		try {
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(495);
				match(T__14);
				setState(496);
				match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				match(T__14);
				setState(498);
				((ArgumentContext)_localctx).ex1 = expression(0);
				_localctx.ast.add(((ArgumentContext)_localctx).ex1.ast);
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(500);
					match(T__10);
					setState(501);
					((ArgumentContext)_localctx).ex2 = expression(0);
					_localctx.ast.add(((ArgumentContext)_localctx).ex2.ast);
					}
					}
					setState(508);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(509);
				match(T__15);
				}
				break;
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

	public static class Proc_invocationContext extends ParserRuleContext {
		public Proc_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proc_invocation; }
	}

	public final Proc_invocationContext proc_invocation() throws RecognitionException {
		Proc_invocationContext _localctx = new Proc_invocationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_proc_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(T__0);
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

	public static class Var_invocationContext extends ParserRuleContext {
		public Expression ast;
		public Token ID;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public Var_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_invocation; }
	}

	public final Var_invocationContext var_invocation() throws RecognitionException {
		Var_invocationContext _localctx = new Var_invocationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_var_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			((Var_invocationContext)_localctx).ID = match(ID);
			((Var_invocationContext)_localctx).ast =  new Variable((((Var_invocationContext)_localctx).ID!=null?((Var_invocationContext)_localctx).ID.getLine():0), (((Var_invocationContext)_localctx).ID!=null?((Var_invocationContext)_localctx).ID.getCharPositionInLine():0), (((Var_invocationContext)_localctx).ID!=null?((Var_invocationContext)_localctx).ID.getText():null));
			setState(518);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(517);
				match(T__0);
				}
				break;
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 16);
		case 6:
			return precpred(_ctx, 15);
		case 7:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u020b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3g\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4z\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5\u0089\n\5\3\6\3\6\3\6\3\6\3\6\6\6\u0090\n\6\r\6\16"+
		"\6\u0091\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\6\7\u009c\n\7\r\7\16\7\u009d"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00aa\n\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\7\n\u00c6\n\n\f\n\16\n\u00c9\13\n\3\n\3\n\5\n\u00cd"+
		"\n\n\3\13\3\13\3\13\5\13\u00d2\n\13\7\13\u00d4\n\13\f\13\16\13\u00d7\13"+
		"\13\3\13\3\13\3\13\5\13\u00dc\n\13\7\13\u00de\n\13\f\13\16\13\u00e1\13"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0100\n\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\7\f\u0128\n\f\f\f\16\f\u012b\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u0148\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0152"+
		"\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u015d\n\17\f\17"+
		"\16\17\u0160\13\17\3\17\5\17\u0163\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\7\20\u016c\n\20\f\20\16\20\u016f\13\20\3\20\5\20\u0172\n\20\3\21"+
		"\3\21\3\21\3\21\5\21\u0178\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0185\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u0191\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u019d\n\23\3\23\3\23\3\23\5\23\u01a2\n\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\5\24\u01ab\n\24\3\25\3\25\5\25\u01af\n\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\5\26\u01b7\n\26\6\26\u01b9\n\26\r\26\16\26\u01ba"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u01c9"+
		"\n\30\6\30\u01cb\n\30\r\30\16\30\u01cc\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\5\31\u01d7\n\31\3\31\3\31\3\32\3\32\3\32\5\32\u01de\n\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u01e7\n\33\3\33\3\33\3\34\3\34\3\34"+
		"\5\34\u01ee\n\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\7\35\u01fb\n\35\f\35\16\35\u01fe\13\35\3\35\3\35\5\35\u0202\n\35\3\36"+
		"\3\36\3\37\3\37\3\37\5\37\u0209\n\37\3\37\2\3\26 \2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\b\3\2\26\30\4\2\24\24\31"+
		"\31\3\2\32\37\3\2 !\3\2#$\3\2),\2\u022e\2>\3\2\2\2\4f\3\2\2\2\6y\3\2\2"+
		"\2\b\u0088\3\2\2\2\n\u008a\3\2\2\2\f\u009b\3\2\2\2\16\u009f\3\2\2\2\20"+
		"\u00b0\3\2\2\2\22\u00cc\3\2\2\2\24\u00d5\3\2\2\2\26\u00ff\3\2\2\2\30\u0147"+
		"\3\2\2\2\32\u0149\3\2\2\2\34\u0155\3\2\2\2\36\u0164\3\2\2\2 \u0184\3\2"+
		"\2\2\"\u0190\3\2\2\2$\u0192\3\2\2\2&\u01a3\3\2\2\2(\u01ac\3\2\2\2*\u01b2"+
		"\3\2\2\2,\u01be\3\2\2\2.\u01c4\3\2\2\2\60\u01d0\3\2\2\2\62\u01da\3\2\2"+
		"\2\64\u01e1\3\2\2\2\66\u01ea\3\2\2\28\u0201\3\2\2\2:\u0203\3\2\2\2<\u0205"+
		"\3\2\2\2>I\b\2\1\2?@\5\6\4\2@A\7\3\2\2AB\3\2\2\2BC\b\2\1\2CH\3\2\2\2D"+
		"E\5\16\b\2EF\b\2\1\2FH\3\2\2\2G?\3\2\2\2GD\3\2\2\2HK\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\5\20\t\2MN\7\2\2\3NO\b\2\1\2O\3\3\2\2"+
		"\2PQ\7\4\2\2Qg\b\3\1\2RS\7\5\2\2Sg\b\3\1\2TU\7\6\2\2Ug\b\3\1\2VW\b\3\1"+
		"\2WX\7\65\2\2XY\7\7\2\2YZ\5\f\7\2Z[\b\3\1\2[\\\3\2\2\2\\]\7\b\2\2]^\b"+
		"\3\1\2^g\3\2\2\2_`\7\t\2\2`a\7\63\2\2ab\7\n\2\2bc\3\2\2\2cd\5\4\3\2de"+
		"\b\3\1\2eg\3\2\2\2fP\3\2\2\2fR\3\2\2\2fT\3\2\2\2fV\3\2\2\2f_\3\2\2\2g"+
		"\5\3\2\2\2hi\5\b\5\2ij\b\4\1\2jz\3\2\2\2kl\5\n\6\2lm\b\4\1\2mz\3\2\2\2"+
		"no\b\4\1\2op\7\67\2\2pq\7\13\2\2qr\7\65\2\2rs\7\7\2\2st\5\f\7\2tu\b\4"+
		"\1\2uv\3\2\2\2vw\7\b\2\2wx\b\4\1\2xz\3\2\2\2yh\3\2\2\2yk\3\2\2\2yn\3\2"+
		"\2\2z\7\3\2\2\2{|\7\67\2\2|}\b\5\1\2}~\7\13\2\2~\177\5\4\3\2\177\u0080"+
		"\b\5\1\2\u0080\u0089\3\2\2\2\u0081\u0082\7\f\2\2\u0082\u0083\7\67\2\2"+
		"\u0083\u0084\b\5\1\2\u0084\u0085\7\13\2\2\u0085\u0086\5\4\3\2\u0086\u0087"+
		"\b\5\1\2\u0087\u0089\3\2\2\2\u0088{\3\2\2\2\u0088\u0081\3\2\2\2\u0089"+
		"\t\3\2\2\2\u008a\u008b\7\67\2\2\u008b\u008f\b\6\1\2\u008c\u008d\7\r\2"+
		"\2\u008d\u008e\7\67\2\2\u008e\u0090\b\6\1\2\u008f\u008c\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0094\7\13\2\2\u0094\u0095\5\4\3\2\u0095\u0096\b\6\1\2\u0096"+
		"\13\3\2\2\2\u0097\u0098\5\6\4\2\u0098\u0099\b\7\1\2\u0099\u009a\7\3\2"+
		"\2\u009a\u009c\3\2\2\2\u009b\u0097\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\r\3\2\2\2\u009f\u00a0\7\16\2\2\u00a0"+
		"\u00a1\7\67\2\2\u00a1\u00a2\5\22\n\2\u00a2\u00a3\b\b\1\2\u00a3\u00a9\7"+
		"\13\2\2\u00a4\u00a5\5\4\3\2\u00a5\u00a6\b\b\1\2\u00a6\u00aa\3\2\2\2\u00a7"+
		"\u00a8\7\17\2\2\u00a8\u00aa\b\b\1\2\u00a9\u00a4\3\2\2\2\u00a9\u00a7\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\7\2\2\u00ac\u00ad\5\24\13\2\u00ad"+
		"\u00ae\7\b\2\2\u00ae\u00af\b\b\1\2\u00af\17\3\2\2\2\u00b0\u00b1\b\t\1"+
		"\2\u00b1\u00b2\7\16\2\2\u00b2\u00b3\7\20\2\2\u00b3\u00b4\7\21\2\2\u00b4"+
		"\u00b5\7\22\2\2\u00b5\u00b6\7\13\2\2\u00b6\u00b7\7\17\2\2\u00b7\u00b8"+
		"\7\7\2\2\u00b8\u00b9\5\24\13\2\u00b9\u00ba\7\b\2\2\u00ba\u00bb\b\t\1\2"+
		"\u00bb\21\3\2\2\2\u00bc\u00bd\7\21\2\2\u00bd\u00cd\7\22\2\2\u00be\u00bf"+
		"\7\21\2\2\u00bf\u00c0\5\b\5\2\u00c0\u00c7\b\n\1\2\u00c1\u00c2\7\r\2\2"+
		"\u00c2\u00c3\5\b\5\2\u00c3\u00c4\b\n\1\2\u00c4\u00c6\3\2\2\2\u00c5\u00c1"+
		"\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\22\2\2\u00cb\u00cd\3"+
		"\2\2\2\u00cc\u00bc\3\2\2\2\u00cc\u00be\3\2\2\2\u00cd\23\3\2\2\2\u00ce"+
		"\u00cf\5\6\4\2\u00cf\u00d1\b\13\1\2\u00d0\u00d2\7\3\2\2\u00d1\u00d0\3"+
		"\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00df\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\5\30\r\2\u00d9\u00db\b\13\1\2\u00da"+
		"\u00dc\7\3\2\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2"+
		"\2\2\u00dd\u00d8\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\25\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\b\f\1"+
		"\2\u00e3\u00e4\7\21\2\2\u00e4\u00e5\5\26\f\2\u00e5\u00e6\7\22\2\2\u00e6"+
		"\u00e7\b\f\1\2\u00e7\u0100\3\2\2\2\u00e8\u00e9\5\64\33\2\u00e9\u00ea\b"+
		"\f\1\2\u00ea\u0100\3\2\2\2\u00eb\u00ec\7\24\2\2\u00ec\u00ed\5\26\f\17"+
		"\u00ed\u00ee\b\f\1\2\u00ee\u0100\3\2\2\2\u00ef\u00f0\7\25\2\2\u00f0\u00f1"+
		"\5\26\f\16\u00f1\u00f2\b\f\1\2\u00f2\u0100\3\2\2\2\u00f3\u00f4\5<\37\2"+
		"\u00f4\u00f5\b\f\1\2\u00f5\u0100\3\2\2\2\u00f6\u00f7\5\66\34\2\u00f7\u00f8"+
		"\b\f\1\2\u00f8\u0100\3\2\2\2\u00f9\u00fa\7\63\2\2\u00fa\u0100\b\f\1\2"+
		"\u00fb\u00fc\7\64\2\2\u00fc\u0100\b\f\1\2\u00fd\u00fe\7\66\2\2\u00fe\u0100"+
		"\b\f\1\2\u00ff\u00e2\3\2\2\2\u00ff\u00e8\3\2\2\2\u00ff\u00eb\3\2\2\2\u00ff"+
		"\u00ef\3\2\2\2\u00ff\u00f3\3\2\2\2\u00ff\u00f6\3\2\2\2\u00ff\u00f9\3\2"+
		"\2\2\u00ff\u00fb\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0129\3\2\2\2\u0101"+
		"\u0102\f\r\2\2\u0102\u0103\t\2\2\2\u0103\u0104\5\26\f\16\u0104\u0105\b"+
		"\f\1\2\u0105\u0128\3\2\2\2\u0106\u0107\f\f\2\2\u0107\u0108\t\3\2\2\u0108"+
		"\u0109\5\26\f\r\u0109\u010a\b\f\1\2\u010a\u0128\3\2\2\2\u010b\u010c\f"+
		"\13\2\2\u010c\u010d\t\4\2\2\u010d\u010e\5\26\f\f\u010e\u010f\b\f\1\2\u010f"+
		"\u0128\3\2\2\2\u0110\u0111\f\n\2\2\u0111\u0112\t\5\2\2\u0112\u0113\5\26"+
		"\f\13\u0113\u0114\b\f\1\2\u0114\u0128\3\2\2\2\u0115\u0116\f\t\2\2\u0116"+
		"\u0117\7\"\2\2\u0117\u0118\5\26\f\n\u0118\u0119\b\f\1\2\u0119\u0128\3"+
		"\2\2\2\u011a\u011b\f\22\2\2\u011b\u011c\7\t\2\2\u011c\u011d\5\26\f\2\u011d"+
		"\u011e\7\n\2\2\u011e\u011f\b\f\1\2\u011f\u0128\3\2\2\2\u0120\u0121\f\21"+
		"\2\2\u0121\u0122\7\23\2\2\u0122\u0123\7\67\2\2\u0123\u0128\b\f\1\2\u0124"+
		"\u0125\f\b\2\2\u0125\u0126\t\6\2\2\u0126\u0128\b\f\1\2\u0127\u0101\3\2"+
		"\2\2\u0127\u0106\3\2\2\2\u0127\u010b\3\2\2\2\u0127\u0110\3\2\2\2\u0127"+
		"\u0115\3\2\2\2\u0127\u011a\3\2\2\2\u0127\u0120\3\2\2\2\u0127\u0124\3\2"+
		"\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\27\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\5$\23\2\u012d\u012e\b\r\1"+
		"\2\u012e\u0148\3\2\2\2\u012f\u0130\5\32\16\2\u0130\u0131\b\r\1\2\u0131"+
		"\u0148\3\2\2\2\u0132\u0133\5,\27\2\u0133\u0134\b\r\1\2\u0134\u0148\3\2"+
		"\2\2\u0135\u0136\5\60\31\2\u0136\u0137\b\r\1\2\u0137\u0148\3\2\2\2\u0138"+
		"\u0139\5\34\17\2\u0139\u013a\b\r\1\2\u013a\u0148\3\2\2\2\u013b\u013c\5"+
		"\36\20\2\u013c\u013d\b\r\1\2\u013d\u0148\3\2\2\2\u013e\u013f\5\66\34\2"+
		"\u013f\u0140\b\r\1\2\u0140\u0148\3\2\2\2\u0141\u0142\5 \21\2\u0142\u0143"+
		"\b\r\1\2\u0143\u0148\3\2\2\2\u0144\u0145\5\62\32\2\u0145\u0146\b\r\1\2"+
		"\u0146\u0148\3\2\2\2\u0147\u012c\3\2\2\2\u0147\u012f\3\2\2\2\u0147\u0132"+
		"\3\2\2\2\u0147\u0135\3\2\2\2\u0147\u0138\3\2\2\2\u0147\u013b\3\2\2\2\u0147"+
		"\u013e\3\2\2\2\u0147\u0141\3\2\2\2\u0147\u0144\3\2\2\2\u0148\31\3\2\2"+
		"\2\u0149\u014a\7\21\2\2\u014a\u014b\5\26\f\2\u014b\u014c\7\22\2\2\u014c"+
		"\u014d\7%\2\2\u014d\u014e\5(\25\2\u014e\u014f\7\13\2\2\u014f\u0151\5("+
		"\25\2\u0150\u0152\7\3\2\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0154\b\16\1\2\u0154\33\3\2\2\2\u0155\u0156\7&\2"+
		"\2\u0156\u0157\5\26\f\2\u0157\u015e\b\17\1\2\u0158\u0159\7\r\2\2\u0159"+
		"\u015a\5\26\f\2\u015a\u015b\b\17\1\2\u015b\u015d\3\2\2\2\u015c\u0158\3"+
		"\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0163\7\3\2\2\u0162\u0161\3\2"+
		"\2\2\u0162\u0163\3\2\2\2\u0163\35\3\2\2\2\u0164\u0165\7\'\2\2\u0165\u0166"+
		"\5\26\f\2\u0166\u016d\b\20\1\2\u0167\u0168\7\r\2\2\u0168\u0169\5\26\f"+
		"\2\u0169\u016a\b\20\1\2\u016a\u016c\3\2\2\2\u016b\u0167\3\2\2\2\u016c"+
		"\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0171\3\2"+
		"\2\2\u016f\u016d\3\2\2\2\u0170\u0172\7\3\2\2\u0171\u0170\3\2\2\2\u0171"+
		"\u0172\3\2\2\2\u0172\37\3\2\2\2\u0173\u0174\5\26\f\2\u0174\u0175\7(\2"+
		"\2\u0175\u0177\5\26\f\2\u0176\u0178\7\3\2\2\u0177\u0176\3\2\2\2\u0177"+
		"\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\b\21\1\2\u017a\u0185\3"+
		"\2\2\2\u017b\u017c\5\26\f\2\u017c\u017d\t\6\2\2\u017d\u017e\b\21\1\2\u017e"+
		"\u0185\3\2\2\2\u017f\u0180\5\26\f\2\u0180\u0181\t\7\2\2\u0181\u0182\5"+
		"\26\f\2\u0182\u0183\b\21\1\2\u0183\u0185\3\2\2\2\u0184\u0173\3\2\2\2\u0184"+
		"\u017b\3\2\2\2\u0184\u017f\3\2\2\2\u0185!\3\2\2\2\u0186\u0187\5\26\f\2"+
		"\u0187\u0188\t\4\2\2\u0188\u0189\5\26\f\2\u0189\u018a\b\22\1\2\u018a\u0191"+
		"\3\2\2\2\u018b\u018c\5\26\f\2\u018c\u018d\t\5\2\2\u018d\u018e\5\26\f\2"+
		"\u018e\u018f\b\22\1\2\u018f\u0191\3\2\2\2\u0190\u0186\3\2\2\2\u0190\u018b"+
		"\3\2\2\2\u0191#\3\2\2\2\u0192\u0193\7-\2\2\u0193\u0194\5\26\f\2\u0194"+
		"\u0195\b\23\1\2\u0195\u019c\7\13\2\2\u0196\u0197\5(\25\2\u0197\u0198\b"+
		"\23\1\2\u0198\u019d\3\2\2\2\u0199\u019a\5*\26\2\u019a\u019b\b\23\1\2\u019b"+
		"\u019d\3\2\2\2\u019c\u0196\3\2\2\2\u019c\u0199\3\2\2\2\u019d\u01a1\3\2"+
		"\2\2\u019e\u019f\5&\24\2\u019f\u01a0\b\23\1\2\u01a0\u01a2\3\2\2\2\u01a1"+
		"\u019e\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2%\3\2\2\2\u01a3\u01aa\7.\2\2\u01a4"+
		"\u01a5\5(\25\2\u01a5\u01a6\b\24\1\2\u01a6\u01ab\3\2\2\2\u01a7\u01a8\5"+
		"*\26\2\u01a8\u01a9\b\24\1\2\u01a9\u01ab\3\2\2\2\u01aa\u01a4\3\2\2\2\u01aa"+
		"\u01a7\3\2\2\2\u01ab\'\3\2\2\2\u01ac\u01ae\5\30\r\2\u01ad\u01af\7\3\2"+
		"\2\u01ae\u01ad\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1"+
		"\b\25\1\2\u01b1)\3\2\2\2\u01b2\u01b8\7\7\2\2\u01b3\u01b4\5\30\r\2\u01b4"+
		"\u01b6\b\26\1\2\u01b5\u01b7\7\3\2\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3"+
		"\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b3\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\7\b"+
		"\2\2\u01bd+\3\2\2\2\u01be\u01bf\7/\2\2\u01bf\u01c0\5\26\f\2\u01c0\u01c1"+
		"\7\13\2\2\u01c1\u01c2\5.\30\2\u01c2\u01c3\b\27\1\2\u01c3-\3\2\2\2\u01c4"+
		"\u01ca\7\7\2\2\u01c5\u01c6\5\30\r\2\u01c6\u01c8\b\30\1\2\u01c7\u01c9\7"+
		"\3\2\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01cb\3\2\2\2\u01ca"+
		"\u01c5\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2"+
		"\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\7\b\2\2\u01cf/\3\2\2\2\u01d0\u01d1"+
		"\7\60\2\2\u01d1\u01d2\7\13\2\2\u01d2\u01d3\5.\30\2\u01d3\u01d4\7/\2\2"+
		"\u01d4\u01d6\5\26\f\2\u01d5\u01d7\7\3\2\2\u01d6\u01d5\3\2\2\2\u01d6\u01d7"+
		"\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\b\31\1\2\u01d9\61\3\2\2\2\u01da"+
		"\u01db\7\61\2\2\u01db\u01dd\5\26\f\2\u01dc\u01de\7\3\2\2\u01dd\u01dc\3"+
		"\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\b\32\1\2\u01e0"+
		"\63\3\2\2\2\u01e1\u01e2\7\21\2\2\u01e2\u01e3\5\4\3\2\u01e3\u01e4\7\22"+
		"\2\2\u01e4\u01e6\5\26\f\2\u01e5\u01e7\7\3\2\2\u01e6\u01e5\3\2\2\2\u01e6"+
		"\u01e7\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\b\33\1\2\u01e9\65\3\2\2"+
		"\2\u01ea\u01eb\7\67\2\2\u01eb\u01ed\58\35\2\u01ec\u01ee\7\3\2\2\u01ed"+
		"\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\b\34"+
		"\1\2\u01f0\67\3\2\2\2\u01f1\u01f2\7\21\2\2\u01f2\u0202\7\22\2\2\u01f3"+
		"\u01f4\7\21\2\2\u01f4\u01f5\5\26\f\2\u01f5\u01fc\b\35\1\2\u01f6\u01f7"+
		"\7\r\2\2\u01f7\u01f8\5\26\f\2\u01f8\u01f9\b\35\1\2\u01f9\u01fb\3\2\2\2"+
		"\u01fa\u01f6\3\2\2\2\u01fb\u01fe\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd"+
		"\3\2\2\2\u01fd\u01ff\3\2\2\2\u01fe\u01fc\3\2\2\2\u01ff\u0200\7\22\2\2"+
		"\u0200\u0202\3\2\2\2\u0201\u01f1\3\2\2\2\u0201\u01f3\3\2\2\2\u02029\3"+
		"\2\2\2\u0203\u0204\7\3\2\2\u0204;\3\2\2\2\u0205\u0206\7\67\2\2\u0206\u0208"+
		"\b\37\1\2\u0207\u0209\7\3\2\2\u0208\u0207\3\2\2\2\u0208\u0209\3\2\2\2"+
		"\u0209=\3\2\2\2+GIfy\u0088\u0091\u009d\u00a9\u00c7\u00cc\u00d1\u00d5\u00db"+
		"\u00df\u00ff\u0127\u0129\u0147\u0151\u015e\u0162\u016d\u0171\u0177\u0184"+
		"\u0190\u019c\u01a1\u01aa\u01ae\u01b6\u01ba\u01c8\u01cc\u01d6\u01dd\u01e6"+
		"\u01ed\u01fc\u0201\u0208";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}