package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Logical {
    public static class Not extends Codon {
        public Not( String codon ) {
            super( codon, "LOGICALNOT" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.store( ! ctx.popBool() );
        }
    }

    public static class And extends Codon {
        public And( String codon ) {
            super( codon, "LOGICALAND" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.store( ctx.popBool() && ctx.popBool() );
        }
    }

    public static class Or extends Codon {
        public Or( String codon ) {
            super( codon, "LOGICALOR" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.store( ctx.popBool() || ctx.popBool() );
        }
    }

    public static class Xor extends Codon {
        public Xor( String codon ) {
            super( codon, "LOGICALXOR" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.store( ctx.popBool() != ctx.popBool() );
        }
    }
}
