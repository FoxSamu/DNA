package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Negate extends Codon {
    public Negate( String codon ) {
        super( codon, "NEGATE" );
    }

    @Override
    public void execute( Executor ctx ) {
        ctx.memory = - ctx.pop();
    }
}
