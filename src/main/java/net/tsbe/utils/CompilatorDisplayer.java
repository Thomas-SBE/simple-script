package net.tsbe.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompilatorDisplayer {

    public static String ERROR_CROSS_ICON = "⛌";
    public static String VALID_CHECK_ICON = "✓";
    public static String WARNING_ICON = "▲";
    public static String INFO_ICON = "\uD83D\uDEC8";

    public static String COLOR_ERROR = "\u001b[31;1m";
    public static String COLOR_VALID = "\u001b[32;1m";
    public static String COLOR_RESET = "\u001b[0m";

    private static boolean onSameline = false;
    private static int lastLineLength = 0;

    private static boolean showDetails = false;

    public static void setFlagShowDetails(boolean status) { showDetails = status; }

    public static void showInitialization(String sourceFileName){
        if(onSameline) clearCurrentLine();
        System.out.println("\u001b[1m┌\u001b[0m • Source : \u001b[4m" + sourceFileName + "\u001b[0m");
        onSameline = false;
    }

    public static void showFinal(String sourceFileName, boolean hasOutput){
        if(onSameline) clearCurrentLine();
        if(hasOutput) System.out.println("\u001b[1m└\u001b[0m • Output : \u001b[4m" + sourceFileName + "\u001b[0m");
        else System.out.println("\u001b[1m└\u001b[0m • Successfully generated code.\u001b[0m");
        onSameline = false;
    }

    public static void showErrorMissingArguments(){
        if(onSameline) clearCurrentLine();
        System.out.println("\u001b[31m⛌ Missing the source file as an argument, use -i <filepath> or -input <filepath> flag !\u001b[0m");
        onSameline = false;
    }

    public static void showErrorInvalidArguments(){
        if(onSameline) clearCurrentLine();
        System.out.println("\u001b[31m⛌ Invalid argument sequence, all arguments must start with the character \u001b[32m-\u001b[31m !\u001b[0m");
        onSameline = false;
    }

    public static void showErrorInvalidArgumentFormat(String format){
        if(onSameline) clearCurrentLine();
        System.out.println("\u001b[31m⛌ Invalid argument sequence, "+format+" !\u001b[0m");
        onSameline = false;
    }

    public static void showFileDoesNotExist(String file){
        if(onSameline) clearCurrentLine();
        System.out.println("\u001b[1m└\u001b[0m \u001b[31m⛌\u001b[0m - The file \u001b[4m" + file + "\u001b[0m does not exist or could not be opened !\u001b[0m");
        onSameline = false;
    }

    public static void showGenericValidMessage(String icon, String content, boolean isEnding, boolean returnToLine){
        if(!showDetails) return;
        if(onSameline) clearCurrentLine();
        System.out.print("\u001b[1m"+ (isEnding ? "└" : "├") +"\u001b[0m \u001b[32;1m"+icon+"\u001b[0m - " + content);
        lastLineLength = 5 + icon.length() + content.length();
        if(returnToLine) { System.out.println(); onSameline = false; }
        else onSameline = true;
    }

    public static void showGenericErrorMessage(String icon, String content, boolean isEnding, boolean returnToLine){
        if(onSameline) clearCurrentLine();
        System.out.print("\u001b[1m"+ (isEnding ? "└" : "├") +"\u001b[0m \u001b[31;1m"+icon+"\u001b[0m - " + content);
        lastLineLength = 5 + icon.length() + content.length();
        if(returnToLine) { System.out.println(); onSameline = false; }
        else onSameline = true;
    }

    public static void showGenericWarningMessage(String icon, String content, boolean isEnding, boolean returnToLine){
        if(!showDetails) return;
        if(onSameline) clearCurrentLine();
        System.out.print("\u001b[1m"+ (isEnding ? "└" : "├") +"\u001b[0m \u001b[33;1m"+icon+"\u001b[0m - " + content);
        lastLineLength = 5 + icon.length() + content.length();
        if(returnToLine) { System.out.println(); onSameline = false; }
        else onSameline = true;
    }

    public static void showGenericInformationMessage(String icon, String content, boolean isEnding, boolean returnToLine){
        if(!showDetails) return;
        if(onSameline) clearCurrentLine();
        System.out.print("\u001b[1m"+ (isEnding ? "└" : "├") +"\u001b[0m \u001b[36m"+icon+"\u001b[0m - " + content);
        lastLineLength = 5 + icon.length() + content.length();
        if(returnToLine) { System.out.println(); onSameline = false; }
        else onSameline = true;
    }

    private static void clearCurrentLine(){
        System.out.print("\r" + " ".repeat(lastLineLength) + "\r");
    }

    public static void showExceptionStack(Exception e){
        if(onSameline) clearCurrentLine();
        onSameline = false;
        System.out.println("│ \u001b[31m╔════► \u001b[0m");
        System.out.println("│ \u001b[31m║ \u001b[4mMessage :\u001b[0m");
        System.out.println("│ \u001b[31m║ "+ e.getMessage() +"\u001b[0m");
        System.out.println("│ \u001b[31m║ \u001b[4mStack trace :\u001b[0m");
        List<String> lines = Arrays.stream(e.getStackTrace()).map(c -> "│ \u001b[31m║ " + c.toString() + "\u001b[0m").collect(Collectors.toList());
        lines.forEach(System.out::println);
        System.out.println("│ \u001b[31m╚════► \u001b[0m");
    }

    public static void showBlockContent(String header, List<String> lines, boolean isEnding){
        if(onSameline) clearCurrentLine();
        onSameline = false;
        int sides = (75 - header.length())/2;
        System.out.println("├" + "─".repeat(sides) + " " + header + " " + "─".repeat(sides));
        lines.forEach(l -> System.out.println("│ " + l));
        System.out.println((isEnding ? "└" : "├") + "─".repeat(75 + 2));
    }

}
