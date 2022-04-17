package net.rgsw.dna;

public class DNAExecutionException extends RuntimeException {
    public final Executor executor;
    public final String problem;
    public final String chromosomeStr;
    public final int index;
    public final int chromosome;

    public DNAExecutionException( Executor executor, String problem ) {
        this.executor = executor;
        this.problem = problem;
        this.chromosomeStr = executor.chromosomes[ executor.lastChromosome ].toString();
        this.index = executor.lastIndex;
        this.chromosome = executor.lastChromosome;
    }

    @Override
    public String getMessage() {
        StringBuilder builder = new StringBuilder( "@" + chromosome + ':' + index + ": " + problem + "\n" );
        builder.append( chromosomeStr ).append( "\n" );
        for( int i = 0; i < index; i++ ) {
            builder.append( "    " );
        }
        builder.append( '^' );
        return builder.toString();
    }
}
