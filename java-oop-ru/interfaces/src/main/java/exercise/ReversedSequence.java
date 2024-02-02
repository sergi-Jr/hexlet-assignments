package exercise;

// BEGIN
public final class ReversedSequence implements CharSequence {
    private String sequence;

    public String getSequence() {
        return sequence;
    }
    public ReversedSequence(String paramSequence) {
        sequence = new StringBuilder(paramSequence).reverse().toString();
    }

    @Override
    public int length() {
        return sequence.length();
    }

    @Override
    public char charAt(int index) {
        return sequence.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return sequence.substring(start, end);
    }
}
// END
