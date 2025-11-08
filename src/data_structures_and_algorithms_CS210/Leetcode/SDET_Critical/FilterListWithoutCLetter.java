package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

import java.util.List;
import java.util.stream.Collectors;

public class FilterListWithoutCLetter {

    List<String> filterWithoutC(List<String> list) {
        return list.stream().filter(s -> !s.toLowerCase().contains("c")).collect(Collectors.toList());
    }
}
