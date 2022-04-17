package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Bitwise {
    public static class Not extends Codon {
        public Not( String codon ) {
            super( codon, "BITWISENOT" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ~ ctx.pop();
        }
    }

    public static class And extends Codon {
        public And( String codon ) {
            super( codon, "BITWISEAND" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() & ctx.pop();
        }
    }

    public static class Or extends Codon {
        public Or( String codon ) {
            super( codon, "BITWISEOR" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() | ctx.pop();
        }
    }

    public static class Xor extends Codon {
        public Xor( String codon ) {
            super( codon, "BITWISEXOR" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() ^ ctx.pop();
        }
    }
}
