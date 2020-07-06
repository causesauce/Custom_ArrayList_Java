

public class SimpleArrayList {
    final static int INITIAL_CAPACITY = 5;
    private int size;
    private int cap = INITIAL_CAPACITY;
    private int[] arr = new int[cap];
//------------------------------------------CONSTRUCTORS-------------------------------
public static void main(String[] args) {

    SimpleArrayList a = new SimpleArrayList()
            .append(new int[]{1,3})
            .insert(1,2)
            .append(6)
            .insert(3,new int[]{4,5});

    SimpleArrayList b = new SimpleArrayList(a);



    for (int i = 0; i < a.size(); ++i)
        a.set(i,a.get(i)+6);

    b.append(a).append(13).trim();


    System.out.println("a -> " + a);
    System.out.println("b -> " + b);
}


    SimpleArrayList(){
        size = 0;
        arr = new int[cap];
    }

    SimpleArrayList(int val){
        size = 1;
        arr[0] = val;
    }

    SimpleArrayList(int[] val){
        size = val.length;
        cap = val.length;
        arr = new int[cap];
        for (int i = 0; i < size; i++) {
            arr[i]=val[i];
        }
    }

    SimpleArrayList(SimpleArrayList arrList){

        this(arrList.getArr());
    }

//-------------------------------------------------------------------------------------
//--------------------------------------SIMPLE MEMBER FUNCTIONS------------------------

    public int getCap(){
        return cap;
    }

    public int[] getArr() {
        return arr;
    }

    public int size(){
        return size;
    }
    // ------------------------------------------------------------------------------------
    //--------------------------------------CUSTOM FUNCTIONS-------------------------------
    public void clear(){
        arr = new SimpleArrayList().getArr();
    }

    public void trim(){

        int[] arr2 = new int[size];
        for(int i = 0; i < size; i++)
            arr2[i] = arr[i];
        arr = new int[1];
        arr = arr2;
        cap = size;
    }

    public SimpleArrayList insert(int ind, int[] other){
        if(size < ind || ind < 0) throw new ArrayIndexOutOfBoundsException();

        int otherSize = other.length;

        if(cap >= size + otherSize) {

            for (int i = size - 1; i >= ind; i--) {
                arr[i + otherSize] = arr[i];
            }
            for(int i = 0; i < otherSize; i++)
                arr[ind++] = other[i];

            size += otherSize;
                this.trim();
        }else {

            int[] arr2 = new int[2 * (size + otherSize)];

            for (int i = 0; i < size; i++)
                arr2[i] = arr[i];

            arr = arr2;

            for (int i = size - 1; i >= ind; i--) {
                arr[i  + otherSize] = arr[i];
            }

            for(int i = 0; i < otherSize; i++)
                arr[ind++] = other[i];

            size += otherSize;
            this.trim();

        }


        return this;
    }

    public SimpleArrayList insert(int ind, int e){
        int[] tmp = {e};
        return insert(ind, tmp);
    }

    public SimpleArrayList append(int e){
        return insert(size, e);
    }

    public SimpleArrayList append(int[] a){

        return insert(size, a);
    }

    public SimpleArrayList append(SimpleArrayList a){
        int[] tmp = a.getArr();
        return insert(size, tmp);
    }

    public int get(int ind){
    if(ind > size || ind < 0 ) throw new ArrayIndexOutOfBoundsException();

        return arr[ind];
    }

    public SimpleArrayList set(int ind, int val){
        if(ind > size || ind < 0 ) throw new ArrayIndexOutOfBoundsException();
        arr[ind] = val;
        return this;

    }

    @Override
    public String toString(){
    StringBuilder res = new StringBuilder("Cap=" + cap + ", size=" + size + ": [ ");
    for(int i = 0; i < size; i++)
        res.append(arr[i] + " ");
    res.append("]");
     return res.toString();
    }

    // ------------------------------------------------------------------------------------
}

