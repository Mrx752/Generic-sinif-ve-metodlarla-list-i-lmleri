import java.util.Arrays;
import java.util.*;
public class MyList <t>{

    t[] array;
    private int capacity;
    public MyList() {
        this.capacity=10;
        this.array=(t[]) new Object[this.capacity];

    }

    public MyList(int capacity) {
        this.capacity=capacity;
        this.array=(t[]) new Object[this.capacity];
    }

   
   public int size()
   {
        int a=0;
       for (t i:this.array)
       {
           if(i != null)
           {
              a++;
           }
       }
      return a;
   }

    public void add(t data)
    {
        if(this.size()>= this.capacity)
        {
            this.capacity=this.capacity*2;
            t[] newArray=(t[]) new Object[this.capacity];
           for(int i=0 ; i< array.length ; i++)
           {
            newArray[i]=this.array[i];
           }
           newArray[(array.length)]=data;
           this.array=newArray;
        }
        else
        {
            int b = this.size();
            this.array[b]=data;
        }
    }

 public t get(int index) {
    return this.array[index];
    }


 public t  remove(int index)
 {
     t outputRemove = this.array[index];
     if(index >= 0 || index <= array.length-1)
     {
         if(this.get(index) != null)
         {
             for (int i = index ; i < array.length ; i++)
             {
                 if( i+1 > array.length -1 ) break;
                 this.array[i]=this.array[i+1];
             }
         }
         return outputRemove;
     }
     else return null;
 }

 public t set(int index, t data)
 {

     if(this.get(index) != null)
     {
        this.array[index]=data;
        return data;
     }
     else return null;
 }

    public String toString()
    {
        String str="";
        for (int i = 0; i <this.array.length ; i++) {
            if(array[i]!=null){

                str=str+this.array[i]+",";
            }

        }
        return str;
    }

    public int indexOf(t data)
    {
       for (int i = 0 ; i <array.length ;i++)
       {
           if(array[i] == data) return i;
       }
    return -1;
    }
   public int maxDataCounter(t data)
   {
       int counter=0;
       for (int i = 0 ; i <array.length ;i++)
       {
           if(array[i] == data) counter++;
       }
   return counter;
   }
   public int lastIndexOf(t data)
   {
       int max = maxDataCounter(data);
       int cnt=0;
       for (int i = 0 ; i <array.length ;i++)
       {
           if(array[i] == data)
           {
               cnt++;
               if (cnt == max ) return i;
           }
       }
       return -1;

   }

    public boolean isEmpty()
    {
      if(this.size() != 0) return false;
      else return true;


    }
    public t []toArray(){
        t [] newList= (t[]) new Object[getCapacity()];
        for (int i = 0; i <this.array.length ; i++) {
            newList[i]=this.array[i];
        }
        return newList;
    }


    public void clear()
    {
        for (int i = 0; i <this.array.length ; i++) {
            array[i] = null;
        }
    }

   public MyList <t> subList(int start,int finish)
   {
       MyList<t> output = new MyList<>();
       for (int i = start; i <= finish; i++) {
           output.add((t) this.array[i]);
       }
       return output;

   }


    public boolean contains(t data)
    {
        for (t i:array)
        {
         if(i == data) return true;
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public t[] getArray() {
        return array;
    }
    public void setArray(t[] array) {
        this.array = array;
    }
}
