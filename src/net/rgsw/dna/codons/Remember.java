package net.rgsw.dna.codons;

import net.rgsw.dna.*;

public class Remember {
    public static class Positive extends Codon {
        public int remember;

        public Positive( String codon ) {
            super( codon, "REMEMBERPOSTIIVE" );
        }

        @Override
        public void readAdditional( ChromosomeParser parser ) {
            remember = parser.readNumber();
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = remember;
        }

        @Override
        public String toString() {
            return codon + " " + DNA.encodeNumber( remember );
        }

        @Override
        public String getMeaning() {
            return super.getMeaning() + " " + remember + " ('" + ((char) remember + "").replace("\n", "[lf]").replace("\r", "[cr]").replaceAll("(?U)[^\\w!@#$%^&*()_+\\-={}\\[\\]:;\"'|\\\\?/>.<,~` ]", "[]") + "')";
        }
    }

    public static class Negative extends Codon {
        public int remember;

        public Negative( String codon ) {
            super( codon, "REMEMBERNEGATIVE" );
        }

        @Override
        public void readAdditional( ChromosomeParser parser ) {
            remember = - parser.readNumber();
        }

        @Override
        public void execute( Executor ctx ) {
            ctx.memory = remember;
        }

        @Override
        public String toString() {
            return codon + " " + DNA.encodeNumber( - remember );
        }

        @Override
        public String getMeaning() {
            return super.getMeaning() + " " + - remember + " ('" + (char) -remember + "')";
        }
    }
}
