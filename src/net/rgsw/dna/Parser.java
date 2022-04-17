package net.rgsw.dna;

public class Parser {
    public final String[] lines;

    public Parser( String fullCode ) {
        lines = fullCode.split( "[\\n\\r|]" );
    }

    public Parser( String... lines ) {
        this.lines = lines;
    }

    public Executor compile() {
        int count = 0;
        for( String s : lines ) {
            if( ! s.isEmpty() ) count++;
        }
        Chromosome[] chromosomes = new Chromosome[ count ];

        int i = 0;
        for( String s : lines ) {
            if( s.isEmpty() ) continue;
            ChromosomeParser parser = new ChromosomeParser( s, i );
            chromosomes[ i ] = parser.readChromosome();
            i++;
        }

        return new Executor( chromosomes );
    }
}
