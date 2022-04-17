package net.rgsw.dna;

import java.util.ArrayList;

public class ChromosomeParser {
    public final String input;
    public final int chromosomeLine;
    private int index;
    private final StringBuilder codonBuilder = new StringBuilder();

    public ChromosomeParser( String input, int chromosomeLine ) {
        this.input = input.trim();
        this.chromosomeLine = chromosomeLine;
    }

    public String readCodon() {
        codonBuilder.setLength( 0 );
        int l = input.length();
        for( int i = index; i < l; i++ ) {
            char c = input.charAt( i );
            if( c == 'T' || c == 'C' || c == 'G' || c == 'A' ) {
                codonBuilder.append( c );
            } else if( c != ' ' ) {
                error( "Invalid character!", i );
            }
            if( codonBuilder.length() == 3 ) {
                index = i + 1;
                return codonBuilder.toString();
            }
        }
        if( codonBuilder.length() != 3 ) {
            index = input.length();
            error( "Not enough input!" );
        }
        return "";
    }

    private static int getBits( char base ) {
        switch( base ) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return 0;
    }

    public int readNumber() {
        int number = 0;
        String codon = readCodon();
        while( true ) {
            number <<= 2;
            number |= getBits( codon.charAt( 0 ) );
            number <<= 2;
            number |= getBits( codon.charAt( 1 ) );
            char continuity = codon.charAt( 2 );
            if( continuity == 'C' || continuity == 'G' ) break;
            codon = readCodon();
        }
        return number;
    }

    public boolean canReadCodon() {
        int b = 0;
        int l = input.length();
        for( int i = index; i < l; i++ ) {
            char c = input.charAt( i );
            if( c == 'T' || c == 'C' || c == 'G' || c == 'A' ) {
                b++;
            } else if( c != ' ' ) {
                error( "Invalid character!", i );
            }
            if( b == 3 ) {
                return true;
            }
        }
        return false;
    }

    public Chromosome readChromosome() {
        ArrayList<Codon> codons = new ArrayList<>();
        while( canReadCodon() ) {
            Codon c = CodonMap.createCodon( readCodon() );
            c.readAdditional( this );
            codons.add( c );
        }
        throwRemainderException();
        return new Chromosome( codons.toArray( new Codon[ 0 ] ) );
    }

    public void throwRemainderException() {
        if( index - input.length() < 0 ) {
            error( "Remainder found!" );
        }
    }

    private void error( String msg ) {
        throw new DNASyntaxException( chromosomeLine, index, msg, input );
    }

    private void error( String msg, int i ) {
        throw new DNASyntaxException( chromosomeLine, i, msg, input );
    }
}
