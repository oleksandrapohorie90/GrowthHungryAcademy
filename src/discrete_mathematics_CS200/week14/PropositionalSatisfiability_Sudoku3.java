package discrete_mathematics_CS200.week14;

public class PropositionalSatisfiability_Sudoku3 {
    //final every 3 x 3 block contains every_number

    int everyBlockContainsEveryNumber() {
        int all_blocks_have_all_numbers = 1;

        for (int r = 0; r <= 2; r++) {
            for (int s = 0; s <= 2; s++) {
                //(r=0, s=0) <-> the 1st block that will verify, i.e. grid[1..3][1..3]
                //(r=0, s=1) <-> the 2nd block that will verify, i.e. grid[1..3][4..6]
                //(r=0, s=2) <-> the 3rd block that will verify, i.e. grid[1..3][7..9]


                //(r=1, s=0) <-> the 4th block that will verify, i.e. grid[4..6][1..3]
                //(r=1, s=1) <-> the 5th block that will verify, i.e. grid[4..6][4..6]
                //(r=1, s=2) <-> the sixth block that will verify, i.e. grid[4..6][7..9]


                //(r=2, s=0) <-> the seventh block that will verify, i.e. grid[7..9][1..3]
                //(r=2, s=1) <-> the eighth block that will verify, i.e. grid[7..9][4..6]
                //(r=2, s=2) <-> the ninth block that will verify, i.e. grid[7..9][7..9]

                int current_block_has_all_numbers = 1;

                for (int n = 1; n <= 9; n++) {
                    //verify that every number n=1..9 is present inside the current 3x3 block

                    int number_n_is_present = 0;

                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 3; j++) {
                            //iterating over the current (3r +i, 3s +j) 3x 3 block
                            //if any of these values are true than number_n_is present is True
                            //number_n_is_present |= p(3 * r + i, 3 * s + j, n);
                        }
                    }
                    //then AND operation
                    current_block_has_all_numbers &= number_n_is_present;
                }
                all_blocks_have_all_numbers &= current_block_has_all_numbers;
            }
        }

        return all_blocks_have_all_numbers;
    }
}
