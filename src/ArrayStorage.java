/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int capasity = 10000;
    private int size;
    Resume[] storage = new Resume[capasity];

    void clear() {
        // Обход всех элементов массива
        for (int i = 0; i < size; i++) {
            //присвоение всем элементам null
            storage[i] = null;
        }
        //обнуление счетчика заполненных ячеек
        size = 0;
    }

    void save(Resume r) {
        //если массив заолнен, тогда выйт из метода
        if (size >= capasity) {
            return;
        }
        //добавление резюме в массив
        storage[size] = r;
        //увеличение размера на1
        size++;
    }

    Resume get(String uuid) {
        //обход всех элементов массива
        for (int i = 0; i < size; i++) {
            //если uuid текущего элемента равен заданному, то вернуть его
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int idx = -1;
        //обход всех элементов массива
        for (int i = 0; i < size; i++) {
            //если uuid текущего элемента равен заданному, то
            if (storage[i].uuid.equals(uuid)) {
                //присвоение значения позиции удаленного из массива резюме
                idx = 1;
                //выход из цикла
                break;
            }
        }
        //если значение idx стало больше чем -1, то
        if (idx > -1) {
            //смещаем все элементы массива
            for (int i = idx; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[size - 1] = null;
        }
        //уменьшаем размер на 1
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        //создание нового массива с резюме с размером реально заполненных элементов
        Resume[] res = new Resume[size];
        //добавление всех резюме в новый массив
        for (int i = 0; i < size; i++) {
            res[i] = storage[i];
        }
        return res;
    }

    int size() {
        return size;
    }
}
