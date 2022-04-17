package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Discard extends Codon {
    public Discard( String codon ) {
        super( codon, "DISCARD" );
    }

    @Override
    public void execute( Executor ctx ) {
        ctx.pop();
    }
}
