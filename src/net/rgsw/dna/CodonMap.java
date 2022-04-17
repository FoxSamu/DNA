package net.rgsw.dna;

import net.rgsw.dna.codons.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public final class CodonMap {
    private static final List<Function<String, Codon>> CODONS = Collections.unmodifiableList( makeList( new ArrayList<>( 64 ) ) );

    private CodonMap() {
    }

    public static Codon createCodon( String codon ) {
        int index = getBaseBits( codon.charAt( 0 ) );
        index <<= 2;
        index |= getBaseBits( codon.charAt( 1 ) );
        index <<= 2;
        index |= getBaseBits( codon.charAt( 2 ) );
        return CODONS.get( index ).apply( codon );
    }

    private static List<Function<String, Codon>> makeList( List<Function<String, Codon>> list ) {
        for( int i = 0; i < 64; i ++ ) {
            list.add( null );
        }

        put( list, "CGA", OutNum::new );
        put( list, "CGT", OutChar::new );
        put( list, "CGG", InNum::new );
        put( list, "CGC", InChar::new );

        put( list, "CTA", Push::new );
        put( list, "CTC", Pop::new );
        put( list, "CTT", Discard::new );
        put( list, "CTG", Negate::new );

        put( list, "CAT", Mathematical.Add::new );
        put( list, "CAA", Mathematical.Sub::new );
        put( list, "CAG", Mathematical.Mul::new );
        put( list, "CAC", Mathematical.Div::new );

        put( list, "CCA", Logical.Not::new );
        put( list, "CCT", Logical.And::new );
        put( list, "CCG", Logical.Or::new );
        put( list, "CCC", Logical.Xor::new );

        put( list, "GAA", Bitwise.Not::new );
        put( list, "GAG", Bitwise.And::new );
        put( list, "GAC", Bitwise.Or::new );
        put( list, "GAT", Bitwise.Xor::new );

        put( list, "GCT", Shift.Left::new );
        put( list, "GCA", Shift.Right::new );
        put( list, "GCC", Shift.RawRight::new );
        put( list, "GCG", DoNothing::new );

        put( list, "GTT", Flow.Conditional.IfZero::new );
        put( list, "GTA", Flow.Conditional.IfNZero::new );
        put( list, "GTG", Flow.Conditional.IfPositive::new );
        put( list, "GTC", Flow.Conditional.IfNegative::new );

        put( list, "GGG", Terminate::new );
        put( list, "GGT", DoNothing::new );
        put( list, "GGA", DoNothing::new );
        put( list, "GGC", DoNothing::new );

        put( list, "AAA", Mem.Incr::new );
        put( list, "AAC", Mem.Decr::new );
        put( list, "AAG", Mem.Add::new );
        put( list, "AAT", Mem.Sub::new );

        put( list, "ACT", Remember.Positive::new );
        put( list, "ACA", Remember.Negative::new );
        put( list, "ACG", DoNothing::new );
        put( list, "ACC", DoNothing::new );

        put( list, "AGC", Table.Store::new );
        put( list, "AGA", Table.Load::new );
        put( list, "AGT", Table.Incr::new );
        put( list, "AGG", Table.Decr::new );

        put( list, "ATA", Table.Add::new );
        put( list, "ATT", Table.Sub::new );
        put( list, "ATG", Table.Alloc::new );
        put( list, "ATC", Swap::new );

        put( list, "TAG", Flow.Mark.Set::new );
        put( list, "TAC", Flow.Mark.Goto::new );
        put( list, "TAA", Flow.Get.Chromosome::new );
        put( list, "TAT", Flow.Get.Index::new );

        put( list, "TCA", Flow.Move.Forward::new );
        put( list, "TCG", Flow.Move.Backward::new );
        put( list, "TCT", Flow.Set.Chromosome::new );
        put( list, "TCC", Flow.Set.Index::new );

        put( list, "TGA", Flow.Chromosome.Next::new );
        put( list, "TGT", Flow.Chromosome.Prev::new );
        put( list, "TGG", Flow.Chromosome.Repeat::new );
        put( list, "TGC", Flow.Move.Skip::new );

        put( list, "TTG", DoNothing::new );
        put( list, "TTC", DoNothing::new );
        put( list, "TTA", DoNothing::new );
        put( list, "TTT", Sleep::new );

        return list;
    }

    private static int getBaseBits( char base ) {
        switch( base ) {
            default:
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
    }

    private static void put( List<Function<String, Codon>> list, String codon, Function<String, Codon> item ) {
        int index = getBaseBits( codon.charAt( 0 ) );
        index <<= 2;
        index |= getBaseBits( codon.charAt( 1 ) );
        index <<= 2;
        index |= getBaseBits( codon.charAt( 2 ) );
        list.set( index, item );
    }
}
