package net.rgsw.dna;

import java.util.Arrays;
import java.util.Scanner;

public class Executor implements Runnable {
    public Scanner in = new Scanner( System.in );
    public final Chromosome[] chromosomes;
    public int lastIndex;
    public int lastChromosome;
    public int index;
    public int chromosome;
    public final int[] stack = new int[128];
    private int stackIndex;
    public int memory;
    public boolean terminated = false;

    public final int[] mark = new int[ 2 ];

    private int[] table = new int[ 0 ];

    public Executor( Chromosome[] chromosomes ) {
        this.chromosomes = chromosomes;
    }

    public void push( int value ) {
        if( stackIndex >= stack.length ) {
            stackIndex = stack.length;
            throw new DNAExecutionException( this, "Stack overflow!" );
        }
        stack[ stackIndex ] = value;
        stackIndex ++;
    }

    public int pop() {
        if( stackIndex <= 0 ) {
            stackIndex = 0;
            throw new DNAExecutionException( this, "Stack underflow!" );
        }
        return stack[ -- stackIndex ];
    }

    public void store( boolean b ) {
        memory = b ? 1 : 0;
    }

    public boolean popBool() {
        return pop() != 0;
    }

    public void push( boolean b ) {
        push( b ? 1 : 0 );
    }

    public int stackSize() {
        return stackIndex;
    }

    public void mark() {
        mark[ 0 ] = chromosome;
        mark[ 1 ] = index - 1;
    }

    public void reset() {
        chromosome = mark[ 0 ];
        index = mark[ 1 ];
    }

    public void doNext() {
        lastChromosome = chromosome;
        lastIndex = index;
        if( chromosome < 0 || chromosome >= chromosomes.length ) {
            terminated = true;
            return;
        }
        Chromosome cmsm = chromosomes[ chromosome ];
        if( index < 0 || index >= cmsm.codons.length ) {
            terminated = true;
            return;
        }
        Codon codon = cmsm.codons[ index ];
        index ++;
        codon.execute( this );
    }

    public void tabAlloc( int size ) {
        if( size < 0 ) {
            throw new DNAExecutionException( this, "Negative table size!" );
        }
        table = new int[ size ];
    }

    public void tabStore( int index, int value ) {
        if( index < 0 || index >= table.length ) {
            throw new DNAExecutionException( this, "Invalid table slot " + index + "!" );
        }
        table[ index ] = value;
    }

    public int tabLoad( int index ) {
        if( index < 0 || index >= table.length ) {
            throw new DNAExecutionException( this, "Invalid table slot " + index + "!" );
        }
        return table[ index ];
    }

    public void tabAdd( int index, int value ) {
        if( index < 0 || index >= table.length ) {
            throw new DNAExecutionException( this, "Invalid table slot " + index + "!" );
        }
        table[ index ] += value;
    }

    public void tabSub( int index, int value ) {
        if( index < 0 || index >= table.length ) {
            throw new DNAExecutionException( this, "Invalid table slot " + index + "!" );
        }
        table[ index ] -= value;
    }

    public void tabIncr( int index ) {
        if( index < 0 || index >= table.length ) {
            throw new DNAExecutionException( this, "Invalid table slot " + index + "!" );
        }
        table[ index ] ++;
    }

    public void tabDecr( int index ) {
        if( index < 0 || index >= table.length ) {
            throw new DNAExecutionException( this, "Invalid table slot " + index + "!" );
        }
        table[ index ] --;
    }

    @Override
    public void run() {
        while( ! terminated ) {
            doNext();
        }
    }
}
