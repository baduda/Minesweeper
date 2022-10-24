public class Cell {
    private boolean open;
    private int bombs;
    private boolean bomb;

    public Cell(boolean open, boolean bomb) {
        this.open = open;
        this.bombs = 0;
        this.bomb = bomb;
    }

    public boolean isOpen() {
        return open;
    }

    public int getBombs() {
        return bombs;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void incBombs() {
        this.bombs++;
    }
}
