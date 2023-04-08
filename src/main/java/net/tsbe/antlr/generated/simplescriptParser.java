// Generated from C:/Users/thoma/Desktop/simple-script-language/language\simplescript.g4 by ANTLR 4.12.0
package net.tsbe.antlr.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class simplescriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, EOIC=35, ID=36, INT=37, WS=38;
	public static final int
		RULE_type = 0, RULE_boolean = 1, RULE_unary_operator = 2, RULE_binary_operator = 3, 
		RULE_increments_operator = 4, RULE_function_parameter = 5, RULE_function_declaration = 6, 
		RULE_expression = 7, RULE_instruction = 8, RULE_program = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"type", "boolean", "unary_operator", "binary_operator", "increments_operator", 
			"function_parameter", "function_declaration", "expression", "instruction", 
			"program"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bool'", "'int'", "'string'", "'true'", "'false'", "'!'", "'-'", 
			"'+'", "'/'", "'*'", "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'||'", 
			"'&&'", "'++'", "'--'", "':'", "'function'", "'('", "','", "')'", "'=>'", 
			"'return'", "'var'", "'='", "'if'", "'else'", "'while'", "'{'", "'}'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "EOIC", 
			"ID", "INT", "WS"
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

	@Override
	public String getGrammarFileName() { return "simplescript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public simplescriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ParserRuleContext {
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean_() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_operatorContext extends ParserRuleContext {
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Binary_operatorContext extends ParserRuleContext {
		public Binary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterBinary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitBinary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitBinary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_operatorContext binary_operator() throws RecognitionException {
		Binary_operatorContext _localctx = new Binary_operatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_binary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 524160L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Increments_operatorContext extends ParserRuleContext {
		public Increments_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_increments_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterIncrements_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitIncrements_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitIncrements_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Increments_operatorContext increments_operator() throws RecognitionException {
		Increments_operatorContext _localctx = new Increments_operatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_increments_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_parameterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Function_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterFunction_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitFunction_parameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitFunction_parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_parameterContext function_parameter() throws RecognitionException {
		Function_parameterContext _localctx = new Function_parameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(ID);
			setState(31);
			match(T__20);
			setState(32);
			type();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_declarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<Function_parameterContext> function_parameter() {
			return getRuleContexts(Function_parameterContext.class);
		}
		public Function_parameterContext function_parameter(int i) {
			return getRuleContext(Function_parameterContext.class,i);
		}
		public Function_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterFunction_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitFunction_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitFunction_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declarationContext function_declaration() throws RecognitionException {
		Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__21);
			setState(35);
			match(ID);
			setState(36);
			match(T__22);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(37);
				function_parameter();
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(38);
					match(T__23);
					setState(39);
					function_parameter();
					}
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(47);
			match(T__24);
			setState(48);
			match(T__20);
			setState(49);
			type();
			setState(50);
			match(T__25);
			setState(51);
			instruction();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionIdentifierContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public ExpressionIdentifierContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterExpressionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitExpressionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitExpressionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionBooleanContext extends ExpressionContext {
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public ExpressionBooleanContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterExpressionBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitExpressionBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitExpressionBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionUnaryContext extends ExpressionContext {
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionUnaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterExpressionUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitExpressionUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitExpressionUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionFunctionCallContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionFunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterExpressionFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitExpressionFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitExpressionFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionBinaryContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Binary_operatorContext binary_operator() {
			return getRuleContext(Binary_operatorContext.class,0);
		}
		public ExpressionBinaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterExpressionBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitExpressionBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitExpressionBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionIntContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(simplescriptParser.INT, 0); }
		public ExpressionIntContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterExpressionInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitExpressionInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitExpressionInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionEmbeddedContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionEmbeddedContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterExpressionEmbedded(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitExpressionEmbedded(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitExpressionEmbedded(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new ExpressionIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(54);
				match(INT);
				}
				break;
			case 2:
				{
				_localctx = new ExpressionBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				boolean_();
				}
				break;
			case 3:
				{
				_localctx = new ExpressionUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				unary_operator();
				setState(57);
				expression(4);
				}
				break;
			case 4:
				{
				_localctx = new ExpressionEmbeddedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				match(T__22);
				setState(60);
				expression(0);
				setState(61);
				match(T__24);
				}
				break;
			case 5:
				{
				_localctx = new ExpressionFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				match(ID);
				setState(64);
				match(T__22);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 206166819312L) != 0)) {
					{
					setState(65);
					expression(0);
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__23) {
						{
						{
						setState(66);
						match(T__23);
						setState(67);
						expression(0);
						}
						}
						setState(72);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(75);
				match(T__24);
				}
				break;
			case 6:
				{
				_localctx = new ExpressionIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionBinaryContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(79);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(80);
					binary_operator();
					setState(81);
					expression(6);
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionBlockContext extends InstructionContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public InstructionBlockContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionReturnContext extends InstructionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOIC() { return getToken(simplescriptParser.EOIC, 0); }
		public InstructionReturnContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionVariableDeclarationContext extends InstructionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EOIC() { return getToken(simplescriptParser.EOIC, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstructionVariableDeclarationContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionIncrementationContext extends InstructionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public Increments_operatorContext increments_operator() {
			return getRuleContext(Increments_operatorContext.class,0);
		}
		public TerminalNode EOIC() { return getToken(simplescriptParser.EOIC, 0); }
		public InstructionIncrementationContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionIncrementation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionIncrementation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionIncrementation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionWhileContext extends InstructionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public InstructionWhileContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionVariableAssignContext extends InstructionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOIC() { return getToken(simplescriptParser.EOIC, 0); }
		public InstructionVariableAssignContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionVariableAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionVariableAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionVariableAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionIfContext extends InstructionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public InstructionIfContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instruction);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new InstructionReturnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(T__26);
				setState(89);
				expression(0);
				setState(90);
				match(EOIC);
				}
				break;
			case 2:
				_localctx = new InstructionVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__27);
				setState(93);
				match(ID);
				setState(94);
				match(T__20);
				setState(95);
				type();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__28) {
					{
					setState(96);
					match(T__28);
					setState(97);
					expression(0);
					}
				}

				setState(100);
				match(EOIC);
				}
				break;
			case 3:
				_localctx = new InstructionVariableAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(ID);
				setState(103);
				match(T__28);
				setState(104);
				expression(0);
				setState(105);
				match(EOIC);
				}
				break;
			case 4:
				_localctx = new InstructionIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				match(T__29);
				setState(108);
				match(T__22);
				setState(109);
				expression(0);
				setState(110);
				match(T__24);
				setState(111);
				match(T__25);
				setState(112);
				instruction();
				setState(116);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(113);
					match(T__30);
					setState(114);
					match(T__25);
					setState(115);
					instruction();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new InstructionWhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
				match(T__31);
				setState(119);
				match(T__22);
				setState(120);
				expression(0);
				setState(121);
				match(T__24);
				setState(122);
				match(T__25);
				setState(123);
				instruction();
				}
				break;
			case 6:
				_localctx = new InstructionBlockContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(125);
				match(T__32);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 83080773632L) != 0)) {
					{
					{
					setState(126);
					instruction();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(132);
				match(T__33);
				}
				break;
			case 7:
				_localctx = new InstructionIncrementationContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(133);
				match(ID);
				setState(134);
				increments_operator();
				setState(135);
				match(EOIC);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<Function_declarationContext> function_declaration() {
			return getRuleContexts(Function_declarationContext.class);
		}
		public Function_declarationContext function_declaration(int i) {
			return getRuleContext(Function_declarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 83084967936L) != 0)) {
				{
				setState(141);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__26:
				case T__27:
				case T__29:
				case T__31:
				case T__32:
				case ID:
					{
					setState(139);
					instruction();
					}
					break;
				case T__21:
					{
					setState(140);
					function_declaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(145);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u0093\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006)\b\u0006"+
		"\n\u0006\f\u0006,\t\u0006\u0003\u0006.\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007E\b\u0007\n\u0007\f\u0007H\t\u0007\u0003\u0007"+
		"J\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007N\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007T\b\u0007\n\u0007\f\u0007W\t"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\bc\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bu\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0080\b\b\n\b\f\b\u0083\t\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u008a\b\b\u0001\t\u0001"+
		"\t\u0005\t\u008e\b\t\n\t\f\t\u0091\t\t\u0001\t\u0000\u0001\u000e\n\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0005\u0001\u0000\u0001"+
		"\u0003\u0001\u0000\u0004\u0005\u0001\u0000\u0006\b\u0001\u0000\u0007\u0012"+
		"\u0001\u0000\u0013\u0014\u009d\u0000\u0014\u0001\u0000\u0000\u0000\u0002"+
		"\u0016\u0001\u0000\u0000\u0000\u0004\u0018\u0001\u0000\u0000\u0000\u0006"+
		"\u001a\u0001\u0000\u0000\u0000\b\u001c\u0001\u0000\u0000\u0000\n\u001e"+
		"\u0001\u0000\u0000\u0000\f\"\u0001\u0000\u0000\u0000\u000eM\u0001\u0000"+
		"\u0000\u0000\u0010\u0089\u0001\u0000\u0000\u0000\u0012\u008f\u0001\u0000"+
		"\u0000\u0000\u0014\u0015\u0007\u0000\u0000\u0000\u0015\u0001\u0001\u0000"+
		"\u0000\u0000\u0016\u0017\u0007\u0001\u0000\u0000\u0017\u0003\u0001\u0000"+
		"\u0000\u0000\u0018\u0019\u0007\u0002\u0000\u0000\u0019\u0005\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0007\u0003\u0000\u0000\u001b\u0007\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0007\u0004\u0000\u0000\u001d\t\u0001\u0000\u0000"+
		"\u0000\u001e\u001f\u0005$\u0000\u0000\u001f \u0005\u0015\u0000\u0000 "+
		"!\u0003\u0000\u0000\u0000!\u000b\u0001\u0000\u0000\u0000\"#\u0005\u0016"+
		"\u0000\u0000#$\u0005$\u0000\u0000$-\u0005\u0017\u0000\u0000%*\u0003\n"+
		"\u0005\u0000&\'\u0005\u0018\u0000\u0000\')\u0003\n\u0005\u0000(&\u0001"+
		"\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000-%\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0001\u0000"+
		"\u0000\u0000/0\u0005\u0019\u0000\u000001\u0005\u0015\u0000\u000012\u0003"+
		"\u0000\u0000\u000023\u0005\u001a\u0000\u000034\u0003\u0010\b\u00004\r"+
		"\u0001\u0000\u0000\u000056\u0006\u0007\uffff\uffff\u00006N\u0005%\u0000"+
		"\u00007N\u0003\u0002\u0001\u000089\u0003\u0004\u0002\u00009:\u0003\u000e"+
		"\u0007\u0004:N\u0001\u0000\u0000\u0000;<\u0005\u0017\u0000\u0000<=\u0003"+
		"\u000e\u0007\u0000=>\u0005\u0019\u0000\u0000>N\u0001\u0000\u0000\u0000"+
		"?@\u0005$\u0000\u0000@I\u0005\u0017\u0000\u0000AF\u0003\u000e\u0007\u0000"+
		"BC\u0005\u0018\u0000\u0000CE\u0003\u000e\u0007\u0000DB\u0001\u0000\u0000"+
		"\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000"+
		"\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IA\u0001"+
		"\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000"+
		"KN\u0005\u0019\u0000\u0000LN\u0005$\u0000\u0000M5\u0001\u0000\u0000\u0000"+
		"M7\u0001\u0000\u0000\u0000M8\u0001\u0000\u0000\u0000M;\u0001\u0000\u0000"+
		"\u0000M?\u0001\u0000\u0000\u0000ML\u0001\u0000\u0000\u0000NU\u0001\u0000"+
		"\u0000\u0000OP\n\u0005\u0000\u0000PQ\u0003\u0006\u0003\u0000QR\u0003\u000e"+
		"\u0007\u0006RT\u0001\u0000\u0000\u0000SO\u0001\u0000\u0000\u0000TW\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"V\u000f\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0005\u001b"+
		"\u0000\u0000YZ\u0003\u000e\u0007\u0000Z[\u0005#\u0000\u0000[\u008a\u0001"+
		"\u0000\u0000\u0000\\]\u0005\u001c\u0000\u0000]^\u0005$\u0000\u0000^_\u0005"+
		"\u0015\u0000\u0000_b\u0003\u0000\u0000\u0000`a\u0005\u001d\u0000\u0000"+
		"ac\u0003\u000e\u0007\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000cd\u0001\u0000\u0000\u0000de\u0005#\u0000\u0000e\u008a\u0001\u0000"+
		"\u0000\u0000fg\u0005$\u0000\u0000gh\u0005\u001d\u0000\u0000hi\u0003\u000e"+
		"\u0007\u0000ij\u0005#\u0000\u0000j\u008a\u0001\u0000\u0000\u0000kl\u0005"+
		"\u001e\u0000\u0000lm\u0005\u0017\u0000\u0000mn\u0003\u000e\u0007\u0000"+
		"no\u0005\u0019\u0000\u0000op\u0005\u001a\u0000\u0000pt\u0003\u0010\b\u0000"+
		"qr\u0005\u001f\u0000\u0000rs\u0005\u001a\u0000\u0000su\u0003\u0010\b\u0000"+
		"tq\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u\u008a\u0001\u0000"+
		"\u0000\u0000vw\u0005 \u0000\u0000wx\u0005\u0017\u0000\u0000xy\u0003\u000e"+
		"\u0007\u0000yz\u0005\u0019\u0000\u0000z{\u0005\u001a\u0000\u0000{|\u0003"+
		"\u0010\b\u0000|\u008a\u0001\u0000\u0000\u0000}\u0081\u0005!\u0000\u0000"+
		"~\u0080\u0003\u0010\b\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083"+
		"\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0084\u008a\u0005\"\u0000\u0000\u0085\u0086\u0005"+
		"$\u0000\u0000\u0086\u0087\u0003\b\u0004\u0000\u0087\u0088\u0005#\u0000"+
		"\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089X\u0001\u0000\u0000\u0000"+
		"\u0089\\\u0001\u0000\u0000\u0000\u0089f\u0001\u0000\u0000\u0000\u0089"+
		"k\u0001\u0000\u0000\u0000\u0089v\u0001\u0000\u0000\u0000\u0089}\u0001"+
		"\u0000\u0000\u0000\u0089\u0085\u0001\u0000\u0000\u0000\u008a\u0011\u0001"+
		"\u0000\u0000\u0000\u008b\u008e\u0003\u0010\b\u0000\u008c\u008e\u0003\f"+
		"\u0006\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000"+
		"\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0013\u0001\u0000"+
		"\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\f*-FIMUbt\u0081\u0089"+
		"\u008d\u008f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}