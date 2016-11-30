package javavsdatabase;

public class JavaVsDatabase {

    public static void main(String[] args) {
       SingletonConnection singletonConnection = SingletonConnection.getInstance();
       //singletonConnection.fillTab(); 
       Sorting  sorting = new Sorting();
       System.out.println("czas sortowania sql: " +sorting.sqlSort()+ " nanosekund");
       sorting.fillTable();
       //sorting.show();
       System.out.println("czas sortowania babelkowego: "+sorting.javaSort() + " nanosekund");
       //sorting.show();
    }
    
}
