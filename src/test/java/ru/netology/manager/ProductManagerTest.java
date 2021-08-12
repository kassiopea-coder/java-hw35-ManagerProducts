package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager();

    private final Book bookFirst = new Book(1, "Онегин", 100, "Пушкин");
    private final Book bookSecond = new Book(2, "Война и мир", 1000, "Толстой");
    private final Book bookThird = new Book(3, "Солярис", 350, "Лем");
    private final Book bookForth = new Book(4, "Сказки", 3000, "Пушкин");
    private final Book bookFifth = new Book(5, "Преступление и наказание", 100, "Достоевский");
    private final Book bookSixth = new Book(6, "Война миров", 1000, "Кинг");
    private final Smartphone smartphoneFirst = new Smartphone(7, "P10", 25000, "Huawei");
    private final Smartphone smartphoneSecond = new Smartphone(8, "8mini", 40000, "Apple");
    private final Smartphone smartphoneThird = new Smartphone(9, "P10Pro", 35000, "Huawei");
    private final Smartphone smartphoneForth = new Smartphone(10, "6S", 20000, "Apple");
    private final Smartphone smartphoneFifth = new Smartphone(11, "Mi10", 25000, "Xiaomi");
    private final Smartphone smartphoneSixth = new Smartphone(12, "P500", 15000, "Oppo");

    @BeforeEach
    public void setUp() {
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(bookForth);
        manager.add(bookFifth);
        manager.add(bookSixth);
        manager.add(smartphoneFirst);
        manager.add(smartphoneSecond);
        manager.add(smartphoneThird);
        manager.add(smartphoneForth);
        manager.add(smartphoneFifth);
        manager.add(smartphoneSixth);
    }

    @Test
    void shouldSearchByNameForBook() {
        Product[] expected = new Product[]{bookFirst};
        Product[] actual = manager.searchBy("Онегин");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthorForBook() {
        Product[] expected = new Product[]{bookFirst, bookForth};
        Product[] actual = manager.searchBy("Пушкин");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameForPhone() {
        Product[] expected = new Product[]{smartphoneFirst};
        Product[] actual = manager.searchBy("P10");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducerForPhone() {
        Product[] expected = new Product[]{smartphoneFirst, smartphoneThird};
        Product[] actual = manager.searchBy("Huawei");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnNull() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Самсунг");
        assertArrayEquals(expected, actual);
    }
}