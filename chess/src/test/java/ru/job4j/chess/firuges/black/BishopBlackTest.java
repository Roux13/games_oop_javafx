package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B5);
        Cell result = bishopBlack.position();
        assertThat (result, is(Cell.B5));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        Figure result = bishopBlack.copy(Cell.A3);
        assertThat(result.position(), is(Cell.A3));
    }

    @Test
    public void wayWhenDiagonalC1G5ThenD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expect));
    }

    @Test
    public void wayWhenDiagonalB7E5ThenD6E5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B7);
        Cell[] result = bishopBlack.way(Cell.B7, Cell.D5);
        Cell[] expect = {Cell.C6, Cell.D5};
        assertThat(result, is(expect));
    }

    @Test(expected = IllegalStateException.class)
    public void wayWhenNonDiagonalThenException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.C5);
    }

    @Test
    public void isDiagonalWhenFromA1ToC3ThenTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.isDiagonal(Cell.A1, Cell.C3), is(true));
    }

    @Test
    public void isDiagonalWhenFromA3ToA2ThenFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.isDiagonal(Cell.A1, Cell.A2), is(false));
    }
}