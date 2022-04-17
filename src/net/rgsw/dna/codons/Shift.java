package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Shift {
    public static class Left extends Codon {
        public Left( String codon ) {
            super( codon, "SHIFTLEFT" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() << ctx.pop();
        }
    }
    public static class Right extends Codon {
        public Right( String codon ) {
            super( codon, "SHIFTRIGHT" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() >> ctx.pop();
        }
    }
    public static class RawRight extends Codon {
        public RawRight( String codon ) {
            super( codon, "RAWSHIFTRIGHT" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() >>> ctx.pop();
        }
    }
}
