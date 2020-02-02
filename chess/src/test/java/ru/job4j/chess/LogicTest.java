package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void moveWhenWayIsFree() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        assertThat(logic.move(Cell.C1, Cell.G5), is(true));
    }

    @Test
    public void moveWhenWayHasFigure() {
        Logic logic = new Logic();
        BishopBlack bishopBlackC1 = new BishopBlack(Cell.C1);
        BishopBlack bishopBlackE3 = new BishopBlack(Cell.E3);
        logic.add(bishopBlackC1);
        logic.add(bishopBlackE3);
        assertThat(logic.move(Cell.C1, Cell.G5), is(false));
    }

    @Test
    public void moveWhenWayHasFigureInDestination() {
        Logic logic = new Logic();
        BishopBlack bishopBlackC1 = new BishopBlack(Cell.C1);
        BishopBlack bishopBlackE3 = new BishopBlack(Cell.G5);
        logic.add(bishopBlackC1);
        logic.add(bishopBlackE3);
        assertThat(logic.move(Cell.C1, Cell.G5), is(false));
    }
}