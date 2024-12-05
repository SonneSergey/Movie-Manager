package ru.netology.movie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void shouldAddAndFindAllMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");

        String[] expected = {"Бладшот", "Вперед"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindLastMoviesWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель Белград", "Вперед"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMoviesWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперед", "Бладшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMoviesLessThanLimit() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");

        String[] expected = {"Вперед", "Бладшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldReturnEmptyWhenNoMovies() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        assertArrayEquals(expected, manager.findAll());
        assertArrayEquals(expected, manager.findLast());
    }
}