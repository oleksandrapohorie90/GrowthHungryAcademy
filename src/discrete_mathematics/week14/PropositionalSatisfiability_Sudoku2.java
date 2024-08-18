package discrete_mathematics.week14;

public class PropositionalSatisfiability_Sudoku2 {
    //propositional equivalences - Ch. 1.3
    int everyColumnContainsEveryNumber() {
        int every_column_contains_every_number = 1;

        //we 1st iterate over columns
        for (int j = 1; j <= 9; j++) {
            //for each column we verify that every num is in this column
            int every_number_is_in_the_column = 1;

            //we iterate over the numbers
            for (int n = 1; n <= 9; n++) {

//for each number we verify it is in this column
                int number_n_is_in_the_column = 0; //because we are using OR operation

                //now iterate over the columns
                for (int i = 1; i <= 9; i++) {
                    //using OR operation
                    //if column i in row j contains number n,
                    //then number_n_is_in_the_column will become 1 (true)

                    /number_n_is_in_the_column |= p(i, j, n); //one of the columns contains this number n
                }
                //using AND operation
                //if NOT number_n_is_in_the_row, then
                //every_number_is_in_the_row will become 0 (false)
                every_number_is_in_the_column &= number_n_is_in_the_column;//then we take AND for all of these values
            }
            //using AND operation
            //if NOT very_number_is_in_the_row, then
            //every_row_contains_every_number will become 0 (false)
            every_column_contains_every_number &= every_number_is_in_the_column;//we take AND  for every column that every column has every number
        }

        return everyColumnContainsEveryNumber();
    }
}


