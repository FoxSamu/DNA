package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.DNAExecutionException;
import net.rgsw.dna.Executor;

public class Sleep extends Codon {
    public Sleep( String codon ) {
        super( codon, "SLEEP" );
    }

    @Override
    public void execute( Executor ctx ) {
        try {
            Thread.sleep( ctx.memory );
        } catch( InterruptedException e ) {
            throw new DNAExecutionException( ctx, "Interrupted!" );
        }
    }
}
