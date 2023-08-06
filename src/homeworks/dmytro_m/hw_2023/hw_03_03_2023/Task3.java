package homeworks.dmytro_m.hw_2023.hw_03_03_2023;

public class Task3 {

    public int squareRectangle(int a, int b) {
        if(a<= 0 || b <= 0) {
            throw new IllegalArgumentException();
        } else {
            return a*b;
        }
    }

    public int trySquareRectangle(int a, int b) {
        try {
            return squareRectangle(a, b);
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

}
/*Создаем метод для вычисления площади прямоугольника.
int SquareRectangle(int a, int b), который должен генерировать исключение IllegalArgumentException
если хотя бы один из его аргументов неположителен.
Создайте метод trySquareRectangle, который принимает два параметра.
и вызывает SquareRectangle для оценки площади прямоугольника.
Поймать исключение, которое может быть сгенерировано.
trySquareRectangle не должен генерировать никаких исключений.
В случае, когда один или два параметра не являются положительными, метод должен возвращать -1.*/