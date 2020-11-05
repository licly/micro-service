package com.licly.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author licly
 * @date 2020/11/5
 */
public class CollectorPractice {

    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>();
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("name", "beijing");
        m1.put("type", "city");
        list.add(m1);

        HashMap<String, String> m2 = new HashMap<>();
        m2.put("name", "shanghai");
        m2.put("type", "city");
        list.add(m2);

        HashMap<String, String> m3 = new HashMap<>();
        m3.put("name", "shanxi");
        m3.put("type", "province");
        list.add(m3);

        HashMap<String, String> m4 = new HashMap<>();
        m4.put("name", "hebei");
        m4.put("type", "province");
        list.add(m4);
        list.stream().forEach(System.out::println);

        Map<String, List<Map<String, String>>> type = list.stream()
                .filter(m -> Objects.nonNull(m.get("type")))
                .collect(Collectors.groupingBy(m -> m.get("type")));
        System.out.println(type);
    }
}
