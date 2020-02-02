package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Yuriy Nekhodov (u.nehodov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) / size;
        int deltaY = (dest.y - source.y) / size;
        for (int index = 0; index < size; index++) {
            int x = source.x + ((index + 1) * deltaX);
            int y = source.y + ((index + 1) * deltaY);
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int diffX = dest.x - source.x;
        int diffY = dest.y - source.y;
        return Math.abs(diffX) == Math.abs(diffY);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
