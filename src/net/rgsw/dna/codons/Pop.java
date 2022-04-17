package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Pop extends Codon {
    public Pop( String codon ) {
        super( codon, "POP" );
    }

    @Override
    public void execute( Executor ctx ) {
        ctx.memory = ctx.pop();
    }
}
