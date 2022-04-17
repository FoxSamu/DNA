package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Swap extends Codon {
    public Swap( String codon ) {
        super( codon, "SWAP" );
    }

    @Override
    public void execute( Executor ctx ) {
        int a = ctx.pop();
        int b = ctx.pop();
        ctx.push( a );
        ctx.push( b );
    }
}
