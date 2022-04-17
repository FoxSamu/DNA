package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Terminate extends Codon {
    public Terminate( String codon ) {
        super( codon, "TERMINATE" );
    }

    @Override
    public void execute( Executor ctx ) {
        ctx.terminated = true;
    }
}
