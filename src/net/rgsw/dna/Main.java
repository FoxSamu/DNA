package net.rgsw.dna;

import java.util.Scanner;

public final class Main {
    private Main() {
    }

    private static int mode;

    public static void main( String[] args ) {
        if( args.length == 0 ) {
            mode = 0;
            infiniteInput();
        } else if( args.length == 1 ) {
            if( args[ 0 ].startsWith( "-" ) ) {
                switch( args[ 0 ] ) {
                    default: System.err.println( "Usage: " );
                    case "-t": mode = 1;
                        break;
                    case "-d": mode = 2;
                        break;
                    case "-g": mode = 3;
                        break;
                    case "-n": mode = 4;
                        break;
                }
                infiniteInput();
            } else {
                oneInput( args[ 0 ] );
            }
        } else if( args.length == 2 ) {
            if( args[ 0 ].startsWith( "-" ) ) {
                switch( args[ 0 ] ) {
                    default: System.err.println( "Usage: " );
                    case "-t": mode = 1;
                        break;
                    case "-d": mode = 2;
                        break;
                    case "-g": mode = 3;
                        break;
                    case "-n": mode = 4;
                        break;
                }
                oneInput( args[ 1 ] );
            } else {
                printUsage();
            }
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println( "Arguments: [-t|-d|-g|-n] [input]" );
    }

    private static void input( String input ) {
        if( mode == 0 ) {
            DNA.eval( input );
            return;
        }
        if( mode == 1 ) {
            long nano1 = System.nanoTime();
            DNA.eval( input );
            long nano2 = System.nanoTime();
            long time = nano2 - nano1;
            System.out.println( "Time: " + time / 1000000000D + " seconds" );
            return;
        }
        if( mode == 2 ) {
            System.out.println( DNA.deobfuscate( input ) );
        }
        if( mode == 3 ) {
            System.out.println( DNA.makePrintStringProgram( input ) );
        }
        if( mode == 4 ) {
            try {
                System.out.println( DNA.encodeNumber( Integer.valueOf( input ) ) );
            } catch( NumberFormatException exc ) {
                System.out.println( "Invalid number!" );
            }
        }
    }

    private static void infiniteInput() {
        Scanner scanner = new Scanner( System.in );
        while( true ) {
            System.out.print( "> " );
            String d = scanner.nextLine();
            if( d.isEmpty() ) break;
            try {
                input( d );
                System.out.println();
            } catch( DNASyntaxException | DNAExecutionException exc ) {
                System.out.println( exc.getMessage() );
            }
        }
    }

    private static void oneInput( String in ) {
        try {
            input( in );
            System.out.println();
        } catch( DNASyntaxException | DNAExecutionException exc ) {
            System.out.println( exc.getMessage() );
        }
    }
}
