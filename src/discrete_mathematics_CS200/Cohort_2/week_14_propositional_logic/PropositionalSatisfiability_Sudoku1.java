package discrete_mathematics_CS200.Cohort_2.week_14_propositional_logic;

public class PropositionalSatisfiability_Sudoku1 {
    //propositional equivalences - Ch. 1.3
    int everyRowContainsEveryNumber() {
        int every_row_contains_every_number = 1;
        //fixed the row
        for (int i = 1; i <= 9; i++) {
            int every_number_is_in_the_row = 1;

            //fixed the number
            for (int n = 1; n <= 9; n++) {

                int number_n_is_in_the_row = 0; //because we are using OR operation

                //now iterate over the columns
                for (int j = 1; j <= 9; j++) {
                    //using OR operation
                    //if column j in row i contains number n,
                    //then number_n_is_in_the_row will become 1 (true)

                    //number_n_is_in_the_row |= p(i, j, n); //then this will become true
                }
                //using AND operation
                //if NOT number_n_is_in_the_row, then
                //every_number_is_in_the_row will become 0 (false)
                every_number_is_in_the_row &= number_n_is_in_the_row;
            }
            //using AND operation
            //if NOT very_number_is_in_the_row, then
            //every_row_contains_every_number will become 0 (false)
            every_row_contains_every_number &= every_number_is_in_the_row;
        }

        return every_row_contains_every_number;
    }
}
