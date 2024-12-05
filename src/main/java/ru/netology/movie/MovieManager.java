package ru.netology.movie;

public class MovieManager {
    private String[] movies = new String[0];
    private int limit;

    // Конструктор (лимит 5 фильмов)
    public MovieManager() {
        this.limit = 5;
    }

    // Конструктор с заданием лимита
    public MovieManager(int limit) {
        this.limit = limit;
    }

    // Метод для добавления нового фильма
    public void addMovie(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    // Метод для получения всех фильмов в порядке добавления
    public String[] findAll() {
        return movies;
    }

    // Метод для получения последних фильмов в обратном порядке
    public String[] findLast() {
        int resultLength = Math.min(movies.length, limit);
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}