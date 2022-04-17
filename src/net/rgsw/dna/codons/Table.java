package net.rgsw.dna.codons;

import net.rgsw.dna.ChromosomeParser;
import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Table {
    public static class Alloc extends Codon {
        private int size;

        public Alloc( String codon ) {
            super( codon, "TABALLOC" );
        }

        @Override
        public String getMeaning() {
            return super.getMeaning() + " " + size;
        }

        @Override
        public void readAdditional( ChromosomeParser parser ) {
            size = parser.readNumber();
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.tabAlloc( size );
        }
    }

    public static class Store extends Codon {
        private int index;

        public Store( String codon ) {
            super( codon, "TABSTORE" );
        }

        @Override
        public String getMeaning() {
            return super.getMeaning() + " " + index;
        }

        @Override
        public void readAdditional( ChromosomeParser parser ) {
            index = parser.readNumber();
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.tabStore( index, ctx.memory );
        }
    }

    public static class Load extends Codon {
        private int index;

        public Load( String codon ) {
            super( codon, "TABLOAD" );
        }

        @Override
        public String getMeaning() {
            return super.getMeaning() + " " + index;
        }

        @Override
        public void readAdditional( ChromosomeParser parser ) {
            index = parser.readNumber();
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = ctx.tabLoad( index );
        }
    }

    public static class Add extends Codon {
        private int index;

        public Add( String codon ) {
            super( codon, "TABADD" );
        }

        @Override
        public String getMeaning() {
            return super.getMeaning() + " " + index;
        }

        @Override
        public void readAdditional( ChromosomeParser parser ) {
            index = parser.readNumber();
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.tabAdd( index, ctx.memory );
        }
    }

    public static class Sub extends Codon {
        private int index;

        public Sub( String codon ) {
            super( codon, "TABSUBTRACT" );
        }

        @Override
        public String getMeaning() {
            return super.getMeaning() + " " + index;
        }

        @Override
        public void readAdditional( ChromosomeParser parser ) {
            index = parser.readNumber();
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.tabSub( index, ctx.memory );
        }
    }

    public static class Incr extends Codon {
        private int index;

        public Incr( String codon ) {
            super( codon, "TABINCR" );
        }

        @Override
        public String getMeaning() {
            return super.getMeaning() + " " + index;
        }

        @Override
        public void readAdditional( ChromosomeParser parser ) {
            index = parser.readNumber();
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.tabIncr( index );
        }
    }

    public static class Decr extends Codon {
        private int index;

        public Decr( String codon ) {
            super( codon, "TABDECR" );
        }

        @Override
        public String getMeaning() {
            return super.getMeaning() + " " + index;
        }

        @Override
        public void readAdditional( ChromosomeParser parser ) {
            index = parser.readNumber();
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.tabDecr( index );
        }
    }
}
