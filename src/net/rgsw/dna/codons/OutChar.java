package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class OutChar extends Codon {
    public OutChar( String codon ) {
        super( codon, "OUTCHAR" );
    }

    @Override
    public void execute( Executor ctx ) {
        System.out.print( (char) ctx.memory );
    }
}
