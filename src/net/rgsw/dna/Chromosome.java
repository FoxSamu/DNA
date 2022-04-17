package net.rgsw.dna;

public class Chromosome {
    public final Codon[] codons;

    public Chromosome( Codon[] codons ) {
        this.codons = codons;
    }

    @Override
    public String toString() {
        String[] strings = new String[ codons.length ];
        for( int i = 0; i < strings.length; i++ ) {
            strings[ i ] = codons[ i ].toString();
        }
        return String.join( " ", strings );
    }
}
