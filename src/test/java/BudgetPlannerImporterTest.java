import be.pxl.student.util.BudgetPlannerException;
import be.pxl.student.util.BudgetPlannerImporter;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetPlannerImporterTest {

    Path testCsvFile = Paths.get("src/test/resources/account_payments_test.csv");

    @Test
    void read_csv_file_should_return_non_empty_list () throws BudgetPlannerException {
        assertFalse(BudgetPlannerImporter.readCsvFile(testCsvFile).isEmpty());
    }

    @Test
    void read_csv_file_should_return_list_of_size_2 () throws BudgetPlannerException {
        assertEquals(2, BudgetPlannerImporter.readCsvFile(testCsvFile).size());
    }

    @Test
    void read_csv_file_should_throw_our_own_exception_when_csv_file_does_not_exist() {
        assertThrows(BudgetPlannerException.class, () -> BudgetPlannerImporter.readCsvFile(Paths.get("NonExistentFile")));
    }

    @Test
    void read_csv_file_should_throw_our_own_exception_when_passing_null () {
        assertThrows(BudgetPlannerException.class, () -> BudgetPlannerImporter.readCsvFile(null));
    }
}
