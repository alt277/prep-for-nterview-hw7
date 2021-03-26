package ru.geekbrains.services.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.entities.Student;


import java.math.BigDecimal;

public final class StudentSpecificatiom {

    public static Specification<Student> trueLiteral() {
        return (root, query, builder) -> builder.isTrue(builder.literal(true));
    }

    public static Specification<Student> titleLike(String title) {
        return (root, query, builder) -> builder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Student> priceGreaterThan(Integer price) {
        return (root, query, builder) -> builder.greaterThan(root.get("price"),price);
    }
    public static Specification<Student> priceLessThan(Integer price) {
        return (root, query, builder) -> builder.lessThan(root.get("price"),price);
    }
}