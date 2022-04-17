package net.rgsw.dna.codons;

import net.rgsw.dna.Codon;
import net.rgsw.dna.Executor;

public class Flow {
    public static class Mark {
        public static class Set extends Codon {
            public Set( String codon ) {
                super( codon, "SETMARK" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.mark();
            }
        }

        public static class Goto extends Codon {
            public Goto( String codon ) {
                super( codon, "GOTOMARK" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.reset();
            }
        }
    }

    public static class Get {
        public static class Chromosome extends Codon {
            public Chromosome( String codon ) {
                super( codon, "GETCHROMOSOME" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.memory = ctx.chromosome;
            }
        }

        public static class Index extends Codon {
            public Index( String codon ) {
                super( codon, "GETINDEX" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.memory = ctx.index - 1;
            }
        }
    }

    public static class Move {
        public static class Forward extends Codon {

            public Forward( String codon ) {
                super( codon, "FORWARD" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.index += ctx.memory;
            }
        }

        public static class Backward extends Codon {

            public Backward( String codon ) {
                super( codon, "BACKWARD" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.index -= ctx.memory;
            }
        }

        public static class Skip extends Codon {

            public Skip( String codon ) {
                super( codon, "SKIP" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.index++;
            }
        }
    }

    public static class Set {
        public static class Chromosome extends Codon {

            public Chromosome( String codon ) {
                super( codon, "SETCHROMOSOME" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.chromosome = ctx.memory;
            }
        }

        public static class Index extends Codon {

            public Index( String codon ) {
                super( codon, "SETINDEX" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.index = ctx.memory;
            }
        }
    }

    public static class Chromosome {
        public static class Next extends Codon {

            public Next( String codon ) {
                super( codon, "NEXT" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.chromosome++;
                ctx.index = 0;
            }
        }

        public static class Prev extends Codon {

            public Prev( String codon ) {
                super( codon, "PREV" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.chromosome--;
                ctx.index = 0;
            }
        }

        public static class Repeat extends Codon {

            public Repeat( String codon ) {
                super( codon, "REPEAT" );
            }

            @Override
            public void execute( Executor ctx ) {
                ctx.index = 0;
            }
        }
    }

    public static class Conditional {
        public static class IfZero extends Codon {

            public IfZero( String codon ) {
                super( codon, "IFZERO" );
            }

            @Override
            public void execute( Executor ctx ) {
                if( ctx.memory != 0 ) ctx.index++;
            }
        }

        public static class IfNZero extends Codon {

            public IfNZero( String codon ) {
                super( codon, "IFNZERO" );
            }

            @Override
            public void execute( Executor ctx ) {
                if( ctx.memory == 0 ) ctx.index++;
            }
        }

        public static class IfPositive extends Codon {

            public IfPositive( String codon ) {
                super( codon, "IFPOSITIVE" );
            }

            @Override
            public void execute( Executor ctx ) {
                if( ctx.memory <= 0 ) ctx.index++;
            }
        }

        public static class IfNegative extends Codon {

            public IfNegative( String codon ) {
                super( codon, "IFNEGATIVE" );
            }

            @Override
            public void execute( Executor ctx ) {
                if( ctx.memory >= 0 ) ctx.index++;
            }
        }
    }
}
