package javacs602;

public class SquareWidget extends Widget {
    private final int size;

    public SquareWidget(int size) {
        this.size = size;
    }

    @Override
    protected int width() {
        return size;
    }

    @Override
    protected int height() {
        return size;
    }
    public void printWidth()
    {
    	System.out.println(size);
    }
}