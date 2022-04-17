package net.rgsw.dna;

public final class DNA {
    private static final String NUMBER_CHARS = "ACGT";

    private DNA() {
    }

    public static void eval( String dna ) {
        Parser p = new Parser( dna );
        p.compile().run();
    }

    public static void eval( String... dna ) {
        Parser p = new Parser( dna );
        p.compile().run();
    }

    public static String encodeNumber( int number ) {
        StringBuilder b = new StringBuilder();
        boolean start = true;
        do {
            b.append( start ? "C" : " T" );
            start = false;
            int n = number & 3;
            number >>>= 2;
            b.append( NUMBER_CHARS.charAt( n ) );
            n = number & 3;
            number >>>= 2;
            b.append( NUMBER_CHARS.charAt( n ) );
        } while( number > 0 );
        return b.reverse().toString();
    }

    public static String encodeNumberNoSpace( int number ) {
        StringBuilder b = new StringBuilder();
        boolean start = true;
        do {
            b.append( start ? "C" : "T" );
            start = false;
            int n = number & 3;
            number >>>= 2;
            b.append( NUMBER_CHARS.charAt( n ) );
            n = number & 3;
            number >>>= 2;
            b.append( NUMBER_CHARS.charAt( n ) );
        } while( number > 0 );
        return b.reverse().toString();
    }

    public static String makePrintStringProgram( String str ) {
        StringBuilder builder = new StringBuilder();
        for( char c : str.toCharArray() ) {
            builder.append( "ACT" ).append( encodeNumberNoSpace( c ) ).append( "CGT" );
        }
        return builder.toString();
    }

    public static String deobfuscate( String dna ) {
        String[] chromosomes = dna.split( "[\\n\\r|]" );
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for( String s : chromosomes ) {
            builder.append( "Chromosome " + i + ":\n" );
            ChromosomeParser parser = new ChromosomeParser( s, i );
            Chromosome crsm = parser.readChromosome();

            for( Codon codon : crsm.codons ) {
                builder.append( " - " ).append( codon.getMeaning() ).append( "\n" );
            }
            builder.append( '\n' );
            i++;
        }
        return builder.toString().trim();
    }
}
