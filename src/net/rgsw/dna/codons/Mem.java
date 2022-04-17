package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Mem {
    public static class Incr extends Codon {
        public Incr( String codon ) {
            super( codon, "INCREMENT" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory++;
        }
    }

    public static class Decr extends Codon {
        public Decr( String codon ) {
            super( codon, "DECREMENT" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory--;
        }
    }

    public static class Add extends Codon {
        public Add( String codon ) {
            super( codon, "MEMADD" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory += ctx.pop();
        }
    }

    public static class Sub extends Codon {
        public Sub( String codon ) {
            super( codon, "MEMSUBTRACT" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory -= ctx.pop();
        }
    }
}
