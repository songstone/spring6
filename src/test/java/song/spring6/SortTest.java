package song.spring6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {

    Sort sort;

    @BeforeEach
    void init() {
        sort = new Sort();
        System.out.println(this);
    }

    @Test
    void sort() {
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b", "CCC"));

        assertThat(list).isEqualTo(List.of("b", "aa", "CCC"));
    }

    @Test
    void sortAlreadySorted() {
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "CCC"));

        assertThat(list).isEqualTo(List.of("b", "aa", "CCC"));
    }
}
