package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class InNum extends Codon {
    public InNum( String codon ) {
        super( codon, "INNUM" );
    }

    @Override
    public void execute( Executor ctx ) {
        ctx.memory = ctx.in.nextInt();
    }
}
