public class Board {

    private Cell[][] cells = generateCells();

    private static Cell[][] generateCells() {
        Cell[][] c = new Cell[10][10];
        for (int x = 0; x < c.length; x++) {
            for (int y = 0; y < c[x].length; y++) {
                c[x][y] = new Cell(false, Math.random() < 0.05);
            }
        }

        for (int x = 0; x < c.length; x++) {
            for (int y = 0; y < c[x].length; y++) {
                Cell cell = c[x][y];

                if (isBomb(x + 1, y - 1, c)) cell.incBombs();
                if (isBomb(x + 1, y, c)) cell.incBombs();
                if (isBomb(x + 1, y + 1, c)) cell.incBombs();


                if (isBomb(x, y - 1, c)) cell.incBombs();
                if (isBomb(x, y + 1, c)) cell.incBombs();

                if (isBomb(x - 1, y - 1, c)) cell.incBombs();
                if (isBomb(x - 1, y, c)) cell.incBombs();
                if (isBomb(x - 1, y + 1, c)) cell.incBombs();

            }
        }
        return c;
    }

    private static boolean isBomb(int x, int y, Cell[][] cells) {
        if (x >= 0 && y >= 0 && x < cells.length && y < cells.length) {
            return cells[x][y].isBomb();
        } else {
            return false;
        }
    }


    public boolean allOpen() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (!cell.isOpen()) return false;
            }
        }
        return true;
    }

    public boolean swap(int x, int y) {
        Cell cell = cells[x][y];
        cell.setOpen(true);
        return cell.isBomb();
    }

    public void print() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell.isOpen()) {
                    if (cell.isBomb()) {
                        System.out.print("@");
                    } else {
                        System.out.print(cell.getBombs());
                    }
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
