package ie.tudublin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SudokuTest {
    
    // Test 1: Simple valid puzzle
    @Test
    fun testSimplePuzzle() {
        val puzzle = listOf(
            "003020600",
            "900305001",
            "001806400",
            "008102900",
            "700000008",
            "006708200",
            "002609500",
            "800203009",
            "005010300"
        )
        
        val sudoku = Sudoku(puzzle)
        val solved = sudoku.solveQuietly()
        
        assertTrue(solved)
        assertTrue(sudoku.isSolved())
    }
    
    // Test 2: Another valid puzzle
    @Test
    fun testAnotherPuzzle() {
        val puzzle = listOf(
            "200080300",
            "060070084",
            "030500209",
            "000105408",
            "000000000",
            "402706000",
            "301007040",
            "720040060",
            "004010003"
        )
        
        val sudoku = Sudoku(puzzle)
        val solved = sudoku.solveQuietly()
        
        assertTrue(solved)
        assertTrue(sudoku.isSolved())
    }
    
    // Test 3: Invalid puzzle (has two 1's in first row)
    @Test
    fun testInvalidPuzzle() {
        val invalidPuzzle = listOf(
            "115000000",
            "000000000",
            "000000000",
            "000000000",
            "000000000",
            "000000000",
            "000000000",
            "000000000",
            "000000000"
        )
        
        val sudoku = Sudoku(invalidPuzzle)
        val solved = sudoku.solveQuietly()
        
        assertFalse(solved)
        assertFalse(sudoku.isSolved())
        assertTrue(sudoku.getIterationCount() > 2_000_000)
    }
}