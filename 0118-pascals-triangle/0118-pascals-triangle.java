import java.util.ArrayList; // \U0001f4e6 We need this to create lists!
import java.util.List;       // \U0001f4c4 Interface for lists

class Solution {
    public List<List<Integer>> generate(int numRows) {
        // \U0001f389 This is our main function!  It takes the number of rows and
        //    returns the whole triangle as a list of lists.

        List<List<Integer>> triangle = new ArrayList<>(); // \U0001f4d0 This is where we'll store our triangle!
                                                          //    It's a list of lists, where each inner list
                                                          //    represents one row.

        for (int i = 0; i < numRows; i++) { // \U0001f501 Loop through each row from 0 to numRows-1
            List<Integer> row = new ArrayList<>(); // \U0001f9f1 Create a new list to represent the current row

            row.add(1); // \U0001f947 The first element of every row is ALWAYS 1

            if (i > 0) { // \U0001f914 If we're NOT on the very first row... (row 0)
                List<Integer> prevRow = triangle.get(i - 1); // ⬆️ Get the row above us (the previous row)

                for (int j = 1; j < i; j++) { // ➕ Loop through the *inner* elements of this row.
                                              //    We start at 1 and go up to, but not including, i.
                                              //    We skip the first and last '1' because they are always 1

                    row.add(prevRow.get(j - 1) + prevRow.get(j)); // ➕ MAGIC: Add the two numbers from the
                                                                 //    previous row that are directly above us.
                }
                row.add(1); // \U0001f948 The last element of every row is ALWAYS 1
            }

            triangle.add(row); // ➕ Add the row we just built to our triangle
        }
        return triangle; // \U0001f381 Return the completed Pascal's Triangle!
    }
}