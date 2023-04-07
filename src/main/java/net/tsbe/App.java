package net.tsbe;

import net.tsbe.antlr.generated.simplescriptLexer;
import net.tsbe.antlr.generated.simplescriptParser;
import net.tsbe.models.nodes.Program;
import net.tsbe.models.typechecking.SymbolTable;
import net.tsbe.models.typechecking.SymbolTableBuilder;
import net.tsbe.models.typechecking.TypeChecker;
import net.tsbe.models.visitors.SyntaxHighlightingVisitor;
import net.tsbe.utils.ASTGeneratorVisitor;
import net.tsbe.utils.CompilatorDisplayer;
import net.tsbe.utils.SimpleScriptParserErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class App
{
    public static void main( String[] args ) {
        if (args.length < 1) {
            CompilatorDisplayer.showErrorMissingArguments();
            System.exit(1);
        }

        // File management
        File source = new File(args[0]);
        CompilatorDisplayer.showInitialization(source.getName());
        String content = "";
        try {
            CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Reading file content...", true, false);
            content = Files.readString(Path.of(source.getAbsolutePath()));
        } catch (IOException e) {
            CompilatorDisplayer.showFileDoesNotExist(source.getName());
            System.exit(2);
        }

        CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " FILE READING", "Finished reading the content of " + source.getName() + " !", false, true);
        CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Generating Abstract Syntax Tree of script file...", false, false);

        Program program = null;

        SimpleScriptParserErrorListener simpleScriptParserErrorListener = null;
        try {
            simplescriptLexer lexer = new simplescriptLexer(CharStreams.fromString(content));
            simplescriptParser parser = new simplescriptParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            simpleScriptParserErrorListener = new SimpleScriptParserErrorListener();
            parser.addErrorListener(simpleScriptParserErrorListener);
            program = (Program) parser.program().accept(new ASTGeneratorVisitor());
        } catch (Exception e) {
            if (simpleScriptParserErrorListener != null && simpleScriptParserErrorListener.syntaxErrorAmount > 0) {
                CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON + " AST GENERATION", "Could not continue compiler process with " + CompilatorDisplayer.COLOR_ERROR + simpleScriptParserErrorListener.syntaxErrorAmount + " syntax errors" + CompilatorDisplayer.COLOR_RESET + " !", true, true);
                System.exit(4);
            }
            CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON + " AST GENERATION", "An unexpected error occured during generation of the script's AST :", false, true);
            CompilatorDisplayer.showExceptionStack(e);
            CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON + " COMPILER", "The last error caused the compiler to stop !", true, true);
            System.exit(3);
        }

        CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " AST GENERATION", "Successfully generated the script's program AST !", false, true);

        // =======================================
        //            TYPE CHECKING
        // =======================================

        CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Checking script types...", true, false);
        SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder();
        program.accept(symbolTableBuilder);

        SymbolTable symbolTable = symbolTableBuilder.getSymbolTable();
        TypeChecker typeChecker = new TypeChecker(symbolTable);
        program.accept(typeChecker);
        typeChecker.check();

        CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " TYPE CHECKING", "Found " + CompilatorDisplayer.COLOR_VALID + "0" + CompilatorDisplayer.COLOR_RESET + " errors during type checking and symbol table creation process.", false, true);

        // =======================================
        //            SYNTAX HIGHLIGHT
        // =======================================

        CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Generation of Syntax Highlighting & Prettyfier...", true, false);
        CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " SYNTAX HIGHLIGHT", "Generated the syntax highlighted code ↓", false, true);

        SyntaxHighlightingVisitor syntaxHighlightingVisitor = new SyntaxHighlightingVisitor();
        program.accept(syntaxHighlightingVisitor);
        CompilatorDisplayer.showBlockContent("SYNTAX HIGHLIGHTED", syntaxHighlightingVisitor.fetch(), true);

        // =======================================
        //            REPRES. INTERM.
        // =======================================

        CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Generation of the intermediate representation...", true, false);



        CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " IR", "Generated the intermediate representation code ↓", false, true);
    }
}
