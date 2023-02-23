package net.tsbe.utils;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;
import java.util.stream.Collectors;

public class SimpleScriptParserErrorListener implements ANTLRErrorListener {

    public int syntaxErrorAmount = 0;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
        CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON + " SYNTAX ERROR", "[line: \u001b[33m"+i+"\u001b[0m, offset: \u001b[33m"+i1+"\u001b[0m] - Encountered \u001b[33m" + e.getOffendingToken().getText() + "\u001b[0m but expected one of the following: " + e.getExpectedTokens().toList().stream().map(token -> "\u001b[35m" + recognizer.getVocabulary().getDisplayName(token).replace("'", "") + "\u001b[0m").collect(Collectors.joining(", ")), false, true);
        syntaxErrorAmount++;
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

    }
}
