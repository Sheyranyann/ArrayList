import java.util.Arrays;
public class ArrayList<E> implements List<E>{

    private E[] arrayList;
    private int currentCapacity = 10;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        arrayList = (E[])new Object[currentCapacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(E ... args) {
        if (args.length > currentCapacity) {
            currentCapacity += args.length;
        }
        arrayList = (E[])new Object[currentCapacity];
        System.arraycopy(args, 0, arrayList, 0, args.length);
        size = args.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.currentCapacity;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean add(E element) {
        if(size == currentCapacity) {
            extendArray();
        }
        arrayList[size++] = element;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if(index == size) {
            add(element);
            return;
        }
        try {
            invalidIndex(index);
        } catch (InvalidIndexException e) {
            System.out.print(e.getMessage() + "  ");
            return;
        }
        if(size == currentCapacity) {
            extendArray();
        }
        for(int i = size; i > index; i--) {
            arrayList[i] = arrayList[i-1];
        }
        arrayList[index] = element;
        this.size++;
    }

    @Override
    public E get(int index) {
        try {
            invalidIndex(index);
        } catch (InvalidIndexException e) {
            System.out.print(e.getMessage() + "  ");
            return null;
        }
        return arrayList[index];
    }

    @Override
    public E set(int index, E element) {
        try{
            invalidIndex(index);
        } catch (InvalidIndexException e) {
            System.out.print(e.getMessage() + "  ");
            return null;
        }
        E temp = arrayList[index];
        arrayList[index] = element;
        return temp;
    }

    @Override
    public boolean remove(E element) {
        if(contains(element)) {
            remove(indexOf(element));
            return true;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        try {
            invalidIndex(index);
        } catch (InvalidIndexException e) {
            System.out.print(e.getMessage() + "  ");
            return null;
        }
        E tmp = arrayList[index];
        for (int i = index; i < size - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[--size] = null;
        return tmp;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public int indexOf(E element) {
        for(int i = 0; i < size; i++) {
            if (element.equals(arrayList[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for(int i = size - 1; i >= 0; i--) {
            if (element.equals(arrayList[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        this.size = 0;
        for(int i = 0; i < currentCapacity; i++) {
            arrayList[i] = null;
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arrayList, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] array) {
        if(this.isEmpty()) {
            return array;
        }
        try {
            array[0] = (T) arrayList[0];
        } catch (ArrayStoreException e) {
            System.out.print(e.getClass() + "  ");
            return null;
        }
        if(array.length < size) {
            array = (T[]) new Object[size];
        }
        for (int i = 0; i < size; i++) {
            array[i] = (T) arrayList[i];
        }
        return array;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        try {
            invalidIndex(fromIndex);
            invalidIndex(toIndex);
        } catch (InvalidIndexException e) {
            System.out.print(e.getMessage() + "  ");
            return null;
        }
        if(toIndex <= fromIndex) {
            System.out.println("Not valid indexes for creating sublist");
            return null;
        }
        List<E> list = new ArrayList<>();
        for(int i = fromIndex; i < toIndex; i++) {
            list.add(arrayList[i]);
        }
        return list;
    }

    @Override
    public boolean removeAll(List<? extends E> otherList) {
        boolean isRemoved = false;
        for (int i = 0; i < otherList.size(); i++) {
            if (contains((E) otherList.get(i))) {
                remove((E) otherList.get(i));
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    @Override
    public boolean retainAll(List<? extends E> otherList) {
        boolean isModified = false;
        ArrayList<E> otherArray = new ArrayList<>();
        for (int i = 0; i < otherList.size(); i++) {
            otherArray.add((E) otherList.get(i));
        }
        for (int i = 0; i < size; i++) {
            if(!otherArray.contains((arrayList[i]))) {
                this.remove(arrayList[i--]);
                isModified = true;
            }
        }
        return isModified;
    }

    @Override
    public boolean containsAll(List<? extends E> otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            if (! this.contains((E) otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(List<? extends E> otherList) {
        if(currentCapacity - size < otherList.size()) {
            extendArray(otherList.size());
        }
        for(int i = 0; i < otherList.size(); i++) {
            arrayList[size++] = otherList.get(i);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, List<? extends E> otherList) {
        int otherListSize = otherList.size();
        if(index == size) {
            return addAll(otherList);
        }
        try {
            invalidIndex(index);
        } catch (InvalidIndexException e) {
            System.out.print(e.getMessage() + "  ");
            return false;
        }
        if (currentCapacity - size < otherListSize) {
            extendArray(otherListSize);
        }
        for (int i = size - 1; i >= index; i--) {
            arrayList[i + otherListSize] = arrayList[i];
        }
        size += otherListSize;
        for (int i = 0; i < otherListSize; i++) {
            arrayList[index + i] = otherList.get(i);
        }
        return true;
    }

    public boolean equals(Object obj){
        return super.equals(obj);
    }

    public int hashCode(){
        return super.hashCode();
    }

    public String toString(){
        StringBuilder strResult = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            strResult.append(get(i) + ", ");
        }
        if (size == 0) {
            strResult.append("]");
        } else {
            strResult.replace(strResult.length() - 2, strResult.length(), "]");
        }
        return strResult.toString();
    }

    private void invalidIndex(int index) {
        if (index < 0) {
            throw new InvalidIndexException("Negative index");
        }
        if(index >= size) {
            throw new InvalidIndexException("Index out of bounds");
        }
    }

    @SuppressWarnings("unchecked")
    private void extendArray() {
        currentCapacity += 10;
        Object[] temp = arrayList;
        arrayList = (E[])new Object[currentCapacity];
        System.arraycopy(temp, 0, arrayList, 0, size);
    }

    @SuppressWarnings("unchecked")
    private void extendArray(int s) {
        currentCapacity = currentCapacity + 10 + s;
        Object[] temp = arrayList;
        arrayList = (E[])new Object[currentCapacity];
        System.arraycopy(temp, 0, arrayList, 0, size);
    }

}
