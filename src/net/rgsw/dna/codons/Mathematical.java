package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Mathematical {
    public static class Add extends Codon {
        public Add( String codon ) {
            super( codon, "ADD" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() + ctx.pop();
        }
    }

    public static class Sub extends Codon {
        public Sub( String codon ) {
            super( codon, "SUBTRACT" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() - ctx.pop();
        }
    }

    public static class Mul extends Codon {
        public Mul( String codon ) {
            super( codon, "MULTIPLY" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() * ctx.pop();
        }
    }

    public static class Div extends Codon {
        public Div( String codon ) {
            super( codon, "DIVIDE" );
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.pop() / ctx.pop();
        }
    }
}
