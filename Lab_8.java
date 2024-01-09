import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// исключения для переполненного контейнера
class ContainerFullException extends Exception {
    public ContainerFullException(String message) {
        super(message);
    }
}

//  исключения для пустого контейнера
class ContainerEmptyException extends Exception {
    public ContainerEmptyException(String message) {
        super(message);
    }
}
 class DataContainer<T> {
    private T[] data; // массив для хранения данных
    private int size; // текущий размер массива

    // конструктор с заданием максимального размера контейнера
    public DataContainer(int maxSize) {
        data = (T[]) new Object[maxSize];
        size = 0;
    }

    //добавлениe
    public void add(T element) throws ContainerFullException {
        if (size < data.length) {
            data[size] = element;
            size++;
        } else {
            throw new ContainerFullException("Невозможно добавить элемент, контейнер заполнен");
        }
    }

    // удалениe
    public T remove() throws ContainerEmptyException {
        if (size > 0) {
            T removed = data[size - 1];
            data[size - 1] = null;
            size--;
            return removed;
        } else {
            throw new ContainerEmptyException("Невозможно удалить элемент, контейнер пуст");
        }
    }

    // сложениe
    public T sum() throws ContainerEmptyException {
        if (size > 0) {
            if (data[0] instanceof Integer) {
                Integer sum = 0;
                for (int i = 0; i < size; i++) {
                    sum += (Integer) data[i];
                }
                return (T) sum;
            } else {
                throw new UnsupportedOperationException("Текущая операция поддерживается только для целочисленных данных");
            }
        } else {
            throw new ContainerEmptyException("Невозможно сложить элементы, контейнер пуст");
        }
    }
    public static void main(String[] args) {
        DataContainer<Integer> container = new DataContainer<>(5);
        try {
            container.add(50);
            container.add(20);

            System.out.println("Сумма элементов: " + container.sum());
            container.remove();
            System.out.println("Сумма элементов: " + container.sum());
        }
        catch (ContainerFullException | ContainerEmptyException | UnsupportedOperationException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}

