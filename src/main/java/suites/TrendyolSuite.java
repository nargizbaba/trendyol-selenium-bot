package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.*;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        LoginRunner.class,
        SearchRunner.class,
        BasketRunner.class,
        FavoritesRunner.class,
        FilterRunner.class
})

public class TrendyolSuite {
}
