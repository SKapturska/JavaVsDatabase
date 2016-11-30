package javavsdatabase;

public class JavaVsDatabase {

    public static void main(String[] args) {
       SingletonConnection singletonConnection = SingletonConnection.getInstance();
       //singletonConnection.fillTab(); zmienic id !!!!!!!!
       Sorting  sorting = new Sorting();
       System.out.println("czas sortowania sql: " +sorting.sqlSort()+ " nanosekund");
    }
    
}
