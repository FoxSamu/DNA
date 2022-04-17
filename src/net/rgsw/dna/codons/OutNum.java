package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class OutNum extends Codon {
    public OutNum( String codon ) {
        super( codon, "OUTNUM" );
    }

    @Override
    public void execute( Executor ctx ) {
        System.out.print( ctx.memory );
    }
}
