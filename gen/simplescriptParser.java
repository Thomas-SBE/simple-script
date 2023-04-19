// Generated from C:/Users/thoma/Desktop/simple-script/language\simplescript.g4 by ANTLR 4.12.0
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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, EOIC=37, ID=38, INT=39, 
		WS=40;
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
			null, "'bool'", "'int'", "'true'", "'false'", "'!'", "'-'", "'+'", "'/'", 
			"'*'", "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'||'", "'&&'", 
			"'++'", "'--'", "':'", "'function'", "'('", "','", "')'", "'=>'", "'['", 
			"']'", "'return'", "'var'", "'='", "'if'", "'else'", "'while'", "'for'", 
			"'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "EOIC", "ID", "INT", "WS"
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
			if ( !(_la==T__0 || _la==T__1) ) {
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
			if ( !(_la==T__2 || _la==T__3) ) {
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 224L) != 0)) ) {
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 262080L) != 0)) ) {
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
			if ( !(_la==T__17 || _la==T__18) ) {
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
			match(T__19);
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
			match(T__20);
			setState(35);
			match(ID);
			setState(36);
			match(T__21);
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
				while (_la==T__22) {
					{
					{
					setState(38);
					match(T__22);
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
			match(T__23);
			setState(48);
			match(T__19);
			setState(49);
			type();
			setState(50);
			match(T__24);
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
	public static class ExpressionIdentifierArrayContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionIdentifierArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterExpressionIdentifierArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitExpressionIdentifierArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitExpressionIdentifierArray(this);
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
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionIncrementationContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public Increments_operatorContext increments_operator() {
			return getRuleContext(Increments_operatorContext.class,0);
		}
		public ExpressionIncrementationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterExpressionIncrementation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitExpressionIncrementation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitExpressionIncrementation(this);
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
			setState(84);
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
				expression(6);
				}
				break;
			case 4:
				{
				_localctx = new ExpressionEmbeddedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				match(T__21);
				setState(60);
				expression(0);
				setState(61);
				match(T__23);
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
				match(T__21);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 824637915384L) != 0)) {
					{
					setState(65);
					expression(0);
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__22) {
						{
						{
						setState(66);
						match(T__22);
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
				match(T__23);
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
			case 7:
				{
				_localctx = new ExpressionIdentifierArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(ID);
				setState(78);
				match(T__25);
				setState(79);
				expression(0);
				setState(80);
				match(T__26);
				}
				break;
			case 8:
				{
				_localctx = new ExpressionIncrementationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(ID);
				setState(83);
				increments_operator();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(92);
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
					setState(86);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(87);
					binary_operator();
					setState(88);
					expression(8);
					}
					} 
				}
				setState(94);
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
	public static class InstructionFunctionCallContext extends InstructionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InstructionFunctionCallContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionVariableArrayAssignContext extends InstructionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EOIC() { return getToken(simplescriptParser.EOIC, 0); }
		public InstructionVariableArrayAssignContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionVariableArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionVariableArrayAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionVariableArrayAssign(this);
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
	public static class InstructionForContext extends InstructionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> EOIC() { return getTokens(simplescriptParser.EOIC); }
		public TerminalNode EOIC(int i) {
			return getToken(simplescriptParser.EOIC, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public InstructionForContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionFor(this);
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
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionVariableArrayDeclarationContext extends InstructionContext {
		public TerminalNode ID() { return getToken(simplescriptParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT() { return getToken(simplescriptParser.INT, 0); }
		public TerminalNode EOIC() { return getToken(simplescriptParser.EOIC, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InstructionVariableArrayDeclarationContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).enterInstructionVariableArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simplescriptListener ) ((simplescriptListener)listener).exitInstructionVariableArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simplescriptVisitor ) return ((simplescriptVisitor<? extends T>)visitor).visitInstructionVariableArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instruction);
		int _la;
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new InstructionReturnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(T__27);
				setState(96);
				expression(0);
				setState(97);
				match(EOIC);
				}
				break;
			case 2:
				_localctx = new InstructionVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(T__28);
				setState(100);
				match(ID);
				setState(101);
				match(T__19);
				setState(102);
				type();
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(103);
					match(T__29);
					setState(104);
					expression(0);
					}
				}

				setState(107);
				match(EOIC);
				}
				break;
			case 3:
				_localctx = new InstructionVariableArrayDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(T__28);
				setState(110);
				match(ID);
				setState(111);
				match(T__19);
				setState(112);
				type();
				setState(113);
				match(T__25);
				setState(114);
				match(INT);
				setState(115);
				match(T__26);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(116);
					match(T__29);
					setState(117);
					match(T__25);
					setState(118);
					expression(0);
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__22) {
						{
						{
						setState(119);
						match(T__22);
						setState(120);
						expression(0);
						}
						}
						setState(125);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(126);
					match(T__26);
					}
				}

				setState(130);
				match(EOIC);
				}
				break;
			case 4:
				_localctx = new InstructionVariableAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(ID);
				setState(133);
				match(T__29);
				setState(134);
				expression(0);
				setState(135);
				match(EOIC);
				}
				break;
			case 5:
				_localctx = new InstructionVariableArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(137);
				match(ID);
				setState(138);
				match(T__25);
				setState(139);
				expression(0);
				setState(140);
				match(T__26);
				setState(141);
				match(T__29);
				setState(142);
				expression(0);
				setState(143);
				match(EOIC);
				}
				break;
			case 6:
				_localctx = new InstructionIfContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
				match(T__30);
				setState(146);
				match(T__21);
				setState(147);
				expression(0);
				setState(148);
				match(T__23);
				setState(149);
				match(T__24);
				setState(150);
				instruction();
				setState(154);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(151);
					match(T__31);
					setState(152);
					match(T__24);
					setState(153);
					instruction();
					}
					break;
				}
				}
				break;
			case 7:
				_localctx = new InstructionWhileContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(156);
				match(T__32);
				setState(157);
				match(T__21);
				setState(158);
				expression(0);
				setState(159);
				match(T__23);
				setState(160);
				match(T__24);
				setState(161);
				instruction();
				}
				break;
			case 8:
				_localctx = new InstructionForContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(163);
				match(T__33);
				setState(164);
				match(T__21);
				setState(165);
				match(T__28);
				setState(166);
				match(ID);
				setState(167);
				match(T__19);
				setState(168);
				type();
				setState(169);
				match(T__29);
				setState(170);
				expression(0);
				setState(171);
				match(EOIC);
				setState(172);
				expression(0);
				setState(173);
				match(EOIC);
				setState(174);
				instruction();
				setState(175);
				match(T__23);
				setState(176);
				match(T__24);
				setState(177);
				instruction();
				}
				break;
			case 9:
				_localctx = new InstructionBlockContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(179);
				match(T__34);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 337960239104L) != 0)) {
					{
					{
					setState(180);
					instruction();
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				match(T__35);
				}
				break;
			case 10:
				_localctx = new InstructionIncrementationContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(187);
				match(ID);
				setState(188);
				increments_operator();
				setState(189);
				match(EOIC);
				}
				break;
			case 11:
				_localctx = new InstructionFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(191);
				match(ID);
				setState(192);
				match(T__21);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 824637915384L) != 0)) {
					{
					setState(193);
					expression(0);
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__22) {
						{
						{
						setState(194);
						match(T__22);
						setState(195);
						expression(0);
						}
						}
						setState(200);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(203);
				match(T__23);
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
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 337962336256L) != 0)) {
				{
				setState(208);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__27:
				case T__28:
				case T__30:
				case T__32:
				case T__33:
				case T__34:
				case ID:
					{
					setState(206);
					instruction();
					}
					break;
				case T__20:
					{
					setState(207);
					function_declaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(212);
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
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u00d6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"J\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007U\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007[\b\u0007"+
		"\n\u0007\f\u0007^\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bj\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\bz\b\b\n\b\f\b}\t\b\u0001\b\u0001\b\u0003\b\u0081"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u009b\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00b6\b\b\n"+
		"\b\f\b\u00b9\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u00c5\b\b\n\b\f\b\u00c8\t\b\u0003\b"+
		"\u00ca\b\b\u0001\b\u0003\b\u00cd\b\b\u0001\t\u0001\t\u0005\t\u00d1\b\t"+
		"\n\t\f\t\u00d4\t\t\u0001\t\u0000\u0001\u000e\n\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0000\u0005\u0001\u0000\u0001\u0002\u0001\u0000"+
		"\u0003\u0004\u0001\u0000\u0005\u0007\u0001\u0000\u0006\u0011\u0001\u0000"+
		"\u0012\u0013\u00ea\u0000\u0014\u0001\u0000\u0000\u0000\u0002\u0016\u0001"+
		"\u0000\u0000\u0000\u0004\u0018\u0001\u0000\u0000\u0000\u0006\u001a\u0001"+
		"\u0000\u0000\u0000\b\u001c\u0001\u0000\u0000\u0000\n\u001e\u0001\u0000"+
		"\u0000\u0000\f\"\u0001\u0000\u0000\u0000\u000eT\u0001\u0000\u0000\u0000"+
		"\u0010\u00cc\u0001\u0000\u0000\u0000\u0012\u00d2\u0001\u0000\u0000\u0000"+
		"\u0014\u0015\u0007\u0000\u0000\u0000\u0015\u0001\u0001\u0000\u0000\u0000"+
		"\u0016\u0017\u0007\u0001\u0000\u0000\u0017\u0003\u0001\u0000\u0000\u0000"+
		"\u0018\u0019\u0007\u0002\u0000\u0000\u0019\u0005\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0007\u0003\u0000\u0000\u001b\u0007\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0007\u0004\u0000\u0000\u001d\t\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0005&\u0000\u0000\u001f \u0005\u0014\u0000\u0000 !\u0003\u0000"+
		"\u0000\u0000!\u000b\u0001\u0000\u0000\u0000\"#\u0005\u0015\u0000\u0000"+
		"#$\u0005&\u0000\u0000$-\u0005\u0016\u0000\u0000%*\u0003\n\u0005\u0000"+
		"&\'\u0005\u0017\u0000\u0000\')\u0003\n\u0005\u0000(&\u0001\u0000\u0000"+
		"\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-%\u0001"+
		"\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/0\u0005\u0018\u0000\u000001\u0005\u0014\u0000\u000012\u0003\u0000\u0000"+
		"\u000023\u0005\u0019\u0000\u000034\u0003\u0010\b\u00004\r\u0001\u0000"+
		"\u0000\u000056\u0006\u0007\uffff\uffff\u00006U\u0005\'\u0000\u00007U\u0003"+
		"\u0002\u0001\u000089\u0003\u0004\u0002\u00009:\u0003\u000e\u0007\u0006"+
		":U\u0001\u0000\u0000\u0000;<\u0005\u0016\u0000\u0000<=\u0003\u000e\u0007"+
		"\u0000=>\u0005\u0018\u0000\u0000>U\u0001\u0000\u0000\u0000?@\u0005&\u0000"+
		"\u0000@I\u0005\u0016\u0000\u0000AF\u0003\u000e\u0007\u0000BC\u0005\u0017"+
		"\u0000\u0000CE\u0003\u000e\u0007\u0000DB\u0001\u0000\u0000\u0000EH\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IA\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KU\u0005\u0018"+
		"\u0000\u0000LU\u0005&\u0000\u0000MN\u0005&\u0000\u0000NO\u0005\u001a\u0000"+
		"\u0000OP\u0003\u000e\u0007\u0000PQ\u0005\u001b\u0000\u0000QU\u0001\u0000"+
		"\u0000\u0000RS\u0005&\u0000\u0000SU\u0003\b\u0004\u0000T5\u0001\u0000"+
		"\u0000\u0000T7\u0001\u0000\u0000\u0000T8\u0001\u0000\u0000\u0000T;\u0001"+
		"\u0000\u0000\u0000T?\u0001\u0000\u0000\u0000TL\u0001\u0000\u0000\u0000"+
		"TM\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000U\\\u0001\u0000\u0000"+
		"\u0000VW\n\u0007\u0000\u0000WX\u0003\u0006\u0003\u0000XY\u0003\u000e\u0007"+
		"\bY[\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]\u000f\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_`\u0005\u001c\u0000\u0000"+
		"`a\u0003\u000e\u0007\u0000ab\u0005%\u0000\u0000b\u00cd\u0001\u0000\u0000"+
		"\u0000cd\u0005\u001d\u0000\u0000de\u0005&\u0000\u0000ef\u0005\u0014\u0000"+
		"\u0000fi\u0003\u0000\u0000\u0000gh\u0005\u001e\u0000\u0000hj\u0003\u000e"+
		"\u0007\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000kl\u0005%\u0000\u0000l\u00cd\u0001\u0000\u0000\u0000"+
		"mn\u0005\u001d\u0000\u0000no\u0005&\u0000\u0000op\u0005\u0014\u0000\u0000"+
		"pq\u0003\u0000\u0000\u0000qr\u0005\u001a\u0000\u0000rs\u0005\'\u0000\u0000"+
		"s\u0080\u0005\u001b\u0000\u0000tu\u0005\u001e\u0000\u0000uv\u0005\u001a"+
		"\u0000\u0000v{\u0003\u000e\u0007\u0000wx\u0005\u0017\u0000\u0000xz\u0003"+
		"\u000e\u0007\u0000yw\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000"+
		"{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000"+
		"\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0005\u001b\u0000\u0000\u007f"+
		"\u0081\u0001\u0000\u0000\u0000\u0080t\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005%\u0000\u0000\u0083\u00cd\u0001\u0000\u0000\u0000\u0084\u0085\u0005"+
		"&\u0000\u0000\u0085\u0086\u0005\u001e\u0000\u0000\u0086\u0087\u0003\u000e"+
		"\u0007\u0000\u0087\u0088\u0005%\u0000\u0000\u0088\u00cd\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0005&\u0000\u0000\u008a\u008b\u0005\u001a\u0000\u0000"+
		"\u008b\u008c\u0003\u000e\u0007\u0000\u008c\u008d\u0005\u001b\u0000\u0000"+
		"\u008d\u008e\u0005\u001e\u0000\u0000\u008e\u008f\u0003\u000e\u0007\u0000"+
		"\u008f\u0090\u0005%\u0000\u0000\u0090\u00cd\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005\u001f\u0000\u0000\u0092\u0093\u0005\u0016\u0000\u0000\u0093"+
		"\u0094\u0003\u000e\u0007\u0000\u0094\u0095\u0005\u0018\u0000\u0000\u0095"+
		"\u0096\u0005\u0019\u0000\u0000\u0096\u009a\u0003\u0010\b\u0000\u0097\u0098"+
		"\u0005 \u0000\u0000\u0098\u0099\u0005\u0019\u0000\u0000\u0099\u009b\u0003"+
		"\u0010\b\u0000\u009a\u0097\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000"+
		"\u0000\u0000\u009b\u00cd\u0001\u0000\u0000\u0000\u009c\u009d\u0005!\u0000"+
		"\u0000\u009d\u009e\u0005\u0016\u0000\u0000\u009e\u009f\u0003\u000e\u0007"+
		"\u0000\u009f\u00a0\u0005\u0018\u0000\u0000\u00a0\u00a1\u0005\u0019\u0000"+
		"\u0000\u00a1\u00a2\u0003\u0010\b\u0000\u00a2\u00cd\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0005\"\u0000\u0000\u00a4\u00a5\u0005\u0016\u0000\u0000\u00a5"+
		"\u00a6\u0005\u001d\u0000\u0000\u00a6\u00a7\u0005&\u0000\u0000\u00a7\u00a8"+
		"\u0005\u0014\u0000\u0000\u00a8\u00a9\u0003\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0005\u001e\u0000\u0000\u00aa\u00ab\u0003\u000e\u0007\u0000\u00ab\u00ac"+
		"\u0005%\u0000\u0000\u00ac\u00ad\u0003\u000e\u0007\u0000\u00ad\u00ae\u0005"+
		"%\u0000\u0000\u00ae\u00af\u0003\u0010\b\u0000\u00af\u00b0\u0005\u0018"+
		"\u0000\u0000\u00b0\u00b1\u0005\u0019\u0000\u0000\u00b1\u00b2\u0003\u0010"+
		"\b\u0000\u00b2\u00cd\u0001\u0000\u0000\u0000\u00b3\u00b7\u0005#\u0000"+
		"\u0000\u00b4\u00b6\u0003\u0010\b\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00cd\u0005$\u0000\u0000\u00bb"+
		"\u00bc\u0005&\u0000\u0000\u00bc\u00bd\u0003\b\u0004\u0000\u00bd\u00be"+
		"\u0005%\u0000\u0000\u00be\u00cd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005"+
		"&\u0000\u0000\u00c0\u00c9\u0005\u0016\u0000\u0000\u00c1\u00c6\u0003\u000e"+
		"\u0007\u0000\u00c2\u00c3\u0005\u0017\u0000\u0000\u00c3\u00c5\u0003\u000e"+
		"\u0007\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c9\u00c1\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cd\u0005\u0018"+
		"\u0000\u0000\u00cc_\u0001\u0000\u0000\u0000\u00ccc\u0001\u0000\u0000\u0000"+
		"\u00ccm\u0001\u0000\u0000\u0000\u00cc\u0084\u0001\u0000\u0000\u0000\u00cc"+
		"\u0089\u0001\u0000\u0000\u0000\u00cc\u0091\u0001\u0000\u0000\u0000\u00cc"+
		"\u009c\u0001\u0000\u0000\u0000\u00cc\u00a3\u0001\u0000\u0000\u0000\u00cc"+
		"\u00b3\u0001\u0000\u0000\u0000\u00cc\u00bb\u0001\u0000\u0000\u0000\u00cc"+
		"\u00bf\u0001\u0000\u0000\u0000\u00cd\u0011\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d1\u0003\u0010\b\u0000\u00cf\u00d1\u0003\f\u0006\u0000\u00d0\u00ce"+
		"\u0001\u0000\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d3\u0013\u0001\u0000\u0000\u0000\u00d4\u00d2"+
		"\u0001\u0000\u0000\u0000\u0010*-FIT\\i{\u0080\u009a\u00b7\u00c6\u00c9"+
		"\u00cc\u00d0\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}