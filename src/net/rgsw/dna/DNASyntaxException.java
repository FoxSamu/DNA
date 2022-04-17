package net.rgsw.dna;

public class DNASyntaxException extends RuntimeException {
    public final int chromosome;
    public final int index;
    public final String problem;
    public final String chromosomeCode;

    public DNASyntaxException( int chromosome, int index, String problem, String chromosomeCode ) {
        this.chromosome = chromosome;
        this.index = index;
        this.problem = problem;
        this.chromosomeCode = chromosomeCode;
    }

    @Override
    public String getMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append( "@" ).append( chromosome ).append( ':' ).append( index ).append( ": " );
        builder.append( problem ).append( '\n' );
        builder.append( chromosomeCode ).append( '\n' );
        for( int i = 0; i < index; i ++ ) {
            builder.append( ' ' );
        }
        builder.append( '^' );
        return builder.toString();
    }
}
