package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Push extends Codon {
    public Push( String codon ) {
        super( codon, "PUSH" );
    }

    @Override
    public void execute( Executor ctx ) {
        ctx.push( ctx.memory );
    }
}
