package net.rgsw.dna;

public abstract class Codon {
    public final String codon;
    private final String meaning;

    public Codon( String codon, String meaning ) {
        this.codon = codon;
        this.meaning = meaning;
    }

    public void readAdditional( ChromosomeParser parser ) {
    }

    public abstract void execute( Executor ctx );

    @Override
    public String toString() {
        return codon;
    }

    public String getMeaning() {
        return meaning;
    }
}
