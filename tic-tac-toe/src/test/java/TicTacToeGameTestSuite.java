import com.kodilla.TicTacToeGame.GameTicTacToe;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TicTacToeGameTestSuite {

    GameTicTacToe game;
    String inputEnding;

    @BeforeEach
    void setUp() {
        GameTicTacToe game = new GameTicTacToe();
        inputEnding = "\nn\nn\nn";
    }

    @Nested
    @DisplayName("testing: classic 3x3 board")
    class classic3x3Board {

        private String simulatedInput;

        @BeforeEach
        void setUp() {
            simulatedInput = "3\n2\n"; // this chooses the size of the board(3x3) and the multiplayer mode
        }

        @Test
        @DisplayName("testing: A tie")
        void testOne() {
            simulatedInput += "1\n1\n1\n2\n2\n1\n2\n2\n3\n2\n3\n1\n1\n3\n2\n3\n3\n3"; // Player One wins on the first row
            simulatedInput += "\nn\nn";
            InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
            System.setIn(inputStream);

            // When
            GameTicTacToe game = new GameTicTacToe();
            game.play();

            // Then
            Assertions.assertEquals("", game.getWinner());
            Assertions.assertTrue(game.getWinner().isBlank());
        }

        @Nested
        @DisplayName("testing: PlayerOne")
        class x {

            @Test
            @DisplayName("testing: if 'X' wins in rows")
            void testOne() {

                simulatedInput += "1\n1\n3\n3\n2\n1\n3\n2\n3\n1"; // Player One wins on the first row
                simulatedInput += inputEnding;
                InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
                System.setIn(inputStream);

                // When
                GameTicTacToe game = new GameTicTacToe();
                game.play();

                // Then
                Assertions.assertEquals("Player One", game.getWinner());

            }

            @Test
            @DisplayName("testing: if 'X' wins in columns")
            void testTwo() {

                simulatedInput += "1\n1\n3\n3\n1\n2\n3\n2\n1\n3"; // Player One wins on the first column
                simulatedInput += inputEnding;
                InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
                System.setIn(inputStream);

                // When
                GameTicTacToe game = new GameTicTacToe();
                game.play();

                // Then
                Assertions.assertEquals("Player One", game.getWinner());

            }

            @Test
            @DisplayName("testing: if 'X' wins in diagonal")
            void testThree() {

                simulatedInput += "1\n1\n3\n1\n2\n2\n3\n2\n3\n3"; // Player One wins on the diagonal from left to right
                simulatedInput += inputEnding;
                InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
                System.setIn(inputStream);

                // When
                GameTicTacToe game = new GameTicTacToe();
                game.play();

                // Then
                Assertions.assertEquals("Player One", game.getWinner());

            }
        }

        @Nested
        @DisplayName("testing: PlayerTwo")
        class o {
            @Test
            @DisplayName("testing: if 'O' wins in rows")
            void testOne() {

                simulatedInput += "1\n2\n1\n1\n2\n3\n2\n1\n3\n3\n3\n1"; // Player Two wins on the first row
                simulatedInput += inputEnding;
                InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
                System.setIn(inputStream);

                // When
                GameTicTacToe game = new GameTicTacToe();
                game.play();

                // Then
                Assertions.assertEquals("Player Two", game.getWinner());

            }

            @Test
            @DisplayName("testing: if 'O' wins in columns")
            void testTwo() {

                simulatedInput += "2\n2\n1\n1\n2\n3\n1\n2\n3\n3\n1\n3"; // Player Two wins on the first column
                simulatedInput += inputEnding;
                InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
                System.setIn(inputStream);

                // When
                GameTicTacToe game = new GameTicTacToe();
                game.play();

                // Then
                Assertions.assertEquals("Player Two", game.getWinner());

            }

            @Test
            @DisplayName("testing: if 'O' wins in diagonal")
            void testThree() {

                simulatedInput += "1\n2\n1\n1\n1\n3\n2\n2\n2\n3\n3\n3"; // Player Two wins on the diagonal from left to right
                simulatedInput += inputEnding;
                InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
                System.setIn(inputStream);

                // When
                GameTicTacToe game = new GameTicTacToe();
                game.play();

                // Then
                Assertions.assertEquals("Player Two", game.getWinner());

            }
        }
    }

    @Nested
    @DisplayName("testing: classic custom 10x10 board")
    class classicCustomBoard {

        private String simulatedInput;

        @BeforeEach
        void setUp() {
            simulatedInput = "10\n2\n"; // this chooses size of the board (10x10) and the multiplayer mode
        }

        @Nested
        @DisplayName("testing: PlayerOne")
        class x {

            @Test
            @DisplayName("testing: if 'X' wins in rows")
            void testOne() {
                //Given
                simulatedInput += "2\n2\n1\n1\n3\n2\n2\n1\n4\n2\n3\n3\n5\n2\n10\n10\n6\n2"; // X wins in the second row starting from X:2 Y:2
                simulatedInput += inputEnding;
                InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
                System.setIn(inputStream);

                //When
                GameTicTacToe game = new GameTicTacToe();
                game.play();

                //Then
                Assertions.assertEquals("Player One", game.getWinner());
            }
        }
    }
}