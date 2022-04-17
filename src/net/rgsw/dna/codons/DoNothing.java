package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class DoNothing extends Codon {
    public DoNothing( String codon ) {
        super( codon, "DONOTHING" );
    }

    @Override
    public void execute( Executor ctx ) {
    }
}
