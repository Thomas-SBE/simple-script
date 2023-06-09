package net.tsbe;

import net.tsbe.antlr.generated.simplescriptLexer;
import net.tsbe.antlr.generated.simplescriptParser;
import net.tsbe.generators.Mips32Generator;
import net.tsbe.middle.lang.Label;
import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.Frame;
import net.tsbe.middle.models.Pair;
import net.tsbe.middle.visitors.Translate;
import net.tsbe.models.nodes.Program;
import net.tsbe.models.typechecking.SymbolTable;
import net.tsbe.models.typechecking.SymbolTableBuilder;
import net.tsbe.models.typechecking.TypeChecker;
import net.tsbe.models.visitors.ForLoopsOptimizerVisitor;
import net.tsbe.models.visitors.IncrementationExpressionOptimizerVisitor;
import net.tsbe.models.visitors.SyntaxHighlightingVisitor;
import net.tsbe.utils.ASTGeneratorVisitor;
import net.tsbe.utils.CompilatorDisplayer;
import net.tsbe.utils.SimpleScriptParserErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class App
{
    public static void main( String[] args ) {

        // =======================================
        //            ARGUMENTS CHECKING
        // =======================================
        String outputFilepath = null;
        String inputFilepath = null;

        boolean showSyntaxHighlightBeforeOpt = false;
        boolean showSyntaxHighlightAfterOpt = false;
        boolean withDetails = false;

        for(int carg = 0; carg < args.length; carg++){
            if(!args[carg].startsWith("-")){
                CompilatorDisplayer.showErrorInvalidArguments();
            }
            String flag = args[carg];
            if(flag.equals("-i") || flag.equals("-input")){
                if(carg + 1 >= args.length){
                    CompilatorDisplayer.showErrorInvalidArgumentFormat("missing input filepath: -i <filepath>");
                    return;
                }
                inputFilepath = args[carg+1];
                carg++;
            }else if(flag.equals("-o") || flag.equals("-output")){
                if(carg + 1 >= args.length){
                    CompilatorDisplayer.showErrorInvalidArgumentFormat("missing input filepath: -i <filepath>");
                    return;
                }
                outputFilepath = args[carg+1];
                carg++;
            }else if(flag.startsWith("-f")){
                showSyntaxHighlightBeforeOpt = flag.contains("h");
                showSyntaxHighlightAfterOpt = flag.contains("H");
                withDetails = flag.contains("v");
            }
        }

        if(inputFilepath == null){
            CompilatorDisplayer.showErrorMissingArguments();
            System.exit(1);
        }

        CompilatorDisplayer.setFlagShowDetails(withDetails);

        // File management
        File source = new File(inputFilepath);
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
            if(simpleScriptParserErrorListener.syntaxErrorAmount > 0){
                throw new Exception("SYNTAX_ERRORS_FOUND");
            }
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

        // ==============================================================================
        //            SYNTAX HIGHLIGHT BEFORE OPTIMIZATION AND TYPE CHECK
        // ==============================================================================

        if(showSyntaxHighlightBeforeOpt){
            CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Generation of Syntax Highlighting & Prettyfier...", true, false);
            CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " SYNTAX HIGHLIGHT", "Generated the syntax highlighted code ↓", false, true);

            SyntaxHighlightingVisitor syntaxHighlightingVisitor = new SyntaxHighlightingVisitor();
            program.accept(syntaxHighlightingVisitor);
            CompilatorDisplayer.showBlockContent("SYNTAX HIGHLIGHTED BEFORE OPT.", syntaxHighlightingVisitor.fetch(), false);
        }

        // =======================================
        //            AST OPTIMIZER
        // =======================================

        CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Generating Optimized Abstract Syntax Tree of script file...", false, false);

        ForLoopsOptimizerVisitor optimizer = new ForLoopsOptimizerVisitor();
        program.accept(optimizer);

        IncrementationExpressionOptimizerVisitor optimizer2 = new IncrementationExpressionOptimizerVisitor();
        program.accept(optimizer2);

        CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " AST OPTIMIZATION", "Successfully generated the optimized AST !", false, true);

        // =======================================
        //            TYPE CHECKING
        // =======================================

        CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Checking script types...", true, false);
        SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder();
        program.accept(symbolTableBuilder);
        symbolTableBuilder.check();

        SymbolTable symbolTable = symbolTableBuilder.getSymbolTable();
        TypeChecker typeChecker = new TypeChecker(symbolTable);
        program.accept(typeChecker);
        typeChecker.check();

        CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " TYPE CHECKING", "Found " + CompilatorDisplayer.COLOR_VALID + "0" + CompilatorDisplayer.COLOR_RESET + " errors during type checking and symbol table creation process.", false, true);

        // ==============================================================================
        //            SYNTAX HIGHLIGHT AFTER OPTIMIZATION AND TYPE CHECK
        // ==============================================================================

        if(showSyntaxHighlightAfterOpt){
            CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Generation of Syntax Highlighting & Prettyfier...", true, false);
            CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " SYNTAX HIGHLIGHT", "Generated the syntax highlighted code ↓", false, true);

            SyntaxHighlightingVisitor syntaxHighlightingVisitor2 = new SyntaxHighlightingVisitor();
            program.accept(syntaxHighlightingVisitor2);
            CompilatorDisplayer.showBlockContent("SYNTAX HIGHLIGHTED AFTER OPT. AND TYPEC.", syntaxHighlightingVisitor2.fetch(), !withDetails);
        }

        // =======================================
        //            REPRES. INTERM.
        // =======================================

        CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Generation of the intermediate representation...", true, false);

        Pair<Label, List<Pair<Frame, List<Command>>>> ir = Translate.run(symbolTable, program);

        CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " IR", "Generated the intermediate representation code.", false, true);
        CompilatorDisplayer.showGenericInformationMessage(CompilatorDisplayer.INFO_ICON, "Conversion to MIPS32 assembly format...", true, false);

        Mips32Generator gen = new Mips32Generator();
        List<String> code = gen.generate(ir);

        CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " MIPS32", "Generated the MIPS32 assembly code.", false, true);


        if(outputFilepath != null){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilepath, false));
                writer.append(String.join("\n", code));
                writer.close();
                CompilatorDisplayer.showGenericValidMessage(CompilatorDisplayer.VALID_CHECK_ICON + " OUPUT", "Generated the output file as: " + outputFilepath, true, true);
            }catch (IOException e){
                CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON + " OUTPUT ERROR", "Could not write to file...\n" + e.toString(), true, true);
                System.exit(1);
                return;
            }
        }else{
            CompilatorDisplayer.showFinal("", false);
            System.out.println(String.join("\n", code));
        }

    }
}
