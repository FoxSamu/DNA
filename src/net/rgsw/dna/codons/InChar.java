package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

import java.util.regex.Pattern;

public class InChar extends Codon {
    private static final Pattern ANY_CHAR = Pattern.compile( "[\\s\\S]" );

    public InChar( String codon ) {
        super( codon, "INCHAR" );
    }

    @Override
    public void execute( Executor ctx ) {
        ctx.memory = (int) ctx.in.next( ANY_CHAR ).charAt( 0 );
    }
}
