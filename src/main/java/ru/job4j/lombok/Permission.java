package ru.job4j.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    private String name;
    @Singular("ruleAdd")
    private List<String> rules;

    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("Access")
                .ruleAdd("отдельная строка 1")
                .ruleAdd("отдельная строка 2")
                .rules(List.of("строка из списка 1", "строка из списка 2"))
                .build();
        System.out.println(permission);
        System.out.println("Список полученный через геттер: " + permission.getRules());
    }
}
